package baseball.bill.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Component;

@Component
public class BillDao {

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
			//// ����� bean �� �ִ� datasource�� �����ͼ� Connection�� �޾ƿ´�
			con = ds.getConnection();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ��� �ϴܺ� �˻����� : ��ü ����, Ư�� ��¥�� ���� �հ�
	// ��ȯ �� 10��
	public ArrayList<BillVo> teamAllDaySch(ArrayList<BillSch> sch) {
		init();
		System.out.println("�� dao�� ssdAll() ���� : ��ü ����, Ư�� ��¥�� ���� �հ�");
		ArrayList<BillVo> res = new ArrayList<>();

		try {

			sql = "select pay_date, stadium, " + "sum(price), sum(nvl(refund_price,0)),"
					+ "sum(price-nvl(refund_price,0)), sum(price-nvl(refund_price,0))*0.9,"
					+ "sum(price-nvl(refund_price,0))*0.6, sum(price-nvl(refund_price,0))*0.2,"
					+ "sum(price-nvl(refund_price,0))*0.1, sum(price-nvl(refund_price,0))*0.1 " + "from ticket3 "
					+ "where pay_date between ? and ? " + "group by pay_date, stadium order by pay_date desc";

			String firstDate = sch.get(0).year + "/" + sch.get(0).month + "/" + sch.get(0).day;
			String lastDate = sch.get(1).year + "/" + sch.get(1).month + "/" + sch.get(1).day;

			System.out.println("�۽�Ʈ����Ʈ : " + firstDate);
			System.out.println("��Ʈ����Ʈ : " + lastDate);

			stmt = con.prepareStatement(sql);
			stmt.setString(1, firstDate);
			stmt.setString(2, lastDate);
			rs = stmt.executeQuery();

			while (rs.next()) {
				BillVo vo = new BillVo();
				vo.setBilldate(rs.getTimestamp(1));
				vo.setStadium(rs.getString(2));
				vo.setIncome(rs.getInt(3));
				vo.setRefund(rs.getInt(4));
				vo.setDeposit(rs.getInt(5));
				vo.setWithdraw(rs.getInt(6));
				vo.setHome(rs.getInt(7));
				vo.setAway(rs.getInt(8));
				vo.setKbo(rs.getInt(9));
				vo.setWe(rs.getInt(10));
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

	// ��� �ϴܺ� �˻����� : Ư�� ���� , Ư�� ��¥�� ���� ��ȸ
	// ��ȯ �� 8��
	public ArrayList<BillVo> dTeamSch(ArrayList<BillSch> sch) {
		init();
		System.out.println("�� dao�� dTeamSch() ����");
		System.out.println("sch.get(0).steam : " + sch.get(0).steam);
		ArrayList<BillVo> res = new ArrayList<>();

		try {
			sql = "select pay_date, stadium, " + "sum(price), sum(nvl(refund_price,0)),"
					+ "sum(price-nvl(refund_price,0)), sum(price-nvl(refund_price,0))*0.9,"
					+ "sum(price-nvl(refund_price,0))*0.6, sum(price-nvl(refund_price,0))*0.2,"
					+ "sum(price-nvl(refund_price,0))*0.1, sum(price-nvl(refund_price,0))*0.1 "
					+ "from(select * from ticket3 where stadium = ?) " + "where pay_date between ? and ? "
					+ "group by pay_date, stadium order by pay_date desc";

			String firstDate = sch.get(0).year + "/" + sch.get(0).month + "/" + sch.get(0).day;
			String lastDate = sch.get(1).year + "/" + sch.get(1).month + "/" + sch.get(1).day;

			System.out.println("�۽�Ʈ����Ʈ : " + firstDate);
			System.out.println("��Ʈ����Ʈ :" + lastDate);

			stmt = con.prepareStatement(sql);
			stmt.setString(1, sch.get(0).steam);
			stmt.setString(2, firstDate);
			stmt.setString(3, lastDate);
			rs = stmt.executeQuery();

			while (rs.next()) {
				BillVo vo = new BillVo();
				vo.setBilldate(rs.getTimestamp(1));
				vo.setStadium(rs.getString(2));
				vo.setIncome(rs.getInt(3));
				vo.setRefund(rs.getInt(4));
				vo.setDeposit(rs.getInt(5));
				vo.setWithdraw(rs.getInt(6));
				vo.setHome(rs.getInt(7));
				vo.setAway(rs.getInt(8));
				vo.setKbo(rs.getInt(9));
				vo.setWe(rs.getInt(10));
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

	// ��� �ϴܺ� �˻����� : ��ü ����, Ư�� ��¥�� ���� �հ�
	// ��ȯ �� 10��
	public ArrayList<BillVo> teamAllMonthSch(ArrayList<BillSch> sch) {
		init();
		System.out.println("�� dao�� teamAllMonthSch() ���� : ��ü ����, Ư�� ��¥�� ���� �հ�");
		ArrayList<BillVo> res = new ArrayList<>();
		ArrayList<BillVo> res2 = new ArrayList<>();

		try {

			sql = "select pay_date, stadium, " + "sum(price), sum(nvl(refund_price,0)),"
					+ "sum(price-nvl(refund_price,0)), sum(price-nvl(refund_price,0))*0.9,"
					+ "sum(price-nvl(refund_price,0))*0.6, sum(price-nvl(refund_price,0))*0.2,"
					+ "sum(price-nvl(refund_price,0))*0.1, sum(price-nvl(refund_price,0))*0.1 " + "from ticket3 "
					+ "where pay_date between ? and ? " + "group by pay_date, stadium order by pay_date desc";

			String firstDate = sch.get(0).year + "/" + sch.get(0).month + "/01";
			String lastDate = sch.get(1).year + "/" + sch.get(1).month + "/01";

			System.out.println("�۽�Ʈ����Ʈ : " + firstDate);
			System.out.println("��Ʈ����Ʈ : " + lastDate);

			stmt = con.prepareStatement(sql);
			stmt.setString(1, firstDate);
			stmt.setString(2, lastDate);
			rs = stmt.executeQuery();

			while (rs.next()) {
				BillVo vo = new BillVo();
				vo.setBilldate(rs.getTimestamp(1));
				vo.setStadium(rs.getString(2));
				vo.setIncome(rs.getInt(3));
				vo.setRefund(rs.getInt(4));
				vo.setDeposit(rs.getInt(5));
				vo.setWithdraw(rs.getInt(6));
				vo.setHome(rs.getInt(7));
				vo.setAway(rs.getInt(8));
				vo.setKbo(rs.getInt(9));
				vo.setWe(rs.getInt(10));
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

	// ��� �ϴܺ� �˻����� : Ư�� ���� , Ư�� ��¥�� ���� ��ȸ
	// ��ȯ �� 8��
	public ArrayList<BillVo> dTeamMonthSch(ArrayList<BillSch> sch) {
		init();
		System.out.println("�� dao�� dTeamMonthSch() ����");
		System.out.println("sch.get(0).steam : " + sch.get(0).steam);
		ArrayList<BillVo> res = new ArrayList<>();

		try {
			sql = "select pay_date, stadium, " + "sum(price), sum(nvl(refund_price,0)),"
					+ "sum(price-nvl(refund_price,0)), sum(price-nvl(refund_price,0))*0.9,"
					+ "sum(price-nvl(refund_price,0))*0.6, sum(price-nvl(refund_price,0))*0.2,"
					+ "sum(price-nvl(refund_price,0))*0.1, sum(price-nvl(refund_price,0))*0.1 "
					+ "from(select * from ticket3 where stadium = ?) " + "where pay_date between ? and ? "
					+ "group by pay_date, stadium order by pay_date desc";

			String firstDate = sch.get(0).year + "/" + sch.get(0).month + "/01";
			String lastDate = sch.get(1).year + "/" + sch.get(1).month + "/01";

			System.out.println("�۽�Ʈ����Ʈ : " + firstDate);
			System.out.println("��Ʈ����Ʈ :" + lastDate);

			stmt = con.prepareStatement(sql);
			stmt.setString(1, sch.get(0).steam);
			stmt.setString(2, firstDate);
			stmt.setString(3, lastDate);
			rs = stmt.executeQuery();

			while (rs.next()) {
				BillVo vo = new BillVo();
				vo.setBilldate(rs.getTimestamp(1));
				vo.setStadium(rs.getString(2));
				vo.setIncome(rs.getInt(3));
				vo.setRefund(rs.getInt(4));
				vo.setDeposit(rs.getInt(5));
				vo.setWithdraw(rs.getInt(6));
				vo.setHome(rs.getInt(7));
				vo.setAway(rs.getInt(8));
				vo.setKbo(rs.getInt(9));
				vo.setWe(rs.getInt(10));
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

	// ��� �ϴܺ� �˻����� : ��ü ����, Ư�� ��¥�� ���� �հ�
	// ��ȯ �� 10��
	public ArrayList<BillVo> teamAllYearSch(ArrayList<BillSch> sch) {
		init();
		System.out.println("�� dao�� teamAllMonthSch() ���� : ��ü ����, Ư�� ��¥�� ���� �հ�");
		ArrayList<BillVo> res = new ArrayList<>();

		try {

			sql = "select pay_date, stadium, " + "sum(price), sum(nvl(refund_price,0)),"
					+ "sum(price-nvl(refund_price,0)), sum(price-nvl(refund_price,0))*0.9,"
					+ "sum(price-nvl(refund_price,0))*0.6, sum(price-nvl(refund_price,0))*0.2,"
					+ "sum(price-nvl(refund_price,0))*0.1, sum(price-nvl(refund_price,0))*0.1 " + "from ticket3 "
					+ "where pay_date between ? and ? " + "group by pay_date, stadium order by pay_date desc";

			String firstDate = sch.get(0).year + "/01/01";
			String lastDate = sch.get(1).year + "/12/31";
			System.out.println("�۽�Ʈ����Ʈ : " + firstDate);
			System.out.println("��Ʈ����Ʈ : " + lastDate);

			stmt = con.prepareStatement(sql);
			stmt.setString(1, firstDate);
			stmt.setString(2, lastDate);
			rs = stmt.executeQuery();

			while (rs.next()) {
				BillVo vo = new BillVo();
				vo.setBilldate(rs.getTimestamp(1));
				vo.setStadium(rs.getString(2));
				vo.setIncome(rs.getInt(3));
				vo.setRefund(rs.getInt(4));
				vo.setDeposit(rs.getInt(5));
				vo.setWithdraw(rs.getInt(6));
				vo.setHome(rs.getInt(7));
				vo.setAway(rs.getInt(8));
				vo.setKbo(rs.getInt(9));
				vo.setWe(rs.getInt(10));
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

	// ��� �ϴܺ� �˻����� : Ư�� ���� , Ư�� ��¥�� ���� ��ȸ
	// ��ȯ �� 8��
	public ArrayList<BillVo> dTeamYearSch(ArrayList<BillSch> sch) {
		init();
		System.out.println("�� dao�� dTeamMonthSch() ����");
		System.out.println("sch.get(0).steam : " + sch.get(0).steam);
		ArrayList<BillVo> res = new ArrayList<>();

		try {
			sql = "select pay_date, stadium, " + "sum(price), sum(nvl(refund_price,0)),"
					+ "sum(price-nvl(refund_price,0)), sum(price-nvl(refund_price,0))*0.9,"
					+ "sum(price-nvl(refund_price,0))*0.6, sum(price-nvl(refund_price,0))*0.2,"
					+ "sum(price-nvl(refund_price,0))*0.1, sum(price-nvl(refund_price,0))*0.1 "
					+ "from(select * from ticket3 where stadium = ?) " + "where pay_date between ? and ? "
					+ "group by pay_date, stadium order by pay_date desc";

			String firstDate = sch.get(0).year + "/01/01";
			String lastDate = sch.get(1).year + "/12/31";

			System.out.println("�۽�Ʈ����Ʈ : " + firstDate);
			System.out.println("��Ʈ����Ʈ :" + lastDate);

			stmt = con.prepareStatement(sql);
			stmt.setString(1, sch.get(0).steam);
			stmt.setString(2, firstDate);
			stmt.setString(3, lastDate);
			rs = stmt.executeQuery();

			while (rs.next()) {
				BillVo vo = new BillVo();
				vo.setBilldate(rs.getTimestamp(1));
				vo.setStadium(rs.getString(2));
				vo.setIncome(rs.getInt(3));
				vo.setRefund(rs.getInt(4));
				vo.setDeposit(rs.getInt(5));
				vo.setWithdraw(rs.getInt(6));
				vo.setHome(rs.getInt(7));
				vo.setAway(rs.getInt(8));
				vo.setKbo(rs.getInt(9));
				vo.setWe(rs.getInt(10));
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