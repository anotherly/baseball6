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
			ScheduleVo ScheduleVo, PlayerStatVo PlayerStatVo, PlayerStatCareerVo PlayerStatCareerVo, InfoVo InfoVo, /// ��
																													/// ī�װ���
																													/// bean��
																													/// ������////���θ޴���
																													/// ���óѵ鿡����vo
			HttpServletRequest request) {
		data.setRedirect(false);

		ArrayList vos = new ArrayList<>(); /// bean���� ����

		vos.add(PlayerVo);
		vos.add(InfoVo);
		vos.add(PlayerStatCareerVo);

		vos.add(ScheduleVo);
		vos.add(PlayerStatVo);
		// vos.add(TeamVo);// !!!!!!!!!Ȩ�� ������ �� ����������!!!!!!!!!!!!
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
		System.out.println("������Controller�� data - " + data);
		menu();
		String voName;
		/*
		 * if (cate1.equals("home")) { voName = "baseball.team.model.TeamVo"; for
		 * (Object obj : vos) {
		 * 
		 * data.setDd(obj); /// ������ data �� ���� System.out.println("@@@@@@@@@@@@@" + //
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
				data.setDd2(obj); /// ������ data �� ����
				data.setDd3(obj);
				System.out.println("@@@@@@@@@@@@@1" + data.getDd2());

			}
		}*/

		/*
		 * else if (service.equals("gameRegisterView")) { voName =
		 * "baseball.player.model.PlayerStatVo"; for (Object obj2 : vos) {
		 * 
		 * // data.setDd(obj); data.setDd2(obj2); /// ������ data �� ����
		 * System.out.println("@@@@@@@@@@@@@1" + data.getDd2()); } }
		 *///else {
			voName = "baseball." + "schedule" + ".model." + "Schedule" + "Vo";
			// vo�ΰ��±�
			//// ���� �������� �ʿ��� bean Ŭ�������� ���� //���� �ּҴ� cate1+service //vo�� �׻� ����Ű�� �ȿ� �־��
			// ��!!!!!!!
			System.out.println("voName - " + voName);
			for (Object obj : vos) {
				if (obj.getClass().getName().equals(voName)) {
					//// bean�� Ŭ���� �̸��� ���� �������� �ʿ��� bean Ŭ�����̸��� ��

					data.setDd(obj);

					System.out.println("@@@@@@@@@@@@@2" + data.getDd2());
					// data.setDd2(obj);
					/// ������ data �� ����
				}
			}
			for (Object obj2 : vos2) {
				if (obj2.getClass().getName().equals("baseball.player.model.PlayerStatVo")) {
					//// bean�� Ŭ���� �̸��� ���� �������� �ʿ��� bean Ŭ�����̸��� ��

					data.setDd2(obj2);
					data.setDd3(obj2);
					System.out.println("@@@@@@@@@@@@@2" + data.getDd2());
					// data.setDd2(obj);
					/// ������ data �� ����
				}

			
		}

		System.out.println("�������" + voName);
		System.out.println("�н��������� dd - " + data);

		//// mainData

		SubControll control = provider.getContext().getBean("schedule", SubControll.class);
		//// SubCotroll �� getBean ���� ������
		control.execute();
		/// �����Ŵ
		System.out.println("�����ϳ�??????" + data);
		return data;

	}

	void menu() {
		new SameMenu(data);

		HashMap<String, ArrayList<Menu>> subMenu = new HashMap<>();
		subMenu.put("schedule", new ArrayList<>());

		subMenu.get("schedule").add(new Menu("schedule", "��������", "list?year=2018&month=3"));
		subMenu.get("schedule").add(new Menu("schedule", "��������", "teamList?year=2018&month=3"));
		subMenu.get("schedule").add(new Menu("schedule", "����������", "gameRegister"));
		// subMenu.get("schedule").add(new Menu("seasonSchedule", "��������Է�",
		// "gameInfoRegister"));

		HashMap<String, ArrayList<Menu>> subMenu2 = new HashMap<>();
		subMenu2.put("schedule", new ArrayList<>());

		data.setSubMenu(subMenu.get(data.getCate1()));
		data.setSubMenu2(subMenu2.get(data.getCate1()));
	}

	@RequestMapping
	String mapping() {

		String res = "pathInfo/template2";
		if (data.isRedirect()) { //// redirect�� ���� redirect or forward ����
			res = data.getPath();
		}

		return res;
	}

}
