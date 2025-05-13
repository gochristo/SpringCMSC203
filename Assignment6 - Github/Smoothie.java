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
public class Smoothie extends Beverage {

    private int fruits;
    private boolean proteinPowder;

    private final double FRUITS_COST = 0.5;
    private final double PROTEIN_POWDER_COST = 1.50;

    public Smoothie(String bevName, Size size, int fruits, boolean proteinPowder) {
        super(bevName, Type.SMOOTHIE, size);

        this.fruits = fruits;
        this.proteinPowder = proteinPowder;
    }

    public int getNumFruits() {
        return fruits;
    }
    public boolean getAddProtein(){
        return proteinPowder;
    }

    @Override
    public String toString() {
        String hasProteinPowder = proteinPowder ? "Protein Powder," : "";
        return super.toString() + "," + hasProteinPowder + fruits + " Fruits" + ",$" + calcPrice() + "\n";
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice();

        price += fruits * FRUITS_COST;
        price += proteinPowder ? PROTEIN_POWDER_COST : 0;

        return price;
    }

    @Override
    public boolean equals(Object anotherBev){
        if(anotherBev instanceof Smoothie){

            Smoothie anotherSmoothie = (Smoothie) anotherBev;

            return super.equals(anotherSmoothie) &&
                    this.fruits == anotherSmoothie.fruits &&
                    this.proteinPowder == anotherSmoothie.proteinPowder;

        }

        return false;
    }
}
