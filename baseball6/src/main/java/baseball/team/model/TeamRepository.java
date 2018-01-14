package baseball.team.model;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import baseball.team.TeamSch;

@Service
public class TeamRepository {

	@Resource
	SqlSessionTemplate template;

	public List<TeamVo> list() {
		System.out.println("�� �������丮 ����Ʈ ���� ");
		return template.selectList("teamMap.selectList");
	}

	public TeamVo detail(TeamVo vo) {
		System.out.println("�� �������丮 ������ ���� ");
		return template.selectOne("teamMap.selectDetail", vo);
	}

	public void insert(TeamVo vo) {
		template.insert("teamMap.insertOne", vo);
	}

}
