package com.example.client.dataloader;

import com.example.client.entities.*;
import com.example.client.services.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

@Component
public class SampleClientDataLoader implements ApplicationRunner {

    private static final Logger LOGGER = LogManager.getLogger(SampleClientDataLoader.class);

    private final UserService userService;
    private final PostService postService;

    private final UserGroupService userGroupService;

    private final GroupService groupService;

    private final AddressService addressService;


    public SampleClientDataLoader(UserService userService, PostService postService,
                                  UserGroupService userGroupService, GroupService groupService,
                                  AddressService addressService) {
        this.userService = userService;
        this.postService = postService;
        this.userGroupService = userGroupService;
        this.groupService = groupService;
        this.addressService = addressService;
    }

    @Transactional
    @Override
    public void run(ApplicationArguments args) {
        // Load sample data for users
        Group group1 = new Group("Group1");
        Group group2 = new Group("Group2");

        //The BCrypt.checkpw() method compares the provided password with the stored hashed password and returns true if they match.

        User user1 = new User("Patrick","Bruel",
                "patrick.bruel","uxv-2345-vfg-kkk-998",
                BCrypt.hashpw("patr!ck20#", BCrypt.gensalt()),
                "patrick.bruel@yahoo.com", "MALE",
                "+55112345-5432",
                "https://www.disneyplus.com/pt-br/movies/avatar/2YOnkRN4LwZZ",
                LocalDate.of(1990, 8, 25));
        User user2 = new User("Jennifer","lopez",
                "jennifer.lopez","fff-9857-sdc-lok-115",
                BCrypt.hashpw("Jenn!fer20#", BCrypt.gensalt()),
                "jannifer.lopez@gmail.com", "FEMALE",
                "+55116789-2309",
                "https://www.disneyplus.com/pt-br/movies/avatar/2YOnkRN4LwZZ",
                LocalDate.of(1985, 5, 15));


        UserGroup userGroup1 = new UserGroup();
        userGroup1.setGroup(group1);
        userGroup1.setUser(user1);
        userGroup1.setActivated(Boolean.TRUE);
        userGroup1.setRegisteredDate(new Date());

        UserGroup userGroup2 = new UserGroup();
        userGroup2.setGroup(group2);
        userGroup2.setUser(user2);
        userGroup2.setActivated(Boolean.TRUE);
        userGroup2.setRegisteredDate(new Date());

        Address address1 = new Address();
        address1.setCity("Sao Paulo");
        address1.setCountry("Brazil");
        address1.setStreetAddress("462 Rua Mauro");
        address1.setStreetName("Rua Mauro");
        address1.setState("Sao Paulo");
        address1.setZipCode("04055-041");
        address1.setUser(user1);

        Address address2 = new Address();
        address2.setCity("Sao Paulo");
        address2.setCountry("Brazil");
        address2.setStreetAddress("1778 Av. Paulista");
        address2.setStreetName("R. Augusta");
        address2.setState("Sao Paulo");
        address2.setZipCode("01310-000");
        address2.setUser(user2);

        group1.getUserGroups().add(userGroup1);
        group2.getUserGroups().add(userGroup2);

        groupService.saveGroup(group1);
        groupService.saveGroup(group2);
        userGroupService.saveUserGroup(userGroup1);
        userGroupService.saveUserGroup(userGroup2);
        addressService.saveAddress(address1);
        addressService.saveAddress(address2);
        userService.saveUser(user1);
        userService.saveUser(user2);

        // Load sample data for posts
        Post post1 = new Post("Title 1", "Content 1", user1);
        Post post2 = new Post("Title 2", "Content 2", user2);
        postService.savePost(post1);
        postService.savePost(post2);

    }

}
