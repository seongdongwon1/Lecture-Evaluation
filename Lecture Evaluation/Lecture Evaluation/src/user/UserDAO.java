package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DatabaseUtil;

public class UserDAO {
	
	public int login(String userID, String userPassword)
	{
		String SQL = "SELECT userPassword FROM USER WHERE userID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			//executeQuery : �����ͺ��̽����� ��ȸ�Ҷ� �����
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				if(rs.getString(1).equals(userPassword))
				{
					return 1; //�α��� ����
				}
				else
				{
					return 0; //��й�ȣ Ʋ��
				}
			}
			return -1; //���̵����
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		//���������� ���½�Ű�� ��.
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
		return -2; //�����ͺ��̽� ����
	}
	
	
	
	public int join(UserDTO user)
	{
		String SQL = "INSERT INTO USER VALUES (?, ?, ?, ?, false)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserEmail());
			pstmt.setString(4, user.getUserEmailHash());
			//ȸ������ �����ϸ� 1�� ������.
			return pstmt.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		//���������� ���½�Ű�� ��.
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
		return -1; //ȸ������ ����
	}
	
	
	
	public boolean getUserEmailChecked(String userID)
	{
		String SQL = "SELECT userEmailChecked FROM USER WHERE userID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				return rs.getBoolean(1);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		//���������� ���½�Ű�� ��.
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
		return false; //�����ͺ��̽� ����
	}
	
	
	
	public boolean setUserEmailChecked(String userID)
	{
		String SQL = "UPDATE USER SET userEmailChecked = true WHERE userID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			pstmt.executeUpdate();
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		//���������� ���½�Ű�� ��.
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
		return false; //�����ͺ��̽� ����
	}
	
	public String getUserEmail(String userID)
	{
		String SQL = "SELECT userEmail FROM USER WHERE userID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				return rs.getString(1);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		//���������� ���½�Ű�� ��.
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
		return null; //�����ͺ��̽� ����
	}
}
