package demoqa.com;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class FirstTest {
    @BeforeAll
    static void setup() {
        Configuration.browserSize = "760x840";
        Configuration.browserPosition = "0x0";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillAutomationPracticeForm() {
        DataForFirstTest testPerson= new DataForFirstTest("Ivanov","Ivan","iviv@mail.ru","Male","7890890898","12.12.1980","Reading","test.jpg","Canal Street","NCR","Noida");
        open("/automation-practice-form");
        setDataToForm(testPerson);
        clickSubmitButton();
        assertData(testPerson);
    }

    void setDataToForm(DataForFirstTest data)
    {
        $("#firstName").setValue(data.firstName);
        $("#lastName").setValue(data.lastName);
        $("#userEmail").setValue(data.email);
        $("#genterWrapper").find(new ByText(data.gender)).click();
        $("#userNumber").setValue(data.mobile);
        $("#dateOfBirthInput").sendKeys(Keys.CONTROL + "a");
        $("#dateOfBirthInput").sendKeys(data.dateOfBirth + Keys.ENTER);
        $("#hobbiesWrapper").find(new ByText(data.hobbies)).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/" + data.picture));
        $("#currentAddress").setValue(data.currentAddress);
        $("#react-select-3-input").setValue(data.state).pressEnter();
        $("#react-select-4-input").setValue(data.city).pressEnter();
        for (int i = 0; i < data.subjects.length; i++) {
            $("#subjectsInput").setValue(data.subjects[i]).pressEnter();}
    }

    void clickSubmitButton(){
        $("#submit").click();
    }

    void assertData(DataForFirstTest data){
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").find(new ByText("Student Name")).parent().lastChild().shouldHave(text(data.firstName + " " + data.lastName));
        $(".modal-body").find(new ByText("Student Email")).parent().lastChild().shouldHave(text(data.email));
        $(".modal-body").find(new ByText("Gender")).parent().lastChild().shouldHave(text(data.gender));
        $(".modal-body").find(new ByText("Mobile")).parent().lastChild().shouldHave(text(data.mobile));
        $(".modal-body").find(new ByText("Hobbies")).parent().lastChild().shouldHave(text(data.hobbies));
        $(".modal-body").find(new ByText("Address")).parent().lastChild().shouldHave(text(data.currentAddress));
        $(".modal-body").find(new ByText("State and City")).parent().lastChild().shouldHave(text(data.state + " " + data.city));
        $(".modal-body").find(new ByText("Picture")).parent().lastChild().shouldHave(text(data.picture));
        $(".modal-body").find(new ByText("Subjects")).parent().lastChild().shouldHave(text("Maths, Physics, Computer Science, English"));
        $(".modal-body").find(new ByText("Date of Birth")).parent().lastChild().shouldHave(text("12 December,1980"));
    }
}
