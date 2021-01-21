package com.jslhrd.controller.notice;

import com.jslhrd.service.Action;
import com.jslhrd.service.notice.NoticeDeleteAction;
import com.jslhrd.service.notice.NoticeDeleteProAction;
import com.jslhrd.service.notice.NoticeListAction;
import com.jslhrd.service.notice.NoticeModifyAction;
import com.jslhrd.service.notice.NoticeModifyProAction;
import com.jslhrd.service.notice.NoticeViewAction;
import com.jslhrd.service.notice.NoticeWriteAction;
import com.jslhrd.service.notice.NoticeWriteProAction;

public class NoticeActionFactory {
	private static NoticeActionFactory instance = new NoticeActionFactory();

	private NoticeActionFactory() {
	}

	public static NoticeActionFactory getinstance() {
		return instance;
	}

	public Action getAction(String cmd) {
		Action action = null;
		System.out.println("NoticeActionFactory : " + cmd);
		if (cmd.equals("notice_list")) {
			action = new NoticeListAction();
		} else if (cmd.equals("notice_write")) {
			action = new NoticeWriteAction();
		} else if (cmd.equals("notice_write_pro")) {
			action = new NoticeWriteProAction();
		}else if (cmd.equals("notice_view")) {
			action = new NoticeViewAction();
		}else if (cmd.equals("notice_modify")) {
			action = new NoticeModifyAction();
		}else if (cmd.equals("notice_modify_pro")) {
			action = new NoticeModifyProAction();
		}else if (cmd.equals("notice_delete")) {
			action = new NoticeDeleteAction();
		}else if (cmd.equals("notice_delete_pro")) {
			action = new NoticeDeleteProAction();
		}
		return action;
	}
}
