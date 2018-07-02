package com.kanchan.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.kanchan.model.Friend;
import com.kanchan.model.UserDetail;

public class FriendDAOImpl implements FriendDAO
{
	@Autowired 
	SessionFactory sessionFactory;
	public List<Friend> showFriendList(String loginname) {
		
		return null;
	}

	public List<Friend> showPendingFriendRequest(String loginname) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserDetail> showSuggestedFriend(String loginname) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean sendFriendRequest(Friend friend)
	{
		
		return false;
	}

	public boolean acceptFriendRequest(int friendId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteFriendRequest(int friendId) {
		// TODO Auto-generated method stub
		return false;
	}

}
