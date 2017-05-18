package com.hidays.homepage;

import java.util.List;

public interface HomepageDAO {
	
	List<UserInfoVO> getSelectUserInfo();
	UserInfoVO selectUserInfoByKey(String emain);
	int insertUserInfo(UserInfoVO vo);

}
