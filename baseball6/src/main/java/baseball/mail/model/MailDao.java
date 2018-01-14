package baseball.mail.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Component;

@Component
public class MailDao {

	@Resource
	DataSource ds;

	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	String sql = null;
	String url = "localhost:1521:xe";
	String id = "java";
	String pw = "java";

	public void init() {
		// TODO Auto-generated constructor stub

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@" + url, id, pw);
			//// 등록한 bean 에 있는 datasource를 가져와서 Connection을 받아온다
			con = ds.getConnection();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String parseDateNow() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	
	public ArrayList<MailVo> mailList(String id) {
		System.out.println("메일 dao mailList() 진입  : " + id);
		init();
		ArrayList<MailVo> res = new ArrayList<>();

		try {

			sql = "select * from mail where userid= ?";

			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				MailVo vo = new MailVo();

				vo.setUserid(rs.getString(1));
				vo.setSendid(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setMaildate(rs.getString(5));
				vo.setMailid(rs.getInt(6));
				System.out.println("vo : " + vo);
				res.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}

	public void mailInsert(MailVo vo) {
		System.out.println("메일인서트 dao 진입");
		init();
		try {
			sql = "select max(mailid) from mail";
			stmt = con.prepareStatement(sql);

			rs = stmt.executeQuery();

			if (rs.next()) {
				vo.setMailid(rs.getInt(1));
			}

			sql = "insert into mail (userid,sendid,title,content,maildate,mailid) " + "values (?,?,?,?,?,?)";

			System.out.println(sql);

			stmt = con.prepareStatement(sql);

			stmt.setString(1, vo.getUserid());
			stmt.setString(2, vo.getSendid());
			stmt.setString(3, vo.getTitle());
			stmt.setString(4, vo.getContent());
			stmt.setString(5, parseDateNow());
			stmt.setInt(6, vo.getMailid() + 1);

			System.out.println(stmt.executeUpdate());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

	}

	public MailVo mailDetail(int mailId) {
		init();
		System.out.println("dao에서 받아온 mailId값 : " + mailId);
		MailVo res = null;

		try {
			sql = "select * from mail where mailid = ?";

			stmt = con.prepareStatement(sql);

			stmt.setInt(1, mailId);

			rs = stmt.executeQuery();

			if (rs.next()) {
				res = new MailVo();

				res.setUserid(rs.getString(1));
				res.setSendid(rs.getString(2));
				res.setTitle(rs.getString(3));
				res.setContent(rs.getString(4));
				res.setMaildate(rs.getString(5));
				res.setMailid(rs.getInt(6));
				System.out.println("디테일 메일 값 : " + res);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}

	public void mailDelete(MailVo vo) {
		init();
		try {
			System.out.println("딜리트 메일 겟아이디 : "+vo.getMailid());
			
			sql = "delete from mail where mailid = ?";
			
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, vo.getMailid());
			
			System.out.println(sql);
			stmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public void mailBlack(String id) {
		System.out.println("메일인서트 dao 진입");
		init();
		MailVo vo= new MailVo();
		try {
			sql = "select max(mailid) from mail";
			stmt = con.prepareStatement(sql);

			rs = stmt.executeQuery();

			if (rs.next()) {
				vo.setMailid(rs.getInt(1));
			}

			sql = "insert into mail (userid,sendid,title,content,maildate,mailid) " + "values (?,?,?,?,?,?)";

			

			stmt = con.prepareStatement(sql);

			stmt.setString(1, id);
			stmt.setString(2, "관리자");
			stmt.setString(3, "회원님은 블랙리스트로 강등되셨습니다.");
			stmt.setString(4, "사유 : 부적절한 게시글 작성 \r\n 홍보성 광고글 음란성 글 도배글 등은 제재 사유입니다.");
			stmt.setString(5, parseDateNow());
			stmt.setInt(6, vo.getMailid() + 1);
			
			System.out.println(sql);
			System.out.println(stmt.executeUpdate());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

	}
	
	public void mailUser(String id) {
		System.out.println("메일인서트 dao 진입");
		init();
		MailVo vo= new MailVo();
		try {
			sql = "select max(mailid) from mail";
			stmt = con.prepareStatement(sql);

			rs = stmt.executeQuery();

			if (rs.next()) {
				vo.setMailid(rs.getInt(1));
			}

			sql = "insert into mail (userid,sendid,title,content,maildate,mailid) " + "values (?,?,?,?,?,?)";

			System.out.println(sql);

			stmt = con.prepareStatement(sql);

			stmt.setString(1, id);
			stmt.setString(2, "관리자");
			stmt.setString(3, "회원님의 등급이 복구되셨습니다.");
			stmt.setString(4, "홍보성 광고글 음란성 글 도배글 기재시 영구 블랙처리 될 수 있습니다.");
			stmt.setString(5, parseDateNow());
			stmt.setInt(6, vo.getMailid() + 1);

			System.out.println(stmt.executeUpdate());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

	}
	public void close() {

		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
		}
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
		}
		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
		}
	}
}
