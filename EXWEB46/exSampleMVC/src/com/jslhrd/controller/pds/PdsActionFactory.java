package com.jslhrd.controller.pds;

import com.jslhrd.service.Action;
import com.jslhrd.service.pds.PdsDeleteAction;
import com.jslhrd.service.pds.PdsDeleteProAction;
import com.jslhrd.service.pds.PdsDownAction;
import com.jslhrd.service.pds.PdsListAction;
import com.jslhrd.service.pds.PdsModifyAction;
import com.jslhrd.service.pds.PdsModifyProAction;
import com.jslhrd.service.pds.PdsViewAction;
import com.jslhrd.service.pds.PdsWriteAction;
import com.jslhrd.service.pds.PdsWriteProAction;
import com.jslhrd.service.user.UserLoginAction;

public class PdsActionFactory {
	private static PdsActionFactory instance = new PdsActionFactory();

	private PdsActionFactory() {
	}

	public static PdsActionFactory getinstance() {
		return instance;
	}

	public Action getAction(String cmd) {
		Action action = null;
		System.out.println("PdsActionFactory : " + cmd);
		if (cmd.equals("pds_list")) {
			action = new PdsListAction();
		} else if (cmd.equals("pds_write")) {
			action = new PdsWriteAction();
		} else if (cmd.equals("pds_write_pro")) {
			action = new PdsWriteProAction();
		}else if (cmd.equals("pds_view")) {
			action = new PdsViewAction();
		}else if (cmd.equals("pds_modify")) {
			action = new PdsModifyAction();
		}else if (cmd.equals("pds_modify_pro")) {
			action = new PdsModifyProAction();
		}else if (cmd.equals("pds_delete")) {
			action = new PdsDeleteAction();
		}else if (cmd.equals("pds_delete_pro")) {
			action = new PdsDeleteProAction();
		}else if (cmd.equals("pds_down")) {
			action = new PdsDownAction();
		}
		return action;
	}
}
