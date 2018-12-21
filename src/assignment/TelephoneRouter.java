package assignment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TelephoneRouter {
	static double getLongestPattern(HashMap<String, Double> operator, String phone) {
		String temp;
		String idx = "";
		int i=1;
		while(i<phone.length()) {
			temp = phone.substring(0,i);
			if(operator.containsKey(temp)) {
				idx = temp;
			}
			else {
				idx += "";
			}
			i++;
		}
		if(!operator.containsKey(idx)) {
			return 9999;
		}
		return operator.get(idx);
	}
	
	//This method will find minimum cost for a number for any number of operators.
	static double minimumCost(ArrayList<HashMap<String, Double>> arr,String phone) {
		int n = arr.size(); //Will handle any number of operators.
		double[] costs = new double[n];
		for(int i =0; i<n; i++) {
			costs[i] = getLongestPattern(arr.get(i), phone); //Computing longest matching pattern for the number within each operators' key list
			if(costs[i]==9999.0) {
				System.out.println("Phone number "+phone+" cannot be used with operator "+(i+1));
			}
			else {
				System.out.println("Cost for the number "+phone+" with operator "+(i+1)+" is: "+costs[i]);
			}
		}
		Arrays.sort(costs);
		return costs[0];
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter phone number: ");
		String phone = scan.next();
		if(phone.length()<8) {
			System.out.println("Please enter a valid phone number!");
		}
		ArrayList<HashMap<String, Double>> arrOperators = new ArrayList<>();
		HashMap<String, Double> operatorA = new HashMap<>();
		operatorA.put("1", 0.9);
		operatorA.put("268", 5.1);
		operatorA.put("46", 0.17);
		operatorA.put("4620", 0.6);
		operatorA.put("468", 0.15);
		operatorA.put("4631", 0.15);
		operatorA.put("4673", 0.9);
		operatorA.put("46732", 1.1);
		HashMap<String, Double> operatorB = new HashMap<>();
		operatorB.put("1", 0.92);
		operatorB.put("44", 0.5);
		operatorB.put("46", 0.2);
		operatorB.put("467", 6.0);
		operatorB.put("48", 1.2);
		arrOperators.add(operatorA);
		arrOperators.add(operatorB);
		//Any number of operators can be added because a Collections object(ArrayList) has been used.
		//To avoid hodge-podge, I have considered two operators given in the example.
		System.out.println("Minimum cost: "+minimumCost(arrOperators, phone));
		scan.close();
	}
}
