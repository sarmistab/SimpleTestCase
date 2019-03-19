package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RETC_041POM {

	private WebDriver driver; 

	public RETC_041POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	//Blog
	@FindBy(xpath="//li//a[contains(text(), 'Blog')][1]")
	private WebElement blog;
	//Read More
	@FindBy (xpath="//div[@class='post-content']//a[@class='read-more']")
	private WebElement readMore;
	//Comment Textbox
	@FindBy (id="comment")
	private WebElement commentText;
	//Name textbox
	@FindBy(name="author")
	private WebElement nameText;
	//Email address	
	@FindBy (name="email")
	private WebElement emailAddress;
	//Comment button
	@FindBy(name="submit")
	private WebElement postCommentbtn;
	//comments link in admin page 
	@FindBy (xpath="//li//a//div[contains(text(), 'Comments')]")
	private WebElement commentsLink;

//click Blog link
	public  void clickBlog() {
		this.blog.click();
	}
//Click ReadMore link
	public  void clickReadMore() {
		this.readMore.click();
	}
//Enter Comment in text box
	public  void sendCommentText(String commentText ) {
		this.commentText.clear();
		this.commentText.sendKeys(commentText);
	}
//Enter Name
	public  void sendNameText(String nameText ) {
		this.nameText.clear();
		this.nameText.sendKeys(nameText);
	}
//Enter Email address
	public void sendEmailAddress(String emailAddress) {
		this.emailAddress.clear();
		this.emailAddress.sendKeys(emailAddress);
	}
//Click comment button
	public  void clickPostCommentbtn() {
		this.postCommentbtn.click();
	}
//Click on Comments link
	public  void clickCommentsLink() {
		this.commentsLink.click();
	}
}










