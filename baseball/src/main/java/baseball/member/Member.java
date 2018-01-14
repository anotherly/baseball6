package baseball.member;

import java.io.File;
import java.io.FileOutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import baseball.controller.SubControll;
import baseball.mail.model.MailDao;
import baseball.member.model.MemberRepository;
import baseball.member.model.MemberVo;
import baseball.model.PathData;
import baseball.ticket.model.TicketVo;

@Service
public class Member implements SubControll {

	/**
	 * @uml.property name="data"
	 * @uml.associationEnd readOnly="true"
	 */
	@Resource
	PathData data;

	/**
	 * @uml.property name="dao"
	 * @uml.associationEnd readOnly="true"
	 */
	@Resource
	MemberRepository dao;
	
	@Resource
	MailDao mailDao;
	/**
	 * @uml.property name="session"
	 * @uml.associationEnd readOnly="true"
	 */
	@Resource
	HttpSession session;

	/**
	 * @uml.property name="vo"
	 * @uml.associationEnd
	 */
	MemberVo vo;
	/**
	 * @uml.property name="tvo"
	 * @uml.associationEnd
	 */
	TicketVo tvo;

	@Override
	public void execute() {
		if(data.getCate2().equals("reserve")) {
			tvo = (TicketVo) data.getDd();
		}else {
			vo = (MemberVo) data.getDd();
			System.out.println("멤버클래스에서 vo값 : "+vo);
		}
		switch (data.getService()) {
		
/////////////////////////////////////////
		case "list":
			data.setDd(dao.list());
			break;
		
		case "goBlack":
			dao.goBlack(vo);
			mailDao.mailBlack(vo.getUserid());
			break;
			
		case "blackList":
			data.setDd(dao.blackList());
			break;
			
		case "blackDetail":
			detail(vo);
			break;
			
		case "goUser":
			dao.goUser(vo);	
			mailDao.mailUser(vo.getUserid());
			break;
			
///////////////////////////////////////			
		case "detail":
			detail(vo);
			break;
			
		case "modify":
			detail(vo);
			break;
			
		case "modifyReg":
			modifyReg();
			break;

		case "fileDelete":
			fileDelete(vo);
			break;
			
		case "deleteForm":
			deleteForm();
			break;
			
		case "join":
			insert();
			break;
			
		case "reservedList":
			list();
			break;
		
		case "cancel":
			cancel();
			break;
			
		case "deleteReg":
			delete();
			break;
			
			
		case "../../../../../baseball/pathInfo/join/joinSub/idChk":
			System.out.println(vo.getUserid()+"가 와야 하는데 왜 안되냐...");
			idChk(vo.getUserid());
			
		}
	}


	public void list() {

		data.setDd(dao.reservedList(vo));

	}

	public void cancel() {
		dao.cancel(tvo);
		data.setRedirect(true);
		data.setPath("redirect:reservedList");
	}

	public void detail(MemberVo vo) {
		MemberVo fvo = dao.detail(vo);
		data.setDd(fvo);
	}

	public void deleteForm() {

	}

	public void delete() {
		String path = "redirect:deleteForm";
		if (dao.idPwChk(vo) != null) {
			dao.delete(vo);
			session.invalidate();
			path = "redirect:../../../../baseball/pathInfo/home/notice/first";
		}
		data.setRedirect(true);
		data.setPath(path);

	}

	public void insert() {
		fileupload(vo, data.getRequest());
		dao.insert(vo);
		data.setRedirect(true);
		data.setPath("redirect:../../login/loginSub/first");
	}

	public void modify(MemberVo vo) {
		data.setDd(dao.detail(vo));
	}

	void modifyReg() {
		if (dao.modify(vo)) {
			fileupload(vo, data.getRequest());
		}
		data.setRedirect(true);
		data.setPath("redirect:detail?userid=" + vo.getUserid());
	}

	public void fileupload(MemberVo vo, HttpServletRequest request) {
		// 파일 업로드 메소드 !!!!!!!!!!!!!! upfile = 파일정보,
		// request = 업로드할 폴더정보

		try {
			FileOutputStream fos;
			vo.setOriname(vo.getFile().getOriginalFilename());
			vo.setSysname(vo.getOriname());

			String outPath = request.getRealPath("/resources/up");
			outPath = "C:\\FINAL\\baseball3\\baseball\\src\\main\\webapp\\resources\\memberPhoto";
			String realPath = outPath + "\\" + vo.getFile().getOriginalFilename();
			File file = new File(realPath);
			if (file.exists()) {
				int count = 0;
				int dot = vo.getOriname().lastIndexOf(".");
				String nameonly = vo.getOriname().substring(0, dot);
				String hwak = vo.getOriname().substring(dot);

				while (file.exists()) {
					count++;
					vo.setSysname(nameonly + "_" + count + hwak);
					realPath = outPath + "\\" + vo.getSysname();

					file = new File(realPath);
				}
			}

			fos = new FileOutputStream(realPath);
			fos.write(vo.getFile().getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void fileDelete(MemberVo vo) { // 파일삭제하기!

		String fileName = dao.detail(vo).getSysname();
		if (fileName != null && !fileName.equals("") && !fileName.equals("null")) {
			File ff = new File(
					"C:\\FINAL\\baseball3\\baseball\\src\\main\\webapp\\resources\\memberPhoto\\" + fileName);
			ff.delete();
			dao.fileDelete(vo); // 수정에서 파일삭제!!
		}
		data.setRedirect(true);
		data.setPath("redirect:modify?userid=" + vo.getUserid());
	}

	@RequestMapping("/baseball/pathInfo/join/joinSub/idChk")
	ModelAndView idChk(String uid) {
		ModelAndView mav = new ModelAndView();
		System.out.println(uid + "좀 데려와라");
		mav.addObject("res", dao.idChk(uid));
		return mav;
	}
}
