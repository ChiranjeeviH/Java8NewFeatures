package immuatableObjectDemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class CustomImmuableClass {
	
	/*
	 * 1) Mark class as final to not get inherited
	 * 
	 * 2) Mark all the fields are private so that direct access is not possible outside
	 * 
	 * 3) don't provide setter methods so that others can't access via object
	 * 
	 * 4) Mark all the mutable fields as final so that value can be assigned once.
	 * 
	 * 5) Initialize all fields via a constructor performing deep copy
	 * 
	 * 6) Performing cloning the objects in getter methods to return a copy rather than returning actual 
	 * 
	 */
	
	private final int id;
	
	private final String name;
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, String> getTestMap() {
		return (HashMap<String, String>) testMap.clone();
	}

	private HashMap<String, String> testMap;
	
	public CustomImmuableClass(int i, String n, HashMap<String,String> hm) {
		this.id = i;
		this.name = n;
		this.testMap = hm;
		HashMap<String,String> tempMap=new HashMap<String,String>();
		
		String key;
		Iterator iterator = hm.keySet().iterator();
		
		while(iterator.hasNext()) {
			key = (String) iterator.next();
			tempMap.put(key, hm.get(key));
		}
		this.testMap = tempMap;
	}
	
	public static void main(String[] args) {
		
		HashMap<String, String> implementedHashMap = new HashMap<String, String>();
		implementedHashMap.put("name", "chiru");
		implementedHashMap.put("unit", "FSSTAR");
		implementedHashMap.put("role", "SSE");
		implementedHashMap.put("name", "chiranjeevi");
		
		String s = "Chiranjeevi";
		
		CustomImmuableClass ce = new CustomImmuableClass(725062, "Chiranjeevi", implementedHashMap);
		
			//Lets see whether its copy by field or reference
				System.out.println(s==ce.getName());
				System.out.println(implementedHashMap == ce.getTestMap());
				//print the ce values
				System.out.println("ce id:"+ce.getId());
				System.out.println("ce name:"+ce.getName());
				System.out.println("ce testMap:"+ce.getTestMap());
		 		//change the local variable values
				int i=20;
				s="modified";
				implementedHashMap.put("name", "chiranjeevi");
				//print the values again
				System.out.println("ce id after local variable change:"+ce.getId());
				System.out.println("ce name after local variable change:"+ce.getName());
				System.out.println("ce testMap after local variable change:"+ce.getTestMap());
				
				HashMap<String, String> hmTest = ce.getTestMap();
				hmTest.put("4", "new");
				
				System.out.println("ce testMap after changing variable from accessor methods:"+ce.getTestMap());
	}                                                         
	

}
