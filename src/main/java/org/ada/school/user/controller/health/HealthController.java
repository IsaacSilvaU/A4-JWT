package org.ada.school.user.controller.health;

import org.ada.school.user.controller.user.UserDto;
import org.ada.school.user.repository.document.User;
import org.ada.school.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "v1/health" )
public class HealthController
{

    /*@Autowired
    UserService userService;
*/

    @GetMapping
    public String all()
    {
        //createNewUser();
        return "API Working OK!";
    }

    /*private void createNewUser() {
        UserDto userDto = new UserDto("Isaac","Silva", "isaac@email.com", "123");
        User user = userService.create( userDto );
        System.out.println("Quemando usuario de prueba: " + user.getId());
    }*/


}
