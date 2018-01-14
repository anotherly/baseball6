package baseball.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import baseball.home.model.HomeVo;
import baseball.info.InfoSch;
import baseball.info.model.InfoRepository;
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
@RequestMapping("pathInfo/info/{cate2}/{service}")
public class InfoController {

	@Resource
	MyProvider provider;

	@Resource
	PathData data;

	InfoRepository iRep;

	InfoSch isch;

	@ModelAttribute("kindArr")
	public ArrayList<String[]> kindArr() {
		ArrayList<String[]> res = new ArrayList<>();
		res.add(new String[] { "playerName", "�����̸�" });
		res.add(new String[] { "teamId", "�Ҽ���" });

		return res;

	}

	@ModelAttribute("data")
	PathData data(@PathVariable String cate2, @PathVariable String service, InfoVo InfoVo, InfoSch isch, HomeVo homeVo,
			TeamVo teamVo, /// ��
			/// ī�װ���
			/// bean��
			/// ������////���θ޴���
			/// ���óѵ鿡����vo
			HttpServletRequest request) {
		data.setRedirect(false);
		System.out.println("�������� ���񽺰� : " + service);
		ArrayList vos = new ArrayList<>();
		vos.add(InfoVo);

		System.out.println("vos--------" + vos);
		ArrayList vos2 = new ArrayList<>();
		vos2.add(isch);
		
		ArrayList vos3 = new ArrayList<>();
		vos3.add(teamVo);
		
		
		System.out.println("vos2--------" + vos2);
		ArrayList<Object> home = new ArrayList<>();
		home.add(homeVo);

		data.setCate1("info");
		data.setCate2(cate2);
		data.setService(service);

		data.setCate1Temp("info");
		data.setServiceTemp(service);

		data.setRequest(request);
		System.out.println("infoController�� data - " + data);
		menu();
		String voName;

		if (cate2.equals("notice") && service.equals("first")) {
			voName = "baseball.home.model.HomeVo";
			for (Object homee : home) {
				if (homee.getClass().getName().equals(voName)) {

					data.setHome1(homee);
					data.setHome2(homee);
					data.setHome3(homee);
					System.out.println("home1 - " + data.getHome1());
					System.out.println("home2 - " + data.getHome1());
					System.out.println("home3 - " + data.getHome1());

				}
				/// ������ data �� ����
			}
			// �α��� ȸ�����Խ� ������̳� �����ڰ��� �ҷ��´�
		} else if (service.equals("list")) {

			voName = "baseball.info.InfoSch";
			for (Object obj : vos) {

				data.setDd(obj); // data.setDd2(obj); /// ������ data �� ����
				System.out.println("@@@@@@@@@@@@@13" + data.getDd());
			}
			for (Object obj2 : vos2) {

				data.setDd2(obj2); /// ������ data �� ����
				System.out.println("@@@@@@@@14" + data.getDd2());
			}

			/////////////////////////////////////////////////////////////////////////////////
		} else if (service.equals("teamList") || service.equals("teamdetail")) {
			voName = "baseball.team.model.TeamVo";
			for (Object obj3 : vos3) {
				System.out.println("������ �ܾ ���� �����ϰ�������");
				data.setDd(obj3);
				System.out.println("@@@@@@@@@@@@@1" + data.getDd());
			}
			/////////////////////////////////////////////////////////////////////////////////

		} else {
			voName = "baseball.info.model.InfoVo";
			for (Object obj : vos) {

				data.setDd(obj); // data.setDd2(obj); /// ������ data �� ����
				System.out.println("@@@@@@@@@@@@@13" + data.getDd());
			}
		}

		System.out.println("�������" + voName);
		System.out.println("�н��������� dd - " + data.getDd());
		if(service.contains("team")) {
			SubControll control = provider.getContext().getBean("team", SubControll.class);
			
			control.execute();
		}else {
			SubControll control = provider.getContext().getBean("info", SubControll.class);
			
			control.execute();
		}
		return data;

	}

	void menu() {
		new SameMenu(data);

		HashMap<String, ArrayList<Menu>> subMenu = new HashMap<>();
		subMenu.put("info", new ArrayList<>());

		subMenu.get("info").add(new Menu("notice", "��������", "list"));
		// subMenu.get("info").add(new Menu("notice", "�׽�Ʈ", "test"));
		subMenu.get("info").add(new Menu("notice", "������", "teamList"));

		HashMap<String, ArrayList<Menu>> subMenu2 = new HashMap<>();
		subMenu2.put("info", new ArrayList<>());

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
