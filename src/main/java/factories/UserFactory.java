package factories;

import com.github.javafaker.Faker;
import dto.User;

public class UserFactory {

    public static User createUser(){
        User user = new User();
        Faker faker = new Faker();

        user.setId(faker.idNumber().hashCode());
        user.setUsername(faker.name().username());
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.internet().password());
        user.setPhone(faker.phoneNumber().cellPhone());

        return user;


    }
}
