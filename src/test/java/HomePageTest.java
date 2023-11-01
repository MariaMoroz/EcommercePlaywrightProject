import base.BaseTest;

import com.microsoft.playwright.Locator;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePageTest extends BaseTest {

    @Test
    public void verifyHomeUrlAndTitle() {

        String expectedHomeURL = "https://magento.softwaretestingboard.com/";
        String expectedHomeTitle = "Home Pag";

        assertThat(getPage()).hasURL(expectedHomeURL);
        assertThat(getPage()).hasTitle(expectedHomeTitle);
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
}
