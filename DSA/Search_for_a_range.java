
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//your code here
                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();
                int arr[] = new int[n];
                for(int i=0; i<n; i++){
                        arr[i] = sc.nextInt();
                }
                int target = sc.nextInt();

        int ans[] = new int[2];
        ans[0] = firstOccurance(arr, target);
        ans[1] = lastOccurance(arr, target);

                System.out.print(ans[0] + " " + ans[1]);
                
	}

       // using binary search 
        
    static int firstOccurance(int[] arr, int target){
        int l = 0;
        int r = arr.length - 1;
        int ans = -1;
        int mid;
        while(l <= r){
            mid = (l + r)/2;
            if(arr[mid] == target){
                ans = mid;
                r = mid - 1;
            }
            else if(arr[mid] < target){
                // set the starting point correctly
                l = mid + 1;
            }
            else if(arr[mid] > target){
                // update the end of subarray
                r = mid - 1;
            }
        }
        return ans;
    }
   static int lastOccurance(int[] arr, int target){
        int n = arr.length;
        int l = 0;
        int r = arr.length - 1;
        int mid;
        while(l <= r){
            mid = (l + r)/2;
            if(arr[mid] == target){
                if(mid == n - 1 || arr[mid + 1] != target)
                    return mid;
                l = mid + 1; // reduce the array to half
            }
            else if(arr[mid] < target){
                // set the starting point correctly
                l = mid + 1;
            }
            else if(arr[mid] > target){
                // update the end of subarray
                r = mid - 1;
            }
        }
        return -1;
}
}
