package com.jslhrd.controller.user;

import com.jslhrd.service.Action;
import com.jslhrd.service.user.IndexAction;
import com.jslhrd.service.user.UserIdcheckAction;
import com.jslhrd.service.user.UserIdcheckOkAction;
import com.jslhrd.service.user.UserIdsearcOkhAction;
import com.jslhrd.service.user.UserIdsearchAction;
import com.jslhrd.service.user.UserInsertAction;
import com.jslhrd.service.user.UserListAction;
import com.jslhrd.service.user.UserLoginAction;
import com.jslhrd.service.user.UserLoginOkAction;
import com.jslhrd.service.user.UserLogoutAction;
import com.jslhrd.service.user.UserModifyAction;
import com.jslhrd.service.user.UserModifyProAction;
import com.jslhrd.service.user.UserPasswdSearchAction;
import com.jslhrd.service.user.UserPasswdSearchOkAction;

public class UserActionFactory {
	private static UserActionFactory instance = new UserActionFactory();

	private UserActionFactory() {
	}

	public static UserActionFactory getinstance() {
		return instance;
	}

	public Action getAction(String cmd) {
		Action action = null;
		System.out.println("UserActionFactory : " + cmd);
		if (cmd.equals("user_list")) {
			action = new UserListAction();
		} else if (cmd.equals("user_insert")) {
			action = new UserInsertAction();
		} else if (cmd.equals("user_idcheck")) {
			action = new UserIdcheckAction();
		}else if (cmd.equals("user_idcheck_ok")) {
			action = new UserIdcheckOkAction();
		}else if (cmd.equals("user_modify")) {
			action = new UserModifyAction();
		}else if (cmd.equals("user_modify_pro")) {
			action = new UserModifyProAction();
		}else if (cmd.equals("user_logout")) {
			action = new UserLogoutAction();
		}else if (cmd.equals("user_modify_pro")) {
			action = new UserModifyProAction();
		}else if (cmd.equals("user_login")) {
			action = new UserLoginAction();
		}else if (cmd.equals("user_login_ok")) {
			action = new UserLoginOkAction();
		}else if (cmd.equals("index")) {
			action = new IndexAction();
		}else if (cmd.equals("user_idsearch")) {
			action = new UserIdsearchAction();
		}else if (cmd.equals("user_idsearch_ok")) {
			action = new UserIdsearcOkhAction();
		}else if (cmd.equals("user_passwdsearch")) {
			action = new UserPasswdSearchAction();
		}else if (cmd.equals("user_passwdsearch_ok")) {
			action = new UserPasswdSearchOkAction();
		}
		return action;
	}
}
