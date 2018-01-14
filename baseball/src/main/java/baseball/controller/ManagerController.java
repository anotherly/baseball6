package baseball.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import baseball.bill.model.BillDao;
import baseball.bill.model.BillSch;
import baseball.bill.model.BillVo;
import baseball.board.model.BoardVo;
import baseball.mail.model.MailVo;
import baseball.member.model.MemberVo;
import baseball.model.SameMenu;
import baseball.model.Menu;
import baseball.model.PathData;
import baseball.team.model.TeamVo;
import baseball.ticket.model.TicketVo;

@Controller
@RequestMapping("pathInfo/manager/{cate2}/{service}")
public class ManagerController {

	@Resource
	MyProvider provider;

	@Resource
	PathData data;

	@ModelAttribute("yearArr")
	ArrayList<String[]> yearArr() {
		System.out.println("��Ʈ�ѷ� yearArr ����");
		ArrayList<String[]> res = new ArrayList<>();
		for (int i = 2018; i >= 2016; i--) {
			res.add(new String[] { "year", Integer.toString(i) });
		}
		return res;
	}

	@ModelAttribute("monthArr")
	ArrayList<String[]> monthArr() {
		System.out.println("��Ʈ�ѷ� monthArr ����");
		ArrayList<String[]> res = new ArrayList<>();
		for (int i = 1; i <= 12; i++) {
			res.add(new String[] { "month", Integer.toString(i) });
		}
		return res;
	}

	@ModelAttribute("dayArr")
	ArrayList<String[]> dayArr() {
		ArrayList<String[]> res = new ArrayList<>();
		System.out.println("��Ʈ�ѷ� dayArr ����");
		for (int i = 1; i <= 31; i++) {
			res.add(new String[] { "day", Integer.toString(i) });
		}

		return res;
	}

	@ModelAttribute("steamArr")
	ArrayList<String[]> steamArr() {
		ArrayList<String[]> res = new ArrayList<>();
		System.out.println("��Ʈ�ѷ� teamArr ����");

		res.add(new String[] { "steam", "ALL" });
		res.add(new String[] { "steam", "kia" });
		res.add(new String[] { "steam", "doosan" });
		res.add(new String[] { "steam", "lotte" });
		res.add(new String[] { "steam", "nc" });
		res.add(new String[] { "steam", "sk" });
		res.add(new String[] { "steam", "lg" });
		res.add(new String[] { "steam", "hanhwa" });
		res.add(new String[] { "steam", "samsung" });
		res.add(new String[] { "steam", "kt" });
		res.add(new String[] { "steam", "nexen" });

		return res;
	}

	// @RequestMapping("pathInfo/manager/bill/list")

	@ModelAttribute("data") // data ��� �̸����� ���� �ְ���� jsp��
	PathData data(@PathVariable String cate2, @PathVariable String service, 
			MemberVo memberVo, 
			MailVo mailVo,
			TicketVo ticketVo,
			BoardVo boardVo, 
			TeamVo teamVo, 
			BillVo billVo, 
			BillSch sch, 
			HttpServletRequest request) {
		System.out.println("@@@@@@@@@@@@@@@@�Ŵ�����Ʈ�ѷ��� ����Ÿ �޼ҵ� �ʱ�����");
		System.out.println("����ġ ���ʰ� : " + sch);
		System.out.println("���� ���� ����Ÿ : " + data.getDd());
		System.out.println("�迭 �ֱ��� ���vo�� : " + memberVo);

		data.setRedirect(false);

		ArrayList vos = new ArrayList<>(); /// bean���� ����
		vos.add(teamVo);
		vos.add(memberVo);
		vos.add(ticketVo);
		vos.add(boardVo);
		vos.add(billVo);
		vos.add(mailVo);

		ArrayList<Object> vos2 = new ArrayList<>(); /// bean���� ����
		vos2.add(sch);
		vos2.add(mailVo);

		data.setCate1("manager");
		data.setCate2(cate2);
		data.setService(service);
		data.setRequest(request);

		// System.out.println("�н���Ʈ�ѷ��� data - " + data);

		String voName = "baseball." + cate2 + ".model." + cate2.substring(0, 1).toUpperCase() + cate2.substring(1)
				+ "Vo";
		System.out.println("��Ʈ�ѷ����� �Ŵ��� �϶� cate2 : " + cate2);
		System.out.println("voName �� : " + voName);
		// ó�� Ȩ ȭ���϶� ������ �ҷ��´�
		if (cate2.equals("bill")) {
			for (Object obj : vos) {
				if (obj.getClass().getName().equals(voName)) {
					data.setDd(obj);

				}
			}
			for (Object obj2 : vos2) {
				voName = "baseball.bill.model.BillSch";
				if (obj2.getClass().getName().equals(voName)) {
					data.setDd2(obj2);
				}
			}

			/////////////////////////////////////////////////////////
		} else if (service.contains("mail")) {
			voName = "baseball.mail.model.MailVo";
			for (Object obj : vos) {
				if (obj.getClass().getName().equals(voName)) {
					System.out.println("���������� �ֱ���  ����Ÿ : " + data.getDd());
					data.setDd(obj);
					System.out.println("���������� �ְ� ���� ����Ÿ : " + data.getDd());
				}
			}
			cate2 = "mail";
			/////////////////////////////////////////////////////////
		} else {
			System.out.println("�Ŵ��� ��Ʈ�ѷ� ������");
			for (Object obj : vos) {
				System.out.println("������ ���� �� obj�� : " + obj);
				if (obj.getClass().getName().equals(voName)) {
					System.out.println("obj�� : " + obj);
					data.setDd(obj);
				}
			}
		}

		System.out.println("��Ʈ�ѷ����� �Ŵ��� �϶� cate2 : " + cate2);
		//// mainData
		SubControll control = provider.getContext().getBean(cate2, SubControll.class);
		//// SubCotroll �� getBean ���� ������
		control.execute();
		/// �����Ŵ
		System.out.println("----------------------------------------");
		System.out.println("�׽�ťƮ �ϰ��� ��vo�� : " + billVo);
		System.out.println("�׽�ťƮ �ϰ��� ���vo�� : " + memberVo);
		System.out.println("�������� ��Dd1 �� �� :" + data.getDd());

		System.out.println("����ī��2 : " + cate2);
		System.out.println("���� service : " + service);
		System.out.println("�н��������� dd - " + data);
		System.out.println("��Ʈ�ηѷ��� ����Ÿ �޼ҵ� ����");

		menu();

		return data;

	}// pathData data

	void menu() {
		new SameMenu(data);

		// -------------------------�����鼭��޴������������--------------------------
		HashMap<String, ArrayList<Menu>> subMenu = new HashMap<>();

		subMenu.put("team", new ArrayList<>());
		subMenu.put("member", new ArrayList<>());
		subMenu.put("ticket", new ArrayList<>());
		subMenu.put("bill", new ArrayList<>());

		/////////////////////// ������ �޴� ////////////////////////////////////////

		subMenu.get("team").add(new Menu("team", "���� ����Ʈ", "list"));
		
		subMenu.get("member").add(new Menu("member", "ȸ�� ���", "list"));
		subMenu.get("member").add(new Menu("member", "������Ʈ ����", "blackList"));
		subMenu.get("member").add(new Menu("member", "������", "mailList"));

		subMenu.get("bill").add(new Menu("bill", "�ϰ� ��ȸ", "list"));
		subMenu.get("bill").add(new Menu("bill", "���� ��ȸ", "depositList"));
		subMenu.get("bill").add(new Menu("bill", "���� ��ȸ", "withdrawList"));
		subMenu.get("bill").add(new Menu("bill", "������ ��ȸ", "weList"));

		data.setSubMenu(subMenu.get(data.getCate2()));
	}

	// ���⼭ jsp�� ������
	@RequestMapping
	String mapping() {
		System.out.println("��Ʈ�ѷ��� ����");
		String res = "pathInfo/template3";
		if (data.isRedirect()) { //// redirect�� ���� redirect or forward ����
			System.out.println("�Ŵ�����Ʈ�ѷ��� �����̷�Ʈ if�� ����");
			res = data.getPath();
		}

		return res;
	}

}
