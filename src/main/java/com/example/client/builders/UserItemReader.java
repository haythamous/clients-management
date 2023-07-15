package com.example.client.builders;

import com.example.client.data.UserData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Component
public class UserItemReader implements ItemReader<UserData> {

    private static final Logger LOGGER = LogManager.getLogger(UserItemReader.class);

    @Autowired
    private final RestTemplate restTemplate;

    @Value("${rest.api.url.random.user}")
    private String restRandomUserAPI;

    private int nextUserIndex;
    private List<UserData> userData;

    public UserItemReader(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        nextUserIndex = 0;
    }

    @Override
    public UserData read() {
        if (userDataIsNotInitialized()) {
            userData = fetchUsersDataFromAPI();
        }

        UserData nextUser = null;

        if (nextUserIndex < userData.size()) {
            nextUser = userData.get(nextUserIndex);
            nextUserIndex++;
        }
        else {
            nextUserIndex = 0;
            userData = null;
        }

        return nextUser;
    }

    private boolean userDataIsNotInitialized() {
        return this.userData == null;
    }

    private List<UserData> fetchUsersDataFromAPI() {
        ResponseEntity<UserData[]> response = restTemplate.getForEntity(restRandomUserAPI,
                UserData[].class
        );
        UserData[] usersData = response.getBody();
        return Arrays.asList(usersData);
    }

}