package com.hidays.homepage;

import java.util.List;
import java.util.Map;

public class UserInfoVO {
	
	private String userName;
	private String userEmail;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public UserInfoVO getJsonToData(List<Map<String, Object>> list) {
		
		for(Map<String, Object> m : list) {	
			
			if ("userName".equals(m.get("name"))) {
				this.setUserName(m.get("value").toString());
			}
			
			if ("userEmail".equals(m.get("name"))) {
				this.setUserEmail(m.get("value").toString());
			}

		}
		
		return this;		
	}

}
