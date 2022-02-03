package com.elliottJavaClub.app;

import com.elliottJavaClub.app.algorithms.Algorithms;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Algorithms algorithms = new Algorithms();
        int [] original= {1,2,3,4};

        System.out.println(arrayToString(Algorithms.reverseArray(original,0,original.length-1)));


    }

    public static String arrayToString(int[] arrays){
        String convertedArray = "";
        for(int i = 0; i <  arrays.length; i ++){
            convertedArray += arrays[i];
        }
        return convertedArray;
    }
}
