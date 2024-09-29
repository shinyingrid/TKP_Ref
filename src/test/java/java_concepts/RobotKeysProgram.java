package java_concepts;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class RobotKeysProgram 
{
	public static void main(String[] args) throws AWTException, HeadlessException, UnsupportedFlavorException, IOException 
	{
		WebDriver driver = new EdgeDriver();
		driver.get("https://example.com/");
		
		
		Robot robot = new Robot();
		
		//To simulate control + A and select all the contents in the page
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_A);
		
		
		//To simulate Ctrl+C and copy content
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);
		
		String pastedText = (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
		
		//String pastedText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        System.out.println("Pasted text: " + pastedText);
		
		driver.quit();
	}
}
