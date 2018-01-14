package baseball.board.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import baseball.model.PathData;

@Service
public class BoardRepository {

	@Resource
	SqlSessionTemplate template;
	
	public List<BoardVo> list(PathData data) {
		
		return template.selectList("board.typelist",data);
	}
	public List<BoardVo> list2(BoardVo vo) {
		
		return template.selectList("board.selectNotice",vo);
	}
	public void addCount(BoardVo vo) {
		template.update("board.addcnt",vo);
	}
	
	public BoardVo detail(BoardVo vo) {
		addCount(vo);
		System.out.println(vo.getCnt());
		return template.selectOne("board.selectDetail",vo);
	}
	public void insert(BoardVo vo) {
		template.insert("board.insertOne",vo);
	}
	public Integer selectTotal(String vo) {
	      return template.selectOne("selectTotal",vo);
	   }
	public boolean modify(BoardVo vo)
	{
		return template.update("board.modify", vo)>0;
	} 
	public void fileDelete(BoardVo vo)
	{
		template.update("board.fileDelete", vo);
	} 
	public void delete(BoardVo vo) {
		template.delete("board.boarddelete", vo);
	}
	
}
