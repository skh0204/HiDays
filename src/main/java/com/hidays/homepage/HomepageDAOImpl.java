package com.hidays.homepage;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomepageDAOImpl implements HomepageDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<UserInfoVO> getSelectUserInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfoVO selectUserInfoByKey(String emain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertUserInfo(UserInfoVO vo) {
		return sqlSession.insert("dao.userinfoMapper.insertUserInfo", vo);
	}

}
