package baseball.home;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import baseball.home.model.HomeVo;
import baseball.player.model.PlayerStatCareerVo;
import baseball.player.model.PlayerStatVo;
import baseball.schedule.model.ScheduleVo;
import baseball.team.model.TeamVo;

@Service
public class HomeRepository {

	@Resource
	SqlSessionTemplate template;

	public List<HomeVo> list(HomeVo hvo) {
		System.out.println("list");
		return template.selectList("homeMap.list", hvo);
	}

	public List<HomeVo> listGame() {
		System.out.println("listGame");
		return template.selectList("homeMap.listGame");
	}

	public List<HomeVo> listPlayerRankingAvg() {

		return template.selectList("homeMap.listPlayerRankingAvg");
	}

	public List<HomeVo> listPlayerRankingHr() {

		return template.selectList("homeMap.listPlayerRankingHr");
	}

	public List<HomeVo> listPlayerRankingRbi() {

		return template.selectList("homeMap.listPlayerRankingRbi");
	}

	public List<HomeVo> listPlayerRankingEra() {

		return template.selectList("homeMap.listPlayerRankingEra");
	}

	public List<HomeVo> listPlayerRankingW() {

		return template.selectList("homeMap.listPlayerRankingW");
	}

	public List<HomeVo> listPlayerRankingPso() {
		return template.selectList("homeMap.listPlayerRankingPso");
	}

	public List<HomeVo> listTeamRanking() {
		System.out.println("listTeamRanking");
		return template.selectList("homeMap.listTeamRanking");
	}

	public HomeVo schedulehome(HomeVo hvo) {

		return template.selectOne("homeMap.schedulehome", hvo);
	}

	public HomeVo scheduleaway(HomeVo hvo) {

		return template.selectOne("homeMap.scheduleaway", hvo);
	}

	public HomeVo gameRegisterViewPlayerStatHome(HomeVo hvo) {
		return template.selectOne("homeMap.gameRegisterViewPlayerStatHome", hvo);
	}

	public HomeVo gameRegisterViewPlayerStatAway(HomeVo hvo) {
		return template.selectOne("homeMap.gameRegisterViewPlayerStatAway", hvo);
	}
}
