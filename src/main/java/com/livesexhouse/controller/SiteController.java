package com.livesexhouse.controller;

import com.google.common.collect.Sets;
import com.livesexhouse.DAO.*;
import com.livesexhouse.model.BlockedCountryM2m;
import com.livesexhouse.model.BlockedRegionM2m;
import com.livesexhouse.model.Contact;
import com.livesexhouse.model.Girls;
import com.livesexhouse.model.Heartbeat;
import com.livesexhouse.model.InteresM2m;
import com.livesexhouse.model.KinkyM2m;
import com.livesexhouse.model.MemberHouse;
import com.livesexhouse.model.MembersRank;
import com.livesexhouse.model.Model;
import com.livesexhouse.model.Participant;
import com.livesexhouse.model.Time;
import com.livesexhouse.model.UserM2m;
import com.livesexhouse.model.UserRoles;
import com.livesexhouse.model.Users;
import com.livesexhouse.model.UsersActivate;
import com.livesexhouse.model.VideoCategories;
import com.livesexhouse.model.VideoCategoryCountClip;
import com.livesexhouse.model.VideoClip;
import com.livesexhouse.model.VideoFileName;
import com.livesexhouse.model.VideoM2m;
import com.livesexhouse.model.VideoRoom;
import com.livesexhouse.model.YourWish;
import com.livesexhouse.model.YourWishAction;
import com.livesexhouse.model.YourWishExtra;
import com.livesexhouse.service.PricePackageService;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
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

    @Autowired
    Redirect redirect;

    @Autowired
    UserM2mDAO userM2mDAO;

    @Autowired
    UsersActivateDAO usersActivateDAO;

    @Autowired
    GoogleMail googleMail;

    @Autowired
    GirlDao girlDao;

    @Autowired
    OnlineDao onlineDao;

    @Autowired
    MemberRankDao memberRankDao;

    @Autowired
    YourWishDao yourWishDao;

    @Autowired
    YourWishExtraDao yourWishExtraDao;

    @Autowired
    YourWishActionDao yourWishActionDao;

    @Autowired
    ParticipantDao participantDao;

    @Autowired
    ChatMembersDao chatMembersDao;

    @Autowired
    HeartbeatDao heartbeatDao;

    @Autowired
    TimeDao timeDao;

    @Autowired
    Checker checker;

    @Autowired
    ModelDao modelDao;

    @Autowired
    private PricePackageService pricePackageService;
    
    @Autowired
    BCryptPasswordEncoder encoder;

    @RequestMapping(value = "/girlSetup", method = RequestMethod.POST)
    public String girlSetup(
            ModelMap model,
            HttpServletResponse response, RedirectAttributes redirectAttributes,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            Principal principal,
            HttpServletRequest request) throws Exception {
        int id = 0;
        try {

            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }
            if (principal != null && request.isUserInRole("ROLE_GIRL")) {

                Users u = new Users();
                u = userDao.findByUsername(principal.getName());
                model.addAttribute("userName", principal.getName());
                model.addAttribute("user", u);
                id = u.getId();
                Girls g = new Girls();
                g = girlDao.findById(u.getId());

                String groupMinPerson = "";
                String groupTariff = "";
                String privateTariff = "";

                groupMinPerson = request.getParameter("groupMinPerson");
                groupTariff = request.getParameter("groupTariff");
                privateTariff = request.getParameter("privateTariff");

                if (!groupMinPerson.isEmpty()) {
                    g.setGroupMinPerson(Integer.valueOf(request.getParameter("groupMinPerson")));
                }
                if (!groupTariff.isEmpty()) {
                    g.setGroupTariff(Integer.valueOf(request.getParameter("groupTariff")));
                }
                if (!privateTariff.isEmpty()) {
                    g.setPrivateTariff(Integer.valueOf(request.getParameter("privateTariff")));
                }

                girlDao.updateGirl(g);

            }

            model.addAttribute("path", setupDao.getPath());
            model.addAttribute("bck", "");
            model.addAttribute("location", setupDao.getLocation());

        } catch (Exception ex) {
        }
        return "redirect:/webcam/" + id;
    }

    @RequestMapping("/webcam/{id}")
    public String webcam(
            Principal principal, RedirectAttributes redirectAttributes,
            ModelMap model, @PathVariable int id,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {
        Boolean alredySigned = false;
        String ret = "chat";
        try {
            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }
            if (principal != null) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());
                model.addAttribute("userName", principal.getName());
                model.addAttribute("user", u);
                System.out.println("w1");

                Time tGr = timeDao.getTimeGr(u.getId(), id);
                Time tPr = timeDao.getTimePr(u.getId(), id);

                System.out.println("w2");

                long timeGr = 301;
                long timePr = 301;

                if (tGr.getUserId() != 0) {
                    Date d2 = new Date();
                    Date d1 = tGr.getTime();
                    timeGr = (d2.getTime() - d1.getTime()) / 1000;

                }
                if (tPr.getUserId() != 0) {
                    Date d2 = new Date();
                    Date d1 = tPr.getTime();
                    timePr = (d2.getTime() - d1.getTime()) / 1000;
                }

                model.addAttribute("timeGr", timeGr);
                model.addAttribute("timePr", timePr);

                Girls g = new Girls();
                g = girlDao.findById(id);
                model.addAttribute("g", g);

                if (request.isUserInRole("ROLE_GIRL")) {
                    ret = "chatG";
                    int myOnlineStatus = onlineDao.onlineStatus(g.getId().toString());
                    model.addAttribute("myOnlineStatus", myOnlineStatus);

                }
                if (request.isUserInRole("ROLE_MEMBER")) {
                    ret = "chatMH";
                }

                int status = onlineDao.getStatus(id);

                List<Girls> l = new ArrayList<>();
                l = girlDao.findGirlsActive23(id);

                model.addAttribute("girlsOnline", l);

                String onl = "";
                onl = onlineDao.onlineNow();
                model.addAttribute("status", status);
                model.addAttribute("onlineNow", onl);
                
                List<Girls> l2 = new ArrayList<>();
            l2 = girlDao.findGirls();

            model.addAttribute("girl2", l2);

            String onl2 = "";
            onl2 = onlineDao.onlineNow();
            model.addAttribute("onlineNow2", onl2);
                

            } else {

                // you must be loged in
            }

            model.addAttribute("path", setupDao.getPath());
            model.addAttribute("location", setupDao.getLocation());
            model.addAttribute("bck", ".");

        } catch (Exception ex) {
        }
        return ret;
    }

    @RequestMapping("/webcammember/{id}")
    public String webcammember(
            Principal principal, RedirectAttributes redirectAttributes,
            ModelMap model, @PathVariable int id,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {
        Boolean alredySigned = false;
        String ret = "chatWithMember";
        Users m = new Users();
        try {
            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }
            if (principal != null) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());
                model.addAttribute("userName", principal.getName());
                model.addAttribute("user", u);

                if (request.isUserInRole("ROLE_MEMBER")) {
                    ret = "chatMH";
                }

                String nameM = "";
                int idM = 0;

                m = userDao.findById(id);

                nameM = m.getUsername();
                idM = m.getId();

                model.addAttribute("lnk", setupDao.getStreamLnkMH());
                model.addAttribute("nameM", nameM);
                model.addAttribute("idM", idM);

            } else {

                // you must be loged in
            }

            model.addAttribute("path", setupDao.getPath());
            model.addAttribute("location", setupDao.getLocation());
            model.addAttribute("bck", ".");

        } catch (Exception ex) {
        }
        return ret;
    }

    @RequestMapping("/webcam")
    public String webcam(
            Principal principal, RedirectAttributes redirectAttributes,
            ModelMap model,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {
        Boolean alredySigned = false;
        String ret = "webcam";
        try {
            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }
            if (principal != null) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());
                model.addAttribute("userName", principal.getName());
                model.addAttribute("user", u);

                if (request.isUserInRole("ROLE_GIRL")) {
                    ret = "redirect:webcam/" + u.getId();

                    Girls g = new Girls();
                    g = girlDao.findById(u.getId());
                    model.addAttribute("g", g);
                    int myOnlineStatus = onlineDao.onlineStatus(g.getId().toString());
                    model.addAttribute("myOnlineStatus", myOnlineStatus);
                }

            }

            List<Girls> l = new ArrayList<>();
            l = girlDao.findGirls();

            model.addAttribute("girl", l);

            String onl = "";
            onl = onlineDao.onlineNow();
            model.addAttribute("onlineNow", onl);

            model.addAttribute("path", setupDao.getPath());
            model.addAttribute("location", setupDao.getLocation());
            model.addAttribute("bck", "");

        } catch (Exception ex) {
        }
        return ret;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(
            ModelMap model,
            HttpServletResponse response, RedirectAttributes redirectAttributes,
            HttpServletRequest request) throws Exception {
        Boolean alredySigned = false;
        try {
            model.addAttribute("path", setupDao.getPath());
            model.addAttribute("location", setupDao.getLocation());

            String username = "";
            String password = "";
            String email = "";
            username = request.getParameter("username");
            password = request.getParameter("password");
            email = request.getParameter("email");

            boolean usernameB = !username.isEmpty();
            boolean passwordB = !password.isEmpty();
            boolean emailB = !email.isEmpty();
            boolean myChk = (request.getParameter("checkboxAccept") != null);
            boolean allT = false;
            boolean freeUserName = false;
            boolean freeEmail = false;
            String error = "";

            if (usernameB && passwordB && emailB && myChk) {
                allT = true;
            }

            if (allT) {

                if (!userDao.existUserName(username)) {
                    freeUserName = true;
                }

                if (!userDao.existEmail(email)) {
                    freeEmail = true;
                }

                if (freeUserName && freeEmail) {
                    Users user = new Users();
                    user.setEmail(email);
                    short m = 0;
                    user.setEnabled(m);
                    Date date = new Date();
                    user.setMemberfrom(date);
                    String passEn = encoder.encode(password);
                    user.setPassword(passEn);
                   
                    user.setTokens(0);
                    user.setUsername(username);

                    UserRoles ur = new UserRoles();
                    ur.setRole("ROLE_USER");
                    int userId = userDao.save(user);
                    ur.setUsernameId(userId);
                    userDao.saveRola(ur);

                    Cookie newCookieMail = new Cookie("livesexhouseCheckMail", "1");
                    newCookieMail.setPath("/");
                    newCookieMail.setMaxAge(0x3b9ac9ff);
                    response.addCookie(newCookieMail);

                    alredySigned = true;
                    redirectAttributes.addFlashAttribute("checkEmail", true);

                    String gn = nameGenerator.nextKey();
                    while (usersActivateDAO.exist(gn)) {
                        gn = nameGenerator.nextKey();
                    }
                    UsersActivate ua = new UsersActivate();
                    ua.setUserId(userId);
                    ua.setUserKey(gn);
                    usersActivateDAO.save(ua);

                    GoogleMail gm = new GoogleMail();
                    gm.send(email, gn, username);

                } else {

                    if (!freeEmail) {
                        redirectAttributes.addFlashAttribute("emailTaken", true);
                    }
                    if (!freeUserName) {
                        redirectAttributes.addFlashAttribute("usernameTaken", true);
                    }

                }

            } else {
                // neko polje je prazno
                redirectAttributes.addFlashAttribute("emptyField", true);

            }

        } catch (Exception ex) {
        }
        redirectAttributes.addFlashAttribute("bck", "");
        return "redirect:index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error,
    		@CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust, 
    		HttpServletRequest request, HttpServletResponse response, ModelMap model,
    		RedirectAttributes redirectAttributes, Principal principal, Authentication au
    ) {
        try {
            Boolean loginError = false;
            Boolean signinChecker = false;

            if (error != null) {
                loginError = true;
                signinChecker = true;
            } else {
                if (cookieTrust == null) {
                    Cookie newCookie = new Cookie("livesexhouseTrust", "true");
                    newCookie.setPath("/");
                    newCookie.setMaxAge(0x3b9ac9ff);
                    response.addCookie(newCookie);
                }
//            

                if (request.isUserInRole("ROLE_GIRL")) {
                    Users u = new Users();
                    u = userDao.findByUsername(principal.getName());
//                u.setEnabled((short) 4);
//                userDao.update(u);
                    onlineDao.setOnline(u.getId());
                    chatMembersDao.deleteFromGirl(u.getId());
                }

                if (request.isUserInRole("ROLE_MEMBER")) {
                    Users u = new Users();
                    u = userDao.findByUsername(principal.getName());

                    onlineDao.setOnlineMember(u.getId());
                }

            }
            redirectAttributes.addFlashAttribute("loginError", loginError);
            redirectAttributes.addFlashAttribute("signinChecker", signinChecker);
            redirectAttributes.addFlashAttribute("bck", "");
        } catch (Exception e) {

        }
       // redirectAttributes.

       //return redirect.re(request.getHeader("referer"));
        //return request.getHeader("referer");
        return "redirect:/index";
    }

    @RequestMapping("/check/{key}")
    public String check(
            @PathVariable String key,
            Principal principal,
            ModelMap model, RedirectAttributes redirectAttributes,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookie,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {

        String path = "";
        String loc = "";
        Boolean alredySigned = false;
        try {
            path = setupDao.getPath();
            loc = setupDao.getLocation();
            key.trim();

            Object[] tmp = usersActivateDAO.findByKey(key);
            Boolean b = (boolean) tmp[0];

            if (b) {
                Users u = new Users();
                UsersActivate ua = new UsersActivate();
                ua = (UsersActivate) tmp[1];
                u = userDao.findById(ua.getUserId());

                short s = 1;
                u.setEnabled(s);

                userDao.update(u);
                usersActivateDAO.delete(ua);

                Cookie newCookie = new Cookie("livesexhouseSigned", "alredySigned");
                newCookie.setPath("/");
                newCookie.setMaxAge(0x3b9ac9ff);
                response.addCookie(newCookie);
                alredySigned = true;

                redirectAttributes.addFlashAttribute("signinChecker", true);
                redirectAttributes.addFlashAttribute("alredySigned", true);
                redirectAttributes.addFlashAttribute("thanksReg", true);
                redirectAttributes.addFlashAttribute("bck", "");

            }

        } catch (Exception ex) {
        }

        return "redirect:/index";

    }

    @RequestMapping(value = {"/", "", "/index"}, method = RequestMethod.GET)
    public ModelAndView defaultPage(Principal principal,
            HttpServletResponse response,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            RedirectAttributes redirectAttributes,
            HttpServletRequest req
    ) {
        ModelAndView model = new ModelAndView();
        List<Girls> activeG = new ArrayList<>();
        List<Girls> inactiveG = new ArrayList<>();
        try {

            //    serverOffMsg
//        String serverOffMsg = "serverrrrrr offffff";
            if (cookieTrust != null) {
                model.addObject("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addObject("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addObject("checkEmail", true);
                    }
                }
            }
            if (principal != null) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());

                model.addObject("userName", principal.getName());
                model.addObject("user", u);
            }

            List<MembersRank> mh = new ArrayList<>();

            mh = memberRankDao.findTop4();

            model.addObject("mh", mh);

            inactiveG = girlDao.findGirlsInactive();
            activeG = girlDao.findGirlsActive();
            model.addObject("activeG", activeG);
            model.addObject("inactiveG", inactiveG);

//        model.addObject("serverOffMsg", serverOffMsg);
//        model.addObject("serverOff", true);
            model.addObject("path", setupDao.getPath());
            model.addObject("stream", setupDao.getStreamLnk());
            System.out.println("GGGGGGGG GGGGG " + setupDao.getStreamLnk());
            model.addObject("location", setupDao.getLocation());
            model.addObject("bck", "");
            model.setViewName("index");

        } catch (Exception e) {

        }

        return model;

    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public String logoutDo(ModelMap model, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes, Principal principal) {
        String ret = "redirect:index";
        try {

            if (request.isUserInRole("ROLE_GIRL")) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());
//                u.setEnabled((short) 2);
//                userDao.update(u);
                onlineDao.setOffline(u.getId());
                chatMembersDao.deleteFromGirl(u.getId());
            }

            if (request.isUserInRole("ROLE_MEMBER")) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());

                onlineDao.setOfflineMember(u.getId());
            }

            if (request.isUserInRole("ROLE_USER")) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());
                chatMembersDao.deleteFromUser(u.getId());

            }

        } catch (Exception e) {

        }

        try {
            HttpSession session = request.getSession(false);
            SecurityContextHolder.clearContext();
            session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            model.addAttribute("path", setupDao.getPath());
            model.addAttribute("bck", "");
            model.addAttribute("location", setupDao.getLocation());
        } catch (Exception ex) {

        }
        return "redirect:/index";
        //return redirect.re(request.getHeader("referer"));
    }

    //for 403 access denied page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {
        ModelAndView model = new ModelAndView();
        try {

            //check if user is login
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (!(auth instanceof AnonymousAuthenticationToken)) {
                UserDetails userDetail = (UserDetails) auth.getPrincipal();
                model.addObject("username", userDetail.getUsername());
            }

            model.setViewName("403");
        } catch (Exception e) {

        }

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
            model.addAttribute("bck", "");

        } catch (Exception ex) {
        }
        return "uploadMulti";
    }

    @RequestMapping(value = "/becomeapartpost", method = RequestMethod.POST)
    public String becomeaparticipant(
            @RequestParam("file") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("birth") String birth,
            @RequestParam("state") String state,
            @RequestParam("city") String city,
            @RequestParam("msg") String msg,
            HttpServletRequest request,
            ModelMap model,
            RedirectAttributes redirectAttributes
    ) {

        try {
            List<Setup> setups = setupDao.getSetups();
            String videosUploadLocation = setups.get(12).getValueString();

            String picSave = videosUploadLocation + file.getOriginalFilename().substring(file.getOriginalFilename().length() - 4, file.getOriginalFilename().length());

            boolean successSave = saveVideoFile.save(file.getBytes(), picSave);

            Participant p = new Participant();
            Date date = new Date();
            p.setBirth(birth);
            p.setCity(city);
            p.setDate(date);
            p.setEmail(email);
            p.setMsg(msg);
            p.setName(name);
            p.setState(state);

            participantDao.saveParticipant(p);

            model.addAttribute("path", setupDao.getPath());
            model.addAttribute("location", setupDao.getLocation());

        } catch (Exception e) {

        }

        return "redirect:index";
    }

    @RequestMapping(value = "/uploadMulti", method = RequestMethod.POST)
    public String multiFileUpload(
            @RequestParam("file") MultipartFile[] files,
            @RequestParam("name") String[] names,
            @RequestParam("tag") String[] tags,
            HttpServletRequest request,
            //            @RequestParam("season") Integer[] season,
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
                    int ii = i;
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

                                        videoM2m.setSeason(1);
                                        videoM2m.setClipId(clipId);
                                        videoM2mRoom.setClipId(clipId);
                                        videoM2mCategory.setClipId(clipId);
                                        videoM2mMember.setClipId(clipId);
                                        Object[] temp = videoM2mDao.save(videoM2m);
                                        boolean videoM2mB = (boolean) temp[0];
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

                    } catch (IOException | NumberFormatException e) {
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
    
      @RequestMapping(value = "/video", method = RequestMethod.GET)
    public String videos(
            Principal principal, RedirectAttributes redirectAttributes,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
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
        Boolean alredySigned = false;
        try {

            int durFilter = durationFilter[0];

            int[] df = {durFilter};

            durationFilter = df;

            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }
            if (principal != null) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());
                model.addAttribute("userName", principal.getName());
                model.addAttribute("user", u);
            }

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

            if (!dateFilter.equals("0")) {
                if (dateFilter.charAt(4) != '-') {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm/DD/yyyy");
                    Date date = simpleDateFormat.parse(dateFilter);
                    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-mm-DD");
                    dateFilter = simpleDateFormat2.format(date);
                }
            }

            String filterDateExist = "yes";
            if (!dateFilter.equals("0")) {
                filterDateExist = "1";
            }

            Boolean searchExist = false;
            if (!search.equals("0")) {
                searchExist = true;
            }

            if (!dateFilter.equals("0") || roomFilter.length > 1 || seasonFilter.length > 1
                    //                    || durationFilter.length > 1 
                    || memberFilter.length > 1 || categoryFilter.length > 1 || sort != 0 || searchExist) {
                bigPagination = true;
            }

            if (!bigPagination) {

                if (roomFilter.length == 1) {
                    if (roomFilter[0] != 0) {
                        bigPagination = true;
                    }
                }

                if (searchExist) {
                    bigPagination = true;
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
                Object[] par = params.allParam(categoryFilter, roomFilter, memberFilter, seasonFilter, durationFilter, sort, dateFilter, totalSeasons, memberHouse, videoRoom, videoCategories, totalSeasons, search);
                allParams = (String) par[0];
                paramsWithoutSort = (String) par[1];
                individualPar = (List<String>) par[2];

                Object[] tmp = videoDao.find(maxVideoPerPage, firstResult, sort, dateFilter, roomFilter, seasonFilter, durationFilter, memberFilter, categoryFilter, search);

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
            String percent = "";
int searchInt = 0;

if(searchExist){
   searchInt = 1; 
   for(VideoClip v : videosResultsList){
       v.setmLink("./video/"+v.getId()+"?10="+search);
       System.out.println(v.getmLink());
   }
}


          

            model.addAttribute("searchInt", searchInt);
            model.addAttribute("percent", percent);
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

            if (paramsWithoutSort.length() > 1) {
                model.addAttribute("paramsWithoutSort", paramsWithoutSort.substring(0, paramsWithoutSort.length() - 2));
            } else {
                model.addAttribute("paramsWithoutSort", paramsWithoutSort);
            }

            model.addAttribute("params", allParams);
            model.addAttribute("bck", "");

        } catch (ParseException ex) {
        }
        return "video-archive";
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(
            Principal principal,
            ModelMap model,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            HttpServletResponse response, RedirectAttributes redirectAttributes,
            HttpServletRequest request) throws Exception {
        Boolean alredySigned = false;
        try {
            int searchInt = 0;
            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }
            if (principal != null) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());
                model.addAttribute("userName", principal.getName());
                model.addAttribute("user", u);
            }

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

            if (!string.isEmpty()) {

                String[] parts;
                parts = string.split(" ");
                individualPar.add("Search: " + string + ",10=0");
            }

            Object[] tmp = videoDao.search(maxVideoPerPage, string);

            videosResultsList = (List<VideoClip>) tmp[0];
//            checker.check(search);
            if(videosResultsList.size()>0){
                string = string.replaceAll(" ", "-");
                searchInt = 1;
                for(VideoClip v : videosResultsList){
                    v.setmLink("./video/"+v.getId().toString()+"?10="+string);
                    System.out.println("###################### " + v.getmLink());
                }
            }
            
            numberOfVideos = (int) tmp[1];
            videoNumTotal = (int) tmp[2];
            String percent = (String) tmp[3];

            if (numberOfVideos > maxVideoPerPage) {
                pag = pagination.pagination(0, numberOfVideos, "video", maxVideoPerPage, path, percent.substring(2));
            }

            if (numberOfVideos != 0) {
                noVideoFound = "";
            }
            
            
            
           
    
    
         

            model.addAttribute("searchInt", searchInt);
            model.addAttribute("startDate", startDate);
            model.addAttribute("percent", percent);
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

        } catch (Exception ex) {
        }
        model.addAttribute("bck", "");
        return "video-archive";
    }

    @RequestMapping("/video/{id}")
    public String video2(
            @PathVariable int id,
            ModelMap model,
            HttpServletResponse response, RedirectAttributes redirectAttributes,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            Principal principal,
            @RequestParam(required = false, value = "10", defaultValue = "") String search,

            HttpServletRequest request) throws Exception {

        Boolean alredySigned = false;
        try {
            
            System.out.println("k1");
            boolean simVideo = false;
            List<VideoClip> similarVideo = new ArrayList<>();
            if(search.equals("")){
                simVideo = true;
            } 
            
            System.out.println("k2");
          
            
            
            int liked = 0;
            int disLiked = 0;
            int fav = 0;
            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }
            System.out.println("k3");
            
            if (principal != null) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());

                System.out.println("t0");
                List<UserM2m> lvc = new ArrayList<>();
                lvc = userM2mDAO.findLikedVideosByUserId(u.getId() , id);
                
                System.out.println("t01");
                List<UserM2m> dlvc = new ArrayList<>();
                dlvc = userM2mDAO.findDisLikedVideosByUserId(u.getId(), id);
                
                System.out.println("t02");
                List<UserM2m> fvc = new ArrayList<>();
                fvc = userM2mDAO.findFacVideosByUserId(u.getId() , id);

                System.out.println("t11");
                if(lvc.size()>0){
                    System.out.println("y1");
                for (UserM2m v : lvc) {
                    System.out.println("r1");
                    if (v.getLikedClip() == id) {
                        System.out.println("yy1");
                        liked = 1;
                    }
                }}

                 if(dlvc.size()>0){
                     System.out.println("z2");
                for (UserM2m v : dlvc) {
                    if (v.getDisLikedclip() == id) {
                        disLiked = 1;
                    }
                }}

                  if(fvc.size()>0){
                      System.out.println("z3");
                for (UserM2m v : fvc) {
                    if (v.getDisLikedclip()== id) {
                        fav = 1;
                    }
                }}
                System.out.println("t2");
                model.addAttribute("userName", principal.getName());
                model.addAttribute("user", u);
            }
            System.out.println("k4");
            List<Setup> setups = setupDao.getSetups();
            int maxVideoPerPage = setups.get(2).getValueInt();
            int totalSeasons = setups.get(5).getValueInt();
            String location = setups.get(0).getValueString();
            String noVideoFound = setups.get(6).getValueString();
            String path = setups.get(1).getValueString();
            String videoLocation = setups.get(8).getValueString();
            String imgLocation = setups.get(9).getValueString();
            String startDate = setups.get(10).getValueString();
            System.out.println("k41");
            int maxSimilar = setups.get(17).getValueInt();
            System.out.println("k5");
            VideoClip v = videoDao.findById(id);
            v.setViewCount(v.getViewCount() + 1);
            videoDao.update(v);
            VideoM2m vm2m = new VideoM2m();
            
            System.out.println("r1");
            if(simVideo){
                similarVideo = videoDao.findSimilarByVideo(v,maxSimilar);
                System.out.println("***************** 11111");
            } else {
                System.out.println("***************** 222222");
                 similarVideo = videoDao.findSimilarByVideoSearch(v,maxSimilar,search);
            }
            
           
            System.out.println("r2");
            List videoCat = new ArrayList();
            videoCat = videoM2mDao.findCategoriesByVideoId(id);

            vm2m = videoM2mDao.findById(id);
            System.out.println("k6");
            List<MemberHouse> memberHouse = memberHouseDao.find();
            List<VideoRoom> videoRoom = videoRoomDao.find();
            List<VideoCategories> videoCategories = videoCategoryDao.find();
            List<VideoCategoryCountClip> videoCategoryCountClips = videoCategoryCountClipDao.find();
            System.out.println("k7");
            int seas = videoM2mDao.findSeasonByVideoId(id);
            model.addAttribute("similarVideo", similarVideo); 
            model.addAttribute("liked", liked);
            model.addAttribute("disLiked", disLiked);
            model.addAttribute("fav", fav);
            model.addAttribute("videoCat", videoCat);
            model.addAttribute("season", seas);
            model.addAttribute("video", v);
            model.addAttribute("member", memberHouse);
            model.addAttribute("videoRoom", videoRoom);
            model.addAttribute("videoCategories", videoCategories);
            model.addAttribute("path", path);
            model.addAttribute("location", location);
            model.addAttribute("totalSeasons", totalSeasons);
            model.addAttribute("videoCategoryCountClips", videoCategoryCountClips);
            model.addAttribute("vm2m", vm2m);

            model.addAttribute("noVideoFound", noVideoFound);
            model.addAttribute("videoLocation", videoLocation);
            model.addAttribute("imgLocation", imgLocation);
            model.addAttribute("bck", ".");
            System.out.println("k8");
        } catch (Exception ex) {
        }
        return "video-player";
    }

   @RequestMapping(value = "/contactpost", method = RequestMethod.POST)
    public String contactpost(
            ModelMap model,
            HttpServletResponse response, RedirectAttributes redirectAttributes,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            Principal principal,
            HttpServletRequest request) throws Exception {
        Boolean alredySigned = false;
        try {

            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }
            if (principal != null) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());
                model.addAttribute("userName", principal.getName());
                model.addAttribute("user", u);
            }

            model.addAttribute("path", setupDao.getPath());
            model.addAttribute("bck", "");
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

    @RequestMapping(value = "/participatepost", method = RequestMethod.POST)
    public String partpost(
            @RequestParam("file") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("birth") String birth,
            @RequestParam("email") String email,
            @RequestParam("state") String state,
            @RequestParam("city") String city,
            @RequestParam("message-text") String msg,
            ModelMap model,
            HttpServletResponse response, RedirectAttributes redirectAttributes,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            Principal principal,
            HttpServletRequest request) throws Exception {
        Boolean alredySigned = false;
        String ret = "becomemodelFAIL";
        try {

            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }
            if (principal != null) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());
                model.addAttribute("userName", principal.getName());
                model.addAttribute("user", u);
            }

            List<Setup> setups = setupDao.getSetups();
            String imgSaveLocation = setups.get(12).getValueString();

            model.addAttribute("path", setupDao.getPath());
            model.addAttribute("bck", "");
            model.addAttribute("location", setupDao.getLocation());

            Participant p = new Participant();
            Date date = new Date();

            String videoName2save = "";

            boolean ok = false;
            boolean ok2 = false;
            boolean myChk = (request.getParameter("checkboxAccept") != null) ? true : false;

            if (myChk) {
                System.out.println("t1");

                if (!file.isEmpty() && !name.isEmpty() && !birth.isEmpty() && !email.isEmpty() && !state.isEmpty() && !city.isEmpty()) {
                    System.out.println("t2");
                    String ext = file.getOriginalFilename().substring(file.getOriginalFilename().length() - 3, file.getOriginalFilename().length()).toUpperCase();
                    if (ext.equals("JPG") || ext.equals("GIF") || ext.equals("PNG")) {
                        ok = true;
                        System.out.println("t3");
                    }

                    if (ext.equals("PEG")) {
                        System.out.println("t4");
                        if (file.getOriginalFilename().substring(file.getOriginalFilename().length() - 4, file.getOriginalFilename().length()).toUpperCase().equals("JPEG")) {
                            System.out.println("t5");
                            ok = true;
                        }
                    }

                    if (ok) {
                        System.out.println("t6");
                        if (checker.check(request.getParameter("name"))) {
                            System.out.println("t61");
                            if (checker.check(request.getParameter("birth"))) {
                                System.out.println("t62");
                                if (checker.checkEmail(request.getParameter("email"))) {
                                    System.out.println("t63");
                                    if (checker.check(request.getParameter("state"))) {
                                        System.out.println("t64");
                                        if (checker.check(request.getParameter("city"))) {
                                            System.out.println("t65");

                                            if (checker.check(request.getParameter("message-text"))) {
                                                System.out.println("t66");
                                                ok2 = true;

                                            }
                                        }
                                    }
                                }
                            }
                        }

                    }

                    System.out.println("t7");
                }
                System.out.println("t8");
            } else {
                System.out.println("please check");
            }
            System.out.println("t9");
            if (ok2) {
                System.out.println("t10");

                videoName2save = imgSaveLocation + request.getParameter("email") + "_" + date + file.getOriginalFilename().substring(file.getOriginalFilename().length() - 4, file.getOriginalFilename().length());
                //
                if (saveVideoFile.savePic(file.getBytes(), videoName2save)) {
                    System.out.println("t11");
                    p.setName(request.getParameter("name"));
                    p.setBirth(request.getParameter("birth"));
                    p.setEmail(request.getParameter("email"));
                    p.setState(request.getParameter("state"));
                    p.setCity(request.getParameter("city"));
                    p.setMsg(request.getParameter("message-text"));
                    p.setDate(date);

                    participantDao.saveParticipant(p);
                    ret = "becomemodelOK";
                }

            }
        } catch (Exception ex) {
        }
        return ret;
    }

    @RequestMapping(value = "/modelpost", method = RequestMethod.POST)
    public String modelpost(
            @RequestParam("files") MultipartFile[] files,
            ModelMap model,
            HttpServletResponse response, RedirectAttributes redirectAttributes,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            Principal principal,
            HttpServletRequest request) throws Exception {
        Boolean alredySigned = false;
        String ret = "becomemodelFAIL";
        try {
            System.out.println("*****************");
            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }

            if (principal != null) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());
                model.addAttribute("userName", principal.getName());
                model.addAttribute("user", u);
            }

            Integer fail = 0;
            boolean acceptTerms = (request.getParameter("acceptterms") != null) ? true : false;
            System.out.println("t1");
            boolean passErr = true;
            System.out.println("t2");
            String audio = request.getParameter("Audio");
            String hdVideo = request.getParameter("hdVideo");
            String phoneService = request.getParameter("phoneService");
            String groupShow = request.getParameter("groupShow");
            String privateShow = request.getParameter("privateShow");
            String permanentID = request.getParameter("permanentID");
            System.out.println("t3");
            String in = request.getParameter("interes");

            System.out.println("gender" + request.getParameter("gender"));
            System.out.println("t4");

            Model m = new Model();
            boolean ok = false;
            if (acceptTerms) {
                if (audio != null && hdVideo != null && phoneService != null && groupShow != null && privateShow != null && permanentID != null && in != null) {
                    System.out.println("u1");
                    if (!request.getParameter("email").equals("") && checker.checkEmail(request.getParameter("email"))) {
                        if (!request.getParameter("fullname").equals("") && checker.check(request.getParameter("fullname"))) {
                            if (checker.check(request.getParameter("region"))) {
                                if (!request.getParameter("country").equals("") && checker.check(request.getParameter("country"))) {
                                    if (!request.getParameter("telep").equals("") && checker.check(request.getParameter("telep"))) {
                                        if (!request.getParameter("password").equals("") && checker.checkPass(request.getParameter("password"))) {
                                            passErr = false;
                                            System.out.println("u2");
                                            if (!request.getParameter("nick").equals("") && checker.check(request.getParameter("nick"))) {
                                                System.out.println("u21");
                                                if (!request.getParameter("birthday").equals("") && checker.check(request.getParameter("birthday"))) {
                                                    System.out.println("u22");
                                                    if (!request.getParameter("Adress").equals("") && checker.check(request.getParameter("Adress"))) {
                                                        System.out.println("u23");
                                                        if (!request.getParameter("gender").equals("") && checker.check(request.getParameter("gender"))) {
                                                            System.out.println("u24");
                                                            if (!request.getParameter("birthday").equals("") && checker.check(request.getParameter("birthday"))) {
                                                                System.out.println("u25");
                                                                if (!request.getParameter("sex").equals("") && checker.check(request.getParameter("sex"))) {
                                                                    System.out.println("u26");
                                                                    if (!request.getParameter("displayName").equals("") && checker.check(request.getParameter("displayName"))) {
                                                                        System.out.println("u3");
                                                                        if (!request.getParameter("zodiac").equals("") && checker.check(request.getParameter("zodiac"))) {
                                                                            if (!request.getParameter("language").equals("") && checker.check(request.getParameter("language"))) {
                                                                                if (!request.getParameter("body").equals("") && checker.check(request.getParameter("body"))) {
                                                                                    if (checker.check(request.getParameter("decorations"))) {
                                                                                        if (!request.getParameter("lngSpoken").equals("") && checker.check(request.getParameter("lngSpoken"))) {
                                                                                            if (!request.getParameter("height").equals("") && checker.check(request.getParameter("height"))) {
                                                                                                if (!request.getParameter("weight").equals("") && checker.check(request.getParameter("weight"))) {
                                                                                                    System.out.println("u4");
                                                                                                    if (!request.getParameter("hairColor").equals("") && checker.check(request.getParameter("hairColor"))) {
                                                                                                        if (!request.getParameter("eyes").equals("") && checker.check(request.getParameter("eyes"))) {
                                                                                                            if (!request.getParameter("ethnicity").equals("") && checker.check(request.getParameter("ethnicity"))) {
                                                                                                                if (!request.getParameter("cupSize").equals("") && checker.check(request.getParameter("cupSize"))) {
                                                                                                                    System.out.println("u5");
                                                                                                                    if (!request.getParameter("pubicHair").equals("") && checker.check(request.getParameter("pubicHair"))) {
                                                                                                                        if (!request.getParameter("mes1").equals("") && checker.check(request.getParameter("mes1"))) {
                                                                                                                            if (!request.getParameter("mes2").equals("") && checker.check(request.getParameter("mes2"))) {
                                                                                                                                if (!request.getParameter("mes3").equals("") && checker.check(request.getParameter("mes3"))) {
                                                                                                                                    if (checker.check(request.getParameter("Audio"))) {
                                                                                                                                        if (checker.check(request.getParameter("hdVideo"))) {
                                                                                                                                            if (checker.check(request.getParameter("phoneService"))) {
                                                                                                                                                System.out.println("u7");
                                                                                                                                                if (checker.check(request.getParameter("groupShow"))) {
                                                                                                                                                    if (checker.check(request.getParameter("privateShow"))) {
                                                                                                                                                        if (checker.check(request.getParameter("permanentID"))) {
                                                                                                                                                            if (!request.getParameter("idExpire").equals("") && checker.check(request.getParameter("idExpire"))) {
                                                                                                                                                                if (!request.getParameter("about").equals("") && checker.check(request.getParameter("about"))) {
                                                                                                                                                                    ok = true;

                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }

                                    }

                                }

                            }

                        }

                    }
                }
            }

            if (ok) {
                System.out.println("qq1");

                m.setEmail(request.getParameter("email"));
                m.setFullname(request.getParameter("fullname"));

                m.setRegion(request.getParameter("region"));
                m.setCountry(Integer.valueOf(request.getParameter("country")));
                m.setAddress(request.getParameter("Adress"));
                System.out.println("s1");
                m.setTelephone(request.getParameter("telep"));
                m.setPassword(request.getParameter("password"));
                m.setNickname(request.getParameter("nick"));
                m.setGender(request.getParameter("gender"));
                m.setBirthday(request.getParameter("birthday"));
                m.setSex(request.getParameter("sex"));
                m.setDspName(request.getParameter("displayName"));
                System.out.println("s2");
                m.setZodiac(request.getParameter("zodiac"));
                System.out.println("o1");
                System.out.println(request.getParameter("language"));
                m.setLanguage(Integer.valueOf(request.getParameter("language")));
                System.out.println("o2");
                m.setBody(Integer.valueOf(request.getParameter("body")));
                System.out.println("o3");
                if (!request.getParameter("decorations").equals("")) {
                    m.setDecoration(Integer.valueOf(request.getParameter("decorations")));
                }
                System.out.println("o4");
                m.setLanguageSpoken(Integer.valueOf(request.getParameter("lngSpoken")));
                System.out.println("s3");
                m.setWeight(request.getParameter("weight"));
                m.setHeight(request.getParameter("height"));
                m.setHair(Integer.valueOf(request.getParameter("hairColor")));
                m.setEye(request.getParameter("eyes"));
                m.setEthnicity(request.getParameter("ethnicity"));
                m.setCupSize(request.getParameter("cupSize"));
                System.out.println("s4");
                m.setPubicHair(request.getParameter("pubicHair"));
                m.setMeasurements(request.getParameter("mes1") + "-" + request.getParameter("mes2") + "-" + request.getParameter("mes3"));
                m.setAudio(Integer.valueOf(request.getParameter("Audio")));
                m.setHd(Integer.valueOf(request.getParameter("hdVideo")));
                m.setPhoneService(Integer.valueOf(request.getParameter("phoneService")));
                m.setGroupYN(Integer.valueOf(request.getParameter("groupShow")));
                m.setAbout(request.getParameter("about"));
                System.out.println("s5");
                m.setPrivate1(Integer.valueOf(request.getParameter("privateShow")));
                m.setExpireID(request.getParameter("idExpire"));
                m.setPermanentId(Integer.valueOf(request.getParameter("permanentID")));

                fail = modelDao.saveI(m);
                System.out.println("!!!!!!!!!######################## ok ok ok " + fail);
            }

            String bc = request.getParameter("blockedCountry");
            String br = request.getParameter("blockedRegion");
            String knk = request.getParameter("kinky");

            if (fail > 0) {
                List<Setup> setups = setupDao.getSetups();
                String imgSaveLocation = setups.get(13).getValueString();
                String videoName2save = "";
                //  cuvaj ostale m2m i slike
                System.out.println("%%%%%%% fail");
                ret = "becomemodelOK";
                for (int i = 0; i < files.length; i++) {
                    videoName2save = imgSaveLocation + fail + "_" + files[i].getOriginalFilename();

                    saveVideoFile.savePic(files[i].getBytes(), videoName2save);

                }

                if (bc != null) {
                    String[] blockedCountrys = request.getParameterValues("blockedCountry");
                    for (String s : blockedCountrys) {
                        BlockedCountryM2m bcm2m = new BlockedCountryM2m();
                        bcm2m.setBlockedCountryId(Integer.valueOf(s));
                        bcm2m.setUserId(fail);
                        modelDao.saveBC(bcm2m);
                    }
                }

                if (br != null) {
                    String[] blockedRegions = request.getParameterValues("blockedRegion");
                    for (String s : blockedRegions) {
                        BlockedRegionM2m brm2m = new BlockedRegionM2m();
                        brm2m.setBlockedRegionId(Integer.valueOf(s));
                        brm2m.setUserId(fail);
                        modelDao.saveBR(brm2m);
                    }
                }

                if (in != null) {
                    String[] interests = request.getParameterValues("interes");
                    for (String s : interests) {
                        InteresM2m im2m = new InteresM2m();
                        im2m.setInteresId(Integer.valueOf(s));
                        im2m.setUserId(fail);
                        modelDao.saveIn(im2m);
                    }
                }

                if (knk != null) {
                    String[] kinkys = request.getParameterValues("kinky");
                    for (String s : kinkys) {
                        KinkyM2m km2m = new KinkyM2m();
                        km2m.setKinkyId(Integer.valueOf(s));
                        km2m.setUserId(fail);
                        modelDao.saveKn(km2m);
                        System.out.println("Xxxxxxxxxxxx kn " + s);
                    }
                }

            }

            System.out.println(files.length);

            System.out.println("acceptTerms: " + acceptTerms);

            model.addAttribute("path", setupDao.getPath());
            model.addAttribute("bck", "");
            model.addAttribute("location", setupDao.getLocation());

        } catch (Exception ex) {
        }
        return ret;
    }

    @RequestMapping("/becomemodel")
    public String becomeModel(
            Principal principal, RedirectAttributes redirectAttributes,
            ModelMap model,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {
        Boolean alredySigned = false;

        try {
            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }
            if (principal != null) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());
                model.addAttribute("userName", principal.getName());
                model.addAttribute("user", u);
            }
            System.out.println("t1");
            model.addAttribute("findInteres", modelDao.findInteres());
            model.addAttribute("findCountry", modelDao.findCountry());
            model.addAttribute("findLanguage", modelDao.findLanguage());
            model.addAttribute("findBody", modelDao.findBody());
            model.addAttribute("findDecoration", modelDao.findDecoration());
            model.addAttribute("findLanguageSpoken", modelDao.findLanguageSpoken());
            model.addAttribute("findHair", modelDao.findHair());
            model.addAttribute("findKinky", modelDao.findKinky());
            model.addAttribute("findBlockedCountry", modelDao.findBlockedCountry());
            model.addAttribute("findBlockedRegion", modelDao.findBlockedRegion());
            System.out.println("t2");
            model.addAttribute("path", setupDao.getPath());
            model.addAttribute("location", setupDao.getLocation());
            model.addAttribute("bck", "");

        } catch (Exception ex) {
        }
        return "becomemodel";
    }

    @RequestMapping(value = "/formWish", method = RequestMethod.POST)
    public String formWish(
            ModelMap model,
            HttpServletResponse response, RedirectAttributes redirectAttributes,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            Principal principal,
            HttpServletRequest request) throws Exception {
        Boolean alredySigned = false;
        try {

            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }
            if (principal != null) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());
                model.addAttribute("userName", principal.getName());
                model.addAttribute("user", u);

                YourWish yw = new YourWish();
                Date date = new Date();

                yw.setAction(request.getParameter("action"));
                yw.setExtra(request.getParameter("extra"));
                yw.setLocation(request.getParameter("location"));
                yw.setParticipant1(request.getParameter("participant1"));
                yw.setParticipant2(request.getParameter("participant2"));
                yw.setUserId(u.getId());

                yourWishDao.saveWish(yw);

            }

            model.addAttribute("path", setupDao.getPath());
            model.addAttribute("bck", "");
            model.addAttribute("location", setupDao.getLocation());

        } catch (Exception ex) {
        }
        return "redirect:index";
    }

    @RequestMapping("/contact")
    public String contact(
            Principal principal, RedirectAttributes redirectAttributes,
            ModelMap model,
            HttpServletResponse response,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            HttpServletRequest request) throws Exception {
        Boolean alredySigned = false;
        try {
            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }
            if (principal != null) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());
                model.addAttribute("userName", principal.getName());
                model.addAttribute("user", u);
            }

            model.addAttribute("path", setupDao.getPath());
            model.addAttribute("bck", "");
            model.addAttribute("location", setupDao.getLocation());

        } catch (Exception ex) {
        }
        return "contact";
    }

    @RequestMapping("/live-stream")
    public String livestream(
            Principal principal, RedirectAttributes redirectAttributes,
            ModelMap model,
            HttpServletResponse response,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            HttpServletRequest request) throws Exception {
        Boolean alredySigned = false;
        try {
            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }
            if (principal != null) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());
                model.addAttribute("userName", principal.getName());
                model.addAttribute("user", u);
            }

            List<MembersRank> mh = new ArrayList<>();

            mh = memberRankDao.findTop5();

            model.addAttribute("mh", mh);

            model.addAttribute("defaultCam", setupDao.defaultCamOnLiveStream());

            List<VideoRoom> vr = new ArrayList<>();
            vr = videoRoomDao.find();
            model.addAttribute("vr", vr);

            int onlineMember = 0;
            onlineMember = onlineDao.onlineMember();
            System.out.println("www hhh " + onlineMember);
            model.addAttribute("onlineMember", onlineMember);

            model.addAttribute("path", setupDao.getPath());
            model.addAttribute("bck", "");
            model.addAttribute("location", setupDao.getLocation());

        } catch (Exception ex) {
        }
        return "live-stream";
    }

    @RequestMapping("/my-account")
    public String myaccount(
            Principal principal, RedirectAttributes redirectAttributes,
            ModelMap model,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {
        Boolean alredySigned = false;
        try {
            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }
            if (principal != null) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());
                model.addAttribute("userName", principal.getName());
                model.addAttribute("user", u);
            }

            model.addAttribute("path", setupDao.getPath());
            model.addAttribute("bck", "");
            model.addAttribute("location", setupDao.getLocation());

        } catch (Exception ex) {
        }
        return "my-account";
    }

    @RequestMapping("/offline/{id}")
    public String offline(
            Principal principal, RedirectAttributes redirectAttributes,
            ModelMap model,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            HttpServletResponse response,
            @PathVariable int id,
            HttpServletRequest request) throws Exception {
        Boolean alredySigned = false;
        try {
            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }
            if (principal != null) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());
                model.addAttribute("userName", principal.getName());
                model.addAttribute("user", u);
            }
            
            Girls g = new Girls();
            g=girlDao.findById(id);

            model.addAttribute("path", setupDao.getPath());
            model.addAttribute("location", setupDao.getLocation());
            model.addAttribute("bck", "");

        } catch (Exception ex) {
        }
        return "offline";
    }

    @RequestMapping("/participate")
    public String participate(
            Principal principal, RedirectAttributes redirectAttributes,
            ModelMap model,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {
        Boolean alredySigned = false;
        try {
            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }
            if (principal != null) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());
                model.addAttribute("userName", principal.getName());
                model.addAttribute("user", u);
            }

            model.addAttribute("path", setupDao.getPath());
            model.addAttribute("location", setupDao.getLocation());
            model.addAttribute("bck", "");

        } catch (Exception ex) {
        }
        return "participate";
    }

    @RequestMapping("/vote-video")
    public String votevideo(
            Principal principal, RedirectAttributes redirectAttributes,
            ModelMap model,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {
        Boolean alredySigned = false;
        try {
            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }
            if (principal != null) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());
                model.addAttribute("userName", principal.getName());
                model.addAttribute("user", u);
            }

            model.addAttribute("path", setupDao.getPath());
            model.addAttribute("location", setupDao.getLocation());
            model.addAttribute("bck", "");

        } catch (Exception ex) {
        }
        return "vote-video";
    }

    @RequestMapping("/vote")
    public String vote(
            Principal principal, RedirectAttributes redirectAttributes,
            ModelMap model,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {
        Boolean alredySigned = false;
        try {
            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }
            if (principal != null) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());
                model.addAttribute("userName", principal.getName());
                model.addAttribute("user", u);
            }

            List<MembersRank> mh = new ArrayList<>();

            mh = memberRankDao.find();

            model.addAttribute("path", setupDao.getPath());
            model.addAttribute("mh", mh);
            model.addAttribute("location", setupDao.getLocation());
            model.addAttribute("bck", "");
            model.addAttribute("pricePackages", pricePackageService.findAllActive());

        } catch (Exception ex) {
        }
        return "vote";
    }

    @RequestMapping("/voteFromIndex/{id}")
    public String voteFromIndex(
            Principal principal, RedirectAttributes redirectAttributes,
            ModelMap model,
            @PathVariable int id,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {
        Boolean alredySigned = false;
        try {
            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }
            if (principal != null) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());
                model.addAttribute("userName", principal.getName());
                model.addAttribute("user", u);
            }

            List<MembersRank> mh = new ArrayList<>();

            mh = memberRankDao.find();

            redirectAttributes.addFlashAttribute("idFromIndex", id);
            model.addAttribute("path", setupDao.getPath());
            model.addAttribute("mh", mh);
            model.addAttribute("location", setupDao.getLocation());
            model.addAttribute("bck", "");
            model.addAttribute("pricePackages", pricePackageService.findAllActive());

        } catch (Exception ex) {
        }
        return "redirect:/vote";
    }

    @RequestMapping("/vote/{mhid}")
    public String votee(
            Principal principal, RedirectAttributes redirectAttributes,
            ModelMap model,
            @PathVariable int mhid,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {
        Boolean alredySigned = false;
        try {
            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }
            if (principal != null) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());
                model.addAttribute("userName", principal.getName());
                model.addAttribute("user", u);
                memberHouseDao.updateUserMinus1token(u);
                memberHouseDao.updateMemberPlus1Vote(mhid);

            }

            model.addAttribute("path", setupDao.getPath());

            model.addAttribute("location", setupDao.getLocation());
            model.addAttribute("bck", "");
            model.addAttribute("pricePackages", pricePackageService.findAllActive());

        } catch (Exception ex) {
        }
        return "redirect:/vote";
    }

    @RequestMapping("/wish")
    public String wish(
            Principal principal, RedirectAttributes redirectAttributes,
            ModelMap model,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {
        Boolean alredySigned = false;

        try {
            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }
            model.addAttribute("path", setupDao.getPath());
            model.addAttribute("location", setupDao.getLocation());
            model.addAttribute("bck", "");

            if (principal != null) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());
                model.addAttribute("userName", principal.getName());
                model.addAttribute("user", u);

                List<VideoRoom> videoRoom = new ArrayList<>();
                videoRoom = videoRoomDao.find();
                model.addAttribute("videoRoom", videoRoom);

                List<YourWishExtra> extra = new ArrayList<>();
                extra = yourWishExtraDao.find();
                model.addAttribute("extra", extra);

                List<YourWishAction> action = new ArrayList<>();
                action = yourWishActionDao.find();
                model.addAttribute("action", action);

                List<MemberHouse> members = new ArrayList<>();
                members = memberHouseDao.find();
                model.addAttribute("participant", members);

            }

        } catch (Exception ex) {
        }
        return "wish";
    }

  

    

    @RequestMapping("/addtofav/{id}")
    public String addtofav(
            @PathVariable int id,
            Principal principal,
            ModelMap model, RedirectAttributes redirectAttributes,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {

        String path = "";
        String loc = "";
        Boolean alredySigned = false;
        try {
            path = setupDao.getPath();
            loc = setupDao.getLocation();

            if (principal != null) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());
                model.addAttribute("userName", principal.getName());
                model.addAttribute("user", u);

                List<UserM2m> fvc = new ArrayList<>();
                fvc = userM2mDAO.findFacVideosByUserId(u.getId(),id);

                for (UserM2m v : fvc) {
                    if (v.getFavClip() != id) {
                        UserM2m um = new UserM2m();
                        int userId = u.getId();
                        um.setUserId(userId);
                        um.setFavClip(id);

                        userM2mDAO.save(um);
                    }
                }

            }

            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }

        } catch (Exception ex) {
        }
        model.addAttribute("bck", ".");
        model.addAttribute("path", path);
        model.addAttribute("location", loc);
        return "redirect:/video/" + id;

//        return redirect.re(request.getHeader("referer"));
    }

    @RequestMapping("/addtofan/{id}")
    public String addtofan(
            @PathVariable int id,
            Principal principal,
            ModelMap model, RedirectAttributes redirectAttributes,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {

        String path = "";
        String loc = "";
        Boolean alredySigned = false;
        try {
            path = setupDao.getPath();
            loc = setupDao.getLocation();

            if (principal != null) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());
                model.addAttribute("userName", principal.getName());
                model.addAttribute("user", u);
                UserM2m um = new UserM2m();
                int userId = u.getId();
                um.setUserId(userId);
                um.setFavGirl(id);

                userM2mDAO.save(um);
            }

            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }

        } catch (Exception ex) {
        }
        model.addAttribute("bck", ".");
        model.addAttribute("path", path);
        model.addAttribute("location", loc);
        return "redirect:/webcam/" + id;

//        return redirect.re(request.getHeader("referer"));
    }

    @RequestMapping("/voteUp/{id}")
    public String advoteUpdtofav(
            @PathVariable int id, RedirectAttributes redirectAttributes,
            Principal principal,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            ModelMap model,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {
        Boolean alredySigned = false;
        String path = "";
        String loc = "";

        try {
            path = setupDao.getPath();
            loc = setupDao.getLocation();

            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }

            if (principal != null) {
                System.out.println("voteUp " + id);
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());
                model.addAttribute("userName", principal.getName());
                model.addAttribute("user", u);

                System.out.println("t0");
                  // gledamo da li ima taj klip vec lajkovan
                List<UserM2m> lvc = new ArrayList<>();
                lvc = userM2mDAO.findLikedVideosByUserId(u.getId(),id);

                
                boolean liked = false;
                boolean disliked = false;
                
                for (UserM2m vv : lvc) {
                    if (vv.getLikedClip() == id) {
                        liked = true;
                    }}   
                        
                        
                        
                        List<UserM2m> dlvc = new ArrayList<>();
                dlvc = userM2mDAO.findDisLikedVideosByUserId(u.getId(),id);
                      
                for (UserM2m vvvv : dlvc) {
                    if (vvvv.getDisLikedclip() == id) {
                        disliked = true;
                    }
                }
                        
                 
                if(!liked){
                     VideoClip v = new VideoClip();

                        v = videoDao.findById(id);
                        int vote = v.getVoteUp();
                        v.setVoteUp(vote + 1);

                        videoDao.update(v);
                        
                        
                        UserM2m um = new UserM2m();
                        int userId = u.getId();
                        um.setUserId(userId);
                        um.setLikedClip(id);

                        userM2mDAO.save(um);
                }
                
                if(disliked){
                     userM2mDAO.deleteDisLiked(u.getId(), id);
                        VideoClip v = new VideoClip();
                         v = videoDao.findById(id);
                        int vote = v.getVoteDown();
                        if (v.getVoteDown() > 0){
                           v.setVoteDown(vote - 1);

                        videoDao.update(v); 
                        }
                }
                

            }

        } catch (Exception ex) {
        }
        model.addAttribute("path", path);
        model.addAttribute("location", loc);
        model.addAttribute("bck", "");

        return "redirect:/video/" + id;

//        return redirect.re(request.getHeader("referer"));
    }

    @RequestMapping("/voteDown/{id}")
    public String voteDown(
            @PathVariable int id, RedirectAttributes redirectAttributes,
            Principal principal,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            ModelMap model,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {

        String path = "";
        String loc = "";
        Boolean alredySigned = false;
        try {
            path = setupDao.getPath();
            loc = setupDao.getLocation();

            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }

            if (principal != null) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());
                model.addAttribute("userName", principal.getName());
                model.addAttribute("user", u);

                // gledamo da li ima taj klip vec dislajkovan
                List<UserM2m> dlvc = new ArrayList<>();
                dlvc = userM2mDAO.findDisLikedVideosByUserId(u.getId(),id);

                
                boolean liked = false;
                boolean disliked = false;
                
                
                for (UserM2m vv : dlvc) {
                    if (vv.getDisLikedclip() == id) {
                        disliked = true;
                    }}
                
                
                        List<UserM2m> lvc = new ArrayList<>();
                lvc = userM2mDAO.findLikedVideosByUserId(u.getId(),id);

                for (UserM2m vvvv : lvc) {
                    if (vvvv.getLikedClip() == id) {
                        liked = true;
                        
                        }
                        
                    }
                
                       
                if(liked){
                   userM2mDAO.deleteLiked(u.getId(), id);
                        VideoClip v = new VideoClip();
                         v = videoDao.findById(id);
                        int vote = v.getVoteUp();
                        if (v.getVoteUp() > 0){
                           v.setVoteUp(vote - 1);

                        videoDao.update(v);  
                }
                }
                if(!disliked){
                 VideoClip ve = new VideoClip();

                        ve = videoDao.findById(id);
                        int votee = ve.getVoteDown();
                        ve.setVoteDown(votee + 1);

                        videoDao.update(ve);
                        
                        
                        UserM2m um = new UserM2m();
                        int userId = u.getId();
                        um.setUserId(userId);
                        um.setDisLikedclip(id);

                        userM2mDAO.save(um);
                }

                
            }
                

        } catch (Exception ex) {
        }
        model.addAttribute("path", path);
        model.addAttribute("location", loc);
        model.addAttribute("bck", "");

        return "redirect:/video/" + id;

//        return redirect.re(request.getHeader("referer"));
    }

    @RequestMapping("/userFav")
    public String userFav(
            Principal principal, RedirectAttributes redirectAttributes,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            ModelMap model,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {
        String path = "";
        String loc = "";
        List<VideoClip> res = new ArrayList<>();
        String noVideoFound = "";
        Boolean alredySigned = false;
        try {
            path = setupDao.getPath();
            loc = setupDao.getLocation();

            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }

            if (principal != null) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());
                model.addAttribute("userName", principal.getName());
                model.addAttribute("user", u);
                res = userM2mDAO.findFavVideosByUser(u.getId());
                if (res.size() < 1) {
                    noVideoFound = "no result";
                }
            }

        } catch (Exception ex) {
        }

        model.addAttribute("video", res);
        model.addAttribute("noVideoFound", noVideoFound);
        model.addAttribute("path", path);
        model.addAttribute("location", loc);
        model.addAttribute("bck", "");

        return "videoFav";

//        return redirect.re(request.getHeader("referer"));
    }

    @RequestMapping("/userFan")
    public String userFan(
            Principal principal, RedirectAttributes redirectAttributes,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            ModelMap model,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {
        String path = "";
        String loc = "";
        List<Girls> girls = new ArrayList<>();
        String noVideoFound = "";
        Boolean alredySigned = false;
        try {
            path = setupDao.getPath();
            loc = setupDao.getLocation();

            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }

            if (principal != null) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());
                model.addAttribute("userName", principal.getName());
                model.addAttribute("user", u);
                girls = userM2mDAO.findFavGirlByUser(u.getId());
                if (girls.size() < 1) {
                    noVideoFound = "no result";
                }
            }

        } catch (Exception ex) {
        }

        model.addAttribute("girls", girls);
        model.addAttribute("noVideoFound", noVideoFound);
        model.addAttribute("path", path);
        model.addAttribute("location", loc);
        model.addAttribute("bck", "");

        return "girlsFav";

//        return redirect.re(request.getHeader("referer"));
    }

    @RequestMapping("/userLike")
    public String userLike(
            Principal principal, RedirectAttributes redirectAttributes,
            ModelMap model,
            HttpServletResponse response,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            HttpServletRequest request) throws Exception {
        String path = "";
        String loc = "";
        List<VideoClip> res = new ArrayList<>();
        String noVideoFound = "";
        Boolean alredySigned = false;
        try {
            path = setupDao.getPath();
            loc = setupDao.getLocation();

            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }

            if (principal != null) {
                Users u = new Users();
                u = userDao.findByUsername(principal.getName());
                model.addAttribute("userName", principal.getName());
                model.addAttribute("user", u);
                res = userM2mDAO.findLikedVideosByUser(u.getId());
                if (res.size() < 1) {
                    noVideoFound = "no result";
                }
            }

        } catch (Exception ex) {
        }

        model.addAttribute("video", res);
        model.addAttribute("noVideoFound", noVideoFound);
        model.addAttribute("path", path);
        model.addAttribute("location", loc);
        model.addAttribute("bck", "");

        return "videoLike";

//        return redirect.re(request.getHeader("referer"));
    }

    @RequestMapping("/delete")
    public String deleteAccount(
            Principal principal, RedirectAttributes redirectAttributes,
            ModelMap model,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {
        String path = "";
        String loc = "";
        Boolean alredySigned = false;
        String noVideoFound = "";

        try {

            Users u = new Users();
            path = setupDao.getPath();
            loc = setupDao.getLocation();

            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }

            if (principal != null) {
                u = userDao.findByUsername(principal.getName());
                userDao.delete(u);
                HttpSession session = request.getSession(false);
                SecurityContextHolder.clearContext();
                session = request.getSession(false);
                if (session != null) {
                    session.invalidate();
                }
            }

        } catch (Exception ex) {
        }

        model.addAttribute("path", path);
        model.addAttribute("location", loc);
        model.addAttribute("bck", "");

        return "videoLike";

//        return redirect.re(request.getHeader("referer"));
    }

    @RequestMapping("/update")
    public String updatepass(
            Principal principal, RedirectAttributes redirectAttributes,
            ModelMap model,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {
        String path = "";
        String loc = "";

        try {
            Boolean alredySigned = false;
            Users u = new Users();
            path = setupDao.getPath();
            loc = setupDao.getLocation();

            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }
            if (principal != null) {
                u = userDao.findByUsername(principal.getName());
                model.addAttribute("userName", principal.getName());
                model.addAttribute("user", u);
            }

        } catch (Exception ex) {
        }

        model.addAttribute("path", path);
        model.addAttribute("location", loc);
        model.addAttribute("bck", "");

        return "videoLike";

//        return redirect.re(request.getHeader("referer"));
    }

    @RequestMapping("/privacyPolicy")
    public String tp1(
            Principal principal, RedirectAttributes redirectAttributes,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            ModelMap model,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {
        String path = "";
        String loc = "";

        try {
            path = setupDao.getPath();
            loc = setupDao.getLocation();

            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }

        } catch (Exception ex) {
        }

        model.addAttribute("path", path);
        model.addAttribute("location", loc);
        model.addAttribute("bck", "");

        return "privacyPolicy";

//        return redirect.re(request.getHeader("referer"));
    }

    @RequestMapping("/termsOfUse")
    public String tp2(
            Principal principal, RedirectAttributes redirectAttributes,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            ModelMap model,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {
        String path = "";
        String loc = "";

        try {
            path = setupDao.getPath();
            loc = setupDao.getLocation();

            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }

        } catch (Exception ex) {
        }

        model.addAttribute("path", path);
        model.addAttribute("location", loc);
        model.addAttribute("bck", "");

        return "termsOfUse";

//        return redirect.re(request.getHeader("referer"));
    }

    @RequestMapping("/2257")
    public String tp3(
            Principal principal, RedirectAttributes redirectAttributes,
            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
            ModelMap model,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {
        String path = "";
        String loc = "";

        try {
            path = setupDao.getPath();
            loc = setupDao.getLocation();

            if (cookieTrust != null) {
                model.addAttribute("trustedUser", true);
            } else {
                if (cookieSigned != null) {
                    model.addAttribute("alredySigned", true);
                } else {
                    if (cookieMail != null) {
                        model.addAttribute("checkEmail", true);
                    }
                }
            }

        } catch (Exception ex) {
        }

        model.addAttribute("path", path);
        model.addAttribute("location", loc);
        model.addAttribute("bck", "");

        return "2257";

//        return redirect.re(request.getHeader("referer"));
    }

//    @RequestMapping("/test")
//    public String wwe(
//            Principal principal, RedirectAttributes redirectAttributes,
//            @CookieValue(value = "livesexhouseCheckMail", required = false) Cookie cookieMail,
//            @CookieValue(value = "livesexhouseSigned", required = false) Cookie cookieSigned,
//            @CookieValue(value = "livesexhouseTrust", required = false) Cookie cookieTrust,
//            ModelMap model,
//            HttpServletResponse response,
//            HttpServletRequest request) throws Exception {
//        String path = "";
//        String loc = "";
//
//        try {
//            path = setupDao.getPath();
//            loc = setupDao.getLocation();
//
//            if (cookieTrust != null) {
//                model.addAttribute("trustedUser", true);
//            } else {
//                if (cookieSigned != null) {
//                    model.addAttribute("alredySigned", true);
//                } else {
//                    if (cookieMail != null) {
//                        model.addAttribute("checkEmail", true);
//                    }
//                }
//            }
//            HeartBeatCTRL hb = new HeartBeatCTRL();
//            System.out.println(hb.i);
//List<Heartbeat> l = new ArrayList<>();
//l = heartbeatDao.findByStatus(2);
//for(Heartbeat h : l){
//    System.out.println(h.getPrice());
////}
//        } catch (Exception ex) {
//        }
//
//        model.addAttribute("path", path);
//        model.addAttribute("location", loc);
//        model.addAttribute("bck", "");
//
//        return "index";
//
////        return redirect.re(request.getHeader("referer"));
//    }
}
