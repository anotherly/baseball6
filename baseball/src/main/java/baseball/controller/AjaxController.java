package baseball.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import baseball.member.model.MemberRepository;
import baseball.member.model.MemberVo;
import baseball.model.PathData;
import baseball.model.TicketData;
import baseball.ticket.model.TicketVo;

@Controller
public class AjaxController {
	
	/**
	 * @uml.property  name="dao"
	 * @uml.associationEnd  readOnly="true"
	 */
	
	@Resource
	MemberRepository dao;
	
	@Resource
	PathData data;
	
	@Resource
	MyProvider provider;
	
	@RequestMapping("pathInfo/join/idChk")
	ModelAndView idChk(String userid)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("res",dao.idChk(userid));
		
		return mav;
	}
}
