package baseball.player.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("psvo")
public class PlayerStatVo {

	String  teamId,  playerName, positionToday, playerId; //�����⺻����
			
	Integer statnum, game_num, year, month, day,	
	g, gs, inn, tc, po, a, e, dp,  rf,//������ǥ
	ab, r, h, twoBase, thirdBase, hr, rbi, bb, so, sb, cs,  //Ÿ����ǥ
	w, l, hold, era, sv, svo, ip, pitcherH, pitcherR, er,
	pitcherHr, pitcherBb, pitcherSo ;//������ǥ;
	Date regDate;
	
	Float avg, obp, slg, ops, pitcherAvg, whip, fpct;
	
	
	
	
	
	
	public Integer getStatnum() {
		return statnum;
	}
	public void setStatnum(Integer statnum) {
		this.statnum = statnum;
	}
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
	public String getPositionToday() {
		return positionToday;
	}
	public void setPositionToday(String positionToday) {
		this.positionToday = positionToday;
	}
	public Integer getGame_num() {
		return game_num;
	}
	public void setGame_num(Integer game_num) {
		this.game_num = game_num;
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
	
	public String getPlayerId() {
		return playerId;
	}
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
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
	
	public Float getAvg() {
		return avg;
	}
	public void setAvg(Float avg) {
		String.format("%.2f", avg);
		this.avg = avg;
	}
	public Float getObp() {
		return obp;
	}
	public void setObp(Float obp) {
		String.format("%.2f", obp);
		this.obp = obp;
	}
	public Float getSlg() {
		return slg;
	}
	public void setSlg(Float slg) {
		this.slg = slg;
	}
	public Float getOps() {
		return ops;
	}
	public void setOps(Float ops) {
		this.ops = ops;
	}
	public Float getPitcherAvg() {
		String.format("%.2f", pitcherAvg);
		System.out.println("????"+pitcherAvg);
		return pitcherAvg;
	}
	public void setPitcherAvg(Float pitcherAvg) {
	
		this.pitcherAvg = pitcherAvg;
	}
	public Float getWhip() {
		return whip;
	}
	public void setWhip(Float whip) {
		this.whip = whip;
	}
	public Float getFpct() {
		System.out.println("����");
		return fpct;
	}
	public void setFpct(Float fpct) {
		this.fpct = fpct;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "PlayerStatVo [teamId=" + teamId + ", playerName=" + playerName + ", positionToday=" + positionToday
				+ ", playerId=" + playerId + ", statnum=" + statnum + ", game_num=" + game_num + ", year=" + year
				+ ", month=" + month + ", day=" + day + ", g=" + g + ", gs=" + gs + ", inn=" + inn + ", tc=" + tc
				+ ", po=" + po + ", a=" + a + ", e=" + e + ", dp=" + dp + ", fpct=" + fpct + ", rf=" + rf + ", ab=" + ab
				+ ", r=" + r + ", h=" + h + ", twoBase=" + twoBase + ", thirdBase=" + thirdBase + ", hr=" + hr
				+ ", rbi=" + rbi + ", bb=" + bb + ", so=" + so + ", sb=" + sb + ", cs=" + cs + ", avg=" + avg + ", obp="
				+ obp + ", slg=" + slg + ", ops=" + ops + ", w=" + w + ", l=" + l + ", hold=" + hold + ", era=" + era
				+ ", sv=" + sv + ", svo=" + svo + ", ip=" + ip + ", pitcherH=" + pitcherH + ", pitcherR=" + pitcherR
				+ ", er=" + er + ", pitcherHr=" + pitcherHr + ", pitcherBb=" + pitcherBb + ", pitcherSo=" + pitcherSo
				+ ", pitcherAvg=" + pitcherAvg + ", whip=" + whip + ", regDate=" + regDate + "]";
	}
	
	

	
}
