package admin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import admin.model.AdminVO;
import board.model.BoardVO;
import util.DBManager;

public class AdminDAO {
	private static AdminDAO instance = new AdminDAO();

	public static AdminDAO getInstance() {
		return instance;
	}

	// 로그인
	public int adminLogin(String userid, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;

		String query = "select * from tbl_admin where adminid=? and adminpass=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			row = 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}

	// 글쓰기
	public int adminWrite(AdminVO admin) {
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
	public List<AdminVO> noticeList(int startpage, int endpage) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<AdminVO> list = new ArrayList<AdminVO>();
		AdminVO admin = null;

		String query = "select X.* from (select rownum as rnum, A.* from (select * from tbl_notice order by idx desc) A where rownum<=?) X where rnum>=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				admin = new AdminVO();
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
	public List<AdminVO> noticeList(String s_query, int startpage, int endpage) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<AdminVO> list = new ArrayList<AdminVO>();
		AdminVO admin = null;

		String query = "select X.* from (select rownum as rnum, A.* from (select * from tbl_admin order by idx desc)"
				+ " A where " + s_query + " and rownum<=?) X where " + s_query + " and rnum>=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				admin = new AdminVO();
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
	public void adminReadCount(int idx) {
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
	public AdminVO noticeView(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AdminVO admin = null;

		String query = "select * from tbl_notice where idx=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				admin = new AdminVO();
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
	public int noticeModify(AdminVO admin) {
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
	public int adminDelete(int idx) {
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
