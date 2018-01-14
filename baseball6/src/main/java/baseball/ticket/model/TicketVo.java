package baseball.ticket.model;

import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("ticketinformation")
public class TicketVo {

   /**
    * @uml.property  name="stadium"
    */
   String stadium;
   /**
    * @uml.property  name="seat"
    */
   String seat;
   /**
    * @uml.property  name="ticketinfo"
    */
   String ticketinfo;
   /**
    * @uml.property  name="listt"
    */
   String listt;
   /**
    * @uml.property  name="line"
    */
   String line;
   /**
    * @uml.property  name="paid"
    */
   Integer paid;
   /**
    * @uml.property  name="userid"
    */
   String userid;
   /**
    * @uml.property  name="match_year"
    */
   Integer match_year;
   /**
    * @uml.property  name="match_month"
    */
   Integer match_month;
   /**
    * @uml.property  name="match_day"
    */
   Integer match_day;
   /**
    * @uml.property  name="price"
    */
   Integer price;
   /**
    * @uml.property  name="pay_date"
    */
   Date pay_date;
   /**
    * @uml.property  name="refund_date"
    */
   Date refund_date;
   
   int refund_price;

   public int getRefund_price() {
      Date today = new Date();
      Date game = new Date(match_year-1900, match_month-1, match_day);

      long days = (game.getTime()-today.getTime()) / (24 * 60 * 60 * 1000);
      
      if(days>=3) {
         refund_price = price;
      }else if(days<3 &&
            days>=2){
         refund_price = price * 9/10;
      }else if(2>days&&
            days>=1) {
         refund_price = price * 8/10;
      }else {
         refund_price = 0;
      }
      return refund_price;
   }
   
   public void setRefund_price(int refund_price) {
      this.refund_price = refund_price;
   }

   public boolean isCancel() {
      
      Date today = new Date();
      Date game = new Date(match_year-1900, match_month-1, match_day);
      
      return today.getTime()+1<game.getTime();
   }

   /**
    * @uml.property  name="reallist"
    */
   ArrayList<TicketVo> reallist;
   
   /**
    * @return
    * @uml.property  name="refund_date"
    */
   public Date getRefund_date() {
      return refund_date;
   }

   /**
    * @param refund_date
    * @uml.property  name="refund_date"
    */
   public void setRefund_date(Date refund_date) {
      this.refund_date = refund_date;
   }

   /**
    * @return
    * @uml.property  name="pay_date"
    */
   public Date getPay_date() {
      return pay_date;
   }

   /**
    * @param pay_date
    * @uml.property  name="pay_date"
    */
   public void setPay_date(Date pay_date) {
      this.pay_date = pay_date;
   }

   /**
    * @return
    * @uml.property  name="price"
    */
   public Integer getPrice() {
      return price;
   }

   /**
    * @param price
    * @uml.property  name="price"
    */
   public void setPrice(Integer price) {
      this.price = price;
   }

   /**
    * @return
    * @uml.property  name="match_year"
    */
   public Integer getMatch_year() {
      return match_year;
   }

   /**
    * @param match_year
    * @uml.property  name="match_year"
    */
   public void setMatch_year(Integer match_year) {
      this.match_year = match_year;
   }

   /**
    * @return
    * @uml.property  name="match_month"
    */
   public Integer getMatch_month() {
      return match_month;
   }

   /**
    * @param match_month
    * @uml.property  name="match_month"
    */
   public void setMatch_month(Integer match_month) {
      this.match_month = match_month;
   }

   /**
    * @return
    * @uml.property  name="match_day"
    */
   public Integer getMatch_day() {
      return match_day;
   }

   /**
    * @param match_day
    * @uml.property  name="match_day"
    */
   public void setMatch_day(Integer match_day) {
      this.match_day = match_day;
   }



   /**
    * @return
    * @uml.property  name="paid"
    */
   public Integer getPaid() {
      return paid;
   }

   /**
    * @param paid
    * @uml.property  name="paid"
    */
   public void setPaid(Integer paid) {
      this.paid = paid;
   }

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
    * @uml.property  name="seat"
    */
   public String getSeat() {
      return seat;
   }

   /**
    * @param seat
    * @uml.property  name="seat"
    */
   public void setSeat(String seat) {
      this.seat = seat;
   }

   /**
    * @return
    * @uml.property  name="ticketinfo"
    */
   public String getTicketinfo() {
      return ticketinfo;
   }

   /**
    * @param ticketinfo
    * @uml.property  name="ticketinfo"
    */
   public void setTicketinfo(String ticketinfo) {
      this.ticketinfo = ticketinfo;
   }

   /**
    * @return
    * @uml.property  name="listt"
    */
   public String getListt() {
      return listt;
   }

   /**
    * @param listt
    * @uml.property  name="listt"
    */
   public void setListt(String listt) {
      this.listt = listt;
   }

   /**
    * @return
    * @uml.property  name="line"
    */
   public String getLine() {
      return line;
   }

   /**
    * @param line
    * @uml.property  name="line"
    */
   public void setLine(String line) {
      this.line = line;
   }


   public ArrayList<TicketVo> getReallist() {
      return reallist;
   }

   public void setReallist(ArrayList<TicketVo> reallist) {
      this.reallist = reallist;
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

   @Override
   public String toString() {
      return "TicketVo [stadium=" + stadium + ", seat=" + seat + ", ticketinfo=" + ticketinfo + ", listt=" + listt
            + ", line=" + line + ", paid=" + paid + ", userid=" + userid + ", match_year=" + match_year
            + ", match_month=" + match_month + ", match_day=" + match_day + ", price=" + price + ", reallist="
            + reallist + "]";
   }


   
   
      
} 
 