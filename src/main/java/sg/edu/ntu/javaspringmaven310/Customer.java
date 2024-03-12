package sg.edu.ntu.javaspringmaven310;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    private final String id;
    private String firstName;
    private String lastName;
    private String contactNo;
    private String jobTitle;
    private String yearOfBirth;

    // public String getId() {
    //     return id;
    // }

    public Customer(){
        this.id = UUID.randomUUID().toString();
        
    }
    public Customer(String firstName, String lastName){
        this.id = UUID.randomUUID().toString();
        // this.firstName = firstName;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    
    // public void setId(String id) {
    //     this.id = id;
    // // }
    // public String getFirstName() {
    //     return firstName;
    // }
    // public void setFirstName(String firstName) {
    //     this.firstName = firstName;
    // }
    // public String getLastName() {
    //     return lastName;
    // }
    // public void setLastName(String lastName) {
    //     this.lastName = lastName;
    // }
    // public String getContactNo() {
    //     return contactNo;
    // }
    // public void setContactNo(String contactNo) {
    //     this.contactNo = contactNo;
    // }
    // public String getJobTitle() {
    //     return jobTitle;
    // }
    // public void setJobTitle(String jobTitle) {
    //     this.jobTitle = jobTitle;
    // }
    // public String getYearOfBirth() {
    //     return yearOfBirth;
    // }
    // public void setYearOfBirth(String yearOfBirth) {
    //     this.yearOfBirth = yearOfBirth;
    // }
    
}
