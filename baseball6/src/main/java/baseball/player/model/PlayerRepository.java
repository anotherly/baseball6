package baseball.player.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import baseball.info.model.InfoVo;
import baseball.player.model.PlayerVo;
import baseball.schedule.model.ScheduleVo;

@Service
public class PlayerRepository {

	@Resource
	SqlSessionTemplate template;

	public List<PlayerStatCareerVo> list(PlayerStatCareerVo pscvo) {

		return template.selectList("playerMap.selectList", pscvo);
	}

	public List<PlayerStatCareerVo> listBat(PlayerStatCareerVo pscvo) {
		System.out.println("타격리스트");
		return template.selectList("playerMap.listBat", pscvo);
	}

	public List<PlayerStatCareerVo> listDef(PlayerStatCareerVo pscvo) {
		System.out.println("수비리스트");
		return template.selectList("playerMap.listDef", pscvo);
	}

	public List<PlayerStatCareerVo> teamStatList(Integer yy) {

		return template.selectList("playerMap.teamStatList", yy);
	}

	public List<PlayerStatCareerVo> playerBatList() {

		return template.selectList("playerMap.playerBatList");
	}

	public List<PlayerStatCareerVo> playerDefList() {

		return template.selectList("playerMap.playerDefList");
	}

	public List<PlayerVo> teamList() {
		return template.selectList("playerMap.selectTeamList");
	}

	public List<PlayerVo> playerRegister() {
		return template.selectList("playerMap.playerRegister");
	}

	public Integer stat_num() {
		return template.selectOne("playerMap.stat_num");
	}

	/*
	 * public List<PlayerVo> listSch(PlayerSch sch) { return
	 * template.selectList("playerInfo.selectListSch", sch); }
	 * 
	 * public List<PlayerVo> listSchList(PlayerSch sch) { return
	 * template.selectList("playerInfo.selectListSchList", sch); }
	 */

	public PlayerVo detail(PlayerVo vo) {
		System.out.println("아배고프다ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ" + vo);
		return template.selectOne("playerMap.selectDetail", vo);
	}

	/*
	 * public PlayerStatCareerVo viewTodayStat() {
	 * System.out.println("아배고프다ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ"); return
	 * template.selectList("playerMap.selectDetail"); }
	 */

	/*
	 * public (PlayerStatCareerVo pscvo) { System.out.println("아배고프다ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ" +
	 * pscvo); return template.selectOne("playerMap.", pscvo); }
	 */
	public List<PlayerStatCareerVo> viewTodayStat(PlayerStatCareerVo pscvo) {

		return template.selectList("playerMap.selectViewTodayStat", pscvo);
	}

	/*
	 * public void insert(PlayerVo vo) { template.insert("playerMap.insertOne", vo);
	 * }
	 */
	public void insertPlayerStatCareer(PlayerStatCareerVo pscvo) {
		template.insert("playerMap.insertPlayerStatCareer", pscvo);
	}

	public void insertStat(PlayerStatCareerVo pscvo) {
		template.insert("playerMap.insertOneStat", pscvo);
	}

	/*
	 * public PlayerVo idPwChk(PlayerVo vo) { return
	 * template.selectOne("playerInfo.idPwChk", vo); }
	 */

	public void fileDelete(PlayerVo vo) {
		template.update("playerMap.fileDelete", vo);
	}

	public void delete(PlayerStatCareerVo pscvo) {
		template.delete("playerMap.delete", pscvo);
	}

	public boolean modify(PlayerVo vo) {
		return template.update("playerMap.modify", vo) > 0;
	}

	public boolean careerUpdate(PlayerStatCareerVo pscvo) {
		return template.update("playerMap.careerUpdate", pscvo) > 0;
	}

	public boolean completeUpdate(PlayerStatCareerVo pscvo) {
		return template.update("playerMap.completeUpdate", pscvo) > 0;
	}

	public boolean gameResComplete(PlayerStatCareerVo pscvo) {
		return template.update("playerMap.gameResComplete", pscvo) > 0;
	}

}
