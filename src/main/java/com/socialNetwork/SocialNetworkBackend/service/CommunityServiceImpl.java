package com.socialNetwork.SocialNetworkBackend.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.socialNetwork.SocialNetworkBackend.dto.ImageDto;
import com.socialNetwork.SocialNetworkBackend.dto.MessageDto;

@Service
public class CommunityServiceImpl implements CommunityService{

	@Override
	public List<MessageDto> getCommunityMessages(int page) {
		return Arrays.asList(new MessageDto(1L, "First Message"),
				new MessageDto(2L, "Second Message"));
	}

	@Override
	public List<ImageDto> getCommunityImages(int page) {
		return Arrays.asList(new ImageDto(1L, "First Title",null),
				new ImageDto(2L, "Second Title",null));
	}

	@Override
	public MessageDto postMessage(MessageDto messageDto) {
		return new MessageDto(3L, "Third Message");
	}

	@Override
	public ImageDto postImage(MultipartFile file, String title) {
		return new ImageDto(3L, "Third Title", null);
	}

}
