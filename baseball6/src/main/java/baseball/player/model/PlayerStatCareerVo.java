package baseball.player.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Alias("pscvo")
public class PlayerStatCareerVo {

	String teamId, playerName, position,positionToday, juPosition, playerId; // 선수기본정보
			
			
	Integer game_num, statnum, year, month, day,
	g, gs, inn, tc, po, a, e, dp,  rf, // 수비지표
	ab, r, h, twoBase, thirdBase, hr, rbi, bb, so, sb, cs,// 타자지표
	w, l, hold, era, sv, svo, ip, pitcherH, pitcherR, er, pitcherHr, pitcherBb, pitcherSo;// 투수지표
	Date regDate;
	Float avg, obp, slg, ops, pitcherAvg, whip, fpct;
	//---------teamvo----------
	String teamName, office, tel, homepage;
	Integer teamBirth, win, lose, draw, game;
	String home, owner, president, captin, manager, sysFile, oriFile;
	MultipartFile ff;
	Float winPer, cha;
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPositionToday() {
		return positionToday;
	}
	public void setPositionToday(String positionToday) {
		this.positionToday = positionToday;
	}
	public String getJuPosition() {
		return juPosition;
	}
	public void setJuPosition(String juPosition) {
		this.juPosition = juPosition;
	}
	public String getPlayerId() {
		return playerId;
	}
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}
	public Integer getGame_num() {
		return game_num;
	}
	public void setGame_num(Integer game_num) {
		this.game_num = game_num;
	}
	public Integer getStatnum() {
		return statnum;
	}
	public void setStatnum(Integer statnum) {
		this.statnum = statnum;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public Integer getG() {
		return g;
	}
	public void setG(Integer g) {
		this.g = g;
	}
	public Integer getGs() {
		return gs;
	}
	public void setGs(Integer gs) {
		this.gs = gs;
	}
	public Integer getInn() {
		return inn;
	}
	public void setInn(Integer inn) {
		this.inn = inn;
	}
	public Integer getTc() {
		return tc;
	}
	public void setTc(Integer tc) {
		this.tc = tc;
	}
	public Integer getPo() {
		return po;
	}
	public void setPo(Integer po) {
		this.po = po;
	}
	public Integer getA() {
		return a;
	}
	public void setA(Integer a) {
		this.a = a;
	}
	public Integer getE() {
		return e;
	}
	public void setE(Integer e) {
		this.e = e;
	}
	public Integer getDp() {
		return dp;
	}
	public void setDp(Integer dp) {
		this.dp = dp;
	}
	public Integer getRf() {
		return rf;
	}
	public void setRf(Integer rf) {
		this.rf = rf;
	}
	public Integer getAb() {
		return ab;
	}
	public void setAb(Integer ab) {
		this.ab = ab;
	}
	public Integer getR() {
		return r;
	}
	public void setR(Integer r) {
		this.r = r;
	}
	public Integer getH() {
		return h;
	}
	public void setH(Integer h) {
		this.h = h;
	}
	public Integer getTwoBase() {
		return twoBase;
	}
	public void setTwoBase(Integer twoBase) {
		this.twoBase = twoBase;
	}
	public Integer getThirdBase() {
		return thirdBase;
	}
	public void setThirdBase(Integer thirdBase) {
		this.thirdBase = thirdBase;
	}
	public Integer getHr() {
		return hr;
	}
	public void setHr(Integer hr) {
		this.hr = hr;
	}
	public Integer getRbi() {
		return rbi;
	}
	public void setRbi(Integer rbi) {
		this.rbi = rbi;
	}
	public Integer getBb() {
		return bb;
	}
	public void setBb(Integer bb) {
		this.bb = bb;
	}
	public Integer getSo() {
		return so;
	}
	public void setSo(Integer so) {
		this.so = so;
	}
	public Integer getSb() {
		return sb;
	}
	public void setSb(Integer sb) {
		this.sb = sb;
	}
	public Integer getCs() {
		return cs;
	}
	public void setCs(Integer cs) {
		this.cs = cs;
	}
	public Integer getW() {
		return w;
	}
	public void setW(Integer w) {
		this.w = w;
	}
	public Integer getL() {
		return l;
	}
	public void setL(Integer l) {
		this.l = l;
	}
	public Integer getHold() {
		return hold;
	}
	public void setHold(Integer hold) {
		this.hold = hold;
	}
	public Integer getEra() {
		return era;
	}
	public void setEra(Integer era) {
		this.era = era;
	}
	public Integer getSv() {
		return sv;
	}
	public void setSv(Integer sv) {
		this.sv = sv;
	}
	public Integer getSvo() {
		return svo;
	}
	public void setSvo(Integer svo) {
		this.svo = svo;
	}
	public Integer getIp() {
		return ip;
	}
	public void setIp(Integer ip) {
		this.ip = ip;
	}
	public Integer getPitcherH() {
		return pitcherH;
	}
	public void setPitcherH(Integer pitcherH) {
		this.pitcherH = pitcherH;
	}
	public Integer getPitcherR() {
		return pitcherR;
	}
	public void setPitcherR(Integer pitcherR) {
		this.pitcherR = pitcherR;
	}
	public Integer getEr() {
		return er;
	}
	public void setEr(Integer er) {
		this.er = er;
	}
	public Integer getPitcherHr() {
		return pitcherHr;
	}
	public void setPitcherHr(Integer pitcherHr) {
		this.pitcherHr = pitcherHr;
	}
	public Integer getPitcherBb() {
		return pitcherBb;
	}
	public void setPitcherBb(Integer pitcherBb) {
		this.pitcherBb = pitcherBb;
	}
	public Integer getPitcherSo() {
		return pitcherSo;
	}
	public void setPitcherSo(Integer pitcherSo) {
		this.pitcherSo = pitcherSo;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Float getAvg() {
String a = String.format("%.3f", avg);
		
		Float avg = Float.parseFloat(a);
		return avg;
	}
	public void setAvg(Float avg) {
		this.avg = avg;
	}
	public Float getObp() {
String a = String.format("%.3f", obp);
		
		Float obp = Float.parseFloat(a);
		return obp;
	}
	public void setObp(Float obp) {
		this.obp = obp;
	}
	public Float getSlg() {
String a = String.format("%.3f", slg);
		
		Float slg = Float.parseFloat(a);
		return slg;
	}
	public void setSlg(Float slg) {
		this.slg = slg;
	}
	public Float getOps() {
String a = String.format("%.3f", ops);
		
		Float ops = Float.parseFloat(a);
		return ops;
	}
	public void setOps(Float ops) {
		this.ops = ops;
	}
	public Float getPitcherAvg() {
String a = String.format("%.3f", pitcherAvg);
		
		Float pitcherAvg = Float.parseFloat(a);
		return pitcherAvg;
	}
	public void setPitcherAvg(Float pitcherAvg) {
		this.pitcherAvg = pitcherAvg;
	}
	public Float getWhip() {
		String a = String.format("%.3f", whip);
		
		Float whip = Float.parseFloat(a);
		
		return whip;
	}
	public void setWhip(Float whip) {
		
		this.whip = whip;
	}
	public Float getFpct() {
String a = String.format("%.3f", fpct);
		
		Float fpct = Float.parseFloat(a);
		return fpct;
	}
	public void setFpct(Float fpct) {
		this.fpct = fpct;
	}
	public String getTeamName() {
		return teamName;
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
	public Integer getLose() {
		return lose;
	}
	public void setLose(Integer lose) {
		this.lose = lose;
	}
	public Integer getDraw() {
		return draw;
	}
	public void setDraw(Integer draw) {
		this.draw = draw;
	}
	public Integer getGame() {
		return game;
	}
	public void setGame(Integer game) {
		this.game = game;
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
	public MultipartFile getFf() {
		return ff;
	}
	public void setFf(MultipartFile ff) {
		this.ff = ff;
	}
	public Float getWinPer() {
String a = String.format("%.3f", winPer);
		
		Float winPer = Float.parseFloat(a);
		return winPer;
	}
	public void setWinPer(Float winPer) {
		this.winPer = winPer;
	}
	public Float getCha() {
String a = String.format("%.1f", cha);
		
		Float cha = Float.parseFloat(a);
		return cha;
	}
	public void setCha(Float cha) {
		this.cha = cha;
	}
	@Override
	public String toString() {
		return "PlayerStatCareerVo [teamId=" + teamId + ", playerName=" + playerName + ", position=" + position
				+ ", positionToday=" + positionToday + ", juPosition=" + juPosition + ", playerId=" + playerId
				+ ", game_num=" + game_num + ", statnum=" + statnum + ", year=" + year + ", month=" + month + ", day="
				+ day + ", g=" + g + ", gs=" + gs + ", inn=" + inn + ", tc=" + tc + ", po=" + po + ", a=" + a + ", e="
				+ e + ", dp=" + dp + ", rf=" + rf + ", ab=" + ab + ", r=" + r + ", h=" + h + ", twoBase=" + twoBase
				+ ", thirdBase=" + thirdBase + ", hr=" + hr + ", rbi=" + rbi + ", bb=" + bb + ", so=" + so + ", sb="
				+ sb + ", cs=" + cs + ", w=" + w + ", l=" + l + ", hold=" + hold + ", era=" + era + ", sv=" + sv
				+ ", svo=" + svo + ", ip=" + ip + ", pitcherH=" + pitcherH + ", pitcherR=" + pitcherR + ", er=" + er
				+ ", pitcherHr=" + pitcherHr + ", pitcherBb=" + pitcherBb + ", pitcherSo=" + pitcherSo + ", regDate="
				+ regDate + ", avg=" + avg + ", obp=" + obp + ", slg=" + slg + ", ops=" + ops + ", pitcherAvg="
				+ pitcherAvg + ", whip=" + whip + ", fpct=" + fpct + ", teamName=" + teamName + ", office=" + office
				+ ", tel=" + tel + ", homepage=" + homepage + ", teamBirth=" + teamBirth + ", win=" + win + ", lose="
				+ lose + ", draw=" + draw + ", game=" + game + ", home=" + home + ", owner=" + owner + ", president="
				+ president + ", captin=" + captin + ", manager=" + manager + ", sysFile=" + sysFile + ", oriFile="
				+ oriFile + ", ff=" + ff + ", winPer=" + winPer + ", cha=" + cha + "]";
	}
	
	
	
	
	
}
