package baseball.bill;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import baseball.bill.model.BillDao;
import baseball.bill.model.BillSch;
import baseball.bill.model.BillVo;
import baseball.controller.SubControll;
import baseball.model.PathData;

@Service
public class Bill implements SubControll {

	@Resource
	PathData data;

	@Resource
	BillDao dao;

	BillVo vo;

	BillSch sch;
	// String y1, m1, d1, y2, m2, d2;

	@Override
	public void execute() {
		System.out.println("-----------------------------------------");
		System.out.println("빌 클래스 진입성공:" + data);
		System.out.println("빌 클래스 진입시 getDd2:" + data.getDd2());
		System.out.println("빌 클래스 진입시 검색조건 sch:" + sch);
		sch = (BillSch) data.getDd2();
		System.out.println("겟디디4 받고 검색조건 sch:" + sch);
		vo = (BillVo) data.getDd();
		// System.out.println(y1);
		// if(y1!=null&&!(y1.equals(null))) {
		// y1 = Integer.toString(sch.getYear());
		// System.out.println("y1 : "+y1);
		// }else {
		// y1 = "0";
		// }
		// if(m1!=null) {
		// m1 = Integer.toString(sch.getMonth());
		// System.out.println("m1 : "+m1);
		// }else {
		// m1 = "0";
		// }
		// if(d1!=null){
		// d1 = Integer.toString(sch.getDay());
		// System.out.println("d1 : "+d1);
		// }else {
		// d1 = "0";
		// }
		// if(y2!=null) {
		// y2 = Integer.toString(sch.getYear2());
		// System.out.println("y2 : "+y2);
		// }else {
		// y2 = "0";
		// }
		// if(m2!=null) {
		// m2 = Integer.toString(sch.getMonth2());
		// System.out.println("m2 : "+m2);
		// }else {
		// m2 = "0";
		// }
		// if(d2!=null) {
		// d2 = Integer.toString(sch.getDay2());
		// System.out.println("d2 : "+d2);
		// }else {
		// d2 = "0";
		// }
		// if() {
		//
		// }

		switch (data.getService()) {
//		case "list":
//			list(sch);
//			break;

		 case "listDay":
			listDay(sch);
			break;

		 case "listMonth":
			 System.out.println("리스트 먼스 케이스 진입성공");
			 listMonth(sch);
		 break;
		
		 case "listYear":
			 System.out.println("리스트 이어 케이스 진입성공");
			 listYear(sch);
		 break;
		 
		 case "depositListDay":
			 listDay(sch);
			 break;
			 
		 case "depositListMonth":
			 System.out.println("리스트 먼스 케이스 진입성공");
			 listMonth(sch);
			 break;
			 
		 case "depositListYear":
			 System.out.println("리스트 이어 케이스 진입성공");
			 listYear(sch);
			 break;
			 
		 case "withdrawListDay":
			 listDay(sch);
			 break;
			 
		 case "withdrawListMonth":
			 System.out.println("리스트 먼스 케이스 진입성공");
			 listMonth(sch);
			 break;
			 
		 case "withdrawListYear":
			 System.out.println("리스트 이어 케이스 진입성공");
			 listYear(sch);
			 break;
			 
		 case "weListDay":
			 listDay(sch);
			 break;
			 
		 case "weListMonth":
			 System.out.println("리스트 먼스 케이스 진입성공");
			 listMonth(sch);
			 break;
			 
		 case "weListYear":
			 System.out.println("리스트 이어 케이스 진입성공");
			 listYear(sch);
			 break;

		}
	}



	void list(@ModelAttribute("sch") BillSch sch) {
//		System.out.println("리스트 메소드에서 빌서치 : " + sch);
//		System.out.println("getdd : " + data.getDd());
//		System.out.println("처음에는 이게 널일것임 sch.getlist() : " + sch.getList());

	}

	void listDay(@ModelAttribute("sch") BillSch sch) {
		System.out.println("getdd : " + data.getDd());
		if (sch.getList().get(0).getSteam().equals("ALL")) {// 전체 팀에 대한 특정 날짜조회를 하고싶다면
			System.out.println("이프문 ----선택한 팀이 all일때 : 특정 기간에 전체 구장 조회");
			data.setDd(dao.teamAllDaySch(sch.getList()));
		} else {// 특정 기간에 대한 특정 구장을 조회할 떼
			System.out.println("엘스문 --- 특정 기간에 대한 특정 구장을 조회할 떼");
			data.setDd(dao.dTeamSch(sch.getList()));
		}
	}

	private void listMonth(@ModelAttribute("sch") BillSch sch) {
		System.out.println("getdd : " + data.getDd());
		if (sch.getList().get(0).getSteam().equals("ALL")) {// 전체 팀에 대한 특정 날짜조회를 하고싶다면
			System.out.println("이프문 ----선택한 팀이 all일때 : 특정 기간에 전체 구장 조회");
			data.setDd(dao.teamAllMonthSch(sch.getList()));
		} else {// 특정 기간에 대한 특정 구장을 조회할 떼
			System.out.println("엘스문 --- 특정 기간에 대한 특정 구장을 조회할 떼");
			data.setDd(dao.dTeamMonthSch(sch.getList()));
		}
	}

	private void listYear(@ModelAttribute("sch") BillSch sch) {
		System.out.println("getdd : " + data.getDd());
		if (sch.getList().get(0).getSteam().equals("ALL")) {// 전체 팀에 대한 특정 날짜조회를 하고싶다면
			System.out.println("이프문 ----선택한 팀이 all일때 : 특정 기간에 전체 구장 조회");
			data.setDd(dao.teamAllYearSch(sch.getList()));
		} else {// 특정 기간에 대한 특정 구장을 조회할 떼
			System.out.println("엘스문 --- 특정 기간에 대한 특정 구장을 조회할 떼");
			data.setDd(dao.dTeamYearSch(sch.getList()));
		}
	}
}
