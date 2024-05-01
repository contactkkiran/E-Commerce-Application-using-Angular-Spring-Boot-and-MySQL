package com.youtube.jwt.service;

import com.youtube.jwt.dao.RoleDao;
import com.youtube.jwt.dao.UserDao;
import com.youtube.jwt.entity.Role;
import com.youtube.jwt.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired

    private RoleDao roleDao;

    @Transactional
    public User registerNewUser(User user) {
        return userDao.save(user);
    }

    @Transactional
    public void initRoleAndUsers() {
        //Role
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin Role Description");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default Role for Newly created record");
        roleDao.save(userRole);

        //User
        User adminUser = new User();
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserName("admin123");
        adminUser.setUserPassword("admin@pass");

        Set<Role> adminRoles = new HashSet<>();
        adminUser.setRole(adminRoles);
        adminRoles.add(adminRole);
        userDao.save(adminUser);

        User user = new User();
        user.setUserFirstName("Kiran");
        user.setUserLastName("Kumar");
        user.setUserName("kiran123");
        user.setUserPassword("kiran@pass");

        Set<Role> userRoles = new HashSet<>();
        user.setRole(userRoles);
        userRoles.add(userRole);
        userDao.save(user);
    }

}
