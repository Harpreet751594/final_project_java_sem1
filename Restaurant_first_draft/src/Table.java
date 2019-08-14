import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Table {
	private int tableNumber,noOfPeople=0,billNumber;
	private double totalBill;
	public ArrayList<Dish> orderList = new ArrayList<Dish>();
	
	Table() {
		super();
	}

	public int getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(int newtableNumber) {
		this.tableNumber = newtableNumber;
	}

	public int getNoOfPeople() {
		return noOfPeople;
	}

	public void setNoOfPeople(int noOfPeople) {
		this.noOfPeople = noOfPeople;
	}

	public int getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(int billNumber) {
		this.billNumber = billNumber;
	}
	public void addOrder(){
		Core.showItem();
		int itemNumber;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter dish number");
		itemNumber = input.nextInt();
		this.orderList.add(Menu.menuList.get(itemNumber-1));
	}
	public void showOrder(){
		int index=1;
		Iterator iterator = this.orderList.iterator();
	      while(iterator.hasNext()) {
	         Dish newDish = (Dish) iterator.next();
	         System.out.print(index +"\t");
	         System.out.print(newDish.itemName+"\t");
	         System.out.println(newDish.price);
	         index++;
	      }
	}
	public void generateBill(){
		int index=1,billAmount=0;
		double tax;
		Iterator iterator = this.orderList.iterator();
	      while(iterator.hasNext()) {
	         Dish newDish = (Dish) iterator.next();
	         System.out.print(index +"\t");
	         System.out.print(newDish.itemName+"\t");
	         System.out.println(newDish.price);
	         index++;
	         billAmount += newDish.price;
	      }
	      tax = (double) (billAmount*0.13);
	      this.totalBill = billAmount+tax;
	      System.out.println("\tbill amount\t"+billAmount);
	      System.out.println("\tHST\t"+tax);
	      System.out.println("\tTotal Bill\t"+(this.totalBill));
	}
	public void payBill(){
		int index=1,billAmount=0;
		double tax,givenAmount;
		Iterator iterator = this.orderList.iterator();
	      while(iterator.hasNext()) {
	         Dish newDish = (Dish) iterator.next();
	         System.out.print(index +"\t");
	         System.out.print(newDish.itemName+"\t");
	         System.out.println(newDish.price);
	         index++;
	         billAmount += newDish.price;
	      }
	      tax = (double) (billAmount*0.13);
	      this.totalBill = billAmount+tax;
	      System.out.println("\tbill amount\t"+billAmount);
	      System.out.println("\tHST\t"+tax);
	      System.out.println("\tTotal Bill\t"+this.totalBill);
	      System.out.println("Enter amount given");
	      Scanner input = new Scanner(System.in);
	      givenAmount = input.nextDouble();
	      System.out.printf("Change to be given : %.2f \n",(givenAmount-this.totalBill));
	      this.noOfPeople=0;
	      this.totalBill=0;
	      this.orderList.clear();
	}
}
