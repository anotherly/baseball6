package baseball.info.model;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import baseball.info.InfoSch;

@Service
public class InfoRepository {

	@Resource
	SqlSessionTemplate template;

	public List<InfoVo> playerList() {
		System.out.println("여긴 그냥 리스트 맨처음");
		return template.selectList("infoMap.selectList");
	}	
	public List<InfoVo> listSch(InfoSch sch) {
		System.out.println("listsch");
		return template.selectList("infoMap.selectListSch", sch);
	}
	public List<InfoVo> listSchList(InfoSch sch) {
		System.out.println("listschlist");
		System.out.println(sch);
		return template.selectList("infoMap.selectListSchList", sch);
	}
	
	
	public Integer playerRegisterReg() {
		return template.selectOne("infoMap.playerRegisterReg");
	}

	public InfoVo detail(InfoVo ivo) {
		return template.selectOne("infoMap.selectDetail", ivo);
	}

	public void insertPlayerStatCareer(InfoVo ivo) {
		template.insert("infoMap.insertPlayerStatCareer", ivo);
	}

	public void insert(InfoVo ivo) {
		template.insert("infoMap.insertOne", ivo);
	}
	/*
	 * 
	 * public void insertStat(InfoVo psvo) {
	 * template.insert("InfoMap.insertOneStat", psvo); }
	 * 
	 * public InfoVo idPwChk(InfoVo vo) { return
	 * template.selectOne("InfoInfo.idPwChk", vo); }
	 * 
	 * public void fileDelete(InfoVo vo) { template.update("InfoMap.fileDelete",
	 * vo); }
	 */

	public void delete(InfoVo ivo) {
		template.delete("infoMap.delete", ivo);
	}

	public boolean modify(InfoVo ivo) {
		return template.update("infoMap.modify", ivo) > 0;
	}
}
