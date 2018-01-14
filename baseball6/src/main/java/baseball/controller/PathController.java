package baseball.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import baseball.board.model.BoardVo;
import baseball.home.model.HomeVo;
import baseball.mail.model.MailVo;
import baseball.member.model.MemberVo;
import baseball.model.Menu;
import baseball.model.PathData;
import baseball.model.SameMenu;
import baseball.team.model.TeamVo;
import baseball.ticket.model.TicketVo;

@Controller
@RequestMapping("pathInfo/{cate1}/{cate2}/{service}")
public class PathController {

	@Resource
	MyProvider provider;

	@Resource
	PathData data;
	
	
	@ModelAttribute("ticketOk")
	   public ArrayList ticketOk() {// HttpServletRequest request

	      SimpleDateFormat ySimpleDateFormat = new SimpleDateFormat("yyyy");
	      SimpleDateFormat MSimpleDateFormat = new SimpleDateFormat("MM");
	      SimpleDateFormat dSimpleDateFormat = new SimpleDateFormat("dd");
	      //SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("dd");
	      Date currentTime = new Date();
	      System.out.println("현재시각 - "+currentTime);
	      //오늘 날짜
	      String yTime = ySimpleDateFormat.format(currentTime);
	      String MTime = MSimpleDateFormat.format(currentTime);
	      String dTime = dSimpleDateFormat.format(currentTime);
	      
	      System.out.println("yTime - "+yTime);
	      System.out.println("MTime - "+MTime);
	      System.out.println("dTime - "+dTime);
	      
	      String y = yTime.toString();
	      String M = MTime.toString();
	      String d = dTime.toString();
	      
	      int gameResy = Integer.parseInt(y);
	      int gameResM = Integer.parseInt(M);
	      int gameResd = Integer.parseInt(d);
	      int dd = gameResd-1;
	      
	      
	      String today = y+"년 "+M+"월 "+d+"일";
	      String yesterday = y+"년 "+M+"월 "+dd+"일";
	      int onul = gameResy+gameResM+gameResd;
	      int yes = gameResy+gameResM+gameResd-1;
	      
	            
	      ArrayList arr = new ArrayList<>();
	      arr.add(today);
	      arr.add(yesterday);
	      arr.add(onul);
	      arr.add(yes);

	      System.out.println("----------------"+arr);
	      return arr;

	   }

	@ModelAttribute("data") // data 라는 이름으로 값을 주고받음 jsp와
	PathData data(@PathVariable String cate1, @PathVariable String cate2, @PathVariable String service,
			@RequestParam(value="nowPage", required=false, defaultValue="1")Integer page,
			MemberVo memberVo, 
			TicketVo ticketVo, 
			BoardVo boardVo, 
			TeamVo teamVo, 
			MailVo mailVo,
			HomeVo homeVo,
			HttpServletRequest request) {
		
		System.out.println("@@@@@@@@@@@@@@@@패스컨트롤러 초기진입");
		System.out.println("최초 순수 data : "+data);
		System.out.println("최초 순수 getDd : " + data.getDd());
		System.out.println("최초 순수 getDd2 : " + data.getDd2());
		System.out.println("최초 순수 homevo값 : " + homeVo);

		data.setRedirect(false);

		ArrayList<Object> vos = new ArrayList<>(); /// bean들을 받음

		vos.add(homeVo);
		vos.add(teamVo);
		vos.add(memberVo);
		vos.add(ticketVo);
		vos.add(boardVo);
		vos.add(mailVo);
		for (Object obj : vos) {
			System.out.println("vos 테스트 포문의 obj값 : "+obj);
			
		}
		ArrayList<Object> home = new ArrayList<>(); /// bean들을 받음
		home.add(homeVo);
//		home.add(memberVo);
//		home.add(boardVo);
//		vos.add(teamVo);

		// System.out.println("배열 넣고 후 멤버vo값 : "+MemberVo);

		data.setCate1(cate1);
		data.setCate2(cate2);
		data.setService(service);
		data.setRequest(request);
		data.setNowPage(page);

		// System.out.println("패스컨트롤러의 data - " + data);

		String voName;
		// 처음 홈 화면일때 팀값을 불러온다

		if (cate1.equals("home"))  {
			System.out.println("컨트롤러에서 홈 이프문 들어감?");
			voName = "baseball.home.model.HomeVo";
			for (Object homee : home) {
				if (homee.getClass().getName().equals(voName)) {
					data.setDd(homeVo);
					data.setHome1(homee);
					data.setHome2(homee);
					data.setHome3(homee);
					System.out.println("home1 - "+data.getHome1());
					System.out.println("home2 - "+data.getHome1());
					System.out.println("home3 - "+data.getHome1());
					
				}
				/// 맞으면 data 에 넣음
			}
			// 로그인 회원가입시 멤버값이나 관리자값을 불러온다
		} else if (cate1.equals("member") && cate2.equals("reserve")) {
			for (Object obj : vos) {
				if (obj.getClass().getName().equals("baseball.ticket.model.TicketVo")) {
					
						System.out.println("cate1:" + cate1);
						System.out.println("cate2:" + cate2);
						data.setDd(obj);
					
				}
			}
		} else if (cate1.equals("login")) {
			voName = "baseball.member.model.MemberVo";
			for (Object obj : vos) {
				if (obj.getClass().getName().equals(voName)) {
					System.out.println("이프문에서 넣기전  데이타 : " + data.getDd());
					System.out.println("데이터 넣기전 멤버vo값 : " + memberVo);
					data.setDd(obj);
					System.out.println("이프문에서 넣고 나서 데이타 : " + data.getDd());
					System.out.println("데이터 넣고나서 멤버vo값 : " + memberVo);
				}
			}
		} else if (cate1.equals("join")) {
			voName = "baseball.member.model.MemberVo";
			for (Object obj : vos) {
				if (obj.getClass().getName().equals(voName)) {
					System.out.println("이프문에서 넣기전  데이타 : " + data.getDd());
					System.out.println("데이터 넣기전 멤버vo값 : " + memberVo);
					data.setDd(obj);
					System.out.println("이프문에서 넣고 나서 데이타 : " + data.getDd());
					System.out.println("데이터 넣고나서 멤버vo값 : " + memberVo);
				}
			}
			cate1 = "member";
	/////////////////////////////////////////////////////////		
		} else if (service.contains("mail")){
			voName = "baseball.mail.model.MailVo";
			for (Object obj : vos) {
				if (obj.getClass().getName().equals(voName)) {
					System.out.println("이프문에서 넣기전  데이타 : " + data.getDd());
					data.setDd(obj);
					System.out.println("이프문에서 넣고 나서 데이타 : " + data.getDd());
				}
			}
			cate1 = "mail";
	////////////////////////////////////////////////////////////		
		} else {
			voName = "baseball." + cate1 + ".model." + cate1.substring(0, 1).toUpperCase() + cate1.substring(1) + "Vo";
			System.out.println("voName 값 : " + voName);
			for (Object obj : vos) {
				if (obj.getClass().getName().equals(voName)) {
					System.out.println("이프문에서 넣기전  데이타 : " + data.getDd());
					System.out.println("데이터 넣기전 멤버vo값 : " + homeVo);
					data.setDd(obj);
					System.out.println("이프문에서 넣고 나서 데이타 : " + data.getDd());
					System.out.println("데이터 넣고나서 멤버vo값 : " + homeVo);
				}
			}
		}
		System.out.println("컨트롤러에서 매니저 일때 cate1 : " + cate1);
		//// mainData
		SubControll control = provider.getContext().getBean(cate1, SubControll.class);
		//// SubCotroll 을 getBean 으로 가져옴
		control.execute();
		/// 실행시킴
		System.out.println("----------------------------------------");
		System.out.println("액시큐트 하고나서 멤버vo값 : " + homeVo);
		System.out.println("최종적인 겟Dd 의 값 :" + data.getDd());
		System.out.println("패스데이터의 dd - " + data);
		System.out.println("컨트로롤러의 데이타 메소드 나감");

		menu();
		return data;

	}// pathData data

	void menu() {
		new SameMenu(data);

		HashMap<String, ArrayList<Menu>> subMenu = new HashMap<>();
		subMenu.put("board", new ArrayList<>());
		subMenu.put("member", new ArrayList<>());
		// subMenu.put("ticket", new ArrayList<>());

		subMenu.get("member").add(new Menu("reserve", "예매 현황", "reservedList"));
		subMenu.get("member").add(new Menu("membermail", "쪽지함", "mailList"));
		subMenu.get("member").add(new Menu("membermail", "건의하기", "mailInsert"));

		subMenu.get("board").add(new Menu("boardinfo", "공지사항", "list"));
		subMenu.get("board").add(new Menu("boardfree", "자유게시판", "list"));
		subMenu.get("board").add(new Menu("boardqna", "질문과 답변", "list"));
		subMenu.get("board").add(new Menu("boardfnq", "자주뭍는질문", "list"));

		data.setSubMenu(subMenu.get(data.getCate1()));

	}

	// 여기서 jsp로 보내줌
	@RequestMapping
	String mapping() {
		System.out.println("컨트롤러의 매핑");
		String res = "pathInfo/template";
		if (data.isRedirect()) { //// redirect에 따른 redirect or forward 선택
			System.out.println("컨트롤러의 리다이렉트 if문 진입");
			res = data.getPath();
		}

		return res;
	}

}
