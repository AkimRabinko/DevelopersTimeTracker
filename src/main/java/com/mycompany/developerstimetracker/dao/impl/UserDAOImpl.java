package com.mycompany.developerstimetracker.dao.impl;

import com.mycompany.developerstimetracker.dao.UserDAO;
import com.mycompany.developerstimetracker.entity.Project;
import com.mycompany.developerstimetracker.entity.Time;
import com.mycompany.developerstimetracker.entity.User;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by AkimPC on 04.06.2016.
 */

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private int year = LocalDate.now().getYear();

    public UserDAOImpl() {
    }

    @Override
    public List<User> findAllUsers() {
        List<User> allUsers = (List<User>)
                sessionFactory.getCurrentSession().createCriteria(User.class).list();
        return allUsers;
    }

    @Override
    public User findUserById(int id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public User findUserByLogin(String login) {
        return (User) sessionFactory.getCurrentSession().createQuery("from User as u  where u.userLogin=:login")
                .setParameter("login" , login).uniqueResult();
    }

    @Override
    public User addNewUser(User newUser) {
        sessionFactory.getCurrentSession().save("user", newUser);
        return newUser;
    }

    @Override
    public Time updateUserTime(int userId, String projectName, Time newTime) {
        newTime.setUser((User)sessionFactory.getCurrentSession()
                .createQuery("from User as u  where u.userId=:userId")
                .setParameter("userId" , userId).uniqueResult());
        newTime.setProject((Project) sessionFactory.getCurrentSession()
                .createQuery("from Project as p  where p.projectName=:projectName")
                .setParameter("projectName" , projectName).uniqueResult());
        sessionFactory.getCurrentSession().save("user_time",newTime);
        return newTime;
    }

    @Override
    public List<Time> findTimeByIdLimit(int id, int numOfResults) {
        List<Time> allTime = (List<Time>) sessionFactory.getCurrentSession()
                .createQuery("from Time as t  where t.user.userId=:id  order by t.id  desc ")
                .setMaxResults(numOfResults)
                .setParameter("id", id).list();
        return allTime;
    }

    @Override
    public List<Time> findTimeByIdMonth(int id, Month month) {
        List<Time> allTime = (List<Time>) sessionFactory.getCurrentSession()
                .createQuery("from Time as t  where t.user.userId=:id and EXTRACT(MONTH FROM t.date)=:date " +
                        "and EXTRACT(YEAR from  t.date)=:year order by t.id  desc  ")
                .setParameter("date", month.getValue())
                .setParameter("id", id)
                .setParameter("year", year).list();
        return allTime;
    }

    @Override
    public List<Time> findTimeByIdRange(int id, Date fromDate, Date toDate) {
        List<Time> allTime = (List<Time>) sessionFactory.getCurrentSession()
                .createQuery("from Time as t  where t.user.userId=:id and t.date between :fromDate and :toDate order by t.id  desc  ")
                .setParameter("fromDate", fromDate)
                .setParameter("toDate", toDate)
                .setParameter("id", id).list();
        return allTime;
    }

    @Override
    public int getTotalTime(Month month, int id) {
        List<Integer> totalTime = (List<Integer>)sessionFactory.getCurrentSession()
                .createQuery("select t.time from Time as t  where t.user.userId=:id and  " +
                        "EXTRACT(MONTH FROM t.date) =:date and " +
                        "EXTRACT(YEAR from  t.date)=:year")
                .setParameter("id", id).setParameter("date", month.getValue()).setParameter("year" , year).list();
        return totalTime.stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public List<Project> getAvailableProjects() {
        List<Project> allProjects = (List<Project>) sessionFactory.getCurrentSession().createCriteria(Project.class).list();
        return allProjects;
    }

    @Override
    public String getReport() throws JRException {
        List<User> allUsers = (List<User>)
                sessionFactory.getCurrentSession().createCriteria(User.class).list();
        Map parameters = new HashMap();
        parameters.put("Title", "The Cat Report");
        InputStream reportStream = this.getClass().getResourceAsStream("E:/GitHub/DevelopersTimeTracker/reportFile0.xml");
        JasperDesign jasperDesign = JasperManager.loadXmlDesign(reportStream);
        JasperReport jasperReport = JasperManager.compileReport(jasperDesign);

        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(allUsers);
        JasperPrint jasperPrint = JasperManager.fillReport(jasperReport, parameters, ds);
        JasperManager.printReportToPdfFile(jasperPrint, "reportFile.pdf");

        JasperExportManager.exportReportToPdfFile(jasperPrint, "E:/GitHub/DevelopersTimeTracker/reportFile.pdf");
        return JasperReport.LANGUAGE_JAVA;
    }

}
