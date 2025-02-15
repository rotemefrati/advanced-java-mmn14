package main.java.com.maman14.q1;

public class Student implements Comparable<Student> {

    private String firstName;
    private String lastName;
    private String idNumber;
    private String yearOfBirth;

    // constructor
    public Student(String firstName, String lastName, String idNumber, String yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.yearOfBirth = yearOfBirth;
    }

    // getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    // comparable interface implementation based on ID number
    @Override
    public int compareTo(Student other) {
        return this.idNumber.compareTo(other.idNumber);
    }

    // string representation of a student
    @Override
    public String toString() {
        return "First name: " + firstName +
                ", Last name: " + lastName +
                ", ID number: " + idNumber +
                ", Year of birth: " + yearOfBirth;
    }
}