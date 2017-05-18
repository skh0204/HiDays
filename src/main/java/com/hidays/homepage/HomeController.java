package com.hidays.homepage;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@Autowired 
	SessionLocaleResolver localeResolver; 

	@Autowired 
	MessageSource messageSource;
	
	//@Resource(name = "hpService")
	@Autowired
	private HomepageService hpService;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, HttpServletRequest req, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		// localeResolver 로부터 Locale 을 출력해 봅니다. 
		logger.info("Session locale is {}.", localeResolver.resolveLocale(req));
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/emailRegist.do", method = RequestMethod.POST)
	public RtnVO ajaxEmailRegist(Locale locale, @RequestBody List<Map<String, Object>> list) throws Exception {
		
		UserInfoVO vo = new UserInfoVO();		
		vo = vo.getJsonToData(list);
		
		RtnVO rtnVo = new RtnVO("S", messageSource.getMessage("alert.success.regist", null, locale));
		
		try {
			hpService.insertUserInfo(vo);
		} catch (DuplicateKeyException e) {
			rtnVo.setData("F", messageSource.getMessage("alert.fail.email.duplicate", null, locale));
		} catch (Exception e1) {
			rtnVo.setData("F", messageSource.getMessage("alert.fail.default", null, locale));
		}
		
		return rtnVo;
	}
	
	@ResponseBody
	@RequestMapping(value = "/test.do", method = RequestMethod.POST)
	public RtnVO ajaxTest(@ModelAttribute("frmReg") UserInfoVO vo) throws Exception {
		
		System.out.println(">>>>> vo : " + vo);
		
		System.out.println(">>>>> userName : " + vo.getUserName());
		System.out.println(">>>>> userEmail : " + vo.getUserEmail());
		
		RtnVO rtnVo = new RtnVO("S", "등록 되었습니다.");
		
		return rtnVo;
	}
	
	
}
