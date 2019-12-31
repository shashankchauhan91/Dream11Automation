package com.aut.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeaguesPage 
{
	  WebDriver driver;

    @FindBy(xpath="//div[@class='siteTabText_ce5fe' and text()='cricket']")
   WebElement cricketTab;    
    
    @FindBy(xpath="//div[@class='siteTabText_ce5fe' and text()='football']")
    WebElement footballTab;
    
    @FindBy(xpath="/html/head/meta[@name='description']/preceding-sibling::title")
    WebElement leaguePageTitle;
    
    @FindBy(xpath="//div[contains(@class,'squadShortNameLeft')]")
    List<WebElement> leftTeamNames;
    
    @FindBy(xpath="//div[contains(@class,'squadShortNameRight')]")
    List<WebElement> rightTeamNames;
    
    @FindBy(xpath="//div[contains(@class,'matchCardTimer')]/div")
    List<WebElement> timeLeft;    
  
    @FindBy(xpath="//div[contains(@class,'roleTabItem')]")
    List<WebElement> roleTabs;
    
    @FindBy(xpath="//div[contains(@class,'playerCardIconDisabled')]")
    List<WebElement> disbledPlayersList;
    
    @FindBy(xpath="//div[contains(@class,'playerCardIconSelected')]")
    List<WebElement> playersAdded;
    
    @FindBy(xpath="//i[text()='add']/parent::div[contains(@class,'playerCardIcon_')]")
    List<WebElement> playersTOAdd;
    
    @FindBy(xpath="//div[contains(@class,'creditsText')]/div")
    WebElement creditLeft;	
    
    @FindBy(xpath="//div[@class='shepherd-has-title shepherd-element']//a")
    WebElement shephertButton;
    
    @FindBy(xpath="//div[@class='shepherd-has-title shepherd-element']//a[text()='NEXT']")
    WebElement shephertButtonNxt;
    
    @FindBy(xpath="//div[@class='shepherd-has-title shepherd-element']//a[text()='GOT IT']")
    WebElement shepherdButtonGotIt;
    
    @FindBy(xpath="//button[text()='CONTINUE']")
    WebElement continueBtn;
    
    //We can also use captain and vice captain with there name but need to provide that data to script
    @FindBy(xpath="//div[contains(@class,'playerName')]/ancestor::div[contains(@class,'playerCard_')]//div[contains(@class,'roleIcon_') and text()='C']")
    List<WebElement> captainWithNames;
    
    @FindBy(xpath="//div[contains(@class,'playerName')]/ancestor::div[contains(@class,'playerCard_')]//div[contains(@class,'roleIcon_') and text()='VC']")
    List<WebElement> viceCaptainWithNames;
  
    @FindBy(xpath="//button[text()='SAVE TEAM']")
    WebElement saveTeamBtn;
    
    @FindBy(xpath="//div[contains(@class,'segmentHeaderContainer')]//div[contains(@class,'headerTitle')]")
    List<WebElement> contestList;
    	
    @FindBy(xpath = "//div[text()='Contests']")
    WebElement validateContestDisplayed;
    
    public LeaguesPage(WebDriver driver)
    {
        this.driver = driver;	       
        PageFactory.initElements(driver, this);

    }   
    
    public WebElement getContestPageDisplayed()
    {
    	return validateContestDisplayed;
    }
    
    public List<WebElement> getContestList()
    {
    	return this.contestList;
    }
    public WebElement getGotItBtn()
    {
    	return this.shepherdButtonGotIt;
    }

    public void clickCricketTab()
    {
      	cricketTab.click();
    }
    
    public void clickFootballTab()
    {
    	footballTab.click();
    }
    
    public String getTitleLeaguePage()
    {
    	return driver.getTitle();
    }
    
    public WebElement getTitleWebElement()
    {
    	return leaguePageTitle;
    }
    
    public List<String> getlistOfLeftTeams()
    {
    	List<String> leftTempList = new ArrayList<String>();
    	for (WebElement webElement : leftTeamNames) {
    		leftTempList.add(webElement.getText());
		}
    	return leftTempList;
    }
    
    public List<String> getlistOfRightTeams()
    {
    	List<String> rightTempList = new ArrayList<String>();
    	for (WebElement webElement : rightTeamNames) {
    		rightTempList.add(webElement.getText());
		}
    	return rightTempList;
    }
    
    public List<String> getlistofTimeLeft()
    {
    	List<String> timeLeftList = new ArrayList<String>();
    	for (WebElement webElement : timeLeft) {
    		timeLeftList.add(webElement.getText());
		}
    	return timeLeftList;
    }
    
    public void clickOnFirstLeague()
    {
    	timeLeft.get(0).click();
    }
    
    public List<WebElement> getRoleTabs()
    {
    	return roleTabs;
    }

    public List<WebElement> getListofPlayersToAdd()
    {
    	return playersTOAdd;
    }
    
    public void shepherBtnClick()
    {
    	shephertButton.click();
    }
    
    public void shepherdBtnNextClick() {
    	shephertButtonNxt.click();
    }
    
    public void shepherBtnGotItClick() {
    	shepherdButtonGotIt.click();
    }

    public WebElement getContinueBtn() {
    	return continueBtn;
    }
    
    public void clickCaptain()
    {
    	captainWithNames.get(4).click();
    	
    }
    
    public void clickViceCaptain()
    {
    	viceCaptainWithNames.get(5).click();
    }
    
    public WebElement getSaveTeamBtn() {
    	return this.saveTeamBtn;
    }
    
    public void clickSaveTeamBtn()
    {
    	saveTeamBtn.click();
    }
}
