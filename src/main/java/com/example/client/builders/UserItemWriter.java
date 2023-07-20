package com.example.client.builders;

import com.example.client.data.UserData;
import com.example.client.entities.Address;
import com.example.client.entities.Group;
import com.example.client.entities.User;
import com.example.client.entities.UserGroup;
import com.example.client.services.AddressService;
import com.example.client.services.GroupService;
import com.example.client.services.UserGroupService;
import com.example.client.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
public class UserItemWriter implements ItemWriter<UserData> {

    private static final Logger LOGGER = LogManager.getLogger(UserItemWriter.class);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private UserGroupService userGroupService;

    @Autowired
    private AddressService addressService;

    @Override
    public void write(Chunk<? extends UserData> chunk) {

        for (UserData user : chunk) {
            saveUsersAndGroups(user);
        }

    }

    public void saveUsersAndGroups(UserData user){
        LocalDate birthDate = LocalDate.parse(user.getDate_of_birth(), formatter);

        User userToSave = new User(user.getFirst_name(), user.getLast_name(), user.getUsername(),
                user.getUid(), user.getPassword(), user.getEmail(),
                user.getGender(), user.getPhone_number(), user.getAvatar(),
                birthDate);

        com.example.client.data.Address addressFromAPI = user.getAddress();
        Address addressToSave = new Address(addressFromAPI.getCity(), addressFromAPI.getStreet_name(),
                    addressFromAPI.getStreet_address(),addressFromAPI.getZip_code(),addressFromAPI.getState(),addressFromAPI.getCountry());
        addressToSave.setUser(userToSave);

        Group groupToSave = new Group(user.getSubscription().getPlan());

        UserGroup userGroupToSave = new UserGroup();
        userGroupToSave.setGroup(groupToSave);
        userGroupToSave.setUser(userToSave);
        userGroupToSave.setActivated(user.getSubscription().getStatus().
                equals("Active") ? Boolean.TRUE : Boolean.FALSE);
        userGroupToSave.setRegisteredDate(new Date());

        groupToSave.getUserGroups().add(userGroupToSave);

        addressService.saveAddress(addressToSave);
        groupService.saveGroup(groupToSave);
        userGroupService.saveUserGroup(userGroupToSave);
        userService.saveUser(userToSave);
    }
}

