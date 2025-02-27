/*
 * Class: CMSC203
 * Instructor: Prof. Monshi
 * Description: Constructors and getters/mutators for patient infortmation
 * Due: 02/26/2025
 * Platform/compiler: ItelliJ IDEA
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Christopher Andrews
*/

public class Patient {

        private String firstName;
        private String middleName;
        private String lastName;
        private String streetAddress;
        private String city;
        private String state;
        private String zipCode;
        private String phoneNumber;
        private String emergencyName;
        private String emergencyPhone;

        public Patient() {
        }
        public Patient(String firstName, String middleName, String lastName) {
                this.firstName = firstName;
                this.middleName = middleName;
                this.lastName = lastName;
        }
        public Patient(String firstName, String middleName, String lastName, String streetAddress,
                       String city, String state, String zipCode, String phoneNumber, String emergencyName,
                       String emergencyPhone) {
                this.firstName = firstName;
                this.middleName = middleName;
                this.lastName = lastName;
                this.streetAddress = streetAddress;
                this.city = city;
                this.state = state;
                this.zipCode = zipCode;
                this.phoneNumber = phoneNumber;
                this.emergencyName = emergencyName;
                this.emergencyPhone = emergencyPhone;
        }

        public String getFirstName() {
                return firstName;
        }
        public String getMiddleName() {
                return middleName;
        }
        public String getLastName() {
                return lastName;
        }
        public String getStreetAddress() {
                return streetAddress;
        }
        public String getCity() {
                return city;
        }
        public String getState() {
                return state;
        }
        public String getZipCode() {
                return zipCode;
        }
        public String getPhoneNumber() {
                return phoneNumber;
        }
        public String getEmergencyName() {
                return emergencyName;
        }
        public String getEmergencyPhone() {
                return emergencyPhone;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }
        public void setMiddleName(String middleName) {
                this.middleName = middleName;
        }
        public void setLastName(String lastName) {
                this.lastName = lastName;
        }
        public void setStreetAddress(String streetAddress) {
                this.streetAddress = streetAddress;
        }
        public void setCity(String city) {
                this.city = city;
        }
        public void setState(String state) {
                this.state = state;
        }
        public void setZipCode(String zipCode) {
                this.zipCode = zipCode;
        }
        public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
        }
        public void setEmergencyName(String emergencyName) {
                this.emergencyName = emergencyName;
        }
        public void setEmergencyPhone(String emergencyPhone) {
                this.emergencyPhone = emergencyPhone;
        }

        private String buildFullName() {
                return firstName + " " + middleName + " " + lastName;
        }
        private String buildAddress() {
                return streetAddress + " " + city + " " + state + " " + zipCode;
        }
        private String buildEmergencyContact() {
                return emergencyName + " " + emergencyPhone;
        }

        @Override
        public String toString() {
                return "\nPatient Information: \n" + "  Name: " + buildFullName() + "\n" +
                        "  Address: " + buildAddress() + "\n" + "  Phone: " + phoneNumber + "\n" +
                        "  Emergency Contact: " + buildEmergencyContact();
        }
}