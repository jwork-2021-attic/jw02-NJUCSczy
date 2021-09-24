package S191220016;


public class ShellSorter implements Sorter {

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
        for (int i = a.length / 2; i > 0; i /= 2) {
            for (int j = i; j < a.length; j++) {
                for (int k = j; k > 0  && k - i >= 0; k -= i) {
                    if (a[k] < a[k - i]) {
                        swap(k-1, k);
                    } else {
                        break;
                    }
                }
            }
        }
    }

    @Override
    public String getPlan() {
        return this.plan;
    }

}
