import java.io.Reader;
import java.util.ArrayList;

public class test {

	public static Xls_Reader reader;

	public static void main(String[] args) {
		reader = new Xls_Reader("A:\\JavaPrograms\\SeleniumReadAndWrite\\src\\test\\java\\Data.xlsx");
		int col = reader.getRowCount("Sheet1");
		System.out.println(col);

		for (int i = 2; i < col; i++) {
			String usename = reader.getCellData("Sheet1", "Username", i);
			String password = reader.getCellData("Sheet1", "Password", i);
			System.out.println(usename);
			System.out.println(password);
		}

	}

	public static ArrayList<Object[]> getDataFromExcelSheet() {
		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		try {
			Xls_Reader reader = new Xls_Reader("A:\\JavaPrograms\\SeleniumReadAndWrite\\src\\test\\java\\Data.xlsx");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		for (int i = 2; i < reader.getRowCount("Sheet1"); i++) {
			String username = reader.getCellData("Sheet1", "Username", i);
			String password = reader.getCellData("Sheet1", "Password", i);

			Object[] obj = { username, password };
			mydata.add(obj);

		}

		return mydata;
	}
}
