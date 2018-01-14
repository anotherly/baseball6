package baseball.team.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Alias("tvo")
public class TeamVo {

	String teamName,office,tel,homepage,teamId;
	Integer teamBirth,win;
	String home,owner, president, captin, manager,sysFile, oriFile;
	MultipartFile ff;
	String upfile;
	//HttpServletRequest request;  mapping에서 자동으로 주지 못한다.
	
	public String getTeamName() {
		return teamName;
	}
	public String getTeamId() {
		return teamId;
	}
	
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	
	public Integer getTeamBirth() {
		return teamBirth;
	}
	public void setTeamBirth(Integer teamBirth) {
		this.teamBirth = teamBirth;
	}
	public Integer getWin() {
		return win;
	}
	public void setWin(Integer win) {
		this.win = win;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getPresident() {
		return president;
	}
	public void setPresident(String president) {
		this.president = president;
	}
	public String getCaptin() {
		return captin;
	}
	public void setCaptin(String captin) {
		this.captin = captin;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	

	public MultipartFile getFf() {
		System.out.println("겟파일");
		return ff;
	}
	
	public void setFf(MultipartFile ff) {
		System.out.println("셋파일"+ff.getOriginalFilename());
		this.ff = ff;
	}

	public String getSysFile() {
		return sysFile;
	}

	public void setSysFile(String sysFile) {
		this.sysFile = sysFile;
	}

	public String getOriFile() {
		return oriFile;
	}

	public void setOriFile(String oriFile) {
		this.oriFile = oriFile;
	}

	public String getUpfile() {
		System.out.println("getUpfile메소드에서 업파일값 : "+upfile);
		return upfile;
	}
	
	public String getUpfileEnc() {
		String res = upfile;
		System.out.println("겟업파일enc에서 upfile값 : "+res);
		try {
			 res = URLEncoder.encode(upfile,"utf-8");
			 System.out.println("url인코더 한 upfile값 : "+res);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public void setUpfile(String upfile) {
		this.upfile = upfile;
		System.out.println("setUpfile메소드에서 this와 받아온값 : "+upfile);
	}
	
	public boolean isImg()
	{
		String ext = upfile.toLowerCase().substring(upfile.lastIndexOf(".")+1);
		
		ArrayList<String> list = new ArrayList<>();
		
		list.add("png");
		list.add("gif");
		list.add("bmp");
		list.add("jpg");
		list.add("jpeg");
		
		return list.contains(ext);
		
	}
	@Override
	public String toString() {
		return "TeamVo [teamName=" + teamName + ", office=" + office + ", tel=" + tel + ", homepage=" + homepage
				+ ", teamId=" + teamId + ", teamBirth=" + teamBirth + ", win=" + win + ", home=" + home + ", owner="
				+ owner + ", president=" + president + ", captin=" + captin + ", manager=" + manager + ", sysFile="
				+ sysFile + ", oriFile=" + oriFile + ", ff=" + ff + ", upfile=" + upfile + "]";
	}

}