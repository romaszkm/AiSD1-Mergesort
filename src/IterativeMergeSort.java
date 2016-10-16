/**
 * Created by michalromaszko on 16.10.2016.
 */
public class IterativeMergeSort {
    private Comparable[] tab;
    private Comparable[] t;

    public void BottomUpMergeSort() {
        for (int width = 1; width < tab.length; width = 2 * width) {
            for (int i = 0; i < tab.length; i = i + 2 * width) {
                BottomUpMerge(i, Math.min(i + width, tab.length), Math.min(i + 2 * width, tab.length));
            }
            CopyArray();
        }
    }

    public void BottomUpMerge(int iLeft, int iRight, int iEnd) {
        int i = iLeft, j = iRight;
        for (int k = iLeft; k < iEnd; k++) {
            if (i < iRight && (j >= iEnd || tab[i].compareTo(tab[j]) < 0)) {
                t[k] = tab[i];
                i = i + 1;
            } else {
                t[k] = tab[j];
                j = j + 1;
            }
        }
    }

    public void CopyArray() {
        for (int i = 0; i < tab.length; i++)
            tab[i] = t[i];
    }

    public void sort(Comparable[] tab){
        this.tab = tab;
        t = new Comparable[tab.length];
        BottomUpMergeSort();
    }
}
