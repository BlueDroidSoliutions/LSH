package com.livesexhouse.DAO;

import com.livesexhouse.controller.Checker;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

import javax.persistence.Query;

import com.livesexhouse.model.VideoClip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang.StringUtils;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class VideoDao {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    Checker checker;

    public void save(VideoClip k) {

        try {
            Session session = sessionFactory.getCurrentSession();
            session.save(k);
        } catch (HibernateException e) {

        }

    }

    public void update(VideoClip k) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.update(k);

        } catch (HibernateException e) {

        }
    }

    public Integer saveR(VideoClip k) {
        Integer id = 0;
        try {
            Session session = sessionFactory.getCurrentSession();
            id = (Integer) session.save(k);
        } catch (HibernateException e) {

        }

        return id;
    }

    public void delete(VideoClip vc) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.delete(vc);
        } catch (HibernateException e) {

        }

    }

    public VideoClip findById(int id) {

        VideoClip v = new VideoClip();

        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("VideoClip.findById");
            query.setParameter("id", id);
            v = (VideoClip) query.getSingleResult();
        } catch (HibernateException e) {
        }
        return v;
    }

    public List<VideoClip> findSimilarByVideoSearch(VideoClip video, int similarVideoSize, String search) {

        List<VideoClip> v = new ArrayList<>();
        List<VideoClip> v2 = new ArrayList<>();
        List<VideoClip> fList = new ArrayList<>();
        try {

            String search2 = search.replace('-', ' ').trim();

            if (checker.check(search2)) {
                Session session = sessionFactory.getCurrentSession();

                search = search.replaceAll("-", " ");

                String queryy = "";
                queryy = "SELECT v FROM VideoClip v WHERE v.tag LIKE '%" + search + "%' or v.name LIKE '%" + search + "%'";
                Query q2 = sessionFactory.getCurrentSession().createQuery(queryy);
                String[] parts = search.split(" ");

                if (q2.getResultList().size() < 1) {
                    String m = "";
                    for (String s : parts) {
                        m = m + "v.tag LIKE " + "'%" + s + "%' OR v.name LIKE '%" + s + "%' OR ";
                    }
                    m = m.substring(0, m.length() - 4);
                    queryy = "SELECT v FROM VideoClip v WHERE " + m;
                    q2 = sessionFactory.getCurrentSession().createQuery(queryy);
                }
                v = q2.getResultList();

                for (VideoClip vv : v) {
                    if (vv.getId() != video.getId()) {
                        fList.add(vv);
                    }
                }

                v.clear();
                //ako final lista ima manje klipova nego sto treba
                if (fList.size() < similarVideoSize) {
                    //ubacujemo najbolje klipove
                    Query query = session.createQuery("SELECT v FROM VideoClip v WHERE enabled = 1 order by voteUp desc");

                    query.setMaxResults(similarVideoSize + fList.size() + 1);
                    v2 = query.getResultList();
                    // ubacujemo u final listu do maximuma potrebnog
                    // fList ima koliko ima i nema onaj jedan
                    // v nema nista
                    // v2 su najlajkovaniji klipovi
                    int need = similarVideoSize - fList.size();

                    int have = 0;
                    if (fList.size() > 0) {
                        boolean ccc = false;

                        for (int i = 0; i < v2.size(); i++) {

                            for (VideoClip b : fList) {
                                if (v2.get(i).getId() == b.getId() || v2.get(i).getId() == video.getId()) {
                                    ccc = true;
                                }
                            }
                            if (!ccc) {
                                v.add(v2.get(i));
                            } else {
                                ccc = false;
                            }
                        }

                        for (int i = 0; i < need; i++) {
                            fList.add(v.get(i));
                        }

                    } else {

                        fList.clear();

                        for (int i = 0; i < v2.size(); i++) {

                            if (v2.get(i).getId() != video.getId()) {
                                v.add(v2.get(i));
                            }
                        }

                        for (int i = 0; i < need; i++) {
                            fList.add(v.get(i));
                        }

                    }

                }

            }
        } catch (HibernateException e) {
        }

        return fList;
    }

    //////////////////////
    //////////
    /////////////////////////////
    public List<VideoClip> findSimilarByVideo(VideoClip video, int similarVideoSize) {

        List<VideoClip> v = new ArrayList<>();
        List<VideoClip> v2 = new ArrayList<>();
        List<VideoClip> fList = new ArrayList<>();
        try {
            String in = video.getTag();
            String[] tag = in.split(" ");
            String app = "";
            for (String t : tag) {

                app = app + " or tag = '" + t + "' ";
            }
            app = app.substring(3);
            Session session = sessionFactory.getCurrentSession();
// uzimamo klipove sa slicnim tagom
            Query query = session.createQuery("SELECT v FROM VideoClip v WHERE " + app + " AND enabled = 1 order by voteUp desc");
            query.setMaxResults(similarVideoSize + 1);
            v = query.getResultList();
            // sve dobijene rezultate ubacujemo u final listu osim tog jednog
            for (VideoClip vv : v) {
                if (vv.getId() != video.getId()) {
                    fList.add(vv);
                }
            }
            v.clear();
            //ako final lista ima manje klipova nego sto treba
            if (fList.size() < similarVideoSize) {
                //ubacujemo najbolje klipove
                query = session.createQuery("SELECT v FROM VideoClip v WHERE enabled = 1 order by voteUp desc");
                query.setMaxResults(similarVideoSize + fList.size() + 1);
                v2 = query.getResultList();
                // ubacujemo u final listu do maximuma potrebnog
                // fList ima koliko ima i nema onaj jedan
                // v nema nista
                // v2 su najlajkovaniji klipovi
                int need = similarVideoSize - fList.size();
                int have = 0;
                if (fList.size() > 0) {
                    boolean ccc = false;
                    for (int i = 0; i < v2.size(); i++) {

                        for (VideoClip b : fList) {
                            if (v2.get(i).getId() == b.getId() || v2.get(i).getId() == video.getId()) {
                                ccc = true;
                            }
                        }
                        if (!ccc) {
                            v.add(v2.get(i));
                        } else {
                            ccc = false;
                        }
                    }

                    for (int i = 0; i < need; i++) {
                        fList.add(v.get(i));
                    }

                } else {

                    fList.clear();

                    for (int i = 0; i < v2.size(); i++) {

                        if (v2.get(i).getId() != video.getId()) {
                            v.add(v2.get(i));
                        }
                    }

                    for (int i = 0; i < need; i++) {
                        fList.add(v.get(i));
                    }

                }
            }
        } catch (HibernateException e) {
        }

        return fList;
    }

    public VideoClip findByIdNewSes(int id) {

        VideoClip v = new VideoClip();
        try {
            Session session = sessionFactory.getCurrentSession();

            Query query = session.getNamedQuery("VideoClip.findByIdWithout");
            query.setParameter("id", id);
            v = (VideoClip) query.getSingleResult();
        } catch (HibernateException e) {
        }

        return v;
    }

    public Object[] findAll(int maxVideoPerPage, int firstResult) {
        List<VideoClip> result = new ArrayList();
        int numVideos = 0;
        try {
            Session session = sessionFactory.getCurrentSession();

            Query query = session.getNamedQuery("VideoClip.findAll");
            numVideos = query.getResultList().size();

            query.setFirstResult(firstResult);
            query.setMaxResults(maxVideoPerPage);
            result = query.getResultList();

        } catch (HibernateException e) {
        }
        return new Object[]{result, numVideos};
    }

    public Object[] find(int maxVideoPerPage, int firstResult, int sort, String dateFilterr, int[] roomFilterr, int[] seasonFilterr, int[] durationFilterr, int[] memberFilterr, int[] categoryFilterr, String search) {

        search = search.trim();
        search = search.replace('-', ' ');

        List<VideoClip> result = new ArrayList();
        int numVideos = 0;
        int videoNumTotal = 0;
        try {

            if (checker.check(search)) {

                List seasonList = new ArrayList();
                List memberList = new ArrayList();
                List roomList = new ArrayList();
                List durationList = new ArrayList();
                List categoryList = new ArrayList();
                List searchList = new ArrayList();
                String and = "AND";
                String query = "";
                String sortStr = "";
                String durationStr = "";
                Boolean begin = false;
                Boolean customQuery = true;
                Boolean memberB = false;
                Boolean seasonB = false;
                Boolean roomB = false;
                Boolean categoryB = false;
                Boolean durationB = false;
                Boolean sortBool = false;
                Boolean searchB = false;

//            int dateFilter = 0;
                int roomFilter = 0;
                int seasonFilter = 0;
                int durationFilter = 0;
                int memberFilter = 0;
                int categoryFilter = 0;

                Query videoNumTotalQ = sessionFactory.getCurrentSession().createQuery("SELECT v.id FROM VideoClip v WHERE enabled = 1");
                videoNumTotal = (int) videoNumTotalQ.getResultList().size();

                switch (sort) {

                    case 1:
                        sortStr = " ORDER BY name ASC";
                        break;
                    case 2:
                        sortStr = " ORDER BY name DESC";
                        break;
                    case 3:
                        sortStr = " ORDER BY wish_list DESC";
                        break;
                    case 4:
                        sortStr = " ORDER BY view_count DESC";
                        break;
                    case 5:
                        sortStr = " ORDER BY vote_up ASC";
                        break;
                    case 6:
                        sortStr = " ORDER BY vote_up DESC";
                        break;
                    case 7:
                        sortStr = " ORDER BY upload_date ASC";
                        break;
                    case 8:
                        sortStr = " ORDER BY upload_date DESC";
                        break;
//                case 9:
//                    sortStr = " ORDER BY season ASC";
//                    break;
//                case 10:
//                    sortStr = " ORDER BY season DESC";
//                    break;
                    case 11:
                        sortStr = " ORDER BY duration ASC";
                        break;
                    case 12:
                        sortStr = " ORDER BY duration DESC";
                        break;
                }

                if (roomFilterr.length == 1 && seasonFilterr.length == 1 && durationFilterr.length == 1 && memberFilterr.length == 1 && categoryFilterr.length == 1) {
                    roomFilter = roomFilterr[0];
                    seasonFilter = seasonFilterr[0];
                    durationFilter = durationFilterr[0];
                    memberFilter = memberFilterr[0];
                    categoryFilter = categoryFilterr[0];

                    switch (durationFilter) {

                        case 1:
                            durationStr = " AND duration < 300";
                            break;
                        case 2:
                            durationStr = " AND duration > 299 AND duration < 900";
                            break;
                        case 3:
                            durationStr = " AND duration > 899 AND duration < 1800";
                            break;
                        case 4:
                            durationStr = " AND duration > 1799";
                            break;

                    }

                    if (memberFilter != 0) {
                        Query member = sessionFactory.getCurrentSession().createQuery("SELECT v.clipId FROM VideoM2m v WHERE v.memberHouseId = :m");
                        member.setParameter("m", memberFilter);
                        memberList = member.getResultList();
                        if (memberList.isEmpty()) {
                            customQuery = false;
                        }
                        query = query + "SELECT v FROM VideoClip v WHERE v.id IN :memberList AND enabled = 1";
                        begin = true;
                        memberB = true;
                    }

                    if (!search.equals("0")) {
                        Query searchQ = sessionFactory.getCurrentSession().createQuery("SELECT v.id FROM VideoClip v WHERE v.tag LIKE :searchKeyword or v.name LIKE :searchKeyword");
                        searchQ.setParameter("searchKeyword", search + "%");

                        searchList = searchQ.getResultList();
                        if (searchList.isEmpty()) {
                            customQuery = false;
                        }
                        if (!begin) {
                            query = query + "SELECT v FROM VideoClip v WHERE v.id IN :searchList AND enabled = 1";
                            begin = true;
                        } else {
                            query = query + " AND v.id IN :searchList";
                        }
                        searchB = true;
                    }

                    if (seasonFilter != 0) {
                        Query season = sessionFactory.getCurrentSession().createQuery("SELECT v.clipId FROM VideoM2m v WHERE v.season = :s");
                        season.setParameter("s", seasonFilter);
                        seasonList = season.getResultList();
                        if (seasonList.isEmpty()) {
                            customQuery = false;
                        }
                        if (!begin) {
                            query = query + "SELECT v FROM VideoClip v WHERE v.id IN :seasonList AND enabled = 1";
                            begin = true;
                        } else {
                            query = query + " AND v.id IN :seasonList";
                        }
                        seasonB = true;
                    }

                    if (roomFilter != 0) {
                        Query room = sessionFactory.getCurrentSession().createQuery("SELECT v.clipId FROM VideoM2m v WHERE v.room = :r");
                        room.setParameter("r", roomFilter);
                        roomList = room.getResultList();
                        if (roomList.isEmpty()) {
                            customQuery = false;
                        }
                        if (!begin) {
                            query = query + "SELECT v FROM VideoClip v WHERE v.id IN :roomList AND enabled = 1";
                            begin = true;
                        } else {
                            query = query + " AND v.id IN :roomList";
                        }
                        roomB = true;
                    }

                    if (dateFilterr.length() > 3) {
                        if (!begin) {
                            query = query + "SELECT v FROM VideoClip v WHERE v.uploadDate >='" + dateFilterr + " 00:00:00' AND v.uploadDate <= '" + dateFilterr + " 23:59:59' AND enabled = 1";
                            begin = true;
                        } else {
                            query = query + " AND v.uploadDate >='" + dateFilterr + " 00:00:00' AND v.uploadDate <= '" + dateFilterr + " 23:59:59' ";
                        }
                    }

                    if (categoryFilter != 0) {
                        Query category = sessionFactory.getCurrentSession().createQuery("SELECT v.clipId FROM VideoM2m v WHERE v.categoryId = :c");
                        category.setParameter("c", categoryFilter);
                        categoryList = category.getResultList();
                        if (categoryList.isEmpty()) {
                            customQuery = false;
                        }
                        if (!begin) {
                            query = query + "SELECT v FROM VideoClip v WHERE v.id IN :categoryList AND enabled = 1";
                            begin = true;
                        } else {
                            query = query + " AND v.id IN :categoryList";
                        }
                        categoryB = true;
                    }

                    if (query.length() < 2) {
                        query = "SELECT v FROM VideoClip v WHERE enabled = 1";
                        if (durationFilter != 0) {
                            query = query + durationStr;
                        }
                    }
                    if (customQuery) {
                        if (durationFilter != 0) {
                            query = query + durationStr;
                        }
                        query = query + sortStr;

                        Query q2 = sessionFactory.getCurrentSession().createQuery(query);

                        if (memberB) {
                            q2.setParameter("memberList", memberList);
                        }
                        if (seasonB) {
                            q2.setParameter("seasonList", seasonList);
                        }
                        if (searchB) {
                            q2.setParameter("searchList", searchList);
                        }
                        if (roomB) {
                            q2.setParameter("roomList", roomList);
                        }
                        if (categoryB) {
                            q2.setParameter("categoryList", categoryList);
                        }

                        numVideos = q2.getResultList().size();
                        q2.setFirstResult(firstResult);
                        q2.setMaxResults(maxVideoPerPage);
                        result = q2.getResultList();
                    }

                } else {
                    /////////////////////// ako ima vise filtera
                    String sBegin = "select t1.clip_id from ";

                    String stringCategory = "";
                    String stringRoom = "";
                    String stringMember = "";
                    String stringSeason = "";
                    String stringDuration = "";
                    String stringDate = "";
                    String stringSearch = "";

                    String sFinal = "";

                    int count = 1;

                    Boolean dateFilterrB = true;
                    if (dateFilterr.length() < 3) {
                        dateFilterrB = false;
                    }

                    Boolean categoryFilterrB = true;
                    if (categoryFilterr.length == 1) {
                        if (categoryFilterr[0] == 0) {
                            categoryFilterrB = false;
                        }
                    }

                    Boolean roomFilterrB = true;
                    if (roomFilterr.length == 1) {
                        if (roomFilterr[0] == 0) {
                            roomFilterrB = false;
                        }
                    }

                    Boolean memberFilterrB = true;
                    if (memberFilterr.length == 1) {
                        if (memberFilterr[0] == 0) {
                            memberFilterrB = false;
                        }
                    }

                    Boolean seasonFilterrB = true;
                    if (seasonFilterr.length == 1) {
                        if (seasonFilterr[0] == 0) {
                            seasonFilterrB = false;
                        }
                    }

                    Boolean searchFilterB = true;
                    if (search.equals("0")) {
                        searchFilterB = false;
                    }

                    Boolean durationFilterrB = true;
                    if (durationFilterr.length == 1) {
                        if (durationFilterr[0] == 0) {
                            durationFilterrB = false;
                        }
                    }

                    if (categoryFilterrB) {
                        for (int i = 0; i < categoryFilterr.length; i++) {
                            if (categoryFilterr[i] != 0) {
                                stringCategory = stringCategory + "(select clip_id from video_m2m where category_id = " + categoryFilterr[i] + ") t" + count + "," + "";
                                count++;
                            }
                        }
                    }

                    /////////////
                    if (roomFilterrB) {
                        for (int i = 0; i < roomFilterr.length; i++) {
                            if (roomFilterr[i] != 0) {
                                stringRoom = stringRoom + "(select clip_id from video_m2m where room = " + roomFilterr[i] + ") t" + count + "," + "";
                                count++;
                            }
                        }
                    }

                    if (searchFilterB) {
                        stringSearch = stringSearch + "(SELECT id as clip_id FROM video_clip  WHERE tag LIKE '%" + search + "%' or name LIKE '%" + search + "%') t" + count + "," + "";
                        count++;
                    }

                    ///////////
                    if (memberFilterrB) {
                        for (int i = 0; i < memberFilterr.length; i++) {
                            if (memberFilterr[i] != 0) {
                                stringMember = stringMember + "(select clip_id from video_m2m where member_house_id = " + memberFilterr[i] + ") t" + count + "," + "";
                                count++;
                            }
                        }
                    }

                    /////////
                    if (seasonFilterrB) {
                        for (int i = 0; i < seasonFilterr.length; i++) {
                            if (seasonFilterr[i] != 0) {
                                stringSeason = stringSeason + "(select clip_id from video_m2m where season = " + seasonFilterr[i] + ") t" + count + "," + "";
                                count++;
                            }
                        }
                    }

                    //////////
                    query = query + "SELECT v FROM VideoClip v WHERE v.uploadDate >='" + dateFilterr + " 00:00:00' AND v.uploadDate <= '" + dateFilterr + " 23:59:59' AND enabled = 1";

                    if (dateFilterrB) {
                        stringDate = stringDate + "(select id as clip_id from video_clip WHERE upload_date >='" + dateFilterr + " 00:00:00' AND upload_date <= '" + dateFilterr + " 23:59:59') t" + count + "," + "";
                        count++;
                    }

///////
                    if (durationFilterrB) {
                        for (int i = 0; i < durationFilterr.length; i++) {
                            if (durationFilterr[i] != 0) {
                                if (durationFilterr[i] == 1) {
                                    stringDuration = stringDuration + "(select id as clip_id from video_clip where duration < 300) t" + count + "," + "";
                                    count++;
                                }
                                if (durationFilterr[i] == 2) {
                                    stringDuration = stringDuration + "(select id as clip_id from video_clip where duration > 299 AND duration < 900) t" + count + "," + "";
                                    count++;
                                }
                                if (durationFilterr[i] == 3) {
                                    stringDuration = stringDuration + "(select id as clip_id from video_clip where duration > 899 AND duration < 1800) t" + count + "," + "";
                                    count++;
                                }
                                if (durationFilterr[i] == 4) {
                                    stringDuration = stringDuration + "(select id as clip_id from video_clip where duration > 1799) t" + count + "," + "";
                                    count++;
                                }
                            }
                        }
                    }

                    /////////
                    String mid = stringCategory + stringRoom
                            + stringSearch
                            + stringDate + stringMember + stringSeason + stringDuration;
                    ////////

                    mid = mid.substring(0, mid.length() - 1);
                    String endString = " WHERE t1.clip_id = t2.clip_id ";
                    count--;
                    if (count > 2) {
                        for (int i = 2; i < count; i++) {
                            endString = endString + "AND t" + i + ".clip_id = " + "t" + (i + 1) + ".clip_id ";
                        }
                    }

                    sFinal = sBegin + mid + endString + ";";

                    Query q3 = sessionFactory.getCurrentSession().createNativeQuery(sFinal);

                    numVideos = q3.getResultList().size();

                    List m = new ArrayList();
                    m = q3.getResultList();

                    for (Object n : m) {
                        Session session = sessionFactory.getCurrentSession();
                        Query queryQ = session.getNamedQuery("VideoClip.findById");
                        queryQ.setParameter("id", Integer.valueOf(n.toString()));
                        VideoClip vc = (VideoClip) queryQ.getSingleResult();
                        result.add(vc);
                    }

                    if (!m.isEmpty()) {
                        String q4 = "SELECT v FROM VideoClip v WHERE v.id IN :mm AND enabled = 1 ";
                        q4 = q4 + sortStr;
                        Query q5 = sessionFactory.getCurrentSession().createQuery(q4);
                        q5.setParameter("mm", m);
                        numVideos = q5.getResultList().size();
                        q5.setFirstResult(firstResult);
                        q5.setMaxResults(maxVideoPerPage);
                        result = q5.getResultList();
                    }
                }
            } else {
                System.out.println("errr sql injection");
            }
        } catch (HibernateException e) {
        }
        return new Object[]{result, numVideos, videoNumTotal};
    }

    public Object[] search(int maxVideoPerPage, String search) {
        List<VideoClip> result = new ArrayList();
        int numVideos = 0;
        int videoNumTotal = 0;
        String percent = "";
        try {
            search = search.trim();
            if (checker.check(search)) {

                Query videoNumTotalQ = sessionFactory.getCurrentSession().createQuery("SELECT v.id FROM VideoClip v WHERE enabled = 1");
                videoNumTotal = (int) videoNumTotalQ.getResultList().size();

                String query = "";
                query = "SELECT v FROM VideoClip v WHERE v.tag LIKE '%" + search + "%' or v.name LIKE '%" + search + "%'";
                Query q2 = sessionFactory.getCurrentSession().createQuery(query);
                String[] parts = search.split(" ");
                for (String s : parts) {
                    percent = percent + s + "-";
                }
                if (q2.getResultList().size() < 1) {
                    String m = "";
                    for (String s : parts) {
                        m = m + "v.tag LIKE " + "'%" + s + "%' OR v.name LIKE '%" + s + "%' OR ";
                    }
                    m = m.substring(0, m.length() - 4);
                    query = "SELECT v FROM VideoClip v WHERE " + m;
                    q2 = sessionFactory.getCurrentSession().createQuery(query);
                }

                percent = "&&10=" + percent;
                percent = percent.substring(0, percent.length() - 1);
                numVideos = q2.getResultList().size();
                q2.setMaxResults(maxVideoPerPage);
                result = q2.getResultList();
            } else {
                System.out.println("err mysql injection");
            }
        } catch (HibernateException e) {
        }
        return new Object[]{result, numVideos, videoNumTotal, percent};
    }

}
