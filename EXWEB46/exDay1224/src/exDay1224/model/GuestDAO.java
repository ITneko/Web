package exDay1224.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GuestDAO {
	// 싱글톤
	private static GuestDAO instance = new GuestDAO();

	public static GuestDAO getInstance() {
		return instance;
	}

	private static Connection getConnetion() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jslhrd46", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 게시글 총 글 수 카운트
	public int BoardCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String query = "select count(*) from tbl_board";
		int row = 0;
		try {
			conn = getConnetion();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	// 게시글 검색 글 수 카운트
		public int BoardCount2(String search, String key) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			String query = "select count(*) from tbl_board where " + search + " like '%" + key + "%'";
			int row = 0;
			try {
				conn = getConnetion();
				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					row = rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return row;
		}

	// 게시글 리스트
	public List<BoardVO> BoardList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO vo = null;

		String query = "select * from tbl_board";
		try {
			conn = getConnetion();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new BoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setReadcnt(rs.getInt("readcnt"));
				vo.setRegdate(rs.getString("regdate"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	// 전체 목록 메소드 페이지 처리(검색 조건이 없음)
		public List<BoardVO> BoardList(int startpage, int endpage) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<BoardVO> list = new ArrayList<BoardVO>();
			BoardVO vo = null;
			
			String query = "select X.* from (select rownum as rnum, A.* from ("
					+ "select * from tbl_board order by idx desc) A "
					+ "where rownum <=? ) X where X.rnum >= ?";
			try {
				conn = getConnetion();
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, endpage);
				pstmt.setInt(2, startpage);
				rs = pstmt.executeQuery();
				while (rs.next()) { 
					vo = new BoardVO();
					vo.setIdx(rs.getInt("idx"));
					vo.setName(rs.getString("name"));
					vo.setSubject(rs.getString("subject"));
					vo.setReadcnt(rs.getInt("readcnt"));
					vo.setRegdate(rs.getString("regdate"));
					list.add(vo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return list;
		}
		
		// 전체 목록 메소드 페이지 처리(검색 조건이 포함)
				public List<BoardVO> BoardList(String search, String key, int startpage, int endpage) {
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					List<BoardVO> list = new ArrayList<BoardVO>();
					BoardVO vo = null;
					
					String query = "select X.* from (select rownum as rnum, A.* from ("
							+ "select * from tbl_board order by idx desc) A "
							+ "where "+ search + " like '%" + key + "%' and rownum <=? ) X "
									+ "where "+ search + " like '%" + key + "%' and X.rnum >= ?";
					try {
						conn = getConnetion();
						pstmt = conn.prepareStatement(query);
						pstmt.setInt(1, endpage);
						pstmt.setInt(2, startpage);
						rs = pstmt.executeQuery();
						while (rs.next()) { 
							vo = new BoardVO();
							vo.setIdx(rs.getInt("idx"));
							vo.setName(rs.getString("name"));
							vo.setSubject(rs.getString("subject"));
							vo.setReadcnt(rs.getInt("readcnt"));
							vo.setRegdate(rs.getString("regdate"));
							list.add(vo);
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {
							if (rs != null)
								rs.close();
							if (pstmt != null)
								pstmt.close();
							if (conn != null)
								conn.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					return list;
				}
	
	// 검색된 게시글 리스트
		public List<BoardVO> BoardSList(String search, String key) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<BoardVO> list = new ArrayList<BoardVO>();
			BoardVO vo = null;

			String query = "select * from tbl_board  where " + search + " like '%" + key + "%' order by idx desc";
			try {
				conn = getConnetion();
				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					vo = new BoardVO();
					vo.setIdx(rs.getInt("idx"));
					vo.setName(rs.getString("name"));
					vo.setSubject(rs.getString("subject"));
					vo.setReadcnt(rs.getInt("readcnt"));
					vo.setRegdate(rs.getString("regdate"));
					list.add(vo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return list;
		}

	// 게시글 뷰
	public BoardVO BoardView(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO vo = null;

		String query = "select * from tbl_board where idx=?";
		try {
			conn = getConnetion();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new BoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setReadcnt(rs.getInt("readcnt"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return vo;
	}

	// 게시글 카운트
	public void BoardReadCount(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String query = "update tbl_board set readcnt=readcnt+1 where idx=?";
		try {
			conn = getConnetion();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 글쓰기
	public int BoardWrite(BoardVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;

		String query = "insert into tbl_board (idx, name, pass, email, subject, contents) values(board_seq_idx.nextval, ?, ?, ?, ?, ?)";
		try {
			conn = getConnetion();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getSubject());
			pstmt.setString(5, vo.getContents());
			row = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}

	// 글수정
	public int BoardModify(BoardVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;

		String query = "update tbl_board set email=?, subject=?, contents=? where idx=? and pass=?";
		try {
			conn = getConnetion();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getEmail());
			pstmt.setString(2, vo.getSubject());
			pstmt.setString(3, vo.getContents());
			pstmt.setInt(4, vo.getIdx());
			pstmt.setString(5, vo.getPass());
			row = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}

	// 글삭제
	public int BoardDelete(int idx, String pass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;

		String query = "delete from tbl_board where idx=? and pass=?";
		try {
			conn = getConnetion();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			pstmt.setString(2, pass);
			row = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
}
