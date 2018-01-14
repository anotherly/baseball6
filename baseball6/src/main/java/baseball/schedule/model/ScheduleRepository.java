package baseball.schedule.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import baseball.player.model.PlayerStatVo;
import baseball.player.model.PlayerVo;
import baseball.schedule.model.ScheduleVo;

@Service
public class ScheduleRepository {

	@Resource
	SqlSessionTemplate template;

	public List<ScheduleVo> list(ScheduleVo schevo) {

		return template.selectList("scheduleMap.selectList", schevo);
	}
	public List<ScheduleVo> list2(ScheduleVo schevo) {

		return template.selectList("scheduleMap.selectList2", schevo);
	}
	
	public List<ScheduleVo> teamList(ScheduleVo schevo) {

		return template.selectList("scheduleMap.teamList", schevo);
	}

	public List<PlayerStatVo> listPlayerStat() {

		return template.selectList("scheduleMap.selectListPlayerStat");
	}

	public PlayerStatVo schedulehome(ScheduleVo schevo) {

		return template.selectOne("scheduleMap.schedulehome", schevo);
	}

	public PlayerStatVo scheduleaway(ScheduleVo schevo) {

		return template.selectOne("scheduleMap.scheduleaway", schevo);
	}

	/*
	 * public List<PlayerVo> listSch(PlayerSch sch) { return
	 * template.selectList("playerInfo.selectListSch", sch); }
	 * 
	 * public List<PlayerVo> listSchList(PlayerSch sch) { return
	 * template.selectList("playerInfo.selectListSchList", sch); }
	 */

	public ScheduleVo detail(PlayerVo vo) {
		System.out.println("焼壕壱覗陥たたたたたたたたたたたた" + vo);
		return template.selectOne("scheduleMap.selectDetail", vo);
	}

	public ScheduleVo gameRegisterView(ScheduleVo schevo) {
		return template.selectOne("scheduleMap.gameRegisterView", schevo);
	}

	// ♂照蟹身
	/*
	 * public ArrayList<Integer> gameRegisterViewPlayerStat(ScheduleVo schevo) {
	 * System.out.println("推奄澗 什追匝傾匂憎塘軒"+schevo); return
	 * template.selectOne("scheduleMap.gameRegisterViewPlayerStat", schevo); }
	 */
	public PlayerStatVo gameRegisterViewPlayerStatHome(ScheduleVo schevo) {
		return template.selectOne("scheduleMap.gameRegisterViewPlayerStatHome", schevo);
	}

	public PlayerStatVo gameRegisterViewPlayerStatAway(ScheduleVo schevo) {
		return template.selectOne("scheduleMap.gameRegisterViewPlayerStatAway", schevo);
	}

	/*
	 * public PlayerStatVo gameRegisterViewPlayerStatList(ScheduleVo schevo) {
	 * return template.selectOne("scheduleMap.gameRegisterViewPlayerStatList",
	 * schevo); }
	 */

	public void insert(ScheduleVo vo) {
		template.insert("scheduleMap.insertOne", vo);
	}
	/*
	 * public void insertSchedule(ScheduleVo schevo) {
	 * template.insert("scheduleMap.insertSchedule", schevo); }
	 */

	public void insertGameRegister(ScheduleVo schevo) {
		template.insert("scheduleMap.insertGameRegister", schevo);
	}

	/*
	 * public PlayerVo idPwChk(PlayerVo vo) { return
	 * template.selectOne("playerInfo.idPwChk", vo); }
	 */

	public void fileDelete(PlayerVo vo) {
		template.update("playerMap.fileDelete", vo);
	}

	/*
	 * public void delete(PlayerVo vo) { template.delete("playerInfo.delete", vo); }
	 */
	public boolean modify(PlayerVo vo) {
		return template.update("playerMap.modify", vo) > 0;
	}
}
