package Rough;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PuzzleOne {

    public static void main(String[] args){

        int no_of_Coins=1100,no_of_people=1100;

        //First Person sets all Heads
        List<Boolean> coin = new ArrayList<Boolean>(Collections.nCopies(1101,true));


        //Persons 2 - 1100
        for(int x=2;x<=no_of_people;x++){
            for(int y=1;y<=no_of_Coins;y++){

                if((y)%(x)==0){
                    coin.set(y,!coin.get(y));
                }
            }
        }

        //Ignore extra element - set false
        coin.set(0,false);

        coin.removeIf(n -> n==false);
        int no_of_Heads = coin.size();
        int no_of_Tails = no_of_Coins-no_of_Heads;
        System.out.println("No. of Heads: "+no_of_Heads);
        System.out.println("No. of Tails: "+no_of_Tails);

    }


    public static String getCoinFace(boolean b){
        String face="Tails";
        if(b){
            face="Heads";
        }
        return face;
    }


}
