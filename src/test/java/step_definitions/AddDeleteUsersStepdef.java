package step_definitions;

import java.util.List;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.UserInfoPage;
import utilities.BrowserUtilis;
import utilities.Driver;
import utilities.PropertiesReader;

public class AddDeleteUsersStepdef {


	UserInfoPage userInfoPage = new UserInfoPage();
	BrowserUtilis util = new BrowserUtilis();
	String expectFirstName="novak";
	

	@Given("I am on the userInfo Page")
	public void user_is_on_the_user_info_page() {
		Driver.getDriver().get(PropertiesReader.getProperty("URL"));
		String currentUrl= Driver.getDriver().getCurrentUrl();
		Assert.assertTrue(userInfoPage.addUserBtn.isDisplayed());
		//System.out.println(currentUrl);
		
		Assert.assertEquals(currentUrl, "https://www.way2automation.com/angularjs-protractor/webtables/");

	}

	@When("I click on AddUser button then I am on the Add User page")
	public void user_click_on_add_user_button_and_uset_is_on_add_user_page() {
		userInfoPage.addUserBtn.click();
		Assert.assertTrue(userInfoPage.addUserText.isDisplayed());
	}
	
	@Then("I add new user with following details| novak | Mat | novakMat | {int} | novak@gmail.com | {int}-{int}-{int} |")
	public void i_add_new_user_with_following_details_novak_mat_novak_mat_novak_gmail_com(DataTable dataTable) {
	    
		List<String> list = dataTable.asList();
		userInfoPage.firstNamefild.sendKeys(list.get(0));
		util.customWait(1);
		userInfoPage.lastNameFild.sendKeys(list.get(1));
		util.customWait(1);
		userInfoPage.userNameFild.sendKeys(list.get(2));
		util.customWait(1);
		userInfoPage.password.sendKeys(list.get(3));
		util.customWait(1);
		userInfoPage.EmailFild.sendKeys(list.get(4));
		util.customWait(1);
		userInfoPage.cellPhoneFild.sendKeys(list.get(5));
		

	}

	@When("I click Company AAA")
	public void user_click_company_aaa() {
		util.handleCheckBox(userInfoPage.customerCompanyAAACheckBox, true);
		util.customWait(2);
		util.handleCheckBox(userInfoPage.customerCompanyBBBCheckBox, true);

	}

	@When("I select Role as Sales Team")
	public void user_select_role_as_sales_team() {
		util.selectDropDownText(userInfoPage.roleDropDown, "Customer");
	}

	@Then("I click on Save button")
	public void user_click_on_save_button() {
		userInfoPage.saveBtn.click();
	}

	@Then("The added user displayed on the table")
	public void the_added_user_displayed_on_the_table() {
		util.waitUntilElemetIsVisible(userInfoPage.anyRowFirstName.get(0));
		for(WebElement element:  userInfoPage.anyRowFirstName) {
			String actualFirstName =element.getText();
			boolean flag=false;
			if(actualFirstName.equals(expectFirstName)) {
				flag=true;
				
			}
			
		Assert.assertTrue(flag);
	}
	}
	@When("I click on the delete button")
	public void user_clicks_on_the_delete_button() {
		userInfoPage.removeUserIcon.click();
	}

	@Then("a confirmation Dialog should appear with the text: {string}")
	public void a_confirmation_dialog_should_appear_with_the_text(String string) {
		util.waitUntilElemetIsVisible(userInfoPage.confirmationText);
		Assert.assertTrue(userInfoPage.confirmationText.isDisplayed());
	}

	@When("I click on Ok button")
	public void user_clicks_on_ok_button() {
		userInfoPage.confirmationBtn.click();
	}

	@Then("The user should be deleted")
	public void the_user_should_be_deleted() {
		util.waitUntilElemetIsVisible(userInfoPage.addUserBtn);
		for(WebElement element:  userInfoPage.anyRowFirstName) {
			String actualFirstName =element.getText();
			boolean flag=false;
			if(actualFirstName.equals(expectFirstName)) {
				
				Assert.assertTrue(flag);
				
			}
			flag=true;
			
		
	}
		
	}

}
