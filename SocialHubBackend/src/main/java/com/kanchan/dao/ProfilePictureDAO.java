package com.kanchan.dao;

import com.kanchan.model.ProfilePicture;

public interface ProfilePictureDAO
{
	public void save(ProfilePicture profilePicture);
	public ProfilePicture getProfilePicture(String loginname);
}
