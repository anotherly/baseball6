package baseball.schedule.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Alias("schevo")
public class ScheduleVo {

	String  yoil, game_time,
	 home_img, away_img, channel,
	 away, home,  stadium, status,
	 winPitcher, losePitcher, holdPitcher, savePitcher;
	Integer away_r, home_r, year, month, day,game_num,away_score, home_score; 
	
	
	
	
	public Integer getAway_r() {
		return away_r;
	}
	public void setAway_r(Integer away_r) {
		this.away_r = away_r;
	}
	public Integer getHome_r() {
		return home_r;
	}
	public void setHome_r(Integer home_r) {
		this.home_r = home_r;
	}
	public String getWinPitcher() {
		return winPitcher;
	}
	public void setWinPitcher(String winPitcher) {
		this.winPitcher = winPitcher;
	}
	public String getLosePitcher() {
		return losePitcher;
	}
	public void setLosePitcher(String losePitcher) {
		this.losePitcher = losePitcher;
	}
	public String getHoldPitcher() {
		return holdPitcher;
	}
	public void setHoldPitcher(String holdPitcher) {
		this.holdPitcher = holdPitcher;
	}
	public String getSavePitcher() {
		return savePitcher;
	}
	public void setSavePitcher(String savePitcher) {
		this.savePitcher = savePitcher;
	}
	public String getGame_time() {
		return game_time;
	}
	public void setGame_time(String game_time) {
		this.game_time = game_time;
	}
	public String getYoil() {
		return yoil;
	}
	public void setYoil(String yoil) {
		this.yoil = yoil;
	}
	public String getHome_img() {
		return home_img;
	}
	public void setHome_img(String home_img) {
		this.home_img = home_img;
	}
	public String getAway_img() {
		return away_img;
	}
	public void setAway_img(String away_img) {
		this.away_img = away_img;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getAway() {
		return away;
	}
	public void setAway(String away) {
		this.away = away;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getStadium() {
		return stadium;
	}
	public void setStadium(String stadium) {
		this.stadium = stadium;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public Integer getGame_num() {
		return game_num;
	}
	public void setGame_num(Integer game_num) {
		this.game_num = game_num;
	}
	public Integer getAway_score() {
		return away_score;
	}
	public void setAway_score(Integer away_score) {
		this.away_score = away_score;
	}
	public Integer getHome_score() {
		return home_score;
	}
	public void setHome_score(Integer home_score) {
		this.home_score = home_score;
	}
	@Override
	public String toString() {
		return "ScheduleVo [yoil=" + yoil + ", game_time=" + game_time + ", home_img=" + home_img + ", away_img="
				+ away_img + ", channel=" + channel + ", away=" + away + ", home=" + home + ", stadium=" + stadium
				+ ", status=" + status + ", winPitcher=" + winPitcher + ", losePitcher=" + losePitcher
				+ ", holdPitcher=" + holdPitcher + ", savePitcher=" + savePitcher + ", away_r=" + away_r + ", home_r="
				+ home_r + ", year=" + year + ", month=" + month + ", day=" + day + ", game_num=" + game_num
				+ ", away_score=" + away_score + ", home_score=" + home_score + "]";
	}
	
	
	
	
	

	


}
