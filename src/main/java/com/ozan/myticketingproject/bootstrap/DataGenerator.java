package com.ozan.myticketingproject.bootstrap;

import com.ozan.myticketingproject.dto.RoleDTO;
import com.ozan.myticketingproject.dto.UserDTO;
import com.ozan.myticketingproject.enums.Gender;
import com.ozan.myticketingproject.service.RoleService;
import com.ozan.myticketingproject.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {
    RoleService roleService;
    UserService userService;

    public DataGenerator(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        RoleDTO adminRole=new RoleDTO(1L,"Admin");
        RoleDTO managerRole=new RoleDTO(2L,"Manager");
        RoleDTO employeeRole=new RoleDTO(3L, "Employee");
        //We are giving fake data..add data to map
        //How I am going add data to map? With save method. How I am going to access to save method??
        //We should follow loosely coupled with dependency injection through interface.
        //Create RoleService object (has-a relationship) in DataGenerator and constructor of it.

        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);

        UserDTO user1 = new UserDTO("John", "Kesy",
                "john@cydeo.com", "Abc1", true, "7459684532", managerRole, Gender.MALE);
        UserDTO user5 = new UserDTO("Mike", "Smith",
                "mike@cydeo.com", "Abc2", true, "7459684532", adminRole, Gender.MALE);
        UserDTO user2 = new UserDTO("Delisa",
                "Norre", "delisa@cydeo.com", "123", true, "8567412358", managerRole, Gender.FEMALE);
        UserDTO user3 = new UserDTO("Craig", "Jark",
                "craig@cydeo.com", "Abc3", true, "7777775566", employeeRole, Gender.MALE);
        UserDTO user4 = new UserDTO("Shaun",
                "Hayns", "shaun@cydeo.com", "Abc4", true, "3256987412", managerRole, Gender.MALE);
        UserDTO user6 = new UserDTO("Elizebeth",
                "Loren", "elizebeth@cydeo.com", "Abc4", true, "5306987412", employeeRole, Gender.FEMALE);
        UserDTO user7 = new UserDTO("Maria",
                "Ada", "maria@cydeo.com", "Abc4", true, "9996987412", employeeRole, Gender.FEMALE);
        UserDTO user8 = new UserDTO("Bill",
                "Matt", "bill@cydeo.com", "Abc4", true, "8881239846", employeeRole, Gender.MALE);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);
        /*
        My goal is whenever I start the application I should
        be able to see the roles in dropdown and I should be able to add in the user table
         */


    }
}
