package test.classes.testcase;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aut.pom.LeaguesPage;

import junit.framework.Assert;

public class Dream11LeaguesTest {	
	
	    WebDriver driver;
	    LeaguesPage objLeagues;
	    String tabToClick;
   

	    @Before
	    public void setup()
	    {
	    	tabToClick = System.getProperty("SportToChoose");	    	
	    	String path = "src/test/resources";
	    	File file = new File(path);    		    	
	    	System.setProperty("webdriver.chrome.driver", file.getAbsolutePath()+ "\\chromedriver.exe");
	    	DesiredCapabilities capabilities = new DesiredCapabilities();
	    	capabilities.setCapability("UNHANDLED_PROMPT_BEHAVIOUR", "accept");
	    	ChromeOptions options = new ChromeOptions();
	    	options.merge(capabilities);
	        driver = new ChromeDriver(options);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	        driver.get("https://www.dream11.com/leagues");	        

	    }

	   
	    @Test
	    public void testLeaguePageAppearCorrect()
	    {
	    	objLeagues = new LeaguesPage(driver);	    
	    	String leaguePageTitle = objLeagues.getTitleLeaguePage();	    	
	    	Assert.assertTrue(leaguePageTitle.equalsIgnoreCase("Play Fantasy Sport | Cricket, Football, NBA, Hockey & Kabaddi | DREAM11"));	
	  
	    }

		@Test
	    public void testLeaguePageAppear()
	    {
	    	objLeagues = new LeaguesPage(driver);	    
	    	String leaguePageTitle = objLeagues.getTitleLeaguePage();	    	
	    	Assert.assertTrue(leaguePageTitle.equalsIgnoreCase("Play Fantasy Sport | Cricket, Football, NBA, Hockey & Kabaddi | DREAM11"));	
	  
	    }
	    
	    @Test
	    public void printAndTestUpComingMatch()
	    {
	    	objLeagues = new LeaguesPage(driver);
	    	String leaguePageTitle = objLeagues.getTitleLeaguePage();	
	    	Assert.assertTrue(leaguePageTitle.equalsIgnoreCase("Play Fantasy Sport | Cricket, Football, NBA, Hockey & Kabaddi | DREAM11"));	
	    	
	    	if(tabToClick.equalsIgnoreCase("cricket"))
	    	{
	    		objLeagues.clickCricketTab();
	    	}
	    	if(tabToClick.equalsIgnoreCase("football"))
	    		objLeagues.clickFootballTab();
	    	
	    	System.out.println("T1 Vs T2 TimeLeft");
	    	for (int index = 0; index < objLeagues.getlistOfLeftTeams().size() ; index++)
	    	{
	    		System.out.println( objLeagues.getlistOfLeftTeams().get(index) + " "+  objLeagues.getlistOfRightTeams().get(index) + "  " + objLeagues.getlistofTimeLeft().get(index) );
	    	}    	
	    	
	    }
	    
	    @Test
	    public void createTeamByChoosingPlayers()
	    {
	    	int size=2;
	    	objLeagues = new LeaguesPage(driver);	    	
	    	objLeagues.clickOnFirstLeague();
	    	
	    	objLeagues.shepherBtnClick();
	    	objLeagues.shepherdBtnNextClick();
	    	objLeagues.shepherBtnGotItClick();
	    	
	    	
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, 20);
	    	wait.until(ExpectedConditions.elementToBeClickable(objLeagues.getRoleTabs().get(0)));  	
	    	
	    	objLeagues.getRoleTabs().get(0).click();
	    	
	    	//Adding Two Wicket Keepers
	    	if(objLeagues.getListofPlayersToAdd().size() < 2)
	    		size =  objLeagues.getListofPlayersToAdd().size();
	    	for(int index =0; index < size; index++) {
	    		objLeagues.getListofPlayersToAdd().get(index).click();
	    	}
	    	
	    	
	    	wait.until(ExpectedConditions.elementToBeClickable(objLeagues.getRoleTabs().get(1)));
	    	objLeagues.getRoleTabs().get(1).click();
	    	size=3;
	    	//Add Three Batsman
	    	objLeagues.getListofPlayersToAdd().size();
	    	for(int index =0; index < size; index++) {
	    		Actions build = new Actions(driver); 
	    	    build.moveToElement(objLeagues.getListofPlayersToAdd().get(index)).click().build().perform(); 
	    	}
	    	
	    	//Add Three All rounders
	    	wait.until(ExpectedConditions.elementToBeClickable(objLeagues.getRoleTabs().get(2)));
	    	objLeagues.getRoleTabs().get(2).click();
	    	size=3;	    	
	    	objLeagues.getListofPlayersToAdd().size();
	    	for(int index =1; index <= size; index++) {
	    		Actions build = new Actions(driver); 
	    	    build.moveToElement(objLeagues.getListofPlayersToAdd().get(index)).click().build().perform();      
	    		
	    	}
	    	
	    	//Add Three bowlers 
	    	wait.until(ExpectedConditions.elementToBeClickable(objLeagues.getRoleTabs().get(3)));
	    	objLeagues.getRoleTabs().get(3).click();
	    	size=4;
	    	//Add Three bowlers
	    	objLeagues.getListofPlayersToAdd().size();
	    	for(int index =2; index <= size; index++) {
	    		Actions build = new Actions(driver); 
	    	    build.moveToElement(objLeagues.getListofPlayersToAdd().get(index)).click().build().perform();   		    	    
	    	}
	    	
	    	wait.until(ExpectedConditions.elementToBeClickable(objLeagues.getContinueBtn()));
	    	//verify Conitnue Button is enable
	    	Assert.assertTrue(objLeagues.getContinueBtn().isEnabled());
	    	
	    	if(objLeagues.getContinueBtn().isEnabled())
	    		objLeagues.getContinueBtn().click();
	    	
	    	
	    	objLeagues.clickCaptain();
	    	objLeagues.clickViceCaptain();
	    	
	    	Assert.assertTrue(objLeagues.getSaveTeamBtn().isEnabled());
	    	
	    	objLeagues.clickSaveTeamBtn();
	    	
	    	if(objLeagues.getGotItBtn().isDisplayed())
	    		objLeagues.shepherBtnGotItClick();
	    	
	    	Assert.assertTrue(objLeagues.getContestPageDisplayed().isDisplayed());
	    	
	    	
	    	Assert.assertTrue(objLeagues.getContestList().size() > 5);
	    	
	    	System.out.println("Contest Displayed Below :");
	    	for(int index = 0; index < objLeagues.getContestList().size(); index++)
	    	{
	    		System.out.println(objLeagues.getContestList().get(index).getText());
	    	}
	    	
	    	
	    }
	    
	    
	    @After
	    public void quitBrowser()
	    {
	    	driver.quit();
	    }

	}

