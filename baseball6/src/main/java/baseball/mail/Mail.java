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
		System.out.println("���� ����ťƮ ����" + data + " //----// data.getDd() : " + data.getDd());
		vo = (MailVo) data.getDd();
		System.out.println("����Ŭ�������� mailvo �� : " + vo);
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
			System.out.println("���� ����Ʈ");
			dao.mailDelete(vo);
			break;
		}
	}

}