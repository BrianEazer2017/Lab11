package CarPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarLotApp {
	private static List<Car> cars = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddCar.main(args);
	}

	static void addOrViewCars(Scanner sc, int len) {
		System.out.println("What would you like to do?");
		displayAddOrViewCars();
		int answer = Validator.getInt(sc, "Choose what number you'd like to select", 1, 2);
		if (answer == 1) {
			viewAvailableCars(sc, len);
		}
		else if (answer == 2) {
			AddCar.inputMake(sc, len);
		}
		else {
			System.out.println("You are mistaken");
			addOrViewCars(sc, len);
		}
	}

	static void userMenu(Scanner sc, int len) {
		System.out.println("Menu Options");
		System.out.println("1. Go back");
		System.out.println("2. View a single car's year, price, and mileage");
		System.out.println("3. Remove a car (buy it)");
		System.out.println("4. Replace a car");
		System.out.println("5. Do construction and add another space");
		int num = Validator.getInt(sc, "Choose what number you'd like to select", 1, 5);
		if (num == 1) {
			addOrViewCars(sc, len);
		} else if (num == 2) {
			viewSingleCar(sc);
		} else if (num == 3) {
			removeCar(sc, len);
		} else if (num == 4) {
			replaceCar(sc, len);
		} else if (num == 5) {
			System.out.println("You have another space to add a car");
			len++;
			addOrViewCars(sc, len);
		} else {
			System.out.println("oops. Try again");
		}
	}

	private static void replaceCar(Scanner sc, int len) {
		// TODO Auto-generated method stub
		int answer = Validator.getInt(sc, "What car would you like to replace? Type the number and press enter.", 1, cars.size());
		len++;
		int indexOfReplacement = answer - 1;
		cars.set(indexOfReplacement, new Car());
		//addOrViewCars(sc, indexOfReplacement);
		AddCar.inputMake(sc, len);
	}

	private static void removeCar(Scanner sc, int len) {
		// TODO Auto-generated method stub
		int answer = Validator.getInt(sc, "What car would you like to remove? Type the number and press enter.", 1, cars.size());
		getCars().remove(getCars().get(answer -1));
		len++;
		addOrViewCars(sc, len);
	}

	private static void viewSingleCar(Scanner sc) {
		int answer = Validator.getInt(sc, "What car would you like to view? Type the number and press enter.", 1, cars.size());
		try{
			System.out.println(getCars().get(answer-1).toString());
		} catch(IndexOutOfBoundsException ex) {
			System.out.println("The cars list is only " + getCars().size() + " cars long. Try again.");
			viewSingleCar(sc);
		}
	}

	private static void displayAddOrViewCars() {
		System.out.println("1. View available cars");
		System.out.println("2. Input a car to system");
	}

	private static void viewAvailableCars(Scanner sc, int len) {
		// TODO Auto-generated method stub
		//System.out.println("viewAvailableCarswascalled");
		for (int i = 0; i < getCars().size(); i++) {
			System.out.println((i+1) + getCars().get(i).toString());
		}
		System.out.println("");
		userMenu(sc, len);
	}

	public static List<Car> getCars() {
		return cars;
	}

	public static void setCars(List<Car> cars) {
		CarLotApp.cars = cars;
	}

}
