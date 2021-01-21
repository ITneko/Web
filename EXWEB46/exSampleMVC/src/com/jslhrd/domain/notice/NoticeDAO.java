package com.jslhrd.domain.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jslhrd.util.DBManager;

public class NoticeDAO {
	private static NoticeDAO instance = new NoticeDAO();

	public static NoticeDAO getInstance() {
		return instance;
	}



	// 글쓰기
	public int noticeWrite(NoticeVO admin) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;

		String query = "insert into tbl_notice (idx, subject, contents) values(notice_seq_idx.nextval, ?, ?)";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, admin.getSubject());
			pstmt.setString(2, admin.getContents());

			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}

	// 전체 카운트
	public int noticeCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;

		String query = "select count(*) from tbl_notice";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}

	// 검색 카운트
	public int noticeCount(String s_query) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;

		String query = "select count(*) from tbl_notice where " + s_query;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}

	// 전체 리스트
	public List<NoticeVO> noticeList(int startpage, int endpage) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		NoticeVO admin = null;

		String query = "select X.* from (select rownum as rnum, A.* from (select * from tbl_notice order by idx desc) A where rownum<=?) X where rnum>=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				admin = new NoticeVO();
				admin.setIdx(rs.getInt("idx"));
				admin.setSubject(rs.getString("subject"));
				admin.setRegdate(rs.getString("regdate"));
				admin.setReadcnt(rs.getString("readcnt"));

				list.add(admin);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 검색 리스트
	public List<NoticeVO> noticeList(String s_query, int startpage, int endpage) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		NoticeVO admin = null;

		String query = "select X.* from (select rownum as rnum, A.* from (select * from tbl_admin order by idx desc)"
				+ " A where " + s_query + " and rownum<=?) X where " + s_query + " and rnum>=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				admin = new NoticeVO();
				admin.setIdx(rs.getInt("idx"));
				admin.setSubject(rs.getString("subject"));
				admin.setRegdate(rs.getString("regdate"));
				admin.setReadcnt(rs.getString("readcnt"));

				list.add(admin);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 읽음
	public void noticeReadCount(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String query = "update tbl_notice set readcnt=readcnt+1 where idx=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
	}

	// 뷰
	public NoticeVO noticeView(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeVO admin = null;

		String query = "select * from tbl_notice where idx=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				admin = new NoticeVO();
				admin.setIdx(rs.getInt("idx"));
				admin.setSubject(rs.getString("subject"));
				admin.setContents(rs.getNString("contents"));
				admin.setRegdate(rs.getString("regdate"));
				admin.setReadcnt(rs.getString("readcnt"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return admin;
	}

	// 수정
	public int noticeModify(NoticeVO admin) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		String query = "update tbl_notice set subject=?, contents=? where idx=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, admin.getSubject());
			pstmt.setString(2, admin.getContents());
			pstmt.setInt(3, admin.getIdx());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}

	// 로그인
	public int noticeDelete(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;

		String query = "delete from tbl_notice where idx=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			row = 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}
}
