package com.kanchan.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kanchan.model.Friend;
import com.kanchan.model.UserDetail;
@Repository("friendDAO")
@Transactional
public class FriendDAOImpl implements FriendDAO
{
	@Autowired 
	SessionFactory sessionFactory;
	public List<Friend> showFriendList(String loginname)
	{
		
		return null;
	}

	public List<Friend> showPendingFriendRequest(String loginname) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where friendloginname=:flogin and status='NA'");
		query.setParameter("flogin",loginname);
		List<Friend> pendingFriendRequest=query.list();
		return pendingFriendRequest;
	}

	public List<UserDetail> showSuggestedFriend(String loginname) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean sendFriendRequest(Friend friend)
	{
		try
		{
			sessionFactory.getCurrentSession().save(friend);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised"+e);
			return false;
		}
		
	}

	public boolean acceptFriendRequest(int friendId) 
	{
		try
		{
			Session session=sessionFactory.openSession();
			Friend friend=(Friend)session.get(Friend.class, friendId);
			friend.setStatus("A");
			session.update(friend);
			session.close();
			sessionFactory.getCurrentSession().update(friend);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised"+e);
			return false;
		}
	}

	public boolean deleteFriendRequest(int friendId)
	{
		try
		{
			Session session=sessionFactory.openSession();
			Friend friend=(Friend)session.get(Friend.class, friendId);
			sessionFactory.getCurrentSession().delete(friend);
			session.close();
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised"+e);
			return false;
		}
	}

}
