package com.socialNetwork.SocialNetworkBackend.service;

import java.util.List;

import com.socialNetwork.SocialNetworkBackend.dto.ProfileDto;
import com.socialNetwork.SocialNetworkBackend.dto.SignUpDto;
import com.socialNetwork.SocialNetworkBackend.dto.UserDto;
import com.socialNetwork.SocialNetworkBackend.dto.UserSummaryDto;

public interface UserService {
	
	 public ProfileDto getProfile(Long userId);
	 
	 public void addFriend(Long friendId);
	 
	 public List<UserSummaryDto> searchUsers(String term);
	 
	 public UserDto signUp(SignUpDto user);
	 
	 public void signOut(UserDto user);
	 
}
