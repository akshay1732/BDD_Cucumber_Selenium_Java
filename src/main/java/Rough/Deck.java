package Rough;


import java.util.ArrayList;
import java.util.List;

public class Deck {

    static List<Card> deck= new ArrayList<Card>();

    public Deck(){
        Card card = new Card();
        deck=card.generateDeck();

    }


    public static void main(String[] args){

        for(Card c:deck){
            System.out.println("Rank: "+c.rank+" Suit: "+c.suit);
        }


    }


}
