package baseball.bill.model;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import org.apache.ibatis.type.Alias;

//@Alias("bi")

//정산 버튼을 눌렀을 때 그 값들을 받아오는 vo
//ticketres 테이블의 money를 deposit이라는 변수로 받아와서 
//그것의 세터가 실행 될 때 퍼센트를 넣어줌
//그 계산된 값들을 정산 테이블에 넣어준다
public class BillVo {

	Date billdate;// 날짜
	String stadium;// 홈팀 구장명
	Integer income, refund, deposit, withdraw, // 총 구매수익, 환불금, 수입(총구매-환불),지출(배당금 우리 말고 나머지)
			home, away, kbo, we;// 배당금 : 홈 60 어웨이 20 kbo 10 우리 10


	public String strRegDate(Timestamp ts) {
		System.out.println("셋 레그데이트 진입하냐");
		return new SimpleDateFormat("yyyy-MM-dd").format(ts);
	}

	public void parseRegDate(String strRegDate) {
		try {
			this.billdate = new SimpleDateFormat("yyyy-MM-dd").parse(strRegDate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Date getBilldate() {
		return billdate;
	}

	public void setBilldate(Date billdate) {
		
		this.billdate = billdate;
	}

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	public Integer getIncome() {
		return income;
	}

	public void setIncome(Integer income) {
		this.income = income;
	}

	public Integer getRefund() {
		return refund;
	}

	public void setRefund(Integer refund) {
		this.refund = refund;
	}

	public Integer getDeposit() {
		return deposit;
	}

	public void setDeposit(Integer deposit) {
		this.deposit = deposit;
	}

	public Integer getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(Integer withdraw) {
		this.withdraw = withdraw;
	}

	public Integer getHome() {
		return home;
	}

	public void setHome(Integer home) {
		this.home = home;
	}

	public Integer getAway() {
		return away;
	}

	public void setAway(Integer away) {
		this.away = away;
	}

	public Integer getKbo() {
		return kbo;
	}

	public void setKbo(Integer kbo) {
		this.kbo = kbo;
	}

	public Integer getWe() {
		return we;
	}

	public void setWe(Integer we) {
		this.we = we;
	}

	public void calculate(int income, int refund) {
		this.income = income;
		this.refund = refund;
		this.deposit = income - refund;
		this.withdraw = (int) (deposit * 0.9);
		this.home = (int) (deposit * 0.6);
		this.away = (int) (deposit * 0.2);
		this.kbo = (int) (deposit * 0.1);
		this.we = (int) (deposit * 0.1);
	}

	@Override
	public String toString() {
		return "BillVo [billdate=" + billdate + ", stadium=" + stadium + ", income=" + income + ", refund=" + refund
				+ ", deposit=" + deposit + ", withdraw=" + withdraw + ", home=" + home + ", away=" + away + ", kbo="
				+ kbo + ", we=" + we + "]";
	}

//	@Override
//	public String toString() {
//		return "BillVo [billdate=" + billdate + ", stadium=" + stadium + ", income=" + income + ", refund=" + refund
//				+ ", deposit=" + deposit + ", withdraw=" + withdraw + ", home=" + home + ", away=" + away + ", kbo="
//				+ kbo + ", we=" + we + ", year1=" + year1 + ", month1=" + month1 + ", day1=" + day1 + ", year2=" + year2
//				+ ", month2=" + month2 + ", day2=" + day2 + ", steam=" + steam + "]";
//	}

	
	
}
