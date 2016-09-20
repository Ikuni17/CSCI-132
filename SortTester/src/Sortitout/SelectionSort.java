package sortitout;

public class SelectionSort {
    
  public static <T extends Comparable <T>> 
        void selectionSort (T[] table, Integer low, Integer high) {
    int n = high;
//    System.out.println(n);
	 
    for (int fill = low; fill < n; fill++){
        int posMin = fill;
        int next = fill + 1;
        while (next <= n){
//            System.out.println("here " + n + " " +fill + " " + next);
            if (table[next].compareTo(table[posMin]) < 0) {
		   posMin = next;
	    }
        next++;
        }
        T temp = table[fill];
        table[fill] = table[posMin];
        table[posMin] = temp;
    }
  }
}