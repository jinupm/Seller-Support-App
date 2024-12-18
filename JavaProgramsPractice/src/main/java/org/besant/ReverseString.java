package org.besant;

public class ReverseString {
    public static String reverseString(String str){
        char[] cArray = str.toCharArray();
        int left = 0, right = cArray.length - 1 ;

        while(left < right){
            char temp = cArray[left];
            cArray[left] = cArray[right];
            cArray[right] = temp;
            left++;
            right--;
        }
        return new String(cArray);


    }


    public static void main(String[] args) {
        System.out.println(reverseString("Jinupoyyara"));
    }
}
