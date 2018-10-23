package CarPackage;

import java.util.Scanner;

public class AddCar {

	public static void main(String[] args) {
				Scanner sc = new Scanner(System.in);
				int len = askUserHowManyCarsToEnter(sc);
				inputMake(sc, len);
			}

			private static int askUserHowManyCarsToEnter(Scanner sc) {
				int answer = Validator.getInt(sc, "How many cars would you like to enter? (How many can you keep on your carlot?)");
				return answer;
			}

			static void inputMake(Scanner sc, int len) {
				if (len > 0)
				{	System.out.println("Used or New?");
					String answer = sc.next();
					if (answer.matches("New")) {
						Car car = new Car();
						sc.nextLine();
						String make = Validator.getStringMatchingRegex(sc, "Input the make of the car" , "[a-zA-Z0-9]+");
						car.setMake(make);
						System.out.println(car.getMake());
						inputModel(sc, car, len);
					} else if (answer.matches("Used")) {
						UsedCar car = new UsedCar();
						sc.nextLine();
						String make = Validator.getStringMatchingRegex(sc, "Input the make of the car" , "[a-zA-Z0-9]+");
						car.setMake(make);
						System.out.println(car.getMake());
						inputModel(sc, car, len);
					} else {
						inputMake(sc, len);
					}
				} else {
					System.out.println("Your list is FULL!!! Do some construction");
					System.out.println("");
					CarLotApp.userMenu(sc, len);
				}
			}
			
			private static void inputModel(Scanner sc, Car car, int len) {
				String model = Validator.getStringMatchingRegex(sc,"Input the model of the car" , "[a-zA-Z0-9]+");
				car.setModel(model);
				inputYear(sc, car, len);
			}

			private static void inputYear(Scanner sc, Car car, int len) {
				int year = Validator.getInt(sc, "Input the year of the car" );
				car.setYear(year);
				inputPrice(sc, car, len);
			}

			private static void inputPrice(Scanner sc, Car car, int len) {
				double price = Validator.getDouble(sc, "Enter the price of the car");
				car.setPrice(price);
				if (car instanceof UsedCar) {
					inputMileage(sc, (UsedCar) car, len);
				}
				else {
				len--;
				checkIfCarIsAReplacementCar(sc, car, len);
					}
				
			}
			
			private static void inputMileage(Scanner sc, UsedCar car, int len) {
				int mileage = Validator.getInt(sc, "Input the mileage of the car" );
				car.setMileage(mileage);
				len--;
				checkIfCarIsAReplacementCar(sc, car, len);
			}
			
			private static void checkIfCarIsAReplacementCar(Scanner sc, Car car, int len) {
				boolean isReplacement = false;
				int index = 0;
				for (Car c: CarLotApp.getCars()) {
					if (c.getMake() == null) {
						index = CarLotApp.getCars().indexOf(c);
						isReplacement = true;
					} 
			}
			if (isReplacement) {
				CarLotApp.getCars().set(index, car);
			} else {
				CarLotApp.getCars().add(index, car);
			}
			CarLotApp.addOrViewCars(sc, len);		
			}
}
