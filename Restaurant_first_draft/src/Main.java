import org.json.simple.parser.ParseException;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.IOException;  

public class Main {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int licquorLicenceNumber = 123456,totalTables=5, numberOfCustomers, tableNumber,choice=0;
		SimpleDateFormat simpleformat = new SimpleDateFormat("dd MMMM,yyyy");
		Date date = new Date();
		System.out.println(simpleformat.format(date));
		String manager = new String("Ravi");
		String restaurantName = new String("7 West Cafe");
		String[] servers = new String[2];
		for(int i=1;i<=2;i++){
			System.out.println("Enter Server "+i+" Name");
			servers[i-1] = input.next();
		}
		Menu menu = new Menu();

		Table[] tables = new Table[10];
		for(int tableIterator=0;tableIterator<10;tableIterator++){
			tables[tableIterator] = new Table();
			tables[tableIterator].setTableNumber(tableIterator+1);
		}
		while(true){
			System.out.println("Options: \n1) Assign tables to customers\n2) Add Order\n3)Show Order\n4)Generate Bill\n5)Pay Bill");
			System.out.println("Enter choice");
			choice = input.nextInt();

			switch(choice){

			case 1:
				System.out.println("Enter the table number.");
				tableNumber = input.nextInt();
				while(tableNumber>10 || tableNumber<1){
					System.out.println("Invalid table number.\nEnter table number between 1-10");
					System.out.println("Enter the table number.");
					tableNumber = input.nextInt();
				}
				
				System.out.println("Enter the number of customers");
				numberOfCustomers = input.nextInt();
				tables[tableNumber].setNoOfPeople(numberOfCustomers);
				break;

			case 2: 
				System.out.println("Enter the table number.");
				tableNumber = input.nextInt();
				while(tableNumber>10 || tableNumber<1){
					System.out.println("Invalid table number.\nEnter table number between 1-10");
					System.out.println("Enter the table number.");
					tableNumber = input.nextInt();
				}
				if(tables[tableNumber].getNoOfPeople()==0){
					System.out.println("The table is Empty! Hence cannot add order.");
					break;
				}
				tables[tableNumber].addOrder();
				tables[tableNumber].showOrder();
				break;
				
			case 3: 
				System.out.println("Enter the table number.");
				tableNumber = input.nextInt();
				while(tableNumber>10 || tableNumber<1){
					System.out.println("Invalid table number.\nEnter table number between 1-10");
					System.out.println("Enter the table number.");
					tableNumber = input.nextInt();
				}
				if(tables[tableNumber].getNoOfPeople()==0){
					System.out.println("The table is Empty! Hence cannot show order.");
					break;
				}
				tables[tableNumber].showOrder();
				break;
				
			case 4:
				System.out.println("Enter the table number.");
				tableNumber = input.nextInt();
				while(tableNumber>10 || tableNumber<1){
					System.out.println("Invalid table number.\nEnter table number between 1-10");
					System.out.println("Enter the table number.");
					tableNumber = input.nextInt();
				}
				if(tables[tableNumber].getNoOfPeople()==0){
					System.out.println("The table is Empty! Hence cannot generate bill.");
					break;
				}
				tables[tableNumber].generateBill();
				break;
			
			case 5:
				System.out.println("Enter the table number.");
				tableNumber = input.nextInt();
				while(tableNumber>10 || tableNumber<1){
					System.out.println("Invalid table number.\nEnter table number between 1-10");
					System.out.println("Enter the table number.");
					tableNumber = input.nextInt();
				}
				if(tables[tableNumber].getNoOfPeople()==0){
					System.out.println("The table is Empty! Hence cannot proceed with payment.");
					break;
				}
				tables[tableNumber].payBill();
				break;
				
			default:
				System.out.println("Invalid choice. Enter the function number again.");
				break;
			
			}
			
		}
	}
	
}
