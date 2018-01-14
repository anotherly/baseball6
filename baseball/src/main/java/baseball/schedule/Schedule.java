package baseball.schedule;

import java.awt.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import baseball.controller.SubControll;
import baseball.model.PathData;
import baseball.player.model.PlayerRepository;
import baseball.player.model.PlayerStatCareerVo;
import baseball.player.model.PlayerStatVo;
import baseball.player.model.PlayerVo;
import baseball.schedule.model.ScheduleRepository;
import baseball.schedule.model.ScheduleVo;

@Service
public class Schedule implements SubControll {

	@Resource
	PathData data;

	@Resource
	ScheduleRepository scheRep;

	@Resource
	PlayerRepository pRep;

	PlayerVo pvo;
	PlayerStatVo psvo;
	//PlayerStatCareerVo pscvo;
	ScheduleVo schevo;
	@Resource
	HttpServletRequest request;

	@Override
	public void execute() {

		// TODO Auto-generated method stub

		System.out.println("schedule 진입성공:" + data);
		schevo = (ScheduleVo) data.getDd();
		psvo = (PlayerStatVo) data.getDd2();

		switch (data.getService()) {
		case "list":
			list();
			break;
			
		case "teamList":
			teamList();
			break;
		
		case "gameRegisterDetail":
			gameRegisterReg();
			break;

		case "gameRegisterView":
			gameRegisterView();
			break;

		case "gameRegisterDetail2":
			gameRegisterDetail2();
			break;

		}

	}

	void gameRegisterReg() {

		// fileupload(vo, data.getRequest());
		scheRep.insertGameRegister(schevo);
		scheRep.gameRegisterViewPlayerStatHome(schevo);

		data.setRedirect(true);
		data.setPath("redirect:gameRegisterView?game_num=" + schevo.getGame_num() + "&home=" + schevo.getHome()
				+ "&away=" + schevo.getAway());
		System.out.println(schevo.getAway());
	}

	void gameRegisterDetail2() {

		// fileupload(vo, data.getRequest());
		// scheRep.insertGameRegister(schevo);
		// scheRep.gameRegisterViewPlayerStat(schevo);
		System.out.println("--------777777777777777777--" + scheRep.gameRegisterViewPlayerStatHome(schevo));

		data.setRedirect(true);
		data.setPath("redirect:gameRegisterView?game_num=" + schevo.getGame_num() + "&home=" + schevo.getHome()
				+ "&away=" + schevo.getAway());

	}

	void gameRegisterView() {
		System.out.println("여기1" + schevo);
		data.setDd(scheRep.gameRegisterView(schevo));
		System.out.println("여기2" + scheRep.gameRegisterView(schevo));
		System.out.println("여기3" + psvo);
		data.setDd2(scheRep.gameRegisterViewPlayerStatHome(schevo));
		System.out.println("여기4" + scheRep.gameRegisterViewPlayerStatHome(schevo));
		data.setDd3(scheRep.gameRegisterViewPlayerStatAway(schevo));
		System.out.println("여기4" + scheRep.gameRegisterViewPlayerStatAway(schevo));
		
		data.setDd5(scheRep.schedulehome(schevo));
		data.setDd4(scheRep.scheduleaway(schevo));

	}

	void list() {
		data.setDd(scheRep.list(schevo));
		//data.setDd2(scheRep.listPlayerStat());
		data.setDd2(scheRep.list2(schevo));
	}
	
	void teamList() {
		data.setDd(scheRep.teamList(schevo));
	}
	
	

}
