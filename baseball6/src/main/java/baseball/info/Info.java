package baseball.info;

import java.io.FileOutputStream;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import baseball.controller.SubControll;
import baseball.info.model.InfoRepository;
import baseball.info.model.InfoVo;
import baseball.model.PathData;
import baseball.team.model.TeamRepository;
import baseball.team.model.TeamVo;

@Service
public class Info implements SubControll {

	@Resource
	PathData data;

	@Resource
	InfoRepository iRep;

	InfoVo ivo;

	InfoSch isch;
	
	TeamVo tvo;

	@Resource
	TeamRepository dao;

	@Override
	public void execute() {

		// TODO Auto-generated method stub

		System.out.println("info ���Լ���:" + data);
		isch = (InfoSch) data.getDd2();
		ivo = (InfoVo) data.getDd();
		
		switch (data.getService()) {

		case "list":
			playerList();
			break;
		/*
		 * case "list": list(sch); break;
		 */

		case "view":
			view();
			break;

		case "detail":
			reg();
			break;

		case "playerModify":
			playerModify();
			break;
		case "playerRegister":
			playerRegisterReg();
			break;
		case "playerRegisterForm":
			playerRegisterForm();
			break;

		case "teamList":
			teamList();
			break;

		case "teamdetail":
			teamView();
			break;
		/*
		 * case "detail": modify(); break;
		 */
		}

	}

	private void teamView() {
		System.out.println("�� Ŭ���� �� �޼��� ����");
		System.out.println("tvo : " + tvo);
		data.setDd3(dao.detail(tvo));
	}

	private void teamList() {
		System.out.println("���� Ŭ���� ����Ʈ �޼ҵ� ����");
		data.setDd3(dao.list());
	}

	InfoVo playerModify() {
		data.setDd(iRep.modify(ivo));
		// data.setDd(iRep.detail(ivo));
		return ivo;

	}

	void reg() {

		System.out.println("������ ��������Ȯ��" + ivo);

		fileupload(ivo, data.getRequest());
		iRep.insert(ivo);
		iRep.insertPlayerStatCareer(ivo);
		data.setRedirect(true);

		data.setPath("redirect:view?playerId=" + ivo.getPlayerId());
	}

	void playerRegisterReg() {

		// iRep.playerRegisterReg();
		// System.out.println("Ÿ���̴ٸ���?"+iRep.playerRegisterReg());
		data.setDd(iRep.playerRegisterReg());
		data.setRedirect(true);
		data.setPath("redirect:playerRegisterForm?playerId=" + iRep.playerRegisterReg());
		// System.out.println(iRep.playerRegisterReg());
	}

	void playerRegisterForm() {
		// data.setDd(iRep.playerRegisterReg());
	}

	void view() {

		data.setDd(iRep.detail(ivo));

	}

	void playerList() {
		// kindArr();
		data.setDd2(isch);
		// data.setDd(iRep.playerList());
		// data.setDd(iRep.listSch(sch));
		data.setDd(iRep.listSchList(isch));
		System.out.println("ggggggggg = " + data.getDd());
		System.out.println("hhhhhhhhh = " + data.getDd2());
		System.out.println("sch = " + isch);
		// data.setRedirect(true);
		data.setPath("redirect:list");

	}

	/*
	 * ModelAndView list(InfoSch sch) {
	 * 
	 * 
	 * System.out.println("ž�ϱ�???????"+iRep.listSchList(sch)); ModelAndView mav =
	 * new ModelAndView(); mav.addObject("data", iRep.listSchList(sch));
	 * data.setPath("redirect:list");
	 * 
	 * return mav; }
	 */

	/*
	 * ModelAndView deleteForm(@ModelAttribute("vo") PlayerVo vo) {
	 * 
	 * ModelAndView mav = new ModelAndView(); System.out.println("deleteForm:" +
	 * vo.getPlayerId()); return mav; }
	 */

	void fileupload(InfoVo vo, HttpServletRequest request) {

		try {

			String outPath = request.getRealPath("/resources/playerPhoto");
			outPath = "C:\\FINAL\\baseball\\src\\main\\webapp\\resources\\playerPhoto";
			outPath += "/" + vo.getPlayerPhoto().getOriginalFilename();
			vo.setSysFile(vo.getPlayerPhoto().getOriginalFilename());
			FileOutputStream fos = new FileOutputStream(outPath);

			fos.write(vo.getPlayerPhoto().getBytes());

			fos.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * void fileupload(PlayerVo vo, HttpServletRequest request) {
	 * System.out.println("��ȣȣȣȣȣ" + vo.getPlayerPhoto().getOriginalFilename()); try
	 * {
	 * 
	 * vo.setOriFile(vo.getPlayerPhoto().getOriginalFilename()); String outPath =
	 * request.getRealPath("/resources/playerPhoto"); outPath =
	 * "C:\\FINAL\\baseball\\src\\main\\webapp\\resources\\playerPhoto"; outPath +=
	 * "/" + vo.getOriFile();
	 * 
	 * vo.setSysFile(vo.getOriFile());
	 * System.out.println("�ý������Դϴ�"+vo.getSysFile());
	 * 
	 * FileOutputStream fos = new FileOutputStream(outPath);
	 * 
	 * fos.write(vo.getPlayerPhoto().getBytes());
	 * 
	 * fos.close();
	 * 
	 * } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 */

	/*
	 * String fileupload(PlayerVo vo, HttpServletRequest request) { // ���� ���ε� �޼ҵ�
	 * !!!!!!!!!!!!!! upfile = ��������, // request = ���ε��� �������� FileOutputStream fos;
	 * String sysfile = vo.getPlayerPhoto().getOriginalFilename().toString();
	 * 
	 * try { String outPath = request.getRealPath("/resources/playerPhoto"); outPath
	 * = "C:\\FINAL\\baseball\\src\\main\\webapp\\resources\\playerPhoto"; String
	 * realPath = outPath + "\\" + sysfile; File file = new File(realPath); if
	 * (file.exists()) { int count = 0; int dot = sysfile.lastIndexOf("."); String
	 * nameonly = sysfile.substring(0, dot); String hwak = sysfile.substring(dot);
	 * 
	 * while (file.exists()) { count++; sysfile = nameonly + "_" + count + hwak;
	 * 
	 * realPath = outPath + "\\" + sysfile;
	 * 
	 * file = new File(realPath); } }
	 * 
	 * fos = new FileOutputStream(realPath);
	 * fos.write(vo.getPlayerPhoto().getBytes()); fos.close(); } catch (Exception e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); } return sysfile; }
	 */

}
