package com.cts.user_mgmt_service.service;

import com.cts.user_mgmt_service.Entity.UserPolicy;
import com.cts.user_mgmt_service.Entity.Users;
import com.cts.user_mgmt_service.Repository.UserPolicyRepository;
import com.cts.user_mgmt_service.Repository.UserRepository;
import com.cts.user_mgmt_service.Response.UserResponse;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.java2d.pipe.SpanShapeRenderer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class UserMgmtService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserPolicyRepository userPolicyRepository;


    public Iterable<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users addUsers(Users user){
        String userName = null;
        userName = getUserName(user);

        user.setUsername(userName);
        if (user.getRole() == null){
            user.setRole("user");
        }
        return userRepository.save(user);
    }

    public Users validateUser(String username, String password) {

        String pwdFromdb = null;
        Users users = null;
        //UserResponse userResponse = new UserResponse();

         users = userRepository.findByUsername(username);

        if(users != null && password != null){
            pwdFromdb = users.getPassword();

            if(pwdFromdb != null && pwdFromdb.equalsIgnoreCase(password)){
             return users;
            }
        }

        return users;
    }

    public Users getUserById(Integer userId){

        return userRepository.findOne(userId);

    }

    public Iterable<UserPolicy> getPolicyByUserId(Integer userId){

        Users user = userRepository.findOne(userId);

        Iterable<UserPolicy> userPolicy = user.getUserPolicy();

        return userPolicy;

    }

    private String getUserName(Users users){

        String username= null;
        String firstName = null;
        String dayAndMonth = null;

        if (users != null ) {
            firstName = users.getFirstName();
            try {
                dayAndMonth = getDayAndMonth(users.getDateOfBirth());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        username = firstName + dayAndMonth;
        return username;
    }

    private String getDayAndMonth(String date) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Date formattedDate = null;
        String dayAndMonth = null;
        String dayValue = null;
        String monthValue = null;

        System.out.println("Date value is ::" + date) ;
        LocalDate localDate = LocalDate.parse(date, formatter);

        //DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        //LocalDate localDate = formattedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        if (localDate != null){
            monthValue = String.valueOf(localDate.getMonthValue());
            dayValue = String.valueOf(localDate.getDayOfMonth());
        }
        System.out.println("Day value is ::" + dayValue) ;
        System.out.println("Month value is ::" + monthValue) ;

        if(dayValue != null && dayValue.length() == 1){
            dayValue = "0"+dayValue;
        }

        if (monthValue != null && monthValue.length() == 1){
            monthValue = "0" + monthValue;
        }

        System.out.println("Day value is ::" + dayValue) ;
        System.out.println("Month value is ::" + monthValue) ;
        return dayAndMonth = dayValue + monthValue;
    }


    public void createAdmin(){

        Users users = new Users();

        users.setUsername("admin");
        users.setPassword("admin");
        users.setRole("admin");

        System.out.println("users is ::" + users);
        userRepository.save(users);
    }
}
