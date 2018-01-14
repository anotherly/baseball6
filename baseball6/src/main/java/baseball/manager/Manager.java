package baseball.manager;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import baseball.bill.Bill;
import baseball.bill.model.BillVo;
import baseball.controller.SubControll;
import baseball.member.Member;
import baseball.member.model.MemberRepository;
import baseball.member.model.MemberVo;
import baseball.model.PathData;

import baseball.team.model.TeamVo;
import baseball.ticket.Ticket;
import baseball.ticket.model.TicketVo;
@Service
public class Manager implements SubControll{

	@Resource
	PathData data;

	@Resource
	MemberRepository mdao;

	BillVo bvo;
	MemberVo mvo;
	TeamVo tvo;
	TicketVo tivo;
	
	Bill bil = new Bill();
	Member mem = new Member();
	Ticket tic = new Ticket();
	
	@Override
	public void execute() {
		
		System.out.println("+++++++++++++++++관리자 클래스 진입성공의 data:" + data);

		
		System.out.println(data.getCate1());
		System.out.println("data.getService() : "+data.getService());
		
		switch (data.getCate1()) {
		
		case "bill":
			
			switch (data.getService()) {
//////////////////장부관리////////////////////
			case "first":
				billFirst();
				break;
			
			case "weekBill":
				billWeekBill();
				break;
			
			case "monthBill":
				billMonthBill();
				break;
			}
//////////////////회원관리////////////////////
		case "member":
			mvo = (MemberVo) data.getDd();
			System.out.println("관리자가 보는 vo값: " + mvo);

			switch (data.getService()) {
			case "first":
				memberFirst();
				break;
			
			case "detail":
				data.setDd(mdao.detail(mvo));
				break;
				
			case "delete":
				mem.delete();
				break;
			
			
			case "mailReg":
				System.out.println("관리자케이스 메일 레그");
				break;
			}
		
//////////////////팀관리////////////////////
		case "team":

			switch (data.getService()) {
			
			case "first":
				
				break;
			}
//////////////////티켓관리////////////////////
		case "ticket":

			switch (data.getService()) {
			case "first":
				break;
			}
		}//switch
		
	}//execute
	
	private void memberModify() {
		
	}

	private void memberDetail() {
		
	}

	//////////////////장부관리////////////////////
	private void billFirst() {
		
	}
	
	private void billMonthBill() {
		
	}
	
	private void billWeekBill() {
		
	}
	
//////////////////회원관리////////////////////
	private void memberFirst() {
		System.out.println("관리자클래스.멤버퍼스트 메소드");
		data.setDd(mdao.list());
//		return "redirect:manager/manageMember/first";
	}
	
//	private void memberDelelte() {
//		
//	}
//	
//	private void memberModify() {
//		
//	}
	
//////////////////팀 관리////////////////////
	private void teamFirst() {
		
	}
//////////////////예매 관리////////////////////
	private void ticketBill() {
		
	}

	
}//class
