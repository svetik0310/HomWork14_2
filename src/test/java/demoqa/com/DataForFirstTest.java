package demoqa.com;

public class DataForFirstTest {
    String firstName;
    String lastName;
    String email;
    String gender;
    String mobile;
    String dateOfBirth;
    String hobbies;
    String picture;
    String currentAddress;
    String state;
    String city;
    String[] subjects = {"Maths", "Physics", "Computer Science","English"};

    public DataForFirstTest(String firstName,String lastName,String email,String gender,String mobile,String dateOfBirth,String hobbies,String picture,String currentAddress,String state,String city)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.mobile = mobile;
        this.dateOfBirth = dateOfBirth;
       // this.subjects = subject;
        this.hobbies = hobbies;
        this.picture = picture;
        this.currentAddress = currentAddress;
        this.state = state;
        this.city = city;
    }

}
