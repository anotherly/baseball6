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

import baseball.info.model.InfoVo;
import baseball.model.SameMenu;
import baseball.model.Menu;
import baseball.model.PathData;
import baseball.player.model.PlayerStatCareerVo;
import baseball.player.model.PlayerStatVo;
import baseball.player.model.PlayerVo;
import baseball.schedule.model.ScheduleVo;
import baseball.team.model.TeamVo;

@Controller
@RequestMapping("pathInfo/schedule/{cate2}/{service}")
public class ScheduleController {

	@Resource
	MyProvider provider;

	@Resource
	PathData data;

	@ModelAttribute("ticketOk")
	public ArrayList ticketOk() {// HttpServletRequest request

		SimpleDateFormat ySimpleDateFormat = new SimpleDateFormat("yyyy");
		SimpleDateFormat MSimpleDateFormat = new SimpleDateFormat("MM");
		SimpleDateFormat dSimpleDateFormat = new SimpleDateFormat("dd");
		
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
		int tomorrow = gameResy+gameResM+gameResd+1;
		int twodays = gameResy+gameResM+gameResd+2;
		int threedays = gameResy+gameResM+gameResd+3;
		int fourdays = gameResy+gameResM+gameResd+4;
		int fivedays = gameResy+gameResM+gameResd+5;
		int yes = gameResy+gameResM+gameResd-1;
		
				
		ArrayList arr = new ArrayList<>();
		arr.add(onul);//0
		arr.add(tomorrow);//1
		arr.add(twodays);//2
		arr.add(threedays);//3
		arr.add(fourdays);//4
		arr.add(fivedays);//5
		arr.add(today);//6
		arr.add(yesterday);//7
		arr.add(yes);//8

		System.out.println("----------------"+arr);
		return arr;

	}
	

	@ModelAttribute("data")
	PathData data(@PathVariable String cate2, @PathVariable String service, TeamVo TeamVo, PlayerVo PlayerVo,
			ScheduleVo ScheduleVo, PlayerStatVo PlayerStatVo, PlayerStatCareerVo PlayerStatCareerVo, InfoVo InfoVo, /// 각
																													/// 카테고리별
																													/// bean을
																													/// 가져옴////메인메뉴에
																													/// 들어올넘들에쓰일vo
			HttpServletRequest request) {
		data.setRedirect(false);

		ArrayList vos = new ArrayList<>(); /// bean들을 받음

		vos.add(PlayerVo);
		vos.add(InfoVo);
		vos.add(PlayerStatCareerVo);

		vos.add(ScheduleVo);
		vos.add(PlayerStatVo);
		// vos.add(TeamVo);// !!!!!!!!!홈은 무조건 젤 마지막으로!!!!!!!!!!!!
		// -------------------------------------------------------------------vos2
		System.out.println("vos1--------" + vos);
		ArrayList vos2 = new ArrayList<>();

		// vos2.add(PlayerVo);
		// vos2.add(InfoVo);
		// vos2.add(PlayerStatCareerVo);

		vos2.add(ScheduleVo);
		vos2.add(PlayerStatVo);
		System.out.println("vos2--------" + vos2);
		ArrayList vos3 = new ArrayList<>();

		// vos2.add(PlayerVo);
		// vos2.add(InfoVo);
		// vos2.add(PlayerStatCareerVo);

		vos3.add(ScheduleVo);
		vos3.add(PlayerStatVo);
		System.out.println("vos3--------" + vos3);

		data.setCate1("schedule");
		data.setCate2(cate2);
		data.setService(service);

		data.setCate1Temp("schedule");
		data.setServiceTemp(service);

		data.setRequest(request);
		System.out.println("스케줄Controller의 data - " + data);
		menu();
		String voName;
		/*
		 * if (cate1.equals("home")) { voName = "baseball.team.model.TeamVo"; for
		 * (Object obj : vos) {
		 * 
		 * data.setDd(obj); /// 맞으면 data 에 넣음 System.out.println("@@@@@@@@@@@@@" + //
		 * data.getDd());
		 * 
		 * } }
		 */

		/*if (
			 * service.equals("gameRegisterDetail") || service.equals("gameRegisterDetail2")
			 * ||
			 

		service.equals("detailTodayStat") || service.equals("todayRegister") || service.equals("viewTodayStat")) {

			voName = "baseball.player.model.PlayerStatVo";
			for (Object obj : vos2) {

				data.setDd(obj);
				data.setDd2(obj); /// 맞으면 data 에 넣음
				data.setDd3(obj);
				System.out.println("@@@@@@@@@@@@@1" + data.getDd2());

			}
		}*/

		/*
		 * else if (service.equals("gameRegisterView")) { voName =
		 * "baseball.player.model.PlayerStatVo"; for (Object obj2 : vos) {
		 * 
		 * // data.setDd(obj); data.setDd2(obj2); /// 맞으면 data 에 넣음
		 * System.out.println("@@@@@@@@@@@@@1" + data.getDd2()); } }
		 *///else {
			voName = "baseball." + "schedule" + ".model." + "Schedule" + "Vo";
			// vo로가는길
			//// 현재 페이지에 필요한 bean 클래스명을 만듬 //실제 주소는 cate1+service //vo는 항상 모델패키지 안에 있어야
			// 함!!!!!!!
			System.out.println("voName - " + voName);
			for (Object obj : vos) {
				if (obj.getClass().getName().equals(voName)) {
					//// bean의 클래스 이름과 현재 페이지에 필요한 bean 클래스이름과 비교

					data.setDd(obj);

					System.out.println("@@@@@@@@@@@@@2" + data.getDd2());
					// data.setDd2(obj);
					/// 맞으면 data 에 넣음
				}
			}
			for (Object obj2 : vos2) {
				if (obj2.getClass().getName().equals("baseball.player.model.PlayerStatVo")) {
					//// bean의 클래스 이름과 현재 페이지에 필요한 bean 클래스이름과 비교

					data.setDd2(obj2);
					data.setDd3(obj2);
					System.out.println("@@@@@@@@@@@@@2" + data.getDd2());
					// data.setDd2(obj);
					/// 맞으면 data 에 넣음
				}

			
		}

		System.out.println("최종경로" + voName);
		System.out.println("패스데이터의 dd - " + data);

		//// mainData

		SubControll control = provider.getContext().getBean("schedule", SubControll.class);
		//// SubCotroll 을 getBean 으로 가져옴
		control.execute();
		/// 실행시킴
		System.out.println("실행하냐??????" + data);
		return data;

	}

	void menu() {
		new SameMenu(data);

		HashMap<String, ArrayList<Menu>> subMenu = new HashMap<>();
		subMenu.put("schedule", new ArrayList<>());

		subMenu.get("schedule").add(new Menu("schedule", "시즌일정", "list?year=2018&month=3"));
		subMenu.get("schedule").add(new Menu("schedule", "팀별일정", "teamList?year=2018&month=3"));
		subMenu.get("schedule").add(new Menu("schedule", "경기일정등록", "gameRegister"));
		// subMenu.get("schedule").add(new Menu("seasonSchedule", "경기정보입력",
		// "gameInfoRegister"));

		HashMap<String, ArrayList<Menu>> subMenu2 = new HashMap<>();
		subMenu2.put("schedule", new ArrayList<>());

		data.setSubMenu(subMenu.get(data.getCate1()));
		data.setSubMenu2(subMenu2.get(data.getCate1()));
	}

	@RequestMapping
	String mapping() {

		String res = "pathInfo/template2";
		if (data.isRedirect()) { //// redirect에 따른 redirect or forward 선택
			res = data.getPath();
		}

		return res;
	}

}
