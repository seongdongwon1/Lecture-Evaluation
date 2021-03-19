package likey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DatabaseUtil;

public class LikeyDAO {
	public int like(String userID, String evaluationID, String userIP)
	{
		String SQL = "INSERT INTO LIKEY VALUES (?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			pstmt.setString(2, evaluationID);
			pstmt.setString(3, userIP);
			//회원가입 성공하면 1을 리턴함.
			return pstmt.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		//마지막으로 리셋시키는 것.
		finally
		{
			try
			{
				if(conn != null)
				{
					conn.close();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			try
			{
				if(pstmt != null)
				{
					pstmt.close();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			try
			{
				if(rs != null)
				{
					rs.close();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return -1; // 추천 중복 오류 
	}
}
