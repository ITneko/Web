package com.jslhrd.controller.admin.pds;

import com.jslhrd.service.Action;
import com.jslhrd.service.admin.pds.AdminPdsDeleteAction;
import com.jslhrd.service.admin.pds.AdminPdsDeleteProAction;
import com.jslhrd.service.admin.pds.AdminPdsDownAction;
import com.jslhrd.service.admin.pds.AdminPdsListAction;
import com.jslhrd.service.admin.pds.AdminPdsModifyAction;
import com.jslhrd.service.admin.pds.AdminPdsModifyProAction;
import com.jslhrd.service.admin.pds.AdminPdsViewAction;
import com.jslhrd.service.admin.pds.AdminPdsWriteAction;
import com.jslhrd.service.admin.pds.AdminPdsWriteProAction;

public class AdminPdsActionFactory {
	private static AdminPdsActionFactory instance = new AdminPdsActionFactory();

	private AdminPdsActionFactory() {
	}

	public static AdminPdsActionFactory getinstance() {
		return instance;
	}

	public Action getAction(String cmd) {
		Action action = null;
		System.out.println("PdsActionFactory : " + cmd);
		if (cmd.equals("pds_list")) {
			action = new AdminPdsListAction();
		} else if (cmd.equals("pds_write")) {
			action = new AdminPdsWriteAction();
		} else if (cmd.equals("pds_write_pro")) {
			action = new AdminPdsWriteProAction();
		}else if (cmd.equals("pds_view")) {
			action = new AdminPdsViewAction();
		}else if (cmd.equals("pds_modify")) {
			action = new AdminPdsModifyAction();
		}else if (cmd.equals("pds_modify_pro")) {
			action = new AdminPdsModifyProAction();
		}else if (cmd.equals("pds_delete")) {
			action = new AdminPdsDeleteAction();
		}else if (cmd.equals("pds_delete_pro")) {
			action = new AdminPdsDeleteProAction();
		}else if (cmd.equals("pds_down")) {
			action = new AdminPdsDownAction();
		}
		return action;
	}
}
