package DataProvider;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.*;

public class DataTest {
	@DataProvider
	public Iterator<Object[]> LoginData() {
		ArrayList<Object[]> listData = DataPractis.LoginData();
		return listData.iterator();
	}

	@Test(dataProvider = "LoginData")
	public void login(String username,String password) {
		System.out.println(username);
		System.out.println(password);
		
		System.out.println("--------------------------------------");

	}
}
