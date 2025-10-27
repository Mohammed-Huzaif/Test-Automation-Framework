package com.ui.tests;

import com.ui.pages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchProductTest extends TestBase {

    private MyAccountPage myAccountPage;
    private static final String SEARCH_TERM = "Printed summer dress";

    @BeforeMethod
    public void setUp(){
        myAccountPage = homePage.goToLoginPage().doLoginWith("fitovo5678@endibit.com","password");
    }

    @Test(description = "Verifies if the user is able to search a Product and correct results are displayed",
            groups = {"e2e", "sanity"})
    public void verifyProductSearch(){
       boolean actualResult= myAccountPage.searchForAProduct(SEARCH_TERM).isSearchTermPresentInList(SEARCH_TERM);
      Assert.assertEquals(actualResult, true);
    }
}
