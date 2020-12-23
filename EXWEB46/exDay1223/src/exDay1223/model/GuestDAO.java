package exDay1223.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/* DAO(Data Access Object)
 * 1. 드라이버 로딩 - 커넥션 연결 - CRUD
 * 
 */
public class GuestDAO {
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

	// 메소드 정의
	public int guestCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String query = "select count(*) from tbl_guest";
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

	// 등록 메소드
	public int guestWrite(GuestVO guest) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String query = "insert into tbl_guest(idx, name,pass,subject,contents) values(tbl_guest_seq_idx.nextval, ?,?,?,?)";
		int row = 0;
		try {
			conn = getConnetion();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, guest.getName());
			pstmt.setString(2, guest.getPass());
			pstmt.setString(3, guest.getSubject());
			pstmt.setString(4, guest.getContents());

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

	// 전체 목록 메소드
	public List<GuestVO> guestList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GuestVO vo = null;

		String query = "select * from tbl_guest order by idx desc";
		List<GuestVO> list = new ArrayList<GuestVO>();
		try {
			conn = getConnetion();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new GuestVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
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

	// 특정 게시글 검색view
	public GuestVO guestSelect(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String query = "select * from tbl_guest where idx=?";
		GuestVO vo = new GuestVO();
		try {
			conn = getConnetion();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));

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

	// 조회수 증가 메소드
	public void guestHits(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String query = "update tbl_guest set readcnt=readcnt+1 where idx=?";
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
	
	// 등록 메소드
		public int guestEdit(GuestVO guest) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			String query = "update tbl_guest set subject=?, contents=? where idx=? and pass=?";
			int row = 0;
			try {
				conn = getConnetion();
				pstmt = conn.prepareStatement(query);
				
				pstmt.setString(1, guest.getSubject());
				pstmt.setString(2, guest.getContents());
				pstmt.setInt(3, guest.getIdx());
				pstmt.setString(4, guest.getPass());

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

		// 삭제 메소드
				public int guestDelete(int idx, String pass) {
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;

					String query = "delete from tbl_guest where idx=? and pass=?";
					int row = 0;
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
