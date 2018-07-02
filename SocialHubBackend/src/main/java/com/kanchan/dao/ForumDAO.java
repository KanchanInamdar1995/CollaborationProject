package com.kanchan.dao;

import java.util.List;


import com.kanchan.model.Forum;

public interface ForumDAO 
{
public boolean addForum(Forum forum);
public boolean deleteForum(Forum forum);
public boolean updateForum(Forum forum);

public List<Forum> listForums();
public Forum getForum(int forumId);

public boolean approveForum(int forumId);
public boolean rejectForum(int forumId);

}
