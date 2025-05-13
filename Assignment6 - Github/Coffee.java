/*
 * Class: CMSC203
 * Instructor: Prof.Monshi
 * Description: (Give a brief description for each Class)
 * Due: 05/12/2025
 * Platform/compiler: ItelliJ
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Christopher Andrews
*/
public class Coffee extends Beverage{

    private boolean extraShot;
    private boolean extraSyrup;

    private final double EXTRASHOT_PRICE = 0.5;
    private final double EXTRASYRUP_PRICE = 0.5;


    public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        super(bevName, Type.COFFEE , size);

        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    public boolean getExtraShot() {
        return extraShot;
    }
    public boolean getExtraSyrup() {
        return extraSyrup;
    }



    @Override
    public double calcPrice() {
        double price = addSizePrice();

        price += extraShot ? EXTRASHOT_PRICE : 0;
        price += extraSyrup ? EXTRASYRUP_PRICE : 0;

        return price;
    }

    @Override
    public String toString() {
        String hasExtraShot = extraShot ? "ExtraShot," : "";
        String hasExtraSyrup = extraSyrup ? "ExtraSyrup," : "";
        return super.toString() + "," + hasExtraShot + hasExtraSyrup + "$" + calcPrice() + "\n";
    }

    @Override
    public boolean equals(Object anotherBev){
        if(anotherBev instanceof Coffee){

            Coffee anotherCoffee = (Coffee) anotherBev;

            return super.equals(anotherCoffee) &&
                   this.extraShot == anotherCoffee.extraShot &&
                   this.extraSyrup == anotherCoffee.extraSyrup;

        }

        return false;
    }
}
