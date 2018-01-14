package baseball.home;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import baseball.controller.SubControll;
import baseball.home.model.HomeVo;
import baseball.model.PathData;
import baseball.team.model.TeamVo;

@Service
public class Home implements SubControll {

	@Resource
	PathData data;

	@Resource
	HomeRepository hRep;

	HomeVo hvo;

	@Override
	public void execute() {

		// TODO Auto-generated method stub

		System.out.println("home 진입성공:" + data);
		hvo = (HomeVo) data.getDd();
		System.out.println("Home.java----" + hvo);

		switch (data.getService()) {
		case "first":
			list();
			break;
		}

	}

	void list() {
		System.out.println("홈 패키지의 홈 클래스의 리스트 메소드");
		
		
		
		//data.setHome10(hRep.gamescore());
		data.setHome9(hRep.listGame());
		data.setHome2(hRep.listPlayerRankingAvg());
		data.setHome3(hRep.listPlayerRankingEra());
		data.setHome4(hRep.listPlayerRankingHr());
		data.setHome5(hRep.listPlayerRankingPso());
		data.setHome6(hRep.listPlayerRankingRbi());
		data.setHome7(hRep.listPlayerRankingW());
		data.setHome8(hRep.listTeamRanking());
		
		

	}

}
