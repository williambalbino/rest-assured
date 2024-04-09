package test;

import dataproviders.UserDataProvider;
import dto.User;
import factories.UserFactory;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payload.UserEndPoints;

public class UserTests {

    User userPayload;

    @Test(dataProvider = "createUser", dataProviderClass = UserDataProvider.class)
    public void testPostUser(int id, String username, String firstName, String lastName, String email, String password, String phone){
        userPayload = new User();

        userPayload.setId(id);
        userPayload.setUsername(username);
        userPayload.setFirstName(firstName);
        userPayload.setLastName(lastName);
        userPayload.setEmail(email);
        userPayload.setPassword(password);
        userPayload.setPhone(phone);

        Response response = UserEndPoints.createUser(userPayload);
        response.then().log().all();

        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(dataProvider = "createUser", dataProviderClass = UserDataProvider.class)
    public void testPostUserByPropertiesFile(int id, String username, String firstName, String lastName, String email, String password, String phone){
        userPayload = new User();

        userPayload.setId(id);
        userPayload.setUsername(username);
        userPayload.setFirstName(firstName);
        userPayload.setLastName(lastName);
        userPayload.setEmail(email);
        userPayload.setPassword(password);
        userPayload.setPhone(phone);

        Response response = UserEndPoints.createUserByPropertiesFIle(userPayload);
        response.then().log().all();

        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void testGetUser() {
        userPayload = UserFactory.createUser();
        UserEndPoints.createUser(userPayload);
        Response response = UserEndPoints.readUser(userPayload.getUsername());
        response.then().log().all();

        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test()
    public void testPutUser() {
        userPayload = UserFactory.createUser();
        UserEndPoints.createUser(userPayload);
        Response response = UserEndPoints.updateUser(userPayload, userPayload.getUsername());
        response.then().log().all();

        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void testDeleteUser() {
        userPayload = UserFactory.createUser();
        UserEndPoints.createUser(userPayload);
        Response response = UserEndPoints.deleteUser(userPayload.getUsername());
        response.then().log().all();

        Assert.assertEquals(response.statusCode(), 200);
    }



}
