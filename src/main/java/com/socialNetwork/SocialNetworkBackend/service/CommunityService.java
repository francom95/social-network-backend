package com.socialNetwork.SocialNetworkBackend.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.socialNetwork.SocialNetworkBackend.dto.ImageDto;
import com.socialNetwork.SocialNetworkBackend.dto.MessageDto;

public interface CommunityService {

	public List<MessageDto> getCommunityMessages(int page);
	
	public List<ImageDto> getCommunityImages(int page);
	
	public MessageDto postMessage(MessageDto messageDto);
	
	public ImageDto postImage(MultipartFile file, String title);
	
}
