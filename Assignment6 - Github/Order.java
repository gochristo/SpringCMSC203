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
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order>{

    private int orderTime;
    private Day orderDay;
    private int orderNo;
    private Customer cust;
    private ArrayList<Beverage> beverages = new ArrayList<>();

    public Order(int orderTime, Day orderDay, Customer cust) {
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.cust = cust;
        orderNo = generateOrder();
    }
    public int generateOrder(){
        Random rand = new Random();
        final int minNo = 10000;
        final int maxNo = 90000;
        orderNo = rand.nextInt(maxNo - minNo) + minNo;

        return orderNo;
    }
    public int getOrderNo(){
        return orderNo;
    }
    public int getOrderTime(){
        return orderTime;
    }
    public Day getOrderDay(){
        return orderDay;
    }
    public Customer getCustomer(){
        return new Customer(cust);
    }

    @Override
    public boolean isWeekend() {
        if(orderDay == Day.SATURDAY || orderDay == Day.SUNDAY){
            return true;
        }
        return false;
    }

    @Override
    public Beverage getBeverage(int itemNo) {
        if(beverages.isEmpty()){
            return null;
        }else if(beverages.size() <= itemNo){
            return null;
        }
        return beverages.get(itemNo);
    }

    public int getTotalItems(){
        return beverages.size();
    }

    @Override
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName,size,extraShot,extraSyrup));
    }

    @Override
    public void addNewBeverage(String bevName, Size size) {
        beverages.add(new Alcohol(bevName,size,isWeekend()));
    }

    @Override
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName,size,numOfFruits,addProtein));
    }

    @Override
    public double calcOrderTotal() {
        double total = 0;
        for(Beverage bev : beverages){
            total += bev.calcPrice();
        }
        return total;
    }

    @Override
    public int findNumOfBeveType(Type type) {
        int typeCount = 0;
        for(Beverage bev : beverages){
            if(bev.getType() == type){
                typeCount++;
            }
        }
        return typeCount;
    }

    @Override
    public String toString() {
        return "\nOrder " + "#" + orderNo
                + "\nDay&Time:" + orderDay + "," + orderTime
                + "\nCustomer:" + cust + "\n\n"
                + "Drinks:\n" + beverages
                + "\n Order total: $" + calcOrderTotal()
                + "\n----------------------------------------------------------";
    }

    @Override
    public int compareTo(Order anotherOrder) {
        int compareValue = orderNo - anotherOrder.orderNo;
        if(compareValue == 0){
            return 0;
        }else if(compareValue < 0){
            return -1;
        }
        return 1;
    }
}
