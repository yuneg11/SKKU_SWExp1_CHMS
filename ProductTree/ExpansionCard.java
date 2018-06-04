import JSON.JSONObject;

import java.util.Scanner;

import JSON.JSONArray;
import JSON.parser.JSONParser;


class ExpansionCard extends Product {
	// Variable
    private String slot;
    private String function;
    
    // Constructor
    public ExpansionCard() {
		this.quantity = 1L;
    }
    public ExpansionCard(String attributes) {
		this.quantity = 1L;
    	setAttribute(attributes);
    }
    
    // Setter & Getter
    public String getProductType() {
    	return "ExpansionCard";
    }

    @Override
    public void insert() {
    	super.insert();
    	
    	Scanner s = new Scanner(System.in);    	
    	
    	System.out.print(" Slot: ");
		this.slot = s.nextLine();
		
		System.out.print(" Function: ");
		this.function = s.nextLine();
		
		
	}
    
    public void setAttribute(String attributes) {
    	try {
    		JSONObject obj = (JSONObject)(new JSONParser().parse(attributes));
    		if(obj.containsKey("Name")) 		this.name 			= (String)obj.get("Name");
    		if(obj.containsKey("Price")) 		this.price 			= (Long)obj.get("Price");
			if(obj.containsKey("Manufacturer")) this.manufacturer 	= (String)obj.get("Manufacturer");
			if(obj.containsKey(Str.quantity))	this.quantity 		= (Long)obj.get(Str.quantity);
    		if(obj.containsKey("Slot"))			this.slot 			= (String)obj.get("Slot");
    		if(obj.containsKey("Function"))		this.function 		= (String)obj.get("Function");
    	} catch(Exception exc) {
    		System.out.println("Unexpected error occurred");
    	}
    }
    public String getAttribute(String keys) {
    	try {
			JSONObject required = (JSONObject)(new JSONParser().parse(keys));
			JSONArray keyArray = (JSONArray)required.get("Keys");
    		JSONObject obj = new JSONObject();
    		for(Object key : keyArray) {
				switch((String)key) {
					case "ProductType":		obj.put(Str.productType, "ExpansionCard");break;
					case "Name":			if(this.name != null) obj.put("Name", this.name);break;
					case "Price": 			if(this.price != null) obj.put("Price", this.price);break;
					case "Manufacturer": 	if(this.manufacturer != null) obj.put("Manufacturer", this.manufacturer);break;
					case "Quantity": 		obj.put("Quantity", this.quantity);break;
					case "Slot": 			if(this.slot != null) obj.put("Slot", this.slot);break;
					case "Function": 		if(this.function != null) obj.put("Function", this.function);break;
				}
			}
    		return obj.toJSONString();
    	} catch(Exception exc) {
    		System.out.println("Unexpected error occurred");
    		return null;
    	}
	}
	public JSONObject toJSONObject() {
		JSONObject obj = new JSONObject();
		JSONArray keyArray = new JSONArray();
		keyArray.add(Str.productType);
		keyArray.add(Str.name);
		keyArray.add(Str.price);
		keyArray.add(Str.manufacturer);
		keyArray.add(Str.quantity);
		keyArray.add(Str.slot);
		keyArray.add(Str.function);
		obj.put("Keys", keyArray);
    	try {
			return (JSONObject)(new JSONParser().parse(getAttribute(obj.toJSONString())));
		} catch(Exception ex) {
			System.out.println("Unexpected error occurred");
			return null;
		}
	}
}