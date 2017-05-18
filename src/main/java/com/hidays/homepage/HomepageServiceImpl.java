package com.hidays.homepage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomepageServiceImpl implements HomepageService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomepageServiceImpl.class);
	
	//@Resource(name = "hpDao")
	@Autowired
	private HomepageDAO hpDao;

	@Override
	public int insertUserInfo(UserInfoVO vo) throws Exception {
		LOGGER.debug(vo.toString());
		
		return hpDao.insertUserInfo(vo);
	}

}
