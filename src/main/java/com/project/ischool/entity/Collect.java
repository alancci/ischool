package com.project.ischool.entity;

import java.util.Date;

/**
 * @Description: Collect 类（或接口）是
 * @Author: jiaxing
 * @Date: 2020/4/16 17:23
*/
public class Collect {
	private Integer id;
	private Forum forum;
	private User user;
	private Date createTime;
	
	private Integer userId;
	private Integer forumId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getForumId() {
		return forumId;
	}
	public void setForumId(Integer forumId) {
		this.forumId = forumId;
	}
	
}
