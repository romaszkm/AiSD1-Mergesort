import java.lang.reflect.Array;

/**
 * Created by michalromaszko on 10.10.2016.
 */
public class Mergesort {
    private Comparable[] tab;
    private Comparable[] t;

    private void merge(int beggining, int middle, int end) {
        int i, j, q;
        for (i = beggining; i <= end; i++) {
            t[i] = tab[i];  // Skopiowanie danych do tablicy pomocniczej
        }
        i = beggining;
        j = middle + 1;
        q = beggining;                 // Ustawienie wskaźników tablic
        while (i <= middle && j <= end) {// Przenoszenie danych z sortowaniem ze zbiorów pomocniczych do tablicy głównej
            if (t[i].compareTo(t[j]) < 0)
                tab[q++] = t[i++];
            else
                tab[q++] = t[j++];
        }
        while (i <= middle)
            tab[q++] = t[i++]; // Przeniesienie nie skopiowanych danych ze zbioru pierwszego w przypadku, gdy drugi zbiór się skończył
    }

    private void mergesort(int beggining, int end) {
        int middle;
        if (beggining < end) {
            middle = (beggining + end) / 2;
            mergesort(beggining, middle);
            mergesort(middle + 1, end);
            merge(beggining, middle, end);
        }
    }

    public void sort(Comparable[] tab) {
        this.tab = tab;
        t = new Comparable[tab.length];
        mergesort(0, tab.length - 1);
    }

}
