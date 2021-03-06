package com.jslhrd.controller.admin;

import com.jslhrd.service.Action;
import com.jslhrd.service.admin.AdminIndexAction;
import com.jslhrd.service.admin.AdminLoginAction;
import com.jslhrd.service.admin.AdminLogoutAction;

public class AdminActionFactory {
	private static AdminActionFactory instance = new AdminActionFactory();

	private AdminActionFactory() {
	}

	public static AdminActionFactory getinstance() {
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
