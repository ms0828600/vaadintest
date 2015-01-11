package at.martin;


import java.util.ArrayList;
import java.util.List;

import at.martin.entity.Person;

public class FillDB {

	public static List<Person> generatePersons() {
		List<Person> list = new ArrayList<Person>(10);
		String[] firstNames = { "Martin", "Mario", "Josef", "Hubert", "Johannes", 
				"Klara", "Katharina", "Andrea", "Christine", "Michael"
		};
		
		String[] familyNames = { "Maier", "Hager", "Fellner", "Tomas", "Puhl", 
				"Resch", "Dersch", "Hanse", "Roth", "Seifert"
		};
		
		for (int i = 0; i < 10; i++) {
			Person p = new Person();
			p.setFirstName(firstNames[i]);
			p.setFamilyName(familyNames[i]);
			list.add(p);
		}
		return list;
	}
	
}
