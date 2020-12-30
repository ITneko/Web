package exDay1230.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import exDay1230.util.DBManager;

public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}

	// 전체 카운트
	public int boardCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;

		String query = "select count(*) from tbl_board";

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

	// 검색 카운트
	public int boardCount(String s_query) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;

		String query = "select count(*) from tbl_board where " + s_query;

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

	// 읽음 카운트
	public void boardReadCount(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String query = "update tbl_board set readcnt=readcnt+1 where idx=?";

		try {
			conn = DBManager.getConnetion();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
	}

	// 전체 리스트
	public List<BoardDTO> boardList(int startpage, int endpage) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		BoardDTO board = null;

		String query = "select X.* from (select rownum as rnum, A.* from (select * from tbl_board order by idx desc) A where rownum<=?) X where rnum>=?";

		try {
			conn = DBManager.getConnetion();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				board = new BoardDTO();
				board.setIdx(rs.getInt("idx"));
				board.setName(rs.getString("name"));
				board.setSubject(rs.getString("subject"));
				board.setRegdate(rs.getString("regdate"));
				board.setReadcnt(rs.getString("readcnt"));

				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 검색 리스트
	public List<BoardDTO> boardList(String s_query, int startpage, int endpage) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		BoardDTO board = null;

		String query = "select X.* from (select rownum as rnum, A.* from (select * from tbl_board order by idx desc)"
				+ " A where " + s_query + " and rownum<=?) X where " + s_query + " and rnum>=?";

		try {
			conn = DBManager.getConnetion();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				board = new BoardDTO();
				board.setIdx(rs.getInt("idx"));
				board.setName(rs.getString("name"));
				board.setSubject(rs.getString("subject"));
				board.setRegdate(rs.getString("regdate"));
				board.setReadcnt(rs.getString("readcnt"));

				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 뷰
	public BoardDTO boardView(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDTO board = null;

		String query = "select * from tbl_board where idx=?";

		try {
			conn = DBManager.getConnetion();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				board = new BoardDTO();
				board.setName(rs.getString("name"));
				board.setSubject(rs.getString("subject"));
				board.setContents(rs.getNString("contents"));
				board.setRegdate(rs.getString("regdate"));
				board.setReadcnt(rs.getString("readcnt"));
				board.setEmail(rs.getString("email"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return board;
	}

	// 글쓰기
	public int boardWrite(BoardDTO board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;

		String query = "insert into tbl_board (idx, name, pass, email, subject, contents) values(board_seq_idx.nextval, ?, ?, ?, ?, ?)";

		try {
			conn = DBManager.getConnetion();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getName());
			pstmt.setString(2, board.getPass());
			pstmt.setString(3, board.getEmail());
			pstmt.setString(4, board.getSubject());
			pstmt.setString(5, board.getContents());

			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}

	// 수정
	public int boardModify(int idx, BoardDTO board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;

		String query = "update tbl_board set subject=?, contents=?, email=? where idx=? and pass=?";

		try {
			conn = DBManager.getConnetion();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getSubject());
			pstmt.setString(2, board.getContents());
			pstmt.setString(3, board.getEmail());
			pstmt.setInt(4, idx);
			pstmt.setString(5, board.getPass());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}

	// 삭제
	public int boardDelete(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;

		String query = "delete from tbl_board where idx=?";

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
