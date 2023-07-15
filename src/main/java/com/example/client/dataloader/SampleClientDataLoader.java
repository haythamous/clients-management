package com.example.client.dataloader;

import com.example.client.entities.Group;
import com.example.client.entities.Post;
import com.example.client.entities.User;
import com.example.client.entities.UserGroup;
import com.example.client.services.GroupService;
import com.example.client.services.PostService;
import com.example.client.services.UserGroupService;
import com.example.client.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Component
public class SampleClientDataLoader implements ApplicationRunner {

    private static final Logger LOGGER = LogManager.getLogger(SampleClientDataLoader.class);

    private final UserService userService;
    private final PostService postService;

    private final UserGroupService userGroupService;

    private final GroupService groupService;


    public SampleClientDataLoader(UserService userService, PostService postService,
                                  UserGroupService userGroupService, GroupService groupService) {
        this.userService = userService;
        this.postService = postService;
        this.userGroupService = userGroupService;
        this.groupService = groupService;
    }

    @Transactional
    @Override
    public void run(ApplicationArguments args) {
        // Load sample data for users
        Group group1 = new Group("Group1");
        Group group2 = new Group("Group2");

        //The BCrypt.checkpw() method compares the provided password with the stored hashed password and returns true if they match.

        User user1 = new User("Patrick","Bruel","patrick.bruel","uxv-2345-vfg-kkk-998",BCrypt.hashpw("patr!ck20#", BCrypt.gensalt()), "patrick.bruel@yahoo.com", "MALE", "+55112345-5432","https://www.disneyplus.com/pt-br/movies/avatar/2YOnkRN4LwZZ");
        User user2 = new User("Jennifer","lopez","jennifer.lopez","fff-9857-sdc-lok-115",BCrypt.hashpw("Jenn!fer20#", BCrypt.gensalt()), "jannifer.lopez@gmail.com", "FEMALE", "+55116789-2309","https://www.disneyplus.com/pt-br/movies/avatar/2YOnkRN4LwZZ");


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

//        Set<UserGroup> userGroupSet1 = new HashSet<>();
//        userGroupSet1.add(userGroup1);
//
//        Set<UserGroup> userGroupSet2 = new HashSet<>();
//        userGroupSet2.add(userGroup2);

        group1.getUserGroups().add(userGroup1);
        group2.getUserGroups().add(userGroup2);

        groupService.saveGroup(group1);
        groupService.saveGroup(group2);
        userGroupService.saveUserGroup(userGroup1);
        userGroupService.saveUserGroup(userGroup2);
        userService.saveUser(user1);
        userService.saveUser(user2);

        // Load sample data for posts
        Post post1 = new Post("Title 1", "Content 1", user1);
        Post post2 = new Post("Title 2", "Content 2", user2);
        postService.savePost(post1);
        postService.savePost(post2);

    }

}
