package com.sparta.ajcd;

public class EncodedString {


    public String encode(String plainText){

        char[] plainTextToArray = plainText.toCharArray();
        int curCharScore = 1;
        //{a,a,a,a,b,b,b,b,c}
        //{a,a,a,a,b,b,b,b,b}
        //4a4b1c
        //4a5b
        StringBuilder finalString = new StringBuilder();

        for(int i = 0; i < plainTextToArray.length-1;i++){
        //if (i == plainTextToArray.length - 1)
            //if im at the final character,
             if(i ==plainTextToArray.length-1){
             break;
             }

            if(plainTextToArray[i] == plainTextToArray[i+1]){
                curCharScore+=1;
            }
            if(plainTextToArray[i] != plainTextToArray[i+1]){
                finalString.append(curCharScore);
                finalString.append(plainTextToArray[i]);
                //curCharScore + curChar; 4a4b
                curCharScore = 1;
            }
            if(i+1 == plainTextToArray.length-1 ){
                finalString.append(curCharScore);
                finalString.append(plainTextToArray[i++]);
            }


        }
        return finalString.toString();
    }

    public static void main(String[] args) {
        EncodedString ec = new EncodedString();
        System.out.println(ec.encode("aaaabbbbb"));
        System.out.println(ec.encode("aaaabbbbc"));
        //4a4b1c
    }
}
