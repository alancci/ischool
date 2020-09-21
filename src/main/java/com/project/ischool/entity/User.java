package com.project.ischool.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @desc 用户实体类
 * @author  alancci
 * @date   2020/9/18 15:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private Integer userId;
	private String realName;
	private String userName;
	private Integer sex;
	private String phone;
	private Date birthday;
	private String email;
	private String headerImage;
	private String question;
	private String answer;
	private String userCategory;
	private Integer userLevel;
	private String password;
	private Integer isEffected;
	private Integer isEnabled;
	private String remark;
	private Date createTime;
	private List<Role> role;

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIsEffected() {
        return isEffected;
    }

    public void setIsEffected(Integer isEffected) {
        this.isEffected = isEffected;
    }

    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHeaderImage() {
		return headerImage;
	}
	public void setHeaderImage(String headerImage) {
		this.headerImage = headerImage;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getUserCategory() {
		return userCategory;
	}
	public void setUserCategory(String userCategory) {
		this.userCategory = userCategory;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", realName='" + realName + '\'' +
				", userName='" + userName + '\'' +
				", sex=" + sex +
				", phone='" + phone + '\'' +
				", birthday=" + birthday +
				", email='" + email + '\'' +
				", headerImage='" + headerImage + '\'' +
				", question='" + question + '\'' +
				", answer='" + answer + '\'' +
				", userCategory='" + userCategory + '\'' +
				", userLevel=" + userLevel +
				", password='" + password + '\'' +
				", isEffected=" + isEffected +
				", isEnabled=" + isEnabled +
				", remark='" + remark + '\'' +
				", createTime=" + createTime +
				", role=" + role +
				'}';
	}
}
