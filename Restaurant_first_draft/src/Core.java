import java.util.Iterator;

public class Core {
	
	public static void showItem(){
		/* Display content using Iterator*/
		int index=1;
	      Iterator iterator = Menu.menuList.iterator();
	      while(iterator.hasNext()) {
	         Dish newDish = (Dish) iterator.next();
	         System.out.print(newDish.itemNumber+"\t");
	         System.out.print(newDish.itemName+"\t");
	         System.out.println(newDish.price);
	      }
	}
}
