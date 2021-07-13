package DataDrivenTest;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;


public class DataDriven {

    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFCell cell;
    public static File src;

    @Test
    public void SampleDataDrivenTest() throws IOException, InterruptedException{

        // Dosya import edilir.
        src = new File("C:\\Users\\FurkanGuler\\Desktop\\Related Case Study\\Login(Data Driven).xlsx");
        FileInputStream finput = new FileInputStream(src);
        workbook = new XSSFWorkbook(finput);
        sheet = workbook.getSheetAt(0);

        System.setProperty("webdriver.chrome.driver", "C:\\eclipse\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://euromsgexpress.com");
        driver.findElement(By.xpath("//a[text()='GİRİŞ']")).click();
        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);

        // Excel den alınan veriler ile form doldurulur.
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#exampleInputEmail1")));

        for(int i=1; i<8; i++) {
        	 
        
        cell = sheet.getRow(i).getCell(1);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        String ad = cell.getStringCellValue();
        driver.findElement(By.cssSelector("#exampleInputEmail1")).sendKeys(ad);

        
        cell = sheet.getRow(i).getCell(2);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        String soyad = cell.getStringCellValue();
        driver.findElement(By.cssSelector("#exampleInputPassword1")).sendKeys(soyad);
        
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#exampleInputEmail1")).clear();
        driver.findElement(By.cssSelector("#exampleInputPassword1")).clear();
        
        }
        
    }
    public static void TestResult(ITestResult result) throws Exception {
    	
    	
    	for(int i=1; i<8; i++) {
        if (result.getStatus() == ITestResult.FAILURE) {
        	
        	System.setProperty("webdriver.chrome.driver", "C:\\eclipse\\chromedriver\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            
            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    		FileUtils.copyFile(src, new File("C:\\Users\\FurkanGuler\\Desktop\\Related Case Study\\screenshot.png"));
            sheet.getRow(i).createCell(3).setCellValue("FAILURE Test");
            FileOutputStream fileOutput = new FileOutputStream(src);
            workbook.write(fileOutput);

        } else if (result.getStatus() == ITestResult.SKIP) {

            sheet.getRow(i).createCell(3).setCellValue("SKIP Test");
            FileOutputStream fileOutput = new FileOutputStream(src);
            workbook.write(fileOutput);

        } else if (result.getStatus() == ITestResult.SUCCESS) {

            sheet.getRow(i).createCell(3).setCellValue("SUCCESS Test");
            FileOutputStream fileOutput = new FileOutputStream(src);
            workbook.write(fileOutput);
        }
     }
    }

}

