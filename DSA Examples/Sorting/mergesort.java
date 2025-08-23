public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{12,11,13,5,6};

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }

        System.out.println();
        mergeSort(arr, 0, arr.length-1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static void mergeSort(int[] arr, int l, int r){
        if(l < r){
            int m = l + (r-l)/2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r){
        // Find sizes of two subarrays to be merged
        int s1 = m - l + 1;
        int s2 = r - m;

        // Create temp arrays
        int[] L = new int[s1];
        int[] R = new int[s2];

        // Copy data to temp arrays
        for(int i = 0; i < s1; i ++){ L[i] = arr[l + i];}
        for(int j = 0; j < s2; j++){ R[j] = arr[m+ 1 + j];}

        // Initial indices of first and second subarrays
        int i = 0, j =0;

        // Initial index of merged subarray array
        int k = l;

        while(i < s1 && j < s2){
            if(L[i] <= R[j]){ // "=" to keep sort stable vs non "=", so it takes from L vs R which keeps order.
                arr[k]= L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while(i < s1){
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while(j < s2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
