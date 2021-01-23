package com.jslhrd.controller.admin.guest;

import com.jslhrd.service.Action;
import com.jslhrd.service.admin.guest.AdminGuestDeleteAction;
import com.jslhrd.service.admin.guest.AdminGuestDeleteProAction;
import com.jslhrd.service.admin.guest.AdminGuestListAction;
import com.jslhrd.service.admin.guest.AdminGuestModifyAction;
import com.jslhrd.service.admin.guest.AdminGuestModifyProAction;
import com.jslhrd.service.admin.guest.AdminGuestViewAction;
import com.jslhrd.service.admin.guest.AdminGuestWriteAction;
import com.jslhrd.service.admin.guest.AdminGuestWriteProAction;

public class AdminGuestActionFactory {
	private static AdminGuestActionFactory instance = new AdminGuestActionFactory();

	private AdminGuestActionFactory() {
	}

	public static AdminGuestActionFactory getinstance() {
		return instance;
	}

	public Action getAction(String cmd) {
		Action action = null;
		System.out.println("GuestActionFactory : " + cmd);
		if (cmd.equals("guest_list")) {
			action = new AdminGuestListAction();
		} else if (cmd.equals("guest_write")) {
			action = new AdminGuestWriteAction();
		} else if (cmd.equals("guest_write_pro")) {
			action = new AdminGuestWriteProAction();
		}else if (cmd.equals("guest_view")) {
			action = new AdminGuestViewAction();
		}else if (cmd.equals("guest_modify")) {
			action = new AdminGuestModifyAction();
		}else if (cmd.equals("guest_modify_pro")) {
			action = new AdminGuestModifyProAction();
		}else if (cmd.equals("guest_delete")) {
			action = new AdminGuestDeleteAction();
		}else if (cmd.equals("guest_delete_pro")) {
			action = new AdminGuestDeleteProAction();
		}
		return action;
	}
}
