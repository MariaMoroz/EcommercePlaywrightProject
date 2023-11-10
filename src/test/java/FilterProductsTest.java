import base.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FilterProductsTest extends BaseTest {

    @Test
    public void verifyProductTitles() {
        getPage().navigate("https://magento.softwaretestingboard.com/");
        getPage().locator("nav.navigation ul li a[href*='/men.html'] span:first-child").click();
        getPage().locator("div.sidebar li a[href*='/tops-men.html']").click();
        getPage().getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("Category")).click();
        getPage().locator("css=li a[href*='/men/tops-men.html?cat=16']").click();

        Locator productTitles = getPage().locator("css=div.product-item-details a.product-item-link");
        assertThat(productTitles).hasCount(12);
        assertThat(productTitles).containsText("Tee");
    }
}
