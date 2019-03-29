import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testSample2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		dataDriven2 data = new dataDriven2();
		String fileName = "D:\\\\Pramod\\\\Projects\\\\BRT Portal\\\\WhatsApp\\\\EmpWhatsApp.xlsx";
		String empName = null;
		String mobileNumber = null;
		data.readXLSXFile(fileName, empName, mobileNumber);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		dataDriven2 readXlsx = new dataDriven2();
		//readXlsx.readXLSXFile(fileName, mobileNumber, empName);	
//		String mobileNumber1 = null;
//		String empName1 = null;
		driver.get("https://api.whatsapp.com/send?phone="+mobileNumber+"&text="+empName+"urlencodedtext&source=&data=");
	}

}
