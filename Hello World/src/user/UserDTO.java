package user;

public class UserDTO {
	
	String userID;
	String userPassword;
	
	//어떠한 데이터를 가져오는 것
	public String getUserID() {
		return userID;
	}
	
	// 어떠한 데이터를 입력하는 것
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
	
}
