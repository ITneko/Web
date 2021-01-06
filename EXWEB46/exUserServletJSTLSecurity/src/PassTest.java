import exUserServletJSTL.util.SHA256Util;

public class PassTest {

	public static void main(String[] args) {
		String pass = SHA256Util.getEncSHA256("1234");
		System.out.println(pass);

	}

}
