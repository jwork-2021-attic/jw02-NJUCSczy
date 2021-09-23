package S191220016;

import java.util.LinkedList;

public class QuickSorter implements Sorter {

    private int[] a;

    @Override
    public void load(int[] a) {
        this.a = a;
    }

    private void swap(int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += Integer.toString(i) + "<->" + Integer.toString(j) + "\n";
    }

    private String plan = "";

    @Override
    public void sort() {
        LinkedList<int[]> stack = new LinkedList<>();
        stack.addFirst(new int[]{0, a.length - 1});
        while (!stack.isEmpty()) {
            int[] tuple = stack.removeFirst();
            int start = tuple[0], end = tuple[1], i = tuple[0], j = tuple[1];
            while (j > i) {
                while (j > i && a[j] > a[start]) {
                    j--;
                }
                while (j > i && a[i] <= a[start]) {
                    i++;
                }
                if (j > i) {
                    swap(i, j);
                }
            }
            if (start != i) {
                swap(i,start);
            }
    
            if (i - 1 > start) {
                stack.addFirst(new int[]{0, i - 1});
            }
            if (j + 1 < end) {
                stack.addFirst(new int[]{j + 1, end});
            }
        }
    }

    @Override
    public String getPlan() {
        return this.plan;
    }

}
