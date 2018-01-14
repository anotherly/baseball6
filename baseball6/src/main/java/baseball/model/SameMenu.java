package baseball.model;

import java.util.ArrayList;

public class SameMenu {

//	@Resource
//	PathData data;
	
	public SameMenu(PathData data) {
		// -------------------------������α���/ȸ�����Ը޴������������--------------------------
		ArrayList<Menu> loginMenu = new ArrayList<>();
		loginMenu.add(new Menu("login", "�α���", "loginSub"));// cate1, cate2, service---�ڹٿ��� �޾ƿö��� �ǹ�
		loginMenu.add(new Menu("join", "ȸ������", "joinSub"));// name, korName, url-----jsp�� �������� �ǹ�

		// -------------------------������ž �޴������������--------------------------
		ArrayList<Menu> topMenu = new ArrayList<>();
		
		topMenu.add(new Menu("info", "����", "notice"));
		topMenu.add(new Menu("schedule", "����/���", "notice"));
		topMenu.add(new Menu("player", "��Ͻ�", "stat"));
		topMenu.add(new Menu("board", "�Խ���", "boardinfo"));
		topMenu.add(new Menu("ticket", "����", "reservation"));		
		
		
		// -------------------------����������� �޴��������--------------------------
		ArrayList<Menu> managerMenu = new ArrayList<>();
		managerMenu.add(new Menu("manager", "ȸ�� ����", "member"));// name, korName, url-----jsp�� �������� �ǹ�
		managerMenu.add(new Menu("manager", "���� ����", "team"));// name, korName, url-----jsp�� �������� �ǹ�
		managerMenu.add(new Menu("manager", "��� ����", "bill"));// name, korName, url-----jsp�� �������� �ǹ�

		
		data.setLoginMenu(loginMenu);
		data.setManagerMenu(managerMenu);
		data.setTopMenu(topMenu);
		
	}
	
}
