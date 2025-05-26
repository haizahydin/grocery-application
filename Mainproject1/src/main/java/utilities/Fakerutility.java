package utilities;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;

public class Fakerutility
{
	Faker faker=new Faker();
	public String generatename()
	{
		return faker.name().fullName();
	}
	public String generatephonenum()
	{
		return faker.phoneNumber().toString();
	}
	public String generatepincode()
	{
		return faker.idNumber().toString();//value changed to string
	}
	public String Generateplace()
	{
		return faker.job().position();
	}
	public String generate()
	{
		return faker.color().name();
	}
	public String address()
	{
		return faker.address().toString();
	}
	public String email()
	{
		return faker.internet().emailAddress();
	}
}
