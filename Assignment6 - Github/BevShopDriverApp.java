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
public class BevShopDriverApp {
    public static void main(String[] args) {
        BevShop shop = new BevShop();


        System.out.println("Welcome to the Beverage Shop!\n");

        System.out.println("Please enter the name for the order: Chris");
        System.out.println("Please enter your age: 25");
        System.out.println("Please enter the current time(0-24): 15");
        System.out.println("Please enter the day of the week: Saturday");

        shop.startNewOrder(15,Day.SATURDAY,"Chris",25);

        if(shop.isValidAge(16)){
            System.out.println("\nYou are over 20 and can order alcohol");
        }else{
            System.out.println("\nYou are under 21 and cannot order alcohol");
        }
        System.out.println("You can only have 3 alcoholic beverages per order");
        System.out.println("Due to weekend prices, alcoholic drinks cost an extra 60 cents");


        System.out.println("\nPlease add an alcohol drink to the order");
        shop.processAlcoholOrder("Beer", Size.MEDIUM);

        System.out.println("The current number of drinks is " + shop.getCurrentOrder().getTotalItems());
        System.out.println("The current total price is $" + shop.getCurrentOrder().calcOrderTotal());

        System.out.println("\nPlease add another alcohol drink to the order");
        shop.processAlcoholOrder("Beer", Size.LARGE);

        System.out.println("The current number of drinks is " + shop.getCurrentOrder().getTotalItems());
        System.out.println("The current total price is $" + shop.getCurrentOrder().calcOrderTotal());

        System.out.println("\nPlease add another alcohol drink to the order");
        shop.processAlcoholOrder("Tequila", Size.LARGE);

        System.out.println("The current number of drinks is " + shop.getCurrentOrder().getTotalItems());
        System.out.println("The current total price is $" + shop.getCurrentOrder().calcOrderTotal());

        if(!shop.isEligibleForMore()){
            System.out.println("\nPlease add another alcohol drink to the order");
            shop.processAlcoholOrder("Whiskey",Size.SMALL);
            System.out.println("The current number of drinks is " + shop.getCurrentOrder().getTotalItems());
            System.out.println("The current total price is $" + shop.getCurrentOrder().calcOrderTotal());
        }else{
            System.out.println("\nYou have the maximum amount of alcohol drinks");
        }
        System.out.println("\nPlease add a Coffee or Smoothie to order");
        shop.processSmoothieOrder("Bahama Smoothie",Size.LARGE,4,true);

        System.out.println("The current number of drinks is " + shop.getCurrentOrder().getTotalItems());
        System.out.println("The current total price is $" + shop.getCurrentOrder().calcOrderTotal());

        int thisOrderNum = shop.getCurrentOrder().getOrderNo();
        System.out.println("The order number is " + thisOrderNum);

        System.out.println("|-------------------------------------------|");

        System.out.println("Welcome to the Beverage Shop!\n");

        System.out.println("Please enter the name for the order: George");
        System.out.println("Please enter your age: 16");
        System.out.println("Please enter the current time(0-24): 9");
        System.out.println("Please enter the day of the week: Wednesday");

        shop.startNewOrder(9,Day.WEDNESDAY,"George",16);

        if(shop.isValidAge(16)){
            System.out.println("\nYou are over 20 and can order alcohol");
        }else{
            System.out.println("\nYou are under 21 and cannot order alcohol");
        }

        System.out.println("\nWould you please add a Coffee to the order?");
        shop.processCoffeeOrder("Latte",Size.LARGE,true,true);

        System.out.println("The current number of drinks is " + shop.getCurrentOrder().getTotalItems());
        System.out.println("The current total price is $" + shop.getCurrentOrder().calcOrderTotal());

        System.out.println("\nPlease add a Smoothie to the order");
        shop.processSmoothieOrder("Caribbean",Size.SMALL,5,true);
        if(shop.isMaxFruit(5)){
            System.out.println("\nYou have the maximum amount of fruits");
        }

        System.out.println("The current number of drinks is " + shop.getCurrentOrder().getTotalItems());
        System.out.println("The current total price is $" + shop.getCurrentOrder().calcOrderTotal());

        System.out.println("\nTotal price for all Orders: $" + shop.totalMonthlySale());

        System.out.println("Total Price for Order Number " + thisOrderNum + " is $" + shop.totalOrderPrice(thisOrderNum));

        System.out.println("\nHere is the recipt of all the orders");
        System.out.println(shop.toString());















    }
}
