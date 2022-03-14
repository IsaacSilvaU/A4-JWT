package org.ada.school.user;

import org.ada.school.user.controller.user.UserDto;
import org.ada.school.user.repository.document.User;
import org.ada.school.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserServiceApp
{

    public static void main(String[] args )
    {
        SpringApplication.run( UserServiceApp.class, args );
    }

}