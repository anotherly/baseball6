package baseball.ticket.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("ticketReservation")
public class TicketResVo {

	/**
	 * @uml.property  name="stadium"
	 */
	String stadium;

	/**
	 * @uml.property  name="user_name"
	 */
	String user_name;

	/**
	 * @uml.property  name="user_phone"
	 */
	String user_phone;

	/**
	 * @uml.property  name="money"
	 */
	String money;

	/**
	 * @uml.property  name="user_id"
	 */
	String user_id;
	
	/**
	 * @uml.property  name="payday"
	 */
	Date payday;

	
	
	/**
	 * @return
	 * @uml.property  name="stadium"
	 */
	public String getStadium() {
		return stadium;
	}

	/**
	 * @param stadium
	 * @uml.property  name="stadium"
	 */
	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	/**
	 * @return
	 * @uml.property  name="payday"
	 */
	public Date getPayday() {
		return payday;
	}

	/**
	 * @param payday
	 * @uml.property  name="payday"
	 */
	public void setPayday(Date payday) {
		this.payday = payday;
	}

	/**
	 * @return
	 * @uml.property  name="user_id"
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id
	 * @uml.property  name="user_id"
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	/**
	 * @return
	 * @uml.property  name="user_name"
	 */
	public String getUser_name() {
		return user_name;
	}

	/**
	 * @param user_name
	 * @uml.property  name="user_name"
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/**
	 * @return
	 * @uml.property  name="user_phone"
	 */
	public String getUser_phone() {
		return user_phone;
	}

	/**
	 * @param user_phone
	 * @uml.property  name="user_phone"
	 */
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	/**
	 * @return
	 * @uml.property  name="money"
	 */
	public String getMoney() {
		return money;
	}

	/**
	 * @param money
	 * @uml.property  name="money"
	 */
	public void setMoney(String money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "TicketResVo [stadium=" + stadium + ", user_name=" + user_name + ", user_phone=" + user_phone
				+ ", money=" + money + ", user_id=" + user_id + ", payday=" + payday + "]";
	}

}