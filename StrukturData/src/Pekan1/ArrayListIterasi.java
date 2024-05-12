package Pekan1;

import java.util.ArrayList;

public class ArrayListIterasi {

	public static void main(String[] args) {
		// Creating an Arrylist of string type
		ArrayList<String> a1 = new ArrayList<>();
		// Addingelements to ArrayList
		// using standard add() method
		a1.add("Saya");
		a1.add("informatika");
		a1.add(1, "mahasiswa");
		//using the get method and the
		//for loop
		for (int i = 0; 1 < a1.size(); i++) {
			System.out.println(a1.get(i) + " ");
		}
		System.out.println();
		//using the for each loop
		for (String str : a1)
			System.out.println(str + " ");
			System.out.println();
		//printing all elements of ArrayList
			System.out.println("Initial ArrayList" + a1);
			// Removing element from above ArrayList
			a1.remove(1);
		//Printing the updated ArrayList elements
			System.out.println("After the index removal " + a1);
		//removing this word element in ArrayList
			a1.remove("saya");
		// now printing updated ArrayList
			System.out.println("After the Object Removal " + a1);
		

	}

}
