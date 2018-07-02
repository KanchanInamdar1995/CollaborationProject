package com.kanchan.dao;

import java.util.List;

import com.kanchan.model.ForumComment;

public interface ForumCommentDAO
{
	public boolean addComment(ForumComment forumComment);
	public boolean deleteComment(ForumComment forumComment);
	public List<ForumComment> getAllComments(int forumId);
}
