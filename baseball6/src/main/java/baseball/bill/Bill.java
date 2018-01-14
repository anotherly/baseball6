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
		System.out.println("�� Ŭ���� ���Լ���:" + data);
		System.out.println("�� Ŭ���� ���Խ� getDd2:" + data.getDd2());
		System.out.println("�� Ŭ���� ���Խ� �˻����� sch:" + sch);
		sch = (BillSch) data.getDd2();
		System.out.println("�ٵ��4 �ް� �˻����� sch:" + sch);
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
			 System.out.println("����Ʈ �ս� ���̽� ���Լ���");
			 listMonth(sch);
		 break;
		
		 case "listYear":
			 System.out.println("����Ʈ �̾� ���̽� ���Լ���");
			 listYear(sch);
		 break;
		 
		 case "depositListDay":
			 listDay(sch);
			 break;
			 
		 case "depositListMonth":
			 System.out.println("����Ʈ �ս� ���̽� ���Լ���");
			 listMonth(sch);
			 break;
			 
		 case "depositListYear":
			 System.out.println("����Ʈ �̾� ���̽� ���Լ���");
			 listYear(sch);
			 break;
			 
		 case "withdrawListDay":
			 listDay(sch);
			 break;
			 
		 case "withdrawListMonth":
			 System.out.println("����Ʈ �ս� ���̽� ���Լ���");
			 listMonth(sch);
			 break;
			 
		 case "withdrawListYear":
			 System.out.println("����Ʈ �̾� ���̽� ���Լ���");
			 listYear(sch);
			 break;
			 
		 case "weListDay":
			 listDay(sch);
			 break;
			 
		 case "weListMonth":
			 System.out.println("����Ʈ �ս� ���̽� ���Լ���");
			 listMonth(sch);
			 break;
			 
		 case "weListYear":
			 System.out.println("����Ʈ �̾� ���̽� ���Լ���");
			 listYear(sch);
			 break;

		}
	}



	void list(@ModelAttribute("sch") BillSch sch) {
//		System.out.println("����Ʈ �޼ҵ忡�� ����ġ : " + sch);
//		System.out.println("getdd : " + data.getDd());
//		System.out.println("ó������ �̰� ���ϰ��� sch.getlist() : " + sch.getList());

	}

	void listDay(@ModelAttribute("sch") BillSch sch) {
		System.out.println("getdd : " + data.getDd());
		if (sch.getList().get(0).getSteam().equals("ALL")) {// ��ü ���� ���� Ư�� ��¥��ȸ�� �ϰ�ʹٸ�
			System.out.println("������ ----������ ���� all�϶� : Ư�� �Ⱓ�� ��ü ���� ��ȸ");
			data.setDd(dao.teamAllDaySch(sch.getList()));
		} else {// Ư�� �Ⱓ�� ���� Ư�� ������ ��ȸ�� ��
			System.out.println("������ --- Ư�� �Ⱓ�� ���� Ư�� ������ ��ȸ�� ��");
			data.setDd(dao.dTeamSch(sch.getList()));
		}
	}

	private void listMonth(@ModelAttribute("sch") BillSch sch) {
		System.out.println("getdd : " + data.getDd());
		if (sch.getList().get(0).getSteam().equals("ALL")) {// ��ü ���� ���� Ư�� ��¥��ȸ�� �ϰ�ʹٸ�
			System.out.println("������ ----������ ���� all�϶� : Ư�� �Ⱓ�� ��ü ���� ��ȸ");
			data.setDd(dao.teamAllMonthSch(sch.getList()));
		} else {// Ư�� �Ⱓ�� ���� Ư�� ������ ��ȸ�� ��
			System.out.println("������ --- Ư�� �Ⱓ�� ���� Ư�� ������ ��ȸ�� ��");
			data.setDd(dao.dTeamMonthSch(sch.getList()));
		}
	}

	private void listYear(@ModelAttribute("sch") BillSch sch) {
		System.out.println("getdd : " + data.getDd());
		if (sch.getList().get(0).getSteam().equals("ALL")) {// ��ü ���� ���� Ư�� ��¥��ȸ�� �ϰ�ʹٸ�
			System.out.println("������ ----������ ���� all�϶� : Ư�� �Ⱓ�� ��ü ���� ��ȸ");
			data.setDd(dao.teamAllYearSch(sch.getList()));
		} else {// Ư�� �Ⱓ�� ���� Ư�� ������ ��ȸ�� ��
			System.out.println("������ --- Ư�� �Ⱓ�� ���� Ư�� ������ ��ȸ�� ��");
			data.setDd(dao.dTeamYearSch(sch.getList()));
		}
	}
}
