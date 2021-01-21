package com.jslhrd.controller.admin.board;

import com.jslhrd.service.Action;
import com.jslhrd.service.admin.AdminIndexAction;
import com.jslhrd.service.admin.AdminLoginAction;
import com.jslhrd.service.admin.AdminLogoutAction;

public class AdminBoardActionFactory {
	private static AdminBoardActionFactory instance = new AdminBoardActionFactory();

	private AdminBoardActionFactory() {
	}

	public static AdminBoardActionFactory getinstance() {
		return instance;
	}

	public Action getAction(String cmd) {
		Action action = null;
		System.out.println("AdminActionFactory : " + cmd);
		if (cmd.equals("admin_login")) {
			action = new AdminLoginAction();
		} else if (cmd.equals("admin_logout")) {
			action = new AdminLogoutAction();
		} else if (cmd.equals("admin_index")) {
			action = new AdminIndexAction();
		}
		return action;
	}
}
