package baseball.board;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.DatabaseMetaData;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import baseball.board.model.BoardRepository;
import baseball.board.model.BoardVo;
import baseball.controller.SubControll;
import baseball.model.PathData;

@Service
public class Board implements SubControll{
	
	@Resource
	BoardRepository dao;
	
	@Resource
	PathData data;
	
	BoardVo vo;
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
		vo = (BoardVo) data.getDd();
		
		switch (data.getService()) {
		
		case "list":
			typelist(data,data.getNowPage());
			list();
			break;
			
		case "detail":
			detail();
			break;
			
		case "insert":
			insert();
			break;
			
		case "modify":
			detail();
			break;
			
		case "modifyGo":
			modify();
			break;
		
		case "fileDelete":
			fileDelete(vo);
			break;
			
		case "delete":
			delete();
		}
		
	}
	
	void list() {
		data.setDd2(dao.list2(vo));
	}
	
	void typelist(PathData pathData,@RequestParam(value="page", required=false, defaultValue="1")Integer page) {
		
		data.setTotal(dao.selectTotal(data.getCate2()));
		data.setNowPage(page);
		data.setDd(dao.list(pathData));

	}
	
	
	void delete() {
			dao.delete(vo);
			data.setRedirect(true);
			data.setPath("redirect:list");
	}
	
	void detail() {
		data.setDd(dao.detail(vo));
	}
	
	void insert() {
		fileupload(vo, data.getRequest());
		vo.setCategory1(data.getCate2());
		dao.insert(vo);
		data.setRedirect(true);
		data.setPath("redirect:detail?boardid="+vo.getBoardid());
	}
	
	void modify() {
		if (dao.modify(vo)) {
			fileupload(vo, data.getRequest());
		}
		data.setRedirect(true);
		data.setPath("redirect:detail?boardid="+vo.getBoardid());
	}
	
	
	void fileupload(BoardVo vo, HttpServletRequest request) { // ���� ���ε� �޼ҵ� !!!!!!!!!!!!!! upfile = ��������,
		// request = ���ε��� ��������
		try {
			FileOutputStream fos;
			vo.setOriname(vo.getFile().getOriginalFilename());
			vo.setSysname(vo.getOriname());

			String outPath = request.getRealPath("/resources/up");
			outPath = "C:\\FINAL\\baseball3\\baseball\\src\\main\\webapp\\resources\\board";
			String realPath = outPath + "\\" + vo.getFile().getOriginalFilename();
			File file = new File(realPath);
			if (file.exists()) {
				int count = 0;
				int dot = vo.getOriname().lastIndexOf(".");
				String nameonly = vo.getOriname().substring(0, dot);
				String hwak = vo.getOriname().substring(dot);
				
				while (file.exists()) {
					count++;
					vo.setSysname(nameonly + "_" + count + hwak);
					realPath = outPath + "\\" + vo.getSysname();
					
					file = new File(realPath);
				}
			}
			
			fos = new FileOutputStream(realPath);
			fos.write(vo.getFile().getBytes());
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void fileDelete(BoardVo vo) { // ���ϻ����ϱ�!

		String fileName = dao.detail(vo).getSysname();
		if (fileName != null && !fileName.equals("") && !fileName.equals("null")) {
			File ff = new File(
					 "C:\\FINAL\\baseball3\\baseball\\src\\main\\webapp\\resources\\board\\"+fileName);
			ff.delete();
			dao.fileDelete(vo); // �������� ���ϻ���!!
		}
		data.setRedirect(true);
		data.setPath("redirect:modify?boardid=" + vo.getBoardid());
	}
}
