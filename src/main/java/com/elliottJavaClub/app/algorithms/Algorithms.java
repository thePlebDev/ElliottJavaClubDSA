package com.elliottJavaClub.app.algorithms;

public class Algorithms {

    public static boolean binarySearch(int[] data, int target, int low, int high){
        if(low > high){
            return false;
        }
        else{
            int mid = (low + high) / 2;
            if(data[mid] == target){
                return true;
            }
            else if(target < data[mid]){
                return binarySearch(data,target,low,mid -1);

            }
            else{
                return binarySearch(data,target,mid +1,high);
            }
        }
    }
    public static int[] reverseArray(int[] data,int low,int high){
        if(low < high){
            int temp = data[low];
            data[low] = data[high];
            data[high] = temp;
            reverseArray(data, low + 1, high -1);
        }

        return data;
    }
}
