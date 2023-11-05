import base.BaseTest;

import com.microsoft.playwright.Locator;
import org.testng.annotations.Test;
import utils.TestData;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static utils.ProjectConstants.BASE_URL;
import static utils.ProjectConstants.EXPECTED_HOME_TITLE;

public class HomePageTest extends BaseTest {

    @Test
    public void verifyHomeUrlAndTitle() {

        assertThat(getPage()).hasURL(BASE_URL);
        assertThat(getPage()).hasTitle(EXPECTED_HOME_TITLE);
    }

    @Test
    public void verifyLogo() {
        Locator logoIng = getPage().locator("css=a.logo img[src*='logo.svg']");

        assertThat(logoIng).isVisible();
    }

    @Test
    public void verifyInputSearch() {
        Locator inputSearchField = getPage().locator("css=input#search");

        assertThat(inputSearchField).isVisible();
        assertThat(inputSearchField).hasAttribute("placeholder", "Search entire store here...");
    }

    @Test
    public void verifyCheckoutCart() {
        Locator checkoutCartBtn = getPage().locator("css=a.showcart[href*='checkout/cart']");
        checkoutCartBtn.click();
        Locator blockContent = getPage().locator("css=div#minicart-content-wrapper div.block-content strong");

        assertThat(checkoutCartBtn).isVisible();
        assertThat(blockContent).hasText("You have no items in your shopping cart.");
    }

    @Test
    public void verifyNavigationMenu() {
        String[] expectedMenuItems = {"What's New", "Women", "Men", "Gear", "Training", "Sale"};

        Locator navigationMenu = getPage().locator("css=div[id='store.menu'] nav.navigation");
        Locator menuItems = getPage().locator("css=div[id='store.menu']>nav.navigation>ul >li>a");

        assertThat(navigationMenu).isVisible();
        assertThat(menuItems).hasCount(expectedMenuItems.length);
        assertThat(menuItems).hasText(expectedMenuItems);
    }


    @Test(dataProvider = "NavigationBarTestData", dataProviderClass = TestData.class)
    public void verifyNavigationMenuBar(String cssSelector, String expectedUrl, String expectedTitle) {

        assertThat(getPage()).hasURL(BASE_URL);
        assertThat(getPage()).hasTitle(EXPECTED_HOME_TITLE);

        getPage().locator(cssSelector).click();

        assertThat(getPage()).hasURL(BASE_URL + expectedUrl);
        assertThat(getPage()).hasTitle(expectedTitle);
    }
}
