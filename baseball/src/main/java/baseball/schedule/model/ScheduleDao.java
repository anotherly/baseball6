package baseball.schedule.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.stereotype.Component;


import baseball.player.model.PlayerVo;

@Component
public class ScheduleDao {
	// ������ ���ε��� ������ ����� �����ϱ� ���� ��������
	private static String year = "";
	private static String month = "";
	private static String date = "";
	private static String away = "���ܼ���";
	private static String home = "";
	private static String stadium = "";
	private static String game_num = "";
	@Resource
	DataSource ds;

	String url = "localhost:1521:xe";
	String id = "java";
	String pw = "java";

	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	String sql = null;

	public ScheduleDao() {
		// TODO Auto-generated constructor stub

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@" + url, id, pw);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void init() {
		// TODO Auto-generated constructor stub

		try {

			//// ����� bean �� �ִ� datasource�� �����ͼ� Connection�� �޾ƿ´�
			con = ds.getConnection();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<PlayerVo> getaway(HttpServletRequest request) {// HttpServletRequest request

		ArrayList list = new ArrayList();
		String awayStr = "doosan,samsung,nexen,kia,lg,lotte,hanhwa,sk,kt,nc";
		String[] arr = awayStr.split(",");
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		return list;
	}

	public ArrayList gethome(HttpServletRequest request) {
		ArrayList list = new ArrayList();
		String homeStr = "";
		String awayKey = request.getParameter("away");
		if (awayKey != null) {
			 if(awayKey.equals("doosan")){
			homeStr = "samsung,nexen,kia,lg,lotte,hanhwa,sk,kt,nc";
		} else if (awayKey.equals("samsung")){
			homeStr = "doosan,nexen,kia,lg,lotte,hanhwa,sk,kt,nc";
		} else if (awayKey.equals("nexen")){
			homeStr = "doosan,samsung,kia,lg,lotte,hanhwa,sk,kt,nc";
		} else if (awayKey.equals("kia")){
			homeStr = "doosan,samsung,nexen,lg,lotte,hanhwa,sk,kt,nc";
		} else if (awayKey.equals("lg")){
			homeStr = "doosan,samsung,nexen,kia,lotte,hanhwa,sk,kt,nc";
		} else if (awayKey.equals("lotte")){
			homeStr = "doosan,samsung,nexen,kia,lg,hanhwa,sk,kt,nc";
		} else if (awayKey.equals("hanhwa")){
			homeStr = "doosan,samsung,nexen,kia,lg,lotte,sk,kt,nc";
		} else if (awayKey.equals("sk")){
			homeStr = "doosan,samsung,nexen,kia,lg,lotte,hanhwa,kt,nc";
		} else if (awayKey.equals("kt")){
			homeStr = "doosan,samsung,nexen,kia,lg,lotte,hanhwa,sk,nc";
		} else if (awayKey.equals("nc")){
			homeStr = "doosan,samsung,nexen,kia,lg,lotte,hanhwa,sk";
		} else
			return list;
		}
		String[] arr = homeStr.split(",");
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		return list;
	}

	public ArrayList getstadium(HttpServletRequest request) {
		StadiumVo res = null;
		ArrayList qq = new ArrayList();
		try {
			sql = "select * from STADIUM where name LIKE ?";
			stmt = con.prepareStatement(sql);
			// stmt.setString(1, request.getParameter("away"));
			stmt.setString(1, "%" + request.getParameter("home") + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				res = new StadiumVo();
System.out.println("���ó���>???????????");
				res.setName(rs.getString("name"));
				qq.add(res.getName());/**/

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return qq;
	}
	
	public String getgameNum(HttpServletRequest request) {
		
		String qqq = new String();
		try {
			sql = "select max(game_num)+1 from schedule";
			stmt = con.prepareStatement(sql);
			//stmt.setString(1, "%" + request.getParameter("home") + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				qqq = rs.getString(1);//.replaceAll("[^0-9]", "")
				System.out.println(qqq);
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return qqq;
	}

	/*
	 * public String getYeardropdown(HttpServletRequest request) { if
	 * (request.getParameter("yeardropdown") != null) { year =
	 * request.getParameter("yeardropdown"); } else { year = "���ܼ���"; } return year;
	 * } public String getMonthdropdown(HttpServletRequest request) { if
	 * (request.getParameter("monthdropdown") != null) { month =
	 * request.getParameter("monthdropdown"); } else { month = "���ܼ���"; } return
	 * month; } public String getDaydropdown(HttpServletRequest request) { if
	 * (request.getParameter("daydropdown") != null) { date =
	 * request.getParameter("daydropdown"); } else { date = "���ܼ���"; } return date; }
	 */
	public String getawayState(HttpServletRequest request) {
		if (request.getParameter("away") != null) {
			away = request.getParameter("away");
		} else {
			away = "���ܼ���";
		}
		return away;
	}

	public String gethomeState(HttpServletRequest request) {
		if (request.getParameter("home") != null) {
			home = request.getParameter("home");
		} else {
			home = "";
		}
		return home;
	}

	public String getstadiumState(HttpServletRequest request) {
		if (request.getParameter("stadium") != null) {
			// stadium = request.getParameter("stadium");
			// �ѱ۸� ����
			stadium = request.getParameter("stadium")/*.replaceAll("[^\uAC00-\uD7AF\u1100-\u11FF\u3130-\u318F]", "")*/;
			//System.out.println("stadium" + stadium);
			// ������ ����
			// stadium = request.getParameter("stadium").replaceAll("[^a-zA-Z]", "")
		} else {
			stadium = "";
		}
		return stadium;
	}

	public String getstadiumState1(HttpServletRequest request) {
		if (request.getParameter("stadium") != null) {
			stadium = request.getParameter("stadium").replaceAll("[^\uAC00-\uD7AF\u1100-\u11FF\u3130-\u318F]", "");
		} else {
			stadium = "";
		}
		return stadium;
	}

	public String getstadiumState2(HttpServletRequest request) {
		if (request.getParameter("stadium") != null) {
			// stadium = request.getParameter("stadium");
			// �ѱ۸� ����
			stadium = request.getParameter("stadium").replaceAll("[^\uAC00-\uD7AF\u1100-\u11FF\u3130-\u318F]", "");
			// ������ ����
			// stadium = request.getParameter("stadium").replaceAll("[^a-zA-Z]", "");
		} else {
			stadium = "";
		}
		return stadium;
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