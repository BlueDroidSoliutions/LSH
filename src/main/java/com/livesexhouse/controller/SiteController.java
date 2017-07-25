package com.livesexhouse.controller;

import com.livesexhouse.DAO.*;
import com.livesexhouse.chat.ActiveUserService;
import com.livesexhouse.model.Contact;
import com.livesexhouse.model.MemberHouse;
import com.livesexhouse.model.Users;
import com.livesexhouse.model.VideoCategories;
import com.livesexhouse.model.VideoCategoryCountClip;
import com.livesexhouse.model.VideoClip;
import com.livesexhouse.model.VideoFileName;
import com.livesexhouse.model.VideoM2m;
import com.livesexhouse.model.VideoRoom;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class SiteController {

    @Autowired
    Pagination pagination;

    @Autowired
    SetupDao setupDao;

    @Autowired
    ContactDao contactDao;

    @Autowired
    VideoDao videoDao;

    @Autowired
    MemberHouseDao memberHouseDao;

    @Autowired
    VideoRoomDao videoRoomDao;

    @Autowired
    VideoCategoryDao videoCategoryDao;

    @Autowired
    VideoCategoryCountClipDao videoCategoryCountClipDao;

    @Autowired
    Comparator comparator;

    @Autowired
    NameGenerator nameGenerator;

    @Autowired
    VideoFileNameDao videoFileNameDao;

    @Autowired
    VideoM2mDao videoM2mDao;

    @Autowired
    FrameGrabberDao frameGrabberDao;

    @Autowired
    SaveVideoFile saveVideoFile;

    @Autowired
    SessionFactory sessionFactory;
    
    @Autowired
    Params params;
    
    @Autowired
    UserDao userDao;
    
   

    private ActiveUserService activeUserService;

//    List<Setup> setups = setupDao.getSetups();
//    
//    String location = setups.get(0).getValueString();
//    String path = setups.get(1).getValueString();
//    int maxVideoPerPage = setups.get(2).getValueInt();
//    String method = setups.get(3).getValueString();
//    String siteName = setups.get(4).getValueString();
//    int totalSeasons = setups.get(5).getValueInt();
//    String noVideoFound = setups.get(6).getValueString();
//    String videosLocation = setups.get(7).getValueString();
//    String videosUploadLocation = setups.get(8).getValueString();
    @MessageMapping("/activeUsers")
    public void activeUsers(Message<Object> message) {
        Principal user = message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER, Principal.class);
        activeUserService.mark(user.getName());
    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public String logoutDo(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        SecurityContextHolder.clearContext();
        session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        model.addAttribute("path", setupDao.getPath());
        model.addAttribute("location", setupDao.getLocation());

        return "index";
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView defaultPage(Principal principal) {

        ModelAndView model = new ModelAndView();

        String userName = "";
        if (principal != null) {
            userName = principal.getName();
        }
        model.addObject("userName", userName);

        model.addObject("path", setupDao.getPath());
        model.addObject("location", setupDao.getLocation());
        model.setViewName("index");

        return model;

    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();

        model.setViewName("admin");
        return model;

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error
    ) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username or password!");
        }

        model.setViewName("login");

        model.addObject("path", setupDao.getPath());
        model.addObject("location", setupDao.getLocation());

        return model;

    }

    //for 403 access denied page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {

        ModelAndView model = new ModelAndView();

        //check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            model.addObject("username", userDetail.getUsername());
        }

        model.setViewName("403");
        return model;

    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

    @RequestMapping("/uploadMultiPage")
    public String uploadMultiPage(
            ModelMap model,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {
        try {
            List<MemberHouse> memberHouse = memberHouseDao.find();
            List<VideoRoom> videoRoom = videoRoomDao.find();
            List<VideoCategories> videoCategories = videoCategoryDao.find();
            List<Setup> setups = setupDao.getSetups();
            int totalSeasons = setups.get(5).getValueInt();

            model.addAttribute("totalSeasons", totalSeasons);
            model.addAttribute("memberHouse", memberHouse);
            model.addAttribute("videoRoom", videoRoom);
            model.addAttribute("videoCategories", comparator.sortCategory(videoCategories));
            model.addAttribute("path", setupDao.getPath());
            model.addAttribute("location", setupDao.getLocation());

        } catch (Exception ex) {
        }
        return "uploadMulti";
    }

    @RequestMapping(value = "/uploadMulti", method = RequestMethod.POST)

    public String multiFileUpload(
            @RequestParam("file") MultipartFile[] files,
            @RequestParam("name") String[] names,
            @RequestParam("tag") String[] tags,
            HttpServletRequest request,
            @RequestParam("season") Integer[] season,
            RedirectAttributes redirectAttributes,
            Principal principal) {

        System.setProperty("org.bytedeco.javacpp.maxphysicalbytes", "0");
        System.setProperty("org.bytedeco.javacpp.maxbytes", "0");

        boolean successClipHdd = true;
        StringJoiner failFileSaveMsg = new StringJoiner(" </br>");

        boolean successGrab = true;
        ArrayList<String> failGrabList = new ArrayList<>();
        StringJoiner failGrabMsg = new StringJoiner(" </br>");

        boolean successVideoDB = true;
        ArrayList<String> failSaveDbList = new ArrayList<>();
        ArrayList<Integer> successSaveDbListInt = new ArrayList<>();
        StringJoiner failSaveDbMsg = new StringJoiner(" </br>");

        boolean successFileNameDB = true;
        ArrayList<String> failSaveFileNameList = new ArrayList<>();
        StringJoiner failSaveFileNameMsg = new StringJoiner(" </br>");
        ArrayList<Integer> successSaveFileNameList = new ArrayList<>();

        boolean successM2mDB = true;
        ArrayList<String> failSaveM2mList = new ArrayList<>();
        StringJoiner failSaveM2mMsg = new StringJoiner(" </br>");
        ArrayList<Integer> successM2mList = new ArrayList<>();

        boolean successM2mIn = true;
        StringJoiner failSaveM2mInMsg = new StringJoiner(" </br>");
        ArrayList<String> failSaveM2mInList = new ArrayList<>();
        ArrayList<Integer> successM2mInList = new ArrayList<>();

        boolean successRename = true;
        StringJoiner failSaveRenameMsg = new StringJoiner(" </br>");
        ArrayList<String> failSaveRenameList = new ArrayList<>();
        ArrayList<Integer> successRenameList = new ArrayList<>();

        boolean allCheck = true;
        boolean update = true;
        ArrayList<Integer> updateList = new ArrayList<>();

        try {
            List<Setup> setups = setupDao.getSetups();
            String videosUploadLocation = setups.get(8).getValueString();
            String imgSaveLocation = setups.get(9).getValueString();

            List<VideoCategories> videoCategories = videoCategoryDao.find();
            List<MemberHouse> memberHouse = memberHouseDao.find();
            List<VideoRoom> videoRooms = videoRoomDao.find();
            int totalSeasons = setups.get(5).getValueInt();

            Date date = new Date();
            StringJoiner saveClips = new StringJoiner(" </br>");
            VideoFileName videoFileName = new VideoFileName();
            VideoClip videoClip = new VideoClip();
            VideoM2m videoM2m = new VideoM2m();
            VideoM2m videoM2mRoom = new VideoM2m();
            VideoM2m videoM2mCategory = new VideoM2m();
            VideoM2m videoM2mMember = new VideoM2m();

            Integer clipId = 0;
            String videoName2save = "";

            int countFile = 0;
            int countName = 0;

            for (MultipartFile f : files) {
                if (!f.isEmpty()) {
                    countFile++;
                }
            }

            for (String s : names) {
                if (!s.isEmpty()) {
                    countName++;
                }
            }

            if (countFile == countName) { // ako svi fajlovi imaju ime
                // cuva se file.mp4

                for (int i = 0; i < files.length; i++) {

                    try {
                        String name = names[i];
                        String tag = tags[i];
                        if (files[i].isEmpty()) {
                            continue;
                        }

                        String generatedName = nameGenerator.nextKey();
                        while (videoFileNameDao.exist(generatedName)) {
                            generatedName = nameGenerator.nextKey();
                        }

                        videoName2save = videosUploadLocation + generatedName + files[i].getOriginalFilename().substring(files[i].getOriginalFilename().length() - 4, files[i].getOriginalFilename().length());

                        //
                        boolean successSave = saveVideoFile.save(files[i].getBytes(), videoName2save);

                        if (successSave) { // ako je sacuvan fajl
                            // grebuju se slike

                            Object[] tmp = frameGrabberDao.grab(videoName2save, imgSaveLocation + generatedName);

                            boolean succsGrab = (boolean) tmp[0];

                            if (succsGrab) { // ako su grebovane sve slike
                                // cuva se video klip u bazi

                                videoClip.setTag(tag);
                                videoClip.setUploadDate(date);
                                videoClip.setViewCount(0);
                                videoClip.setVoteDown(0);
                                videoClip.setVoteUp(0);
                                videoClip.setWishList(0);
                                videoClip.setDuration(((Double) tmp[1]).intValue());
                                videoClip.setName(name);
                                videoClip.setEnabled(0);
                                clipId = videoDao.saveR(videoClip);

                                if (clipId != 0) { // ako je sacuvan klip u bazi
                                    // cuva se fileName u bazi

                                    videoFileName.setClipId(clipId);

                                    videoFileName.setFileName(generatedName);
                                    Object[] tempo = videoFileNameDao.save(videoFileName);
                                    boolean videoFileNameB = (boolean) tempo[0];

                                    if (videoFileNameB) { // ako je sacuvan fileName u bazi
                                        // cuva se 1 m2m u bazi

                                        videoM2m.setSeason(season[i]);
                                        videoM2m.setClipId(clipId);
                                        videoM2mRoom.setClipId(clipId);
                                        videoM2mCategory.setClipId(clipId);
                                        videoM2mMember.setClipId(clipId);
                                        Object[] temp = videoM2mDao.save(videoM2m);
                                        boolean videoM2mB = (boolean) temp[0];
//videoM2mB=false;
                                        if (videoM2mB) { // ako je sacuvan video M2m u bazi
                                            // cuvaju se mnogobrojni m2m parametri u bazi

                                            for (int vr = 0; vr < videoRooms.size(); vr++) {
                                                if (request.getParameter("videoRoom" + i + videoRooms.get(vr).getId()) != null && allCheck) {
                                                    videoM2mRoom.setRoom(Integer.parseInt(request.getParameter("videoRoom" + i + videoRooms.get(vr).getId())));
                                                    Object[] tempor = videoM2mDao.save(videoM2mRoom);
                                                    if (!(boolean) tempor[0]) {
                                                        successM2mIn = false;
                                                        failSaveM2mInList.add(generatedName);
                                                        successM2mList.add((Integer) temp[1]);
                                                        successSaveDbListInt.add(clipId);
                                                        successSaveFileNameList.add((Integer) tempo[1]);
                                                        allCheck = false;
                                                        update = false;
                                                    } else {
                                                        successM2mInList.add((Integer) tempor[1]);

                                                    }

                                                }
                                            }

                                            if (allCheck) {
                                                for (int vc = 0; vc < videoCategories.size(); vc++) {
                                                    if (request.getParameter("category" + i + videoCategories.get(vc).getId()) != null && allCheck) {
                                                        videoM2mCategory.setCategoryId(Integer.parseInt(request.getParameter("category" + i + videoCategories.get(vc).getId())));
                                                        Object[] tempor = videoM2mDao.save(videoM2mCategory);
                                                        if (!(boolean) tempor[0]) {
                                                            successM2mIn = false;
                                                            failSaveM2mInList.add(generatedName);
                                                            successM2mList.add((Integer) temp[1]);
                                                            successSaveDbListInt.add(clipId);
                                                            successSaveFileNameList.add((Integer) tempo[1]);
                                                            allCheck = false;
                                                            update = false;
                                                        } else {
                                                            successM2mInList.add((Integer) tempor[1]);

                                                        }

                                                    }
                                                }
                                            }

                                            if (allCheck) {
                                                for (int mh = 0; mh < memberHouse.size(); mh++) {
                                                    if (request.getParameter("memberHouse" + i + memberHouse.get(mh).getId()) != null && allCheck) {
                                                        videoM2mMember.setMemberHouseId(Integer.parseInt(request.getParameter("memberHouse" + i + memberHouse.get(mh).getId())));

                                                        Object[] tempor = videoM2mDao.save(videoM2mMember);

                                                        if (!(boolean) tempor[0]) {
                                                            successM2mIn = false;
                                                            failSaveM2mInList.add(generatedName);
                                                            successM2mList.add((Integer) temp[1]);
                                                            successSaveDbListInt.add(clipId);
                                                            successSaveFileNameList.add((Integer) tempo[1]);
                                                            allCheck = false;
                                                            update = false;
                                                        } else {
                                                            successM2mInList.add((Integer) tempor[1]);

                                                        }

                                                    }
                                                }
                                            }

                                            if (allCheck) {

                                                //ako je sve ok rinejmuje se klip i slike i vraca bul
                                                boolean rename = saveVideoFile.rename(imgSaveLocation, videosUploadLocation, generatedName, clipId);

                                                if (rename) {
                                                    VideoFileName vfn = videoFileNameDao.findById(clipId);
                                                    videoFileNameDao.delete(vfn);
                                                    updateList.add(clipId);
                                                    saveClips.add(name);

                                                } else {
                                                    for (Integer in : successM2mInList) {
                                                        VideoM2m vfn = videoM2mDao.findById(in);
                                                        videoM2mDao.delete(vfn);
                                                    }
                                                    allCheck = true;

                                                    successSaveDbListInt.add(clipId);
                                                    successSaveFileNameList.add((Integer) tempo[1]);

                                                    successRename = false;
                                                    failSaveRenameMsg.add(name);
                                                    failSaveRenameList.add(generatedName);
                                                    successRenameList.add((Integer) temp[1]);
                                                }

                                            } else {
                                                try {
                                                    for (Integer in : successM2mInList) {
                                                        VideoM2m vfn = videoM2mDao.findById(in);
                                                        videoM2mDao.delete(vfn);
                                                    }
                                                } catch (Exception ee) {
                                                }
                                                allCheck = true;
                                                failSaveM2mInMsg.add(name);
                                            }

                                            successM2mInList.clear();

                                        } else { // ako ne moze da sacuva videoM2m
                                            successM2mDB = false;
                                            failSaveM2mList.add(generatedName);
                                            failSaveM2mMsg.add(name);

                                            successSaveDbListInt.add(clipId);
                                            successSaveFileNameList.add((Integer) tempo[1]);

                                        }

                                    } else { // ako ne moze da sacuva file name u bazi
                                        successFileNameDB = false;
                                        failSaveFileNameList.add(generatedName);
                                        failSaveFileNameMsg.add(name);
                                        successSaveDbListInt.add(clipId);

                                    }

                                } else { // ako ne moze da sacuva u bazi
                                    successVideoDB = false;
                                    failSaveDbList.add(generatedName);
                                    failSaveDbMsg.add(name);

                                }

                            } else { // ako nije grebovao sve
                                successGrab = false;
                                failGrabList.add(generatedName);
                                failGrabMsg.add(name);

                            }
                        } else { // ako nije sacuvao mp4 fajl
                            successClipHdd = false;
                            failFileSaveMsg.add(name);

                        }

                        if (allCheck) {

                        }

                    } catch (Exception e) {
                    }
                }

                if (saveClips.length() > 0) {
                    redirectAttributes.addFlashAttribute("message",
                            "<h2>You successfully uploaded:</h2></br> " + saveClips.toString() + "");
                }

            } else {                 // ako ne postoji ime za neki klip ili je neki fajl prazan //
                redirectAttributes.addFlashAttribute("message",
                        "Some of your videos dot't have name or file, please check and try again");
            }

            if (!successClipHdd) { // ako nije sacuvao klip na hddu //
                redirectAttributes.addFlashAttribute("messageFailSaveHdd",
                        "<h1 style=\"color:white; \">Videos with ERROR</h1> "
                        + "<h2>EXPLAIN:can't save on hdd videos with name:</h2></br> " + failFileSaveMsg.toString() + "");
            }

            if (!successGrab) { // ako nije grebovao //
                try {
                    saveVideoFile.deleteFile(failGrabList, videosUploadLocation);
                } catch (Exception ee) {
                }
                redirectAttributes.addFlashAttribute("messageFailGrab",
                        "<h1 style=\"color:white; \">Videos with ERROR</h1> "
                        + "<h2>EXPLAIN:can't grab videos with name:</h2></br> " + failGrabMsg.toString() + "");
            }

            if (!successVideoDB) { // ako nije sacuvao u bazi 
                try {
                    saveVideoFile.deleteFile(failSaveDbList, videosUploadLocation);
                } catch (Exception ee) {
                }
                try {
                    saveVideoFile.deletePics(failSaveDbList, imgSaveLocation);
                } catch (Exception ee) {
                }
                redirectAttributes.addFlashAttribute("messageFailSaveDB",
                        "<h1 style=\"color:white; \">Videos with ERROR</h1> "
                        + "<h2>EXPLAIN:can't save videos in DB with name:</h2></br> " + failSaveDbMsg.toString() + "");
            }

            if (!successFileNameDB) { // ako nije sacuvao fileName u bazi // 
                try {
                    saveVideoFile.deleteFile(failSaveFileNameList, videosUploadLocation);
                } catch (Exception ee) {
                }
                try {
                    saveVideoFile.deletePics(failSaveFileNameList, imgSaveLocation);
                } catch (Exception ee) {
                }
                try {
                    for (Integer in : successSaveDbListInt) {
                        VideoClip vc = (VideoClip) videoDao.findById(in);
                        videoDao.delete(vc);
                    }

                } catch (Exception ee) {
                }
                redirectAttributes.addFlashAttribute("messageFailSaveNameDB",
                        "<h1 style=\"color:white; \">Videos with ERROR</h1> "
                        + "<h2>EXPLAIN:can't save videos fileName  in DB with name:</h2></br> " + failSaveFileNameMsg.toString() + "");
            }

            if (!successM2mDB) { // ako nije sacuvao m2m u bazi //
                try {
                    saveVideoFile.deleteFile(failSaveM2mList, videosUploadLocation);
                } catch (Exception ee) {
                }
                try {
                    saveVideoFile.deletePics(failSaveM2mList, imgSaveLocation);
                } catch (Exception ee) {
                }
                try {

                    for (Integer in : successSaveDbListInt) {
                        VideoClip vc = videoDao.findById(in);
                        videoDao.delete(vc);
                    }

                } catch (Exception ee) {
                }
                try {

                    for (Integer in : successSaveFileNameList) {
                        VideoFileName vfn = videoFileNameDao.findById(in);
                        videoFileNameDao.delete(vfn);
                    }

                } catch (Exception ee) {
                }
                redirectAttributes.addFlashAttribute("messageFailM2mDB",
                        "<h1 style=\"color:white; \">Videos with ERROR</h1> "
                        + "<h2>EXPLAIN:can't save videos m2m in DB with name:</h2></br> " + failSaveM2mMsg.toString() + "");
            }

            if (!successM2mIn) { // ako nije sacuvao m2mIn u bazi
                try {
                    saveVideoFile.deleteFile(failSaveM2mInList, videosUploadLocation);
                } catch (Exception ee) {
                }
                try {
                    saveVideoFile.deletePics(failSaveM2mInList, imgSaveLocation);
                } catch (Exception ee) {
                }
                try {

                    for (Integer in : successSaveDbListInt) {
                        VideoClip vc = videoDao.findById(in);
                        videoDao.delete(vc);
                    }

                } catch (Exception ee) {
                }
                try {

                    for (Integer in : successSaveFileNameList) {
                        VideoFileName vfn = videoFileNameDao.findById(in);
                        videoFileNameDao.delete(vfn);
                    }

                } catch (Exception ee) {
                }

                try {

                    for (Integer in : successM2mList) {
                        VideoM2m vfn = videoM2mDao.findById(in);
                        videoM2mDao.delete(vfn);
                    }

                } catch (Exception ee) {
                }

                redirectAttributes.addFlashAttribute("messageFailM2mInDB",
                        "<h1 style=\"color:white; \">Videos with ERROR</h1> "
                        + "<h2>EXPLAIN:can't save videos m2mIn in DB with name:</h2></br> " + failSaveM2mInMsg.toString() + "");
            }

            if (!successRename) { // ako nije rinejmovao slike i klipove
                try {
                    saveVideoFile.deleteFile(failSaveRenameList, videosUploadLocation);
                } catch (Exception ee) {
                }
                try {
                    saveVideoFile.deletePics(failSaveRenameList, imgSaveLocation);
                } catch (Exception ee) {
                }
                try {

                    for (Integer in : successSaveDbListInt) {
                        VideoClip vc = videoDao.findById(in);
                        videoDao.delete(vc);
                    }

                } catch (Exception ee) {
                }
                try {

                    for (Integer in : successSaveFileNameList) {
                        VideoFileName vfn = videoFileNameDao.findById(in);
                        videoFileNameDao.delete(vfn);
                    }

                } catch (Exception ee) {
                }

                try {

                    for (Integer in : successRenameList) {
                        VideoM2m vfn = videoM2mDao.findById(in);
                        videoM2mDao.delete(vfn);
                    }

                } catch (Exception ee) {
                }

                redirectAttributes.addFlashAttribute("failSaveRenameMsg",
                        "<h1 style=\"color:white; \">Videos with ERROR</h1> "
                        + "<h2>EXPLAIN:can't rename videos on fs with name:</h2></br> " + failSaveRenameMsg.toString() + "");
            }

            if (update) {

                for (Integer ul : updateList) {

                    VideoClip vcc = new VideoClip();
                    vcc = (VideoClip) videoDao.findByIdNewSes(ul);
                    if (vcc != null) {
                        vcc.setEnabled(1);
                        try {
                            videoDao.update(vcc);
                        } catch (Exception h) {
                        }
                    }

                }
            }

        } catch (Exception ex) {

        }
        return "redirect:/uploadStatus";

    }

    @RequestMapping("/video/{id}")
    public String video(
            @PathVariable int id,
            ModelMap model,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {
        try {

            List<Setup> setups = setupDao.getSetups();
            int totalSeasons = setups.get(5).getValueInt();
            String location = setups.get(0).getValueString();

            String path = setups.get(1).getValueString();

            VideoClip v = videoDao.findById(id);

            List<MemberHouse> memberHouse = memberHouseDao.find();
            List<VideoRoom> videoRoom = videoRoomDao.find();
            List<VideoCategories> videoCategories = videoCategoryDao.find();
            List<VideoCategoryCountClip> videoCategoryCountClips = videoCategoryCountClipDao.find();

            model.addAttribute("video", v);
            model.addAttribute("member", memberHouse);
            model.addAttribute("videoRoom", videoRoom);
            model.addAttribute("videoCategories", videoCategories);
            model.addAttribute("path", path);
            model.addAttribute("location", location);
            model.addAttribute("totalSeasons", totalSeasons);
            model.addAttribute("videoCategoryCountClips", videoCategoryCountClips);

        } catch (Exception ex) {
        }
        return "video-archive";
    }
    
   

    @RequestMapping(value = "/video", method = RequestMethod.GET)
    public String videos(
            Principal principal,
            //1.firstResult
            @RequestParam(required = false, value = "1", defaultValue = "0") int firstResult,
            //2.SORT
            //name 1=asc 2=desc
            //wishList 3=desc 
            //views 4=edsc
            //likes 5=asc 6=desc
            //date 7=asc 8=desc
            //season 9=asc 10=desc
            //duration 11=asc 12=desc
            @RequestParam(required = false, value = "2", defaultValue = "0") int sort,
            //FILTERS
            //3.date 
            @RequestParam(required = false, value = "3", defaultValue = "0") String dateFilter,
            //4.room 
            @RequestParam(required = false, value = "4", defaultValue = "0") int[] roomFilter,
            //5.season 
            @RequestParam(required = false, value = "5", defaultValue = "0") int[] seasonFilter,
            //6.duration
            @RequestParam(required = false, value = "6", defaultValue = "0") int[] durationFilter,
            //7.member
            @RequestParam(required = false, value = "7", defaultValue = "0") int[] memberFilter,
            //8.category
            @RequestParam(required = false, value = "8", defaultValue = "0") int[] categoryFilter,
            //9.reset
            @RequestParam(required = false, value = "9", defaultValue = "0") int resetFirstResult,
            //10.search
            @RequestParam(required = false, value = "10", defaultValue = "0") String search,
            ModelMap model,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {
        try {

            

            String userName = "";
            if (principal != null) {
                userName = principal.getName();
            }
            model.addAttribute("userName", userName);

            List<Setup> setups = setupDao.getSetups();
            int maxVideoPerPage = setups.get(2).getValueInt();
            int totalSeasons = setups.get(5).getValueInt();
            String location = setups.get(0).getValueString();
            String noVideoFound = setups.get(6).getValueString();
            String path = setups.get(1).getValueString();
            String videoLocation = setups.get(8).getValueString();
            String imgLocation = setups.get(9).getValueString();
            String startDate = setups.get(10).getValueString();
            Boolean bigPagination = false;
            String pag = "";
            int numberOfVideos = 0;
            List<VideoClip> videosResultsList = new ArrayList<>();
            List<MemberHouse> memberHouse = memberHouseDao.find();

            List<VideoRoom> videoRoom = videoRoomDao.find();
            List<VideoCategories> videoCategories = videoCategoryDao.find();
            List<VideoCategoryCountClip> videoCategoryCountClips = videoCategoryCountClipDao.find();
            List<String> individualPar = new ArrayList<>();
            int videoNumTotal = 0;

            noVideoFound = "<p style=\"color:white\">" + noVideoFound + "</p>";

  
            
            String allParams = "";
            String paramsWithoutSort = "";
            
            
            if (!dateFilter.equals("0")){
                if(dateFilter.charAt(4)!='-'){
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm/DD/yyyy");
                Date date = simpleDateFormat.parse(dateFilter);
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-mm-DD");
                dateFilter = simpleDateFormat2.format(date);
                }
            }
               
            String filterDateExist = "yes";
            if (!dateFilter.equals("0"))
                filterDateExist = "1";
            
            

            if (!dateFilter.equals("0") || roomFilter.length > 1 || seasonFilter.length > 1 || durationFilter.length > 1 || memberFilter.length > 1 || categoryFilter.length > 1 || sort != 0) {
                bigPagination = true;
            }

            if (!bigPagination) {

                if (roomFilter.length == 1) {
                    if (roomFilter[0] != 0) {
                        bigPagination = true;
                    }
                }

                if (seasonFilter.length == 1) {
                    if (seasonFilter[0] != 0) {
                        bigPagination = true;
                    }
                }

                if (durationFilter.length == 1) {
                    if (durationFilter[0] != 0) {
                        bigPagination = true;
                    }
                }

                if (memberFilter.length == 1) {
                    if (memberFilter[0] != 0) {
                        bigPagination = true;
                    }
                }

                if (categoryFilter.length == 1) {
                    if (categoryFilter[0] != 0) {
                        bigPagination = true;
                    }
                }

            }

            
        
            
            if (bigPagination) {
                Object[] par = params.allParam(categoryFilter, roomFilter, memberFilter, seasonFilter, durationFilter, sort, dateFilter,totalSeasons, memberHouse, videoRoom, videoCategories , totalSeasons);
                allParams = (String) par[0];
                paramsWithoutSort = (String) par[1];
                individualPar = (List<String>)par[2];

                Object[] tmp = videoDao.find(maxVideoPerPage, firstResult, sort, dateFilter, roomFilter, seasonFilter, durationFilter, memberFilter, categoryFilter);

                videosResultsList = (List<VideoClip>) tmp[0];
                numberOfVideos = (int) tmp[1];
                videoNumTotal = (int) tmp[2];
            } else {
                Object[] tmp = videoDao.findAll(maxVideoPerPage, firstResult);
                videosResultsList = (List<VideoClip>) tmp[0];
                numberOfVideos = (int) tmp[1];
                videoNumTotal = numberOfVideos;
            }

            if (numberOfVideos > maxVideoPerPage) {
                if (!bigPagination) {
                    pag = pagination.pagination(firstResult, numberOfVideos, "video", maxVideoPerPage, path);
                } else {
                    pag = pagination.pagination(firstResult, numberOfVideos, "video", maxVideoPerPage, path, allParams);
                }
            }

            if (numberOfVideos != 0) {
                noVideoFound = "";
            }

            
            model.addAttribute("individualPar", individualPar);
            model.addAttribute("noVideoFound", noVideoFound);
            model.addAttribute("member", memberHouse);
            model.addAttribute("videoRoom", videoRoom);
            model.addAttribute("videoCategories", videoCategories);
            model.addAttribute("path", path);
            model.addAttribute("location", location);
            model.addAttribute("pagination", pag);
            model.addAttribute("video", videosResultsList);
            model.addAttribute("totalSeasons", totalSeasons);
            model.addAttribute("videoNumTotal", videoNumTotal);
            model.addAttribute("videoCategoryCountClips", videoCategoryCountClips);
            model.addAttribute("videoLocation", videoLocation);
            model.addAttribute("imgLocation", imgLocation);
            model.addAttribute("filterDateExist", filterDateExist);

            
            model.addAttribute("startDate", startDate);
            model.addAttribute("sort", sort);
            model.addAttribute("dateFilter", dateFilter);
            model.addAttribute("roomFilter", roomFilter);
            model.addAttribute("seasonFilter", seasonFilter);
            model.addAttribute("durationFilter", durationFilter);
            model.addAttribute("memberFilter", memberFilter);
            model.addAttribute("categoryFilter", categoryFilter);
            model.addAttribute("paramsWithoutSort", paramsWithoutSort);
            model.addAttribute("params", allParams);
          

        } catch (Exception ex) {
        }
        return "video-archive";
    }

    @RequestMapping("/contact")
    public String archive(
            ModelMap model,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {
        try {
            model.addAttribute("path", setupDao.getPath());
            model.addAttribute("location", setupDao.getLocation());

        } catch (Exception ex) {
        }
        return "contact";
    }

    @RequestMapping(value = "/contactpost", method = RequestMethod.POST)
    public String contactpost(
            ModelMap model,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {
        try {
            model.addAttribute("path", setupDao.getPath());
            model.addAttribute("location", setupDao.getLocation());

            Contact c = new Contact();
            Date date = new Date();

            c.setName(request.getParameter("name"));
            c.setEmail(request.getParameter("mail"));
            c.setSubject(request.getParameter("subject"));
            c.setMessage(request.getParameter("message-text"));
            c.setLanguage(request.getParameter("lng"));
            c.setUserGroup(request.getParameter("user"));
            c.setDate(date);
            c.setIp(request.getRemoteAddr());

            contactDao.saveContact(c);

        } catch (Exception ex) {
        }
        return "index";
    }
    
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(
            ModelMap model,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {
        try {
            model.addAttribute("path", setupDao.getPath());
            model.addAttribute("location", setupDao.getLocation());

            String username = "";
            String password = "";
            String email = "";
            username = request.getParameter("username");
            password = request.getParameter("password");
            email = request.getParameter("email");

            boolean myChk=(request.getParameter("checkboxAccept")!=null)?true:false;
            if(!username.isEmpty() && !password.isEmpty() && !email.isEmpty() && !userDao.exist(username) && myChk)
            {
                Users user = new Users();
                user.setEmail(email);
                short m = 1;
                user.setEnabled(m);
                Date date = new Date();
                user.setMemberfrom(date);
                user.setPassword(password);
                user.setTokens(0);
                user.setUsername(username);
                
                userDao.save(user);
                
                
            } else{
                System.out.println("postoji");
            }

            

        } catch (Exception ex) {
        }
        return "index";
    }
    
     

    @RequestMapping("/participate")
    public String participate(
            ModelMap model,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {
        try {
            model.addAttribute("path", setupDao.getPath());
            model.addAttribute("location", setupDao.getLocation());

        } catch (Exception ex) {
        }
        return "participate";
    }

    @RequestMapping("/votevideo")
    public String votevideo(
            ModelMap model,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {
        try {
            model.addAttribute("path", setupDao.getPath());
            model.addAttribute("location", setupDao.getLocation());

        } catch (Exception ex) {
        }
        return "votevideo";
    }

    @RequestMapping("/vote")
    public String vote(
            ModelMap model,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {

        try {
            model.addAttribute("path", setupDao.getPath());
            model.addAttribute("location", setupDao.getLocation());

        } catch (Exception ex) {
        }
        return "vote";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(
            Principal principal,
            //1.firstResult
            @RequestParam(required = false, value = "1", defaultValue = "0") int firstResult,
            //2.SORT
            //name 1=asc 2=desc
            //wishList 3=desc 
            //views 4=edsc
            //likes 5=asc 6=desc
            //date 7=asc 8=desc
            //season 9=asc 10=desc
            //duration 11=asc 12=desc
            @RequestParam(required = false, value = "2", defaultValue = "0") int sort,
            //FILTERS
            //3.date 
            @RequestParam(required = false, value = "3", defaultValue = "0") String dateFilter,
            //4.room 
            @RequestParam(required = false, value = "4", defaultValue = "0") int[] roomFilter,
            //5.season 
            @RequestParam(required = false, value = "5", defaultValue = "0") int[] seasonFilter,
            //6.duration
            @RequestParam(required = false, value = "6", defaultValue = "0") int[] durationFilter,
            //7.member
            @RequestParam(required = false, value = "7", defaultValue = "0") int[] memberFilter,
            //8.category
            @RequestParam(required = false, value = "8", defaultValue = "0") int[] categoryFilter,
            //9.reset
            @RequestParam(required = false, value = "9", defaultValue = "0") int resetFirstResult,
            //10.search
            @RequestParam(required = false, value = "10", defaultValue = "0") String search,
            ModelMap model,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {
        
         try {

            

            String userName = "";
            if (principal != null) {
                userName = principal.getName();
            }
            model.addAttribute("userName", userName);

            List<Setup> setups = setupDao.getSetups();
            int maxVideoPerPage = setups.get(2).getValueInt();
            int totalSeasons = setups.get(5).getValueInt();
            String location = setups.get(0).getValueString();
            String noVideoFound = setups.get(6).getValueString();
            String path = setups.get(1).getValueString();
            String videoLocation = setups.get(8).getValueString();
            String imgLocation = setups.get(9).getValueString();
            String startDate = setups.get(10).getValueString();
            Boolean bigPagination = false;
            String pag = "";
            int numberOfVideos = 0;
            List<VideoClip> videosResultsList = new ArrayList<>();
            List<MemberHouse> memberHouse = memberHouseDao.find();

            List<VideoRoom> videoRoom = videoRoomDao.find();
            List<VideoCategories> videoCategories = videoCategoryDao.find();
            List<VideoCategoryCountClip> videoCategoryCountClips = videoCategoryCountClipDao.find();
            List<String> individualPar = new ArrayList<>();
            int videoNumTotal = 0;

            noVideoFound = "<p style=\"color:white\">" + noVideoFound + "</p>";

            
            
            
            
            
            
             String string = "";
            
            string = request.getParameter("string");

            
            
            if(!string.isEmpty())
            {
                String[] parts = string.split(" ");

            } else{
                System.out.println("postoji");
            }

            
            
            
            
            
            
            
            
            String allParams = "";
            String paramsWithoutSort = "";
            
            
            if (!dateFilter.equals("0")){
                if(dateFilter.charAt(4)!='-'){
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm/DD/yyyy");
                Date date = simpleDateFormat.parse(dateFilter);
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-mm-DD");
                dateFilter = simpleDateFormat2.format(date);
                }
            }
               
            String filterDateExist = "yes";
            if (!dateFilter.equals("0"))
                filterDateExist = "1";
            
            

            if (!dateFilter.equals("0") || roomFilter.length > 1 || seasonFilter.length > 1 || durationFilter.length > 1 || memberFilter.length > 1 || categoryFilter.length > 1 || sort != 0) {
                bigPagination = true;
            }

            if (!bigPagination) {

                if (roomFilter.length == 1) {
                    if (roomFilter[0] != 0) {
                        bigPagination = true;
                    }
                }

                if (seasonFilter.length == 1) {
                    if (seasonFilter[0] != 0) {
                        bigPagination = true;
                    }
                }

                if (durationFilter.length == 1) {
                    if (durationFilter[0] != 0) {
                        bigPagination = true;
                    }
                }

                if (memberFilter.length == 1) {
                    if (memberFilter[0] != 0) {
                        bigPagination = true;
                    }
                }

                if (categoryFilter.length == 1) {
                    if (categoryFilter[0] != 0) {
                        bigPagination = true;
                    }
                }

            }

            
        
            
            if (bigPagination) {
                Object[] par = params.allParam(categoryFilter, roomFilter, memberFilter, seasonFilter, durationFilter, sort, dateFilter,totalSeasons, memberHouse, videoRoom, videoCategories , totalSeasons);
                allParams = (String) par[0];
                paramsWithoutSort = (String) par[1];
                individualPar = (List<String>)par[2];

                Object[] tmp = videoDao.find(maxVideoPerPage, firstResult, sort, dateFilter, roomFilter, seasonFilter, durationFilter, memberFilter, categoryFilter);

                videosResultsList = (List<VideoClip>) tmp[0];
                numberOfVideos = (int) tmp[1];
                videoNumTotal = (int) tmp[2];
            } else {
                Object[] tmp = videoDao.findAll(maxVideoPerPage, firstResult);
                videosResultsList = (List<VideoClip>) tmp[0];
                numberOfVideos = (int) tmp[1];
                videoNumTotal = numberOfVideos;
            }

            if (numberOfVideos > maxVideoPerPage) {
                if (!bigPagination) {
                    pag = pagination.pagination(firstResult, numberOfVideos, "video", maxVideoPerPage, path);
                } else {
                    pag = pagination.pagination(firstResult, numberOfVideos, "video", maxVideoPerPage, path, allParams);
                }
            }

            if (numberOfVideos != 0) {
                noVideoFound = "";
            }

            
            model.addAttribute("individualPar", individualPar);
            model.addAttribute("noVideoFound", noVideoFound);
            model.addAttribute("member", memberHouse);
            model.addAttribute("videoRoom", videoRoom);
            model.addAttribute("videoCategories", videoCategories);
            model.addAttribute("path", path);
            model.addAttribute("location", location);
            model.addAttribute("pagination", pag);
            model.addAttribute("video", videosResultsList);
            model.addAttribute("totalSeasons", totalSeasons);
            model.addAttribute("videoNumTotal", videoNumTotal);
            model.addAttribute("videoCategoryCountClips", videoCategoryCountClips);
            model.addAttribute("videoLocation", videoLocation);
            model.addAttribute("imgLocation", imgLocation);
            model.addAttribute("filterDateExist", filterDateExist);

            
            model.addAttribute("startDate", startDate);
            model.addAttribute("sort", sort);
            model.addAttribute("dateFilter", dateFilter);
            model.addAttribute("roomFilter", roomFilter);
            model.addAttribute("seasonFilter", seasonFilter);
            model.addAttribute("durationFilter", durationFilter);
            model.addAttribute("memberFilter", memberFilter);
            model.addAttribute("categoryFilter", categoryFilter);
            model.addAttribute("paramsWithoutSort", paramsWithoutSort);
            model.addAttribute("params", allParams);
          

        } catch (Exception ex) {
        }
            
           

        
        return "video-archive";
    }
    
    
    
    
    
    

}
