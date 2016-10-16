import java.util.concurrent.ThreadLocalRandom;

public class meh {

    public static void main(String[] args) {
        int x = 7;
        Car[] carArray = new Car[x];
        String[] carNames = new String[]{"Seat", "VW", "BMW", "Lamborghini", "Ferrari", "Mazda", "Nissan", "Ford", "TVR", "Lotus"};
        for (int i = 0; i < x; i++) {
            Car car = new Car(carNames[ThreadLocalRandom.current().nextInt(0, carNames.length)],
                    ThreadLocalRandom.current().nextInt(50, 300 + 1),
                    ThreadLocalRandom.current().nextInt(1950, 2016 + 1),
                    ThreadLocalRandom.current().nextInt(1, 200000 + 1));
            carArray[i] = car;
        }
        Mergesort sorter = new Mergesort();
        IterativeMergeSort sorter2 = new IterativeMergeSort();

        for(int i = 0; i<x;i++){
            System.out.println(carArray[i].toString());
        }
        sorter2.sort(carArray);

        System.out.println("\nAfter sort:");
        for(int i = 0; i<x;i++){
            System.out.println(carArray[i].toString());
        }


//        }
    }
}
