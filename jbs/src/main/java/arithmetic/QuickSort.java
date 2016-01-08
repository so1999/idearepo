package arithmetic;

/**
 * Created by Sun on 2015/12/30.
 */
public class QuickSort {
    public static void quicksort(int a[],int low,int high){
        int l=low;
        int r=high;
        int temp=a[l];
        if(l<r){
            while(l<r&&a[r]>temp)
                r--;
            if(l<r)
                a[l]=a[r];
            while(l<r&&a[l]<=temp)
                l++;
            if(l<r)
                a[r]=a[l];
        }
        a[l]=temp;
        quicksort(a,low,l-1);
        quicksort(a,l+1,high);
    }
}
