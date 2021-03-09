package interview.loop;

public class BinarySearch {

     public int binarySearch(int[] a, int k){

         int lo = 0, hi = a.length-1;
         while (lo<=hi){
             int mid = lo + (hi-lo)/2;
             if (a[mid]>k) hi = mid - 1;
             else if (a[mid]<k) hi = mid +1;
             else  return mid;
         }
         return -1;
     }

    public int binarySearch2(int[] arr, int k){
         int a = 0;
         int b = arr.length;
         //循环不变量：[a,b)是一个合法区间
         while (a<b){
             int m = a + (b-a)/2;
             if (k<arr[m]){
                 b = m;
             }else if (k > arr[m]){
                 a = m+1;
             }else {
                 return m;
             }
         }
         return -1;
    }

    public static void main(String[] args) {
         BinarySearch binarySearch = new BinarySearch();

        System.out.println(binarySearch.binarySearch2(new int[]{1, 2, 10, 15, 100}, 15));
        System.out.println(binarySearch.binarySearch2(new int[]{1, 2, 10, 15, 100}, -2));
        System.out.println(binarySearch.binarySearch2(new int[]{1, 2, 10, 15, 100}, 101));
        System.out.println(binarySearch.binarySearch2(new int[]{1, 2, 10, 15, 100}, 13));
    }
}
