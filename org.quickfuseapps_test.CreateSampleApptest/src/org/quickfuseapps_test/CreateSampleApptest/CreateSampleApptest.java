package org.quickfuseapps_test.CreateSampleApptest;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
public class CreateSampleApptest {
	@Test
	public void  CreateSampleAppFunc() throws InterruptedException
	{
	System.setProperty("webdriver.gecko.driver","F:/geckodriver-v0.21.0-win64/geckodriver.exe" );
    WebDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver, 10);
//1.	Go to url : http://quickfuseapps.com/
    driver.get("http://quickfuseapps.com/");
//2.	Click on Create an App
   WebElement createapp=(driver.findElement(By.id("link-create")));
   wait.until(ExpectedConditions.elementToBeClickable(createapp)).click();
//3. You will land up on default page and then click “Lets’ get started” :  
    driver.findElement(By.xpath("//button[contains(text(),'started!')]")).click();
//4. Create a new page and give it a name
    driver.findElement(By.id("add-page")).click();
    driver.findElement(By.xpath("//input[@class='indented submitonenter']")).sendKeys("Sample App Name");
    driver.findElement(By.xpath("//button[contains(@class,'ui-state-default ui-corner-all ui-button')]")).click();
//5. Click on “Messaging” group appearing on the left pane under MODULES : 
    WebElement msg=driver.findElement(By.linkText("Messaging"));
    wait.until(ExpectedConditions.elementToBeClickable(msg)).click();
   List <WebElement> sm=driver.findElements(By.xpath("//li[@class='module-item ui-widget-content ui-corner-all module-item-green ui-draggable']"));
    Actions act=new Actions(driver);
//6. Drag component “Send an SMS” to the main app page & join the line from start acting as connector :
    act.dragAndDropBy(sm.get(2),653, 30).build().perform();//90
//7. Fill the details of Phone Number and Message text :
    Thread.sleep(3000);
     driver.findElement(By.xpath("//textarea[contains(@name,'phone')]")).sendKeys("1234567890");
     driver.findElement(By.xpath("//textarea[contains(@name,'message_phrase')]")).sendKeys("TestMsg");
//8. Drag component “Send an email” from the left module and join line from “Not sent” output port.Also fill all the details of the mail as shown :
     Thread.sleep(3000);
     List<WebElement> connect1 = driver.findElements(By.xpath("//div[@class='syn-node ui-draggable syn-node-active']"));
     List<WebElement> connect0=driver.findElements(By.xpath("//div[@Class='syn-receptor ui-droppable syn-receptor-north ui-draggable syn-receptor-draggable']"));
     act.dragAndDrop(connect1.get(1), connect0.get(0)).build().perform();

//Drag component “Send an email” from the left module and join line from “Not sent” output port.Also fill all the details of the mail as shown 
act.dragAndDropBy(sm.get(1),1000, 120).build().perform();
Thread.sleep(3000);
driver.findElement(By.name("smtp_url")).sendKeys("smtp.gmail.com");
driver.findElement(By.xpath("//input[@class='text number']")).sendKeys("465");
driver.findElement(By.xpath("//input[@class='text' and @name='username']")).sendKeys("abc.gmail.com");
driver.findElement(By.xpath("//input[@class='text' and @name='password']")).sendKeys("password1");
driver.findElement(By.name("from_constant")).sendKeys("abc@gmail.com");
driver.findElement(By.name("to_constant")).sendKeys("xyz@gmail.com");
driver.findElement(By.name("subject_constant")).sendKeys("SMS not send");
List<WebElement> Msgphrase=driver.findElements(By.xpath("//textarea[@class='syn-autoexpand syn-constant syn-autogrow' and @name='message_phrase[]']"));
Msgphrase.get(1).sendKeys("SMS to phone number 2134567890 nt sent");
List<WebElement> connect2 = driver.findElements(By.xpath("//div[@class='syn-node syn-node-attached-e ui-draggable syn-node-active']"));
List<WebElement> connect3 = driver.findElements(By.xpath("//div[@class='syn-receptor ui-droppable syn-receptor-north ui-draggable syn-receptor-draggable']"));
act.dragAndDrop(connect2.get(0),connect3.get(1)).build().perform();

//Click on component “Basic” on left Module and drag “Exit App” joining to “Sent” output port of Sent an sms  box
driver.findElement(By.linkText("Basic")).click();
WebElement Exitdrag=driver.findElement(By.xpath("//li[@class='module-item ui-widget-content ui-corner-all module-item-red ui-draggable']"));
act.dragAndDropBy(Exitdrag,400,310).build().perform();//300
Thread.sleep(3000);
List<WebElement> connect4 = driver.findElements(By.xpath("//div[@class='syn-node syn-node-attached-w ui-draggable syn-node-active']"));
List<WebElement> connect5 = driver.findElements(By.xpath("//div[@class='syn-receptor ui-droppable syn-receptor-north ui-draggable syn-receptor-draggable']"));
act.dragAndDrop(connect4.get(0),connect5.get(2)).build().perform();
//WebElement Exitdrag2=driver.findElement(By.xpath("//li[@Class='module-item ui-widget-content ui-corner-all module-item-red ui-draggable']"));
act.dragAndDropBy(Exitdrag,800,310).build().perform();
act.dragAndDropBy(Exitdrag,1250,310).build().perform();
Thread.sleep(3000);
List<WebElement> connect6=driver.findElements(By.xpath("//div[@class='syn-node syn-node-attached-w ui-draggable syn-node-active']"));
List<WebElement> connect7=driver.findElements(By.xpath("//div[@class='syn-receptor ui-droppable syn-receptor-north ui-draggable syn-receptor-draggable']"));
List<WebElement> connect8=driver.findElements(By.xpath("//div[@class='syn-node syn-node-attached-e ui-draggable syn-node-active']"));
List<WebElement> connect9=driver.findElements(By.xpath("//div[@class='syn-receptor ui-droppable syn-receptor-north ui-draggable syn-receptor-draggable']"));
act.dragAndDrop(connect6.get(0),connect7.get(3)).build().perform();
act.dragAndDrop(connect8.get(0),connect9.get(4)).build().perform();
//driver.close(); 
    
  }
		
}


