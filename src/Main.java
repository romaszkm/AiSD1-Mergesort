import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

//    przygotować testy na następne zajęcia razem z sprawozdaniem, złożoność obliczeniowa i czasowa algorytmu
//    czy teoretyczna złożoność się pokryje z testami rzeczywistymi
//    wykresy dla różnych długości ciągu, toeretyczne i faktyczne
//    czas i ilosc danych jako osi x i y

    public static void main(String[] args) {

        int baseDataSize = 10000;   //początkowy rozmiar zbioru danych, mniejsze sortują się zbyt szybko
        int maxDataSize = 10000000; //maksymalny rozmiar zbioru danych, więcej będzie długo się wykonywało

        String toWrite = "";    //dane składające się z linii zapisywane do pliku
        String line;            //linia danych
        double averageTime;     //zmienna trzymająca średni czas dla danej ilości danych
        int n = 10;             //po n testów dla danej wielkości zbioru, z których wyciągany jest średni czas
        for (int dataSize = baseDataSize; dataSize <= maxDataSize; dataSize *= 2) {    //zwiększanie 2-krotnie
            averageTime = 0;
            line = "";
            for (int j = 0; j < n; j++) {
                Car[] carArray = new Car[dataSize];    //deklaracja tablicy żądanej welkości
                String[] carNames = new String[]{"Seat",
                        "VW", "BMW", "Lamborghini", "Ferrari",
                        "Mazda", "Nissan", "Ford", "TVR", "Lotus"}; //deklaracja przykładowych 10 nazw aut
                for (int i = 0; i < dataSize; i++) {    //generowanie losowych danych
                    Car car = new Car(carNames[ThreadLocalRandom.current().nextInt(0, carNames.length)],
                            ThreadLocalRandom.current().nextInt(50, 300 + 1),
                            ThreadLocalRandom.current().nextInt(1950, 2016 + 1),
                            ThreadLocalRandom.current().nextInt(1, 200000 + 1));
                    carArray[i] = car;
                }
                Mergesort sorter = new Mergesort();
//                IterativeMergeSort sorter = new IterativeMergeSort();    //tutaj w wersji iteracjnej
                long start = System.nanoTime();     //pomiar czasu przed sortowaniem
                sorter.sort(carArray);
                long end = System.nanoTime();       //pomiar czasu po sortowaniu
                averageTime += (double) (end - start) / 1000000000; //czas w sekundach

            }
            averageTime /= n;
            System.out.println("Current dataSize = " + dataSize + "\nAverage time for that: " + averageTime);
//            line += dataSize + " ";       //tutaj można odkomentować i będzie dodatkowo zapisywał wielkość zbioru danych
            line += averageTime;
            line = line.replace('.',',');   //tutaj zamieniam kropki na przecinki, bo program od wykresów się gubił
            toWrite += line + "\n";         //dodanie linii do zapisu
        }
        writeToFile(toWrite);               //wypis do pliku
    }

    public static void writeToFile(String s) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("TestData.txt", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        writer.print(s);
        writer.close();
    }
}
