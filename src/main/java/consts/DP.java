package consts;

import org.testng.annotations.DataProvider;

public class DP {
    @DataProvider(name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {{"example.com"}, {"@example.com"}, {"example@dotcom"}, {"exaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaample@gmail.com"}, {"example@gmailcom"}};
    }
}
