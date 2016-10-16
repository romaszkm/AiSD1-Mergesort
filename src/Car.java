/**
 * Created by michalromaszko on 10.10.2016.
 */
public class Car implements Comparable<Car> {
    private String name;
    private int horsepower;
    private int productionYear;
    private int mileage;

    public Car(String name, int horsepower, int productionYear, int mileage) {
        this.name = name;
        this.horsepower = horsepower;
        this.productionYear = productionYear;
        this.mileage = mileage;
    }

    public String getName() {
        return name;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public int getMileage() {
        return mileage;
    }

    public int getProductionYear() {
        return productionYear;
    }

    @Override
    public int compareTo(final Car o) {
//        return this.productionYear > o.getProductionYear() ? 1 : this.productionYear < o.getProductionYear() ? -1 : 0;
        return Integer.compare(this.productionYear,o.getProductionYear());
    }

    public String toString() {
        return name + ": HP: " + horsepower + " Production year: " + productionYear + " Mileage: " + mileage;
    }
}
