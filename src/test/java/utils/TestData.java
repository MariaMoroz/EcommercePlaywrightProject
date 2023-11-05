package utils;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "NavigationBarTestData")
    public static Object[][] topMenuTestDataProvider() {
        return new Object[][] {
                {"div[id='store.menu']>nav>ul[role='menu']>li>a[href*='/what-is-new.html']", "what-is-new.html", "What's New"},
                {"div[id='store.menu']>nav>ul[role='menu']>li>a[href*='/women.html']", "women.html", "Women"},
                {"div[id='store.menu']>nav>ul[role='menu']>li>a[href*='/men.html']", "men.html", "Men"},
                {"div[id='store.menu']>nav>ul[role='menu']>li>a[href*='/gear.html']", "gear.html", "Gear"},
                {"div[id='store.menu']>nav>ul[role='menu']>li>a[href*='/training.html']", "training.html", "Training"},
                {"div[id='store.menu']>nav>ul[role='menu']>li>a[href*='/sale.html']", "sale.html", "Sale"}
        };
    }
}
