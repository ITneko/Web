package com.jslhrd.controller.admin.board;

import com.jslhrd.service.Action;
import com.jslhrd.service.admin.board.AdminBoardDeleteAction;
import com.jslhrd.service.admin.board.AdminBoardDeleteProAction;
import com.jslhrd.service.admin.board.AdminBoardListAction;
import com.jslhrd.service.admin.board.AdminBoardModifyAction;
import com.jslhrd.service.admin.board.AdminBoardModifyProAction;
import com.jslhrd.service.admin.board.AdminBoardViewAction;
import com.jslhrd.service.admin.board.AdminBoardWriteAction;
import com.jslhrd.service.admin.board.AdminBoardWriteProAction;

public class AdminBoardActionFactory {
	private static AdminBoardActionFactory instance = new AdminBoardActionFactory();

	private AdminBoardActionFactory() {
	}

	public static AdminBoardActionFactory getinstance() {
		return instance;
	}

	public Action getAction(String cmd) {
		Action action = null;
		System.out.println("BoardActionFactory : " + cmd);
		if (cmd.equals("board_list")) {
			action = new AdminBoardListAction();
		} else if (cmd.equals("board_write")) {
			action = new AdminBoardWriteAction();
		} else if (cmd.equals("board_write_pro")) {
			action = new AdminBoardWriteProAction();
		}else if (cmd.equals("board_view")) {
			action = new AdminBoardViewAction();
		}else if (cmd.equals("board_modify")) {
			action = new AdminBoardModifyAction();
		}else if (cmd.equals("board_modify_pro")) {
			action = new AdminBoardModifyProAction();
		}else if (cmd.equals("board_delete")) {
			action = new AdminBoardDeleteAction();
		}else if (cmd.equals("board_delete_pro")) {
			action = new AdminBoardDeleteProAction();
		}
		return action;
	}
}
