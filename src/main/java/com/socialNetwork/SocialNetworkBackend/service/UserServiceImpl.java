package com.socialNetwork.SocialNetworkBackend.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.socialNetwork.SocialNetworkBackend.dto.ImageDto;
import com.socialNetwork.SocialNetworkBackend.dto.MessageDto;
import com.socialNetwork.SocialNetworkBackend.dto.ProfileDto;
import com.socialNetwork.SocialNetworkBackend.dto.SignUpDto;
import com.socialNetwork.SocialNetworkBackend.dto.UserDto;
import com.socialNetwork.SocialNetworkBackend.dto.UserSummaryDto;

@Service
public class UserServiceImpl implements UserService {

    public ProfileDto getProfile(Long userId) {
        return new ProfileDto(new UserSummaryDto(1L, "Sergio", "Lema"),
                Arrays.asList(new UserSummaryDto(2L, "John", "Doe")),
                Arrays.asList(new MessageDto(1L, "My message")),
                Arrays.asList(new ImageDto(1L, "Title", null)));
    }

    public void addFriend(Long friendId) {
        // nothing to do at the moment
    }

    public List<UserSummaryDto> searchUsers(String term) {
        return Arrays.asList(new UserSummaryDto(1L, "Sergio", "Lema"),
                new UserSummaryDto(2L, "John", "Doe"));
    }

    public UserDto signUp(SignUpDto user) {
        return new UserDto(1L, "Sergio", "Lema", "login", "token");
    }

    public void signOut(UserDto user) {
        // nothing to do at the moment
    }
}