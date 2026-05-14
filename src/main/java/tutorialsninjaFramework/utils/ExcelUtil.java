package tutorialsninjaFramework.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtil {
	// Path to the Excel file we just created
    public static final String TEST_DATA_SHEET_PATH = "./src/test/resources/testdata/TutorialsNinjaTestData.xlsx";
    private static Workbook book;
    private static Sheet sheet;

    /**
     * This method reads data from the specified Excel sheet and returns it as a 2D Object array.
     * @param sheetName The name of the sheet inside the Excel workbook (e.g., "Login")
     * @return 2D Object Array containing the test data
     */
    public static Object[][] getTestData(String sheetName) {
        Object[][] data = null;
        try {
            // FileInputStream opens the connection to the physical file
            FileInputStream ip = new FileInputStream(TEST_DATA_SHEET_PATH);
            
            // WorkbookFactory creates the Java representation of the Excel workbook
            book = WorkbookFactory.create(ip);
            sheet = book.getSheet(sheetName);

            // Initialize the 2D array based on the number of rows and columns in the sheet
            // We use getLastRowNum() which ignores the header row if we structure our loop correctly
            data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

            // Iterate through the rows (starting at i=0 for the array, but row i+1 in Excel to skip the header)
            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                    // Extract the cell value as a String and store it in the array
                    data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data; // Return the populated array to the TestNG DataProvider
    }
}
