package baseball.player.model;

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
import baseball.schedule.model.ScheduleVo;

@Component
public class PlayerDao {
	// 페이지 리로딩시 셀렉팅 목록을 유지하기 위한 전역변수
	private static String year = "";
	private static String month = "";
	private static String day = "";
	private static String team = "구단선택";
	private static String position = "";
	private static String playerNameNo = "";
	private static String playerId = "";
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

	public PlayerDao() {
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

			//// 등록한 bean 에 있는 datasource를 가져와서 Connection을 받아온다
			con = ds.getConnection();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<PlayerVo> getteam(HttpServletRequest request) {// HttpServletRequest request

		ArrayList list = new ArrayList();
		String teamStr = "doosan,samsung,nexen,kia,lg,lotte,hanhwa,sk,kt,nc";
		String[] arr = teamStr.split(",");
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		return list;
	}

	public ArrayList getposition(HttpServletRequest request) {
		ArrayList list = new ArrayList();
		String positionStr = "";
		String teamKey = request.getParameter("teamId");
		if (teamKey != null) {
			// if(teamKey.equals("3")){
			positionStr = "pitcher,infielder,outfielder";
		} else {
			return list;
		}
		String[] arr = positionStr.split(",");
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		return list;
	}

	public ArrayList getplayerNameNo(HttpServletRequest request) {
		PlayerVo res = null;
		ScheduleVo res1 = null;
		ArrayList qq = new ArrayList();
		ArrayList ww = new ArrayList();
		try {
			sql = "select * from player where teamId = ? and position LIKE ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, request.getParameter("teamId"));
			stmt.setString(2, "%" + request.getParameter("position") + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				res = new PlayerVo();

				res.setPlayerName(rs.getString("playerName"));
				res.setPlayerId(rs.getString("playerId"));
				qq.add(res.getPlayerName() + " [" + res.getPlayerId() + "] ");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qq;
	}

	public ArrayList getGame_num(HttpServletRequest request) {
		ScheduleVo res1 = null;
		ArrayList ww = new ArrayList();
		Integer game_num = null;
		try {
			
			sql = "select * from schedule where (year = ? and month = ? and day = ? and home = ? and status = 'on')" + 
					"or (year = ? and month = ? and day = ? and away = ? and status = 'on')";
			
			stmt = con.prepareStatement(sql);

			stmt.setString(1, request.getParameter("year"));
			stmt.setString(2, request.getParameter("month"));
			stmt.setString(3, request.getParameter("day"));
			stmt.setString(4, request.getParameter("teamId"));
			stmt.setString(5, request.getParameter("year"));
			stmt.setString(6, request.getParameter("month"));
			stmt.setString(7, request.getParameter("day"));
			stmt.setString(8, request.getParameter("teamId"));

			rs = stmt.executeQuery();
			while (rs.next()) {
				res1 = new ScheduleVo();

				res1.setGame_num(rs.getInt("game_num"));
				
				
				
				ww.add(res1.getGame_num());
				
				
		
			}request.setAttribute("rr", ww);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ww;
	}

	public ArrayList getyear(HttpServletRequest request) {

		ArrayList list = new ArrayList();
		String teamStr = "2018,2017,2016,2015,2014,2013,2012,2011,2010";
		String[] arr = teamStr.split(",");
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		return list;
	}

	public ArrayList getmonth(HttpServletRequest request) {

		ArrayList list = new ArrayList();
		String teamStr = "1,2,3,4,5,6,7,8,9,10,11,12";
		String[] arr = teamStr.split(",");
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		return list;
	}

	public ArrayList getday(HttpServletRequest request) {

		ArrayList list = new ArrayList();
		String teamStr = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19," + "20,21,22,23,24,25,26,27,28,29,30,31";
		String[] arr = teamStr.split(",");
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		return list;
	}

	public ArrayList getModi(HttpServletRequest request) {
		PlayerStatVo res = null;
		ArrayList qqq = new ArrayList();
		try {
			sql = "select * from playerstat where year = ? and month = ? and day = ? and playerId = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, request.getParameter("year"));
			stmt.setString(2, request.getParameter("month"));
			stmt.setString(3, request.getParameter("day"));
			stmt.setString(4, request.getParameter("playerId"));
			// stmt.setString(2, "%"+request.getParameter("position")+"%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				res = new PlayerStatVo();

				res.setGs(rs.getInt("gs"));
				res.setPositionToday(rs.getString("positionToday"));
				res.setInn(rs.getInt("inn"));
				res.setTc(rs.getInt("tc"));
				res.setPo(rs.getInt("po"));
				res.setA(rs.getInt("a"));
				res.setE(rs.getInt("e"));
				res.setDp(rs.getInt("dp"));
				res.setAb(rs.getInt("ab"));
				res.setR(rs.getInt("r"));
				res.setH(rs.getInt("h"));
				res.setTwoBase(rs.getInt("twoBase"));
				res.setThirdBase(rs.getInt("thirdBase"));
				res.setHr(rs.getInt("hr"));
				res.setRbi(rs.getInt("rbi"));
				res.setBb(rs.getInt("bb"));
				res.setSo(rs.getInt("so"));
				res.setSb(rs.getInt("sb"));
				res.setCs(rs.getInt("cs"));
				res.setW(rs.getInt("w"));
				res.setL(rs.getInt("l"));
				res.setHold(rs.getInt("hold"));
				res.setSv(rs.getInt("sv"));
				res.setSvo(rs.getInt("svo"));
				res.setIp(rs.getInt("ip"));
				res.setPitcherH(rs.getInt("pitcherH"));
				res.setPitcherR(rs.getInt("pitcherR"));
				res.setPitcherHr(rs.getInt("pitcherHr"));
				res.setPitcherBb(rs.getInt("pitcherBb"));
				res.setPitcherSo(rs.getInt("pitcherSo"));
				// res.seth.setHome(rs.getString("home"));
				res.setPitcherSo(rs.getInt("pitcherSo"));
				res.setPlayerName(rs.getString("playerName"));
				res.setPlayerId(rs.getString("playerId"));
				qqq.add(res);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return qqq;
	}

	public String getyearState(HttpServletRequest request) {
		if (request.getParameter("year") != null) {
			year = request.getParameter("year");
		} else {
			year = "년도선택";
		}
		return year;
	}

	public String getmonthState(HttpServletRequest request) {
		if (request.getParameter("month") != null) {
			month = request.getParameter("month");
		} else {
			month = "월선택";
		}
		return month;
	}

	public String getdayState(HttpServletRequest request) {
		if (request.getParameter("day") != null) {
			day = request.getParameter("day");
		} else {
			day = "일선택";
		}
		return day;
	}

	public String getteamState(HttpServletRequest request) {
		if (request.getParameter("teamId") != null) {
			team = request.getParameter("teamId");
		} else {
			team = "구단선택";
		}
		return team;
	}

	public String getpositionState(HttpServletRequest request) {
		if (request.getParameter("position") != null) {
			position = request.getParameter("position");
		} else {
			position = "";
		}
		return position;
	}

	public String getplayerNameNoState(HttpServletRequest request) {
		if (request.getParameter("playerNameNo") != null) {
			// 한글만 추출
			playerNameNo = request.getParameter("playerNameNo").replaceAll("[^\uAC00-\uD7AF\u1100-\u11FF\u3130-\u318F]",
					"");
			// 영문만 추출
			// playerNameNo =
			// request.getParameter("playerNameNo");/*.replaceAll("[^a-zA-Z]", "")*/
		} else {
			playerNameNo = "";
		}
		return playerNameNo;
	}

	public String getplayerNameNoState1(HttpServletRequest request) {
		if (request.getParameter("playerNameNo") != null) {
			playerId = request.getParameter("playerNameNo").replaceAll("[^0-9]", "");
		} else {
			playerId = "";
		}
		return playerId;
	}

	public String getplayerNameNoState2(HttpServletRequest request) {
		if (request.getParameter("playerNameNo") != null) {
			// 한글만 추출
			playerNameNo = request.getParameter("playerNameNo").replaceAll("[^\uAC00-\uD7AF\u1100-\u11FF\u3130-\u318F]",
					"");
			// 영문만 추출
			// playerNameNo = request.getParameter("playerNameNo").replaceAll("[^a-zA-Z]",
			// "");
		} else {
			playerNameNo = "";
		}
		return playerNameNo;
	}

	public String getGame_numState(HttpServletRequest request) {
		if (request.getParameter("game_num") != null) {
			// 한글만 추출
			// game_num = request.getParameter("game_num");
			// 영문만 추출
			// playerNameNo =
			// request.getParameter("playerNameNo");/*.replaceAll("[^a-zA-Z]", "")

			game_num = request.getParameter("game_num");
			

		} else {
			game_num = "";
		}
		return game_num;
	}

	/*
	 * public String getGame_numState2(HttpServletRequest request) { if
	 * (request.getParameter("game_num") != null) { // 한글만 추출 // game_num =
	 * request.getParameter("game_num"); // 영문만 추출 // playerNameNo = //
	 * request.getParameter("playerNameNo");/*.replaceAll("[^a-zA-Z]", "")
	 * 
	 * game_num = request.getParameter("game_num");
	 * 
	 * } else { game_num = ""; } return game_num; }
	 */

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