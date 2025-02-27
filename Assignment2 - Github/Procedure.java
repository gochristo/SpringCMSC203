/*
 * Class: CMSC203
 * Instructor: Prof. Monshi
 * Description: Constructors and getters/mutators for patient procedures
 * Due: 02/26/2025
 * Platform/compiler: ItelliJ IDEA
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Christopher Andrews
*/

    public class Procedure {

        private String procedureName;
        private String procedureDate;
        private String practitionerName;
        private double procedureCharges;

        public Procedure() {
        }

        public Procedure(String procedureName, String procedureDate) {
            this.procedureName = procedureName;
            this.procedureDate = procedureDate;
        }

        public Procedure(String procedureName, String procedureDate, String practitionerName, double procedureCharges) {
            this.procedureName = procedureName;
            this.procedureDate = procedureDate;
            this.practitionerName = practitionerName;
            this.procedureCharges = procedureCharges;
        }

        public String getProcedureName() {
            return procedureName;
        }
        public String getProcedureDate() {
            return procedureDate;
        }
        public String getPractitionerName() {
            return practitionerName;
        }
        public double getProcedureCharges() {
            return procedureCharges;
        }

        public void setProcedureName(String procedureName) {
            this.procedureName = procedureName;
        }
        public void setProcedureDate(String procedureDate) {
            this.procedureDate = procedureDate;
        }
        public void setPractitionerName(String practitionerName) {
            this.practitionerName = practitionerName;
        }
        public void setProcedureCharges(double procedureCharges) {
            this.procedureCharges = procedureCharges;
        }

        @Override
        public String toString() {
            return "\n\t Procedure: " + procedureName + "\n" + "\t Procedure Date: " +procedureDate + "\n" +
                    "\t Practitioner: " + practitionerName + "\n" + "\t Charge: $" + procedureCharges;
        }
}

