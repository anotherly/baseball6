package baseball.member.model;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Alias("mem")
public class MemberVo {

	/**
	 * @uml.property  name="file"
	 * @uml.associationEnd  
	 */
	MultipartFile file;
	
	/**
	 * @uml.property  name="userid"
	 */
	String userid;

	/**
	 * @uml.property  name="nick"
	 */
	String nick;

	/**
	 * @uml.property  name="name"
	 */
	String name;

	/**
	 * @uml.property  name="birth"
	 */
	String birth;

	/**
	 * @uml.property  name="address"
	 */
	String address;

	/**
	 * @uml.property  name="phone"
	 */
	String phone;

	/**
	 * @uml.property  name="receivemail"
	 */
	String receivemail;

	/**
	 * @uml.property  name="preferTeam"
	 */
	String preferTeam;

	/**
	 * @uml.property  name="password"
	 */
	String password;

	/**
	 * @uml.property  name="grade"
	 */
	String grade;

	/**
	 * @uml.property  name="sysname"
	 */
	String sysname;

	/**
	 * @uml.property  name="oriname"
	 */
	String oriname;

	
	/**
	 * @return
	 * @uml.property  name="grade"
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade
	 * @uml.property  name="grade"
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * @return
	 * @uml.property  name="sysname"
	 */
	public String getSysname() {
		return sysname;
	}

	/**
	 * @param sysname
	 * @uml.property  name="sysname"
	 */
	public void setSysname(String sysname) {
		this.sysname = sysname;
	}

	/**
	 * @return
	 * @uml.property  name="oriname"
	 */
	public String getOriname() {
		return oriname;
	}

	/**
	 * @param oriname
	 * @uml.property  name="oriname"
	 */
	public void setOriname(String oriname) {
		this.oriname = oriname;
	}

	/**
	 * @return
	 * @uml.property  name="file"
	 */
	public MultipartFile getFile() {
		return file;
	}
	/**
	 * @param file
	 * @uml.property  name="file"
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	/**
	 * @return
	 * @uml.property  name="userid"
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * @param userid
	 * @uml.property  name="userid"
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * @return
	 * @uml.property  name="nick"
	 */
	public String getNick() {
		return nick;
	}
	/**
	 * @param nick
	 * @uml.property  name="nick"
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}
	/**
	 * @return
	 * @uml.property  name="name"
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name
	 * @uml.property  name="name"
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return
	 * @uml.property  name="birth"
	 */
	public String getBirth() {
		return birth;
	}
	/**
	 * @param birth
	 * @uml.property  name="birth"
	 */
	public void setBirth(String birth) {
		this.birth = birth;
	}
	/**
	 * @return
	 * @uml.property  name="address"
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address
	 * @uml.property  name="address"
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return
	 * @uml.property  name="phone"
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone
	 * @uml.property  name="phone"
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return
	 * @uml.property  name="receivemail"
	 */
	public String getReceivemail() {
		return receivemail;
	}
	/**
	 * @param receivemail
	 * @uml.property  name="receivemail"
	 */
	public void setReceivemail(String receivemail) {
		this.receivemail = receivemail;
	}
	/**
	 * @return
	 * @uml.property  name="preferTeam"
	 */
	public String getPreferTeam() {
		return preferTeam;
	}
	/**
	 * @param preferTeam
	 * @uml.property  name="preferTeam"
	 */
	public void setPreferTeam(String preferTeam) {
		this.preferTeam = preferTeam;
	}
	/**
	 * @return
	 * @uml.property  name="password"
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password
	 * @uml.property  name="password"
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "MemberVo [file=" + file + ", userid=" + userid + ", nick=" + nick + ", name=" + name + ", birth="
				+ birth + ", address=" + address + ", phone=" + phone + ", receivemail=" + receivemail + ", preferTeam="
				+ preferTeam + ", password=" + password + ", grade=" + grade + ", sysname=" + sysname + ", oriname="
				+ oriname + "]";
	}
	
}
