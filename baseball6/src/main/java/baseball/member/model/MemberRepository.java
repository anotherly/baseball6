package baseball.member.model;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import baseball.ticket.model.TicketResVo;
import baseball.ticket.model.TicketVo;

@Service
public class MemberRepository {

	/**
	 * @uml.property name="template"
	 * @uml.associationEnd readOnly="true"
	 */
	@Resource
	SqlSessionTemplate template;

	public Integer idChk(String uid) {
		System.out.println("정 투더 체 는 바로바로" + uid);
		return template.selectOne("mm.idChk", uid);
	}

	public List<MemberVo> list() {
		return template.selectList("mm.selectList");
	}

	public MemberVo detail(MemberVo vo) {
		return template.selectOne("mm.selectDetail", vo);
	}

	public void insert(MemberVo vo) {
		vo.setGrade("user");
		template.insert("mm.insertOne", vo);
	}

	public void delete(MemberVo vo) {
		template.delete("mm.delete", vo);
	}

	public MemberVo idPwChk(MemberVo vo) {
		return template.selectOne("mm.idPwChk", vo);
	}

	public void fileDelete(MemberVo vo) {
		template.update("mm.fileDelete", vo);
	}

	public boolean modify(MemberVo vo) {
		return template.update("mm.modify", vo) > 0;
	}

	public MemberVo findId(MemberVo vo) {
		return template.selectOne("mm.findId", vo);
	}

	public MemberVo findPw(MemberVo vo) {

		return template.selectOne("mm.findPw", vo);
	}

	public void cancel(TicketVo vo) {
		template.update("ticket.cancel", vo);
	}

	public List<TicketVo> reservedList(MemberVo vo) {
		return template.selectList("ticket.selectList", vo);
	}

	/////////////////////////////////////////////////////////////////////
	public void goBlack(MemberVo vo) {
		template.update("mm.goBlack", vo);
	}

	public List<MemberVo> blackList() {
		System.out.println("블랙리스트 레퍼지토리");
		return template.selectList("mm.blackList");
	}
	
	public void goUser(MemberVo vo) {
		template.update("mm.goUser", vo);
	}
	///////////////////////////////////////////////////////

	/*
	 * public List<TicketResVo> reservedList(MemberVo vo) { return
	 * template.selectList("ticket.selectList",vo); }
	 */
}
