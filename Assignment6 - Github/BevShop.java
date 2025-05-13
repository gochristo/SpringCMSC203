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
import java.util.ArrayList;

public class BevShop implements BevShopInterface {

    private int alcoholBevs;

    private ArrayList<Order> orders = new ArrayList<Order>();

    public BevShop(){
        alcoholBevs = 0;
    };

    @Override
    public boolean isValidTime(int time) {
        if(time < 23 && time > 8){
            return true;
        }
        return false;
    }

    @Override
    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    @Override
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits >= MAX_FRUIT;
    }

    @Override
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public boolean isEligibleForMore() {
        return alcoholBevs >= MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public int getNumOfAlcoholDrink() {
        return alcoholBevs;
    }

    @Override
    public boolean isValidAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        if(!isValidTime(time)){
            System.out.println("You cannot place an order at this time.");
        }else {
            orders.add(new Order(time, day, new Customer(customerName, customerAge)));
            alcoholBevs = 0;
        }
    }

    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        orders.getLast().addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        orders.getLast().addNewBeverage(bevName, size);
        alcoholBevs++;
    }

    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        orders.getLast().addNewBeverage(bevName, size, numOfFruits, addProtein);
    }

    @Override
    public int findOrder(int orderNo) {
        for(int i = 0; i < orders.size(); i++){
            if(orders.get(i).getOrderNo() == orderNo){
                return i;
            }
        }
        return -1;
    }

    @Override
    public double totalOrderPrice(int orderNo) {
        for(int i = 0; i < orders.size(); i++){
            if(orders.get(i).getOrderNo() == orderNo){
                return orders.get(i).calcOrderTotal();
            }
        }
        return 0;
    }

    @Override
    public double totalMonthlySale() {
        double totalSales = 0.0;
        for(int i = 0; i < orders.size(); i++){
            totalSales += orders.get(i).calcOrderTotal();
        }
        return totalSales;
    }

    @Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    @Override
    public Order getCurrentOrder() {
        return orders.getLast();
    }

    @Override
    public Order getOrderAtIndex(int index) {
        return orders.get(index);
    }

    @Override
    public void sortOrders() {
        int n = orders.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (orders.get(j).getOrderNo() < orders.get(minIndex).getOrderNo()) {
                    minIndex = j;
                }
            }

            Order temp = orders.get(minIndex);
            orders.set(minIndex, orders.get(i));
            orders.set(i, temp);
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < orders.size(); i++){
            sb.append(orders.get(i).toString() + "\n");
        }
        sb.append("\n Total Monthly Sales: $" + totalMonthlySale());
        return sb.toString();
    }
}
