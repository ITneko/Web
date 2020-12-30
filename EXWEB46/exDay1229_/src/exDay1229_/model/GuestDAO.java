package exDay1229_.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import exDay1229_.util.DBManager;

public class GuestDAO {
	private static GuestDAO instance = new GuestDAO();

	public static GuestDAO getInstance() {
		return instance;
	}

	// 방명록 전체 게시글 총 수를 구하는 메소드
	public int guestCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int row = 0;

		String query = "select count(*) from tbl_guest";

		try {
			conn = DBManager.getConnetion();
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

	// 검색조건에 맞는 방명록 전체 게시글 총 수를 구하는 메소드
	public int guestCount(String s_query) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int row = 0;

		String query = "select count(*) from tbl_guest where " + s_query;

		try {
			conn = DBManager.getConnetion();
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

	// 검색조건에 맞는 방명록 전체 게시글 총 수를 구하는 메소드(페이지 처리, 검색기능 없음)
	public List<GuestDTO> guestList(int startpage, int endpage) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GuestDTO guest = null;
		List<GuestDTO> list = new ArrayList<GuestDTO>();

		int row = 0;

		String query = "select X.* from ( select rownum as rnum, A.* from (select * from tbl_guest order by idx desc) A where rownum <=?) X where X.rnum >=?";

		try {
			conn = DBManager.getConnetion();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				guest = new GuestDTO();
				guest.setIdx(rs.getInt("idx"));
				guest.setName(rs.getString("name"));
				guest.setSubject(rs.getString("subject"));
				guest.setRegdate(rs.getString("regdate"));
				guest.setReadcnt(rs.getInt("readcnt"));
				list.add(guest);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}
	
	// 검색조건에 맞는 방명록 전체 게시글 총 수를 구하는 메소드(페이지 처리, 검색기능 없음)
		public List<GuestDTO> guestList(String s_query, int startpage, int endpage) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			GuestDTO guest = null;
			List<GuestDTO> list = new ArrayList<GuestDTO>();

			int row = 0;

			String query = "select X.* from ( select rownum as rnum, A.* from "
					+ "(select * from tbl_guest order by idx desc) "
					+ "A where " + s_query + " and rownum <=?) X where "+ s_query + " and X.rnum >=?";

			try {
				conn = DBManager.getConnetion();
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, endpage);
				pstmt.setInt(2, startpage);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					guest = new GuestDTO();
					guest.setIdx(rs.getInt("idx"));
					guest.setName(rs.getString("name"));
					guest.setSubject(rs.getString("subject"));
					guest.setRegdate(rs.getString("regdate"));
					guest.setReadcnt(rs.getInt("readcnt"));
					list.add(guest);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}

			return list;
		}

	// 방명록 전체 게시글 목록을 구하는 메소드
	public List<GuestDTO> guestList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GuestDTO guest = null;
		List<GuestDTO> list = new ArrayList<GuestDTO>();

		String query = "select * from tbl_guest order by idx desc";

		try {
			conn = DBManager.getConnetion();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				guest = new GuestDTO();
				guest.setIdx(rs.getInt("idx"));
				guest.setName(rs.getString("name"));
				guest.setSubject(rs.getString("subject"));
				guest.setRegdate(rs.getString("regdate"));
				guest.setReadcnt(rs.getInt("readcnt"));
				list.add(guest);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}

	// view
	public GuestDTO guestView(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GuestDTO guest = null;

		String query = "select * from tbl_guest where idx=?";

		try {
			conn = DBManager.getConnetion();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				guest = new GuestDTO();
				guest.setIdx(rs.getInt("idx"));
				guest.setName(rs.getString("name"));
				guest.setSubject(rs.getString("subject"));
				guest.setRegdate(rs.getString("regdate"));
				guest.setContents(rs.getString("contents"));
				guest.setReadcnt(rs.getInt("readcnt"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return guest;
	}

	// write
	public int guestWrite(GuestDTO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;

		String query = "insert into tbl_guest (idx, name, pass, subject, contents) values(tbl_guest_seq_idx.nextval,?,?,?,?)";

		try {
			conn = DBManager.getConnetion();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getSubject());
			pstmt.setString(4, vo.getContents());
			row = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return row;
	}

	// modify
	public int guestModify(GuestDTO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;

		String query = "update tbl_guest set subject=? , contents=? where idx=? and pass=?";

		try {
			conn = DBManager.getConnetion();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getSubject());
			pstmt.setString(2, vo.getContents());
			pstmt.setInt(3, vo.getIdx());
			pstmt.setString(4, vo.getPass());
			row = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return row;
	}

	// delete
	public int guestDelete(GuestDTO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;

		String query = "delete from tbl_guest where idx=? and pass=?";

		try {
			conn = DBManager.getConnetion();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, vo.getIdx());
			pstmt.setString(2, vo.getPass());
			row = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return row;
	}

	// read
	public int guestReadCount(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;

		String query = "update tbl_guest set readcnt=readcnt+1 where idx=?";

		try {
			conn = DBManager.getConnetion();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			row = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return row;
	}
}
