import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Menu {

	/* This is how to declare HashMap */
	public static ArrayList<Dish> menuList = new ArrayList<Dish>();
	public Menu() throws IOException, ParseException {
		super();
		// TODO Auto-generated constructor stub
		FileReader reader = new FileReader("menu_first_draft.json");
		JSONParser parser = new JSONParser();
		JSONObject object = (JSONObject) parser.parse(reader);
		String name = (String) object.get("Menu");
		JSONArray jsonArray = (JSONArray) object.get("foodItems");		
		Dish[] dish = new Dish[jsonArray.size()];
		for(int i=0;i<jsonArray.size();i++)
        {
			JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
			dish[i] = new Dish(Integer.parseInt((String) jsonObject1.get("itemNumber")),(String) jsonObject1.get("itemName"),Integer.parseInt((String) jsonObject1.get("price")));
			menuList.add(dish[i]);
        }
        reader.close();
	}
}
