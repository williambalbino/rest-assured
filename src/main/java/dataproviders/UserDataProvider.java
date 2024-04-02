package dataproviders;

import org.testng.annotations.DataProvider;

public class UserDataProvider {

    @DataProvider(name = "createUser")
    public Object[][] createUser(){

        return new Object[][]
            {
                    //id, username, firstname, lastname, email, password, phone
                    {123, "john.doe", "John", "Doe", "john@email.com", "pass123", "14567899874"},

            };
    }

}
