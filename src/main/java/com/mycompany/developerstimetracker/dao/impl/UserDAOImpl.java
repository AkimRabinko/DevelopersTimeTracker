package com.mycompany.developerstimetracker.dao.impl;

import com.mycompany.developerstimetracker.dao.UserDAO;
import com.mycompany.developerstimetracker.entity.Time;
import com.mycompany.developerstimetracker.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.Month;
import java.util.List;

/**
 * Created by AkimPC on 04.06.2016.
 */

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

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
    public Time updateUserTime(Time newTime, int id) {
        newTime.setUser((User)sessionFactory.getCurrentSession()
                .createQuery("from User as u  where u.userId=:userId")
                .setParameter("userId" , id).uniqueResult());
        sessionFactory.getCurrentSession().save("user_time",newTime);
        return newTime;
    }

    @Override
    public List<Time> findTimeById(int id, int numOfResults) {
        List<Time> allTime = (List<Time>) sessionFactory.getCurrentSession()
                .createQuery("from Time as t  where t.user.userId=:id  order by t.id  desc ")
                .setMaxResults(numOfResults)
                .setParameter("id", id).list();
        return allTime;
    }

    @Override
<<<<<<< HEAD
    public int getTotalTime(Month month, int year, int id) {
=======
    public int getTotalTime(Month month,int year, int id) {
>>>>>>> master
        List<Integer> totalTime = (List<Integer>)sessionFactory.getCurrentSession()
                .createQuery("select t.time from Time as t  where t.user.userId=:id and  " +
                        "EXTRACT(MONTH FROM t.date) =:date and " +
                        "EXTRACT(YEAR from  t.date)=:year")
                .setParameter("id", id).setParameter("date", month.getValue()).setParameter("year" , year).list();
        return totalTime.stream().mapToInt(Integer::intValue).sum();
    }
}
