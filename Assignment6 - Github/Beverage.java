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
public abstract class Beverage {
    private String bevName;
    private Type type;
    private Size size;

    private final double BASE_PRICE = 2.0;
    private final double SIZE_PRICE = 0.5;

    public Beverage(String bevName, Type type, Size size) {
        this.bevName = bevName;
        this.type = type;
        this.size = size;
    }

    public double getBasePrice() {
        return BASE_PRICE;
    }
    public Type getType() {
        return type;
    }
    public String getBevName() {
        return bevName;
    }
    public Size getSize() {
        return size;
    }

    public double addSizePrice(){
        if(size == Size.MEDIUM){
            return BASE_PRICE + SIZE_PRICE;
        }
        if(size == Size.LARGE){
            return BASE_PRICE + (SIZE_PRICE * 2);
        }else
            return BASE_PRICE;
    }

    @Override
    public String toString() {
        return bevName + "," + size;
    }

    @Override
    public boolean equals(Object anotherBev){
        if(anotherBev instanceof Beverage){

            Beverage bev = (Beverage) anotherBev;

            return bevName.equals((bev).getBevName()) &&
                   type == (bev).getType() &&
                   size == (bev).getSize();


        }
            return false;
    }

    public abstract double calcPrice();


}
