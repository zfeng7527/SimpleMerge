/**
 * Created by Teacher on 1/28/2019.
 * simpleMerge takes in two sorted arrays of
 * integers and merges them to return one sorted
 * array of integers.
 */
public class SimpleMerge {
    public static int[] simpleMerge(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length+arr2.length];
        int i =0,j=0,k=0;
        while(k<(arr1.length+arr2.length)){
            if( i<arr1.length && arr1[i]<arr2[j]){
                arr3[k]=arr1[i];
                i++;
            }
            else{
                arr3[k]=arr2[j];
                j++;
            }
            k++;
        }
        return arr3;
    }

    public void mergeSort(int[] arr){
        int n = arr.length;
        int[] temp= new int[n];
        mergeSortHelper(arr,0,n-1,temp);
    }

    public void mergeSortHelper(int[] arr, int left,int right,int[] temp){
        if(left<right){
            int mid = (left+right)/2;
            mergeSortHelper(arr,left,mid,temp);
            mergeSortHelper(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);
        }
    }

    public void merge(int[] arr, int left,int mid, int right, int[] temp){
            int i = left ,j = mid+1,k=left;

            while(i <= mid && j <= right)
            {
                if(arr[i] < arr[j])
                {
                    temp[k] = arr[i];
                    i++;
                }
                else
                {
                    temp[k] = arr[j];
                    j++;
                }
                k++;
            }

            while(i <= mid)
            {
                temp[k] = arr[i];
                i++;
                k++;
            }

            while(j<= right) {
                temp[k] = arr[j];
                j++;
                k++;
            }

            for(k= left; k<= right; k++)
            {
                arr[k] = temp[k];
            }
        }

}
