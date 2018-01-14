package baseball.mail;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import baseball.controller.SubControll;
import baseball.mail.model.MailDao;
import baseball.mail.model.MailRepository;
import baseball.mail.model.MailVo;
import baseball.model.PathData;

@Service
public class Mail implements SubControll {
	@Resource
	PathData data;

	@Resource
	MailDao dao;

	MailVo vo;

	@Override
	public void execute() {
		System.out.println("메일 엑시큐트 진입" + data + " //----// data.getDd() : " + data.getDd());
		vo = (MailVo) data.getDd();
		System.out.println("메일클래스에서 mailvo 값 : " + vo);
		switch (data.getService()) {

		case "mailList":
			data.setDd(dao.mailList(vo.getUserid()));
			break;

		case "mailGo":
			dao.mailInsert(vo);
			data.setRedirect(true);
			data.setPath("redirect:mailSubmit");
			break;

		case "mailDetail":
			data.setDd(dao.mailDetail(vo.getMailid()));
			break;

		case "mailDelete":
			System.out.println("메일 딜리트");
			dao.mailDelete(vo);
			break;
		}
	}

}