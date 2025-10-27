package com.ui.tests;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class AddNewAddressTest extends TestBase {

    private MyAccountPage myAccountPage;
    private AddressPOJO addressPOJO;

    @BeforeMethod(description = "Valid First Time USer Login in to Application")
    public void setUp(){
        myAccountPage = homePage.goToLoginPage().doLoginWith("fitovo5678@endibit.com","password");
        addressPOJO = FakeAddressUtility.getFakeAddress();
    }

    @Test
    public void addNewAddress(){
        String newAdress = myAccountPage.goToAddressPage().saveAddress(addressPOJO);
        assertEquals(newAdress, addressPOJO.getAddressAlias().toUpperCase());

    }
}
