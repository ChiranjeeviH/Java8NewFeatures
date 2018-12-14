package interviewQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionInterviewQuestions {
	
	public static void main(String[] args) {
		
		List<Object> list1 = new ArrayList<Object>();
		list1.add("Chiru");
		list1.add(1);
		list1.add("Chiru");
		list1.add(2.3);
		list1.add(2);
		list1.forEach(listDetails ->System.out.println("List Details :"+listDetails));
		list1.listIterator();
		
		Set<Object> set = list1.stream().collect(Collectors.toSet());
		set.forEach(setDetails ->System.out.println("set Details :"+setDetails));
		
	}

}
