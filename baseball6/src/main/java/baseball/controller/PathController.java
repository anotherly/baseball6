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
	      System.out.println("����ð� - "+currentTime);
	      //���� ��¥
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
	      
	      
	      String today = y+"�� "+M+"�� "+d+"��";
	      String yesterday = y+"�� "+M+"�� "+dd+"��";
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

	@ModelAttribute("data") // data ��� �̸����� ���� �ְ���� jsp��
	PathData data(@PathVariable String cate1, @PathVariable String cate2, @PathVariable String service,
			@RequestParam(value="nowPage", required=false, defaultValue="1")Integer page,
			MemberVo memberVo, 
			TicketVo ticketVo, 
			BoardVo boardVo, 
			TeamVo teamVo, 
			MailVo mailVo,
			HomeVo homeVo,
			HttpServletRequest request) {
		
		System.out.println("@@@@@@@@@@@@@@@@�н���Ʈ�ѷ� �ʱ�����");
		System.out.println("���� ���� data : "+data);
		System.out.println("���� ���� getDd : " + data.getDd());
		System.out.println("���� ���� getDd2 : " + data.getDd2());
		System.out.println("���� ���� homevo�� : " + homeVo);

		data.setRedirect(false);

		ArrayList<Object> vos = new ArrayList<>(); /// bean���� ����

		vos.add(homeVo);
		vos.add(teamVo);
		vos.add(memberVo);
		vos.add(ticketVo);
		vos.add(boardVo);
		vos.add(mailVo);
		for (Object obj : vos) {
			System.out.println("vos �׽�Ʈ ������ obj�� : "+obj);
			
		}
		ArrayList<Object> home = new ArrayList<>(); /// bean���� ����
		home.add(homeVo);
//		home.add(memberVo);
//		home.add(boardVo);
//		vos.add(teamVo);

		// System.out.println("�迭 �ְ� �� ���vo�� : "+MemberVo);

		data.setCate1(cate1);
		data.setCate2(cate2);
		data.setService(service);
		data.setRequest(request);
		data.setNowPage(page);

		// System.out.println("�н���Ʈ�ѷ��� data - " + data);

		String voName;
		// ó�� Ȩ ȭ���϶� ������ �ҷ��´�

		if (cate1.equals("home"))  {
			System.out.println("��Ʈ�ѷ����� Ȩ ������ ��?");
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
				/// ������ data �� ����
			}
			// �α��� ȸ�����Խ� ������̳� �����ڰ��� �ҷ��´�
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
					System.out.println("���������� �ֱ���  ����Ÿ : " + data.getDd());
					System.out.println("������ �ֱ��� ���vo�� : " + memberVo);
					data.setDd(obj);
					System.out.println("���������� �ְ� ���� ����Ÿ : " + data.getDd());
					System.out.println("������ �ְ��� ���vo�� : " + memberVo);
				}
			}
		} else if (cate1.equals("join")) {
			voName = "baseball.member.model.MemberVo";
			for (Object obj : vos) {
				if (obj.getClass().getName().equals(voName)) {
					System.out.println("���������� �ֱ���  ����Ÿ : " + data.getDd());
					System.out.println("������ �ֱ��� ���vo�� : " + memberVo);
					data.setDd(obj);
					System.out.println("���������� �ְ� ���� ����Ÿ : " + data.getDd());
					System.out.println("������ �ְ��� ���vo�� : " + memberVo);
				}
			}
			cate1 = "member";
	/////////////////////////////////////////////////////////		
		} else if (service.contains("mail")){
			voName = "baseball.mail.model.MailVo";
			for (Object obj : vos) {
				if (obj.getClass().getName().equals(voName)) {
					System.out.println("���������� �ֱ���  ����Ÿ : " + data.getDd());
					data.setDd(obj);
					System.out.println("���������� �ְ� ���� ����Ÿ : " + data.getDd());
				}
			}
			cate1 = "mail";
	////////////////////////////////////////////////////////////		
		} else {
			voName = "baseball." + cate1 + ".model." + cate1.substring(0, 1).toUpperCase() + cate1.substring(1) + "Vo";
			System.out.println("voName �� : " + voName);
			for (Object obj : vos) {
				if (obj.getClass().getName().equals(voName)) {
					System.out.println("���������� �ֱ���  ����Ÿ : " + data.getDd());
					System.out.println("������ �ֱ��� ���vo�� : " + homeVo);
					data.setDd(obj);
					System.out.println("���������� �ְ� ���� ����Ÿ : " + data.getDd());
					System.out.println("������ �ְ��� ���vo�� : " + homeVo);
				}
			}
		}
		System.out.println("��Ʈ�ѷ����� �Ŵ��� �϶� cate1 : " + cate1);
		//// mainData
		SubControll control = provider.getContext().getBean(cate1, SubControll.class);
		//// SubCotroll �� getBean ���� ������
		control.execute();
		/// �����Ŵ
		System.out.println("----------------------------------------");
		System.out.println("�׽�ťƮ �ϰ��� ���vo�� : " + homeVo);
		System.out.println("�������� ��Dd �� �� :" + data.getDd());
		System.out.println("�н��������� dd - " + data);
		System.out.println("��Ʈ�ηѷ��� ����Ÿ �޼ҵ� ����");

		menu();
		return data;

	}// pathData data

	void menu() {
		new SameMenu(data);

		HashMap<String, ArrayList<Menu>> subMenu = new HashMap<>();
		subMenu.put("board", new ArrayList<>());
		subMenu.put("member", new ArrayList<>());
		// subMenu.put("ticket", new ArrayList<>());

		subMenu.get("member").add(new Menu("reserve", "���� ��Ȳ", "reservedList"));
		subMenu.get("member").add(new Menu("membermail", "������", "mailList"));
		subMenu.get("member").add(new Menu("membermail", "�����ϱ�", "mailInsert"));

		subMenu.get("board").add(new Menu("boardinfo", "��������", "list"));
		subMenu.get("board").add(new Menu("boardfree", "�����Խ���", "list"));
		subMenu.get("board").add(new Menu("boardqna", "������ �亯", "list"));
		subMenu.get("board").add(new Menu("boardfnq", "���ֹ�������", "list"));

		data.setSubMenu(subMenu.get(data.getCate1()));

	}

	// ���⼭ jsp�� ������
	@RequestMapping
	String mapping() {
		System.out.println("��Ʈ�ѷ��� ����");
		String res = "pathInfo/template";
		if (data.isRedirect()) { //// redirect�� ���� redirect or forward ����
			System.out.println("��Ʈ�ѷ��� �����̷�Ʈ if�� ����");
			res = data.getPath();
		}

		return res;
	}

}
