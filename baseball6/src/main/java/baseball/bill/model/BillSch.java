package baseball.bill.model;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestParam;

public class BillSch {

	Integer year,month,day;
	String steam;
	
	ArrayList<BillSch> list;



	public String getSteam() {
		System.out.println("�� ���� : "+steam);
		return steam;
	}

	public void setSteam(String steam) {
		System.out.println("�� ���� : "+steam);
		this.steam = steam;
	}

	public ArrayList<BillSch> getList() {
		return list;
	}

	public void setList(ArrayList<BillSch> list) {
		this.list = list;
	}

	public Integer getYear() {
		System.out.println("���̾� : "+year);
		return year;
	}
	
	public void setYear(Integer year) {
		System.out.println("���̾� : "+year);
		this.year = year;
	}

	public Integer getMonth() {
		System.out.println("�ٸս� : "+month);
		return month;
	}

	public void setMonth(Integer month) {
		System.out.println("�¸ս� : "+month);
		this.month = month;
	}

	public Integer getDay() {
		System.out.println("�ٵ��� : "+day);
		return day;
	}

	public void setDay(Integer day) {
		System.out.println("�µ��� : "+day);
		this.day = day;
	}

	@Override
	public String toString() {
		return "BillSch [year=" + year + ", month=" + month + ", day=" + day + ", steam=" + steam + ", list=" + list
				+ "]";
	}
	
}
