package com.jslhrd.controller.guest;

import com.jslhrd.service.Action;
import com.jslhrd.service.guest.GuestDeleteAction;
import com.jslhrd.service.guest.GuestDeleteProAction;
import com.jslhrd.service.guest.GuestListAction;
import com.jslhrd.service.guest.GuestModifyAction;
import com.jslhrd.service.guest.GuestModifyProAction;
import com.jslhrd.service.guest.GuestViewAction;
import com.jslhrd.service.guest.GuestWriteAction;
import com.jslhrd.service.guest.GuestWriteProAction;

public class GuestActionFactory {
	private static GuestActionFactory instance = new GuestActionFactory();

	private GuestActionFactory() {
	}

	public static GuestActionFactory getinstance() {
		return instance;
	}

	public Action getAction(String cmd) {
		Action action = null;
		System.out.println("GuestActionFactory : " + cmd);
		if (cmd.equals("guest_list")) {
			action = new GuestListAction();
			System.out.println("List@@");
		} else if (cmd.equals("guest_write")) {
			action = new GuestWriteAction();
		} else if (cmd.equals("guest_write_pro")) {
			action = new GuestWriteProAction();
		}else if (cmd.equals("guest_view")) {
			action = new GuestViewAction();
		}else if (cmd.equals("guest_modify")) {
			action = new GuestModifyAction();
		}else if (cmd.equals("guest_modify_pro")) {
			action = new GuestModifyProAction();
		}else if (cmd.equals("guest_delete")) {
			action = new GuestDeleteAction();
		}else if (cmd.equals("guest_delete_pro")) {
			action = new GuestDeleteProAction();
		}
		return action;
	}
}
