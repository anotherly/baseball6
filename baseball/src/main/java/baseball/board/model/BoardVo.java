package baseball.board.model;

import java.sql.Date;
import java.util.ArrayList;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Alias("boa")
public class BoardVo {
	/**
	 * @uml.property  name="file"
	 * @uml.associationEnd  
	 */
	MultipartFile file;
	int boardid;
	int gid;
	int cnt=-1;

	/**
	 * @uml.property  name="title"
	 */
	String title;
	/**
	 * @uml.property  name="content"
	 */
	String content;
	/**
	 * @uml.property  name="userid"
	 */
	String userid;
	/**
	 * @uml.property  name="category1"
	 */
	String category1;
	/**
	 * @uml.property  name="category2"
	 */
	String category2;
	/**
	 * @uml.property  name="receiver"
	 */
	String receiver;
	/**
	 * @uml.property  name="oriname"
	 */
	String oriname;
	/**
	 * @uml.property  name="sysname"
	 */
	String sysname;
	
	/**
	 * @uml.property  name="moddate"
	 */
	Date Moddate;
	/**
	 * @uml.property  name="regdate"
	 */
	Date regdate;
	
	/**
	 * @return
	 * @uml.property  name="regdate"
	 */
	public Date getRegdate() {
		return regdate;
	}
	/**
	 * @return
	 * @uml.property  name="gid"
	 */
	public int getGid() {
		return gid;
	}
	/**
	 * @param gid
	 * @uml.property  name="gid"
	 */
	public void setGid(int gid) {
		this.gid = gid;
	}
	/**
	 * @return
	 * @uml.property  name="moddate"
	 */
	public Date getModdate() {
		return Moddate;
	}
	/**
	 * @param moddate
	 * @uml.property  name="moddate"
	 */
	public void setModdate(Date moddate) {
		Moddate = moddate;
	}
	/**
	 * @param regdate
	 * @uml.property  name="regdate"
	 */
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	/**
	 * @return
	 * @uml.property  name="boardid"
	 */
	public int getBoardid() {
		return boardid;
	}
	/**
	 * @param boardid
	 * @uml.property  name="boardid"
	 */
	public void setBoardid(int boardid) {
		this.boardid = boardid;
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
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getTitle() {
		return title;
	}
	/**
	 * @param title
	 * @uml.property  name="title"
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return
	 * @uml.property  name="content"
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content
	 * @uml.property  name="content"
	 */
	public void setContent(String content) {
		this.content = content;
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
	 * @uml.property  name="category2"
	 */
	public String getCategory2() {
		return category2;
	}
	/**
	 * @param category2
	 * @uml.property  name="category2"
	 */
	public void setCategory2(String category2) {
		this.category2 = category2;
	}
	/**
	 * @return
	 * @uml.property  name="receiver"
	 */
	public String getReceiver() {
		return receiver;
	}
	/**
	 * @param receiver
	 * @uml.property  name="receiver"
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
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
	 * @uml.property  name="category1"
	 */
	public String getCategory1() {
		return category1;
	}
	/**
	 * @param category1
	 * @uml.property  name="category1"
	 */
	public void setCategory1(String category1) {
		this.category1 = category1;
	}
	
}
