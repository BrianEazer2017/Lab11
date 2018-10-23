package CarPackage;

public class UsedCar extends Car {
 private double mileage;

 public UsedCar() {
		
	}

	public UsedCar(String make, String model, int year, double price, double mileage) {
		super();
		this.mileage = mileage;
	}
public double getMileage() {
	return mileage;
}

public void setMileage(double mileage) {
	this.mileage = mileage;
}

@Override
public String toString() {
	return " Make = " + getMake()
			+ ", Model = " + getModel() + ", Year = " + getYear() + ", Price = " + getPrice() + 
			", Mileage: " + mileage;
}


 
}
