package baseball.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import baseball.member.model.MemberVo;

@Alias("boa2")
@Component
public class PathData {

   String cate1, cate2, service, path, serviceTemp, cate1Temp;

   Object dd, dd2, dd3, dd4,dd5, 
   home1, home2, home3, home4, home5, home6, home7, home8, home9;

   ArrayList<Menu> topMenu, subMenu, topMenu2, subMenu2, loginMenu, managerMenu;

   HttpServletRequest request;

   int limit = 5, pageLimit = 5;

   int nowPage = 1;

   int total;

   boolean redirect;// 현재 로그인한 사용자가 관리자인지 아닌지 판단여부

   
   
   
   public Object getDd5() {
      return dd5;
   }

   public void setDd5(Object dd5) {
      this.dd5 = dd5;
   }

   public Object getHome9() {
      return home9;
   }

   public void setHome9(Object home9) {
      this.home9 = home9;
   }

   public Object getHome5() {
      return home5;
   }

   public void setHome5(Object home5) {
      this.home5 = home5;
   }

   public Object getHome6() {
      return home6;
   }

   public void setHome6(Object home6) {
      this.home6 = home6;
   }

   public Object getHome7() {
      return home7;
   }

   public void setHome7(Object home7) {
      this.home7 = home7;
   }

   public Object getHome8() {
      return home8;
   }

   public void setHome8(Object home8) {
      this.home8 = home8;
   }

   public Object getHome1() {
      return home1;
   }

   public void setHome1(Object home1) {
      this.home1 = home1;
   }

   public Object getHome2() {
      return home2;
   }

   public void setHome2(Object home2) {
      this.home2 = home2;
   }

   public Object getHome3() {
      return home3;
   }

   public void setHome3(Object home3) {
      this.home3 = home3;
   }

   public Object getHome4() {
      return home4;
   }

   public void setHome4(Object home4) {
      this.home4 = home4;
   }

   public Object getDd4() {
      return dd4;
   }

   public void setDd4(Object dd4) {
      this.dd4 = dd4;
   }

   public int getStartPage() {
      return (nowPage - 1) / pageLimit * pageLimit + 1;
   }

   public int getEndPage() {
      int res = getStartPage() + pageLimit - 1;
      if (res > getTotalPage())
         res = getTotalPage();
      return res;
   }

   public int getTotalPage() {

      int res = total / limit;
      if (total % limit != 0)
         res++;

      return res;
   }

   public int getTotal() {
      return total;
   }

   public void setTotal(int total) {
      this.total = total;
   }

   public int getStartNum() {
      return (nowPage - 1) * limit + 1;
   }

   public int getEndNum() {
      return nowPage * limit;
   }

   public int getNowPage() {
      return nowPage;
   }

   public void setNowPage(int nowPage) {
      this.nowPage = nowPage;
   }

   public int getLimit() {
      return limit;
   }

   public void setLimit(int limit) {
      this.limit = limit;
   }

   public int getPageLimit() {
      return pageLimit;
   }

   public void setPageLimit(int pageLimit) {
      this.pageLimit = pageLimit;
   }
   
   public Object getDd3() {
      return dd3;
   }

   public void setDd3(Object dd3) {
      this.dd3 = dd3;
   }

   public Object getDd2() {
      return dd2;
   }

   public void setDd2(Object dd2) {
      this.dd2 = dd2;
   }

   public String getServiceTemp() {
      return serviceTemp;
   }

   public void setServiceTemp(String serviceTemp) {
      this.serviceTemp = serviceTemp;
   }

   public String getCate1Temp() {
      return cate1Temp;
   }

   public void setCate1Temp(String cate1Temp) {
      this.cate1Temp = cate1Temp;
   }

   public ArrayList<Menu> getTopMenu2() {
      return topMenu2;
   }

   public void setTopMenu2(ArrayList<Menu> topMenu2) {
      this.topMenu2 = topMenu2;
   }

   public ArrayList<Menu> getSubMenu2() {
      return subMenu2;
   }

   public void setSubMenu2(ArrayList<Menu> subMenu2) {
      this.subMenu2 = subMenu2;
   }

   public ArrayList<Menu> getManagerMenu() {
      return managerMenu;
   }

   public void setManagerMenu(ArrayList<Menu> managerMenu) {
      this.managerMenu = managerMenu;
   }

   public ArrayList<Menu> getLoginMenu() {
      return loginMenu;
   }

   public void setLoginMenu(ArrayList<Menu> loginMenu) {
      this.loginMenu = loginMenu;
   }

   public String getPath() {
      return path;
   }

   public void setPath(String path) {
      this.path = path;
   }

   public boolean isRedirect() {
      return redirect;
   }

   public void setRedirect(boolean redirect) {
      this.redirect = redirect;
   }

   public HttpServletRequest getRequest() {
      return request;
   }

   public void setRequest(HttpServletRequest request) {
      this.request = request;
   }

   public ArrayList<Menu> getTopMenu() {
      return topMenu;
   }

   public void setTopMenu(ArrayList<Menu> topMenu) {
      this.topMenu = topMenu;
   }

   public ArrayList<Menu> getSubMenu() {
      return subMenu;
   }

   public void setSubMenu(ArrayList<Menu> subMenu) {
      this.subMenu = subMenu;
   }

   public Object getDd() {
      return dd;
   }

   public void setDd(Object dd) {
      this.dd = dd;
   }

   public String getCate1() {
      // System.out.println("패스데이타 클래스 의 getCate1값 : "+cate1);
      return cate1;
   }

   public void setCate1(String cate1) {
      this.cate1 = cate1;
      // System.out.println("패스데이타 클래스 의 setCate1값 : "+cate1);
   }

   public String getCate2() {
      return cate2;
   }

   public void setCate2(String cate2) {
      this.cate2 = cate2;
   }

   public String getService() {
      // System.out.println("패스데이터의 getservice : "+service);
      return service;
   }

   public void setService(String service) {
      this.service = service;
   }

   @Override
   public String toString() {
      return "PathData [cate1=" + cate1 + ", cate2=" + cate2 + ", service=" + service + "]";
   }

}