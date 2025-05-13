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

public class Alcohol extends Beverage{

    private boolean isWeekend;

    private final double ISWEEKEND_PRICE = 0.6;

    public Alcohol(String bevName, Size size, boolean isWeekend) {
        super(bevName, Type.ALCOHOL, size);

        this.isWeekend = isWeekend;
    }
    public boolean isWeekend() {
        return isWeekend;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice();

        price += isWeekend ? ISWEEKEND_PRICE : 0;

        return price;
    }

    @Override
    public String toString() {
        String weekendPrice = isWeekend ? "Weekend Price" : "";
        return super.toString() + "," + weekendPrice + ",$" + calcPrice() +"\n";
    }

    @Override
    public boolean equals(Object anotherBev){
        if(anotherBev instanceof Alcohol){

            Alcohol anotherAlcohol = (Alcohol) anotherBev;

            return super.equals(anotherAlcohol) &&
                    this.isWeekend == anotherAlcohol.isWeekend;

        }

        return false;
    }
}
