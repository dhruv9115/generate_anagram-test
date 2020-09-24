package anagram;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.util.Assert;

@SuppressWarnings("deprecation")
public class WebActionsTest {
	
	//private WebDriver driver;

	@Test
	public void tests() {
		HtmlUnitDriver driver = new HtmlUnitDriver(true);
		
		String[] expectedList = {"cta", "atc", "tca", "act", "tac", "cat"};
		
		List<String> elist = Arrays.asList(expectedList);

		driver.get("http://anagram-balancer-820921435.us-east-1.elb.amazonaws.com:8080");
		
		System.out.println("Title of the page is -> " + driver.getTitle());

		WebElement link = driver.findElement(By.xpath("/html/body/a"));
		link.click();

		WebElement word = driver.findElement(By.id("word"));
		word.sendKeys("cat");

		WebElement submit = driver.findElement(By.xpath("//*[@id=\"form\"]/button"));
		submit.click();

		// //*[@id="form"]/table/tbody/tr[1]/th

		// *[@id="form"]/table/tbody/tr[2]/td

		List<WebElement> anagrams = driver.findElements(By.xpath("//*[@id=\"form\"]/table/tbody/tr//td"));

		List<String> angs = new ArrayList<String>();
		for (WebElement element : anagrams) {
			angs.add(element.getText());
		}

		System.out.println(angs);
		
		boolean flag = angs.equals(elist);
		
		System.out.println(flag);
		
		driver.quit();
		
		Assert.isTrue(flag, "Anagrams list does not match the expected result");
		
		
		//assert.assertThat(angs.equals(elist));

		

	}

}
