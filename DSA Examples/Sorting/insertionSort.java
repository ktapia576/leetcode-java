// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    public static void main(String[] args) {
        int[] arr = {12,11,13,5,6};
        
        
        for(int i = 1; i < arr.length; i++){
            int j = i - 1;
            int key = arr[i];
            
            while(j >= 0 && key < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            
            //place "key"
            arr[j+1] = key; 
        }
        
        for(int element: arr){
            System.out.print(element + ",");
        }
        
    }
}