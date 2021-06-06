package Rough;

import java.util.ArrayList;
import java.util.List;

public class Card {

    private enum Rank{ACE,DEUCE,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING}
    private enum Suit{CLUB,DIAMOND,HEART,SPADE}


    Rank rank;Suit suit;


    public Card (Rank r,Suit s){
        this.rank = r;
        this.suit = s;

    }

    public Card (){

    }

    public List<Card> generateDeck(){

        List<Card> deck= new ArrayList<Card>();
        for(Rank r:Rank.values()){
            for(Suit s:Suit.values()){
                deck.add(new Card(r,s));
            }
        }
        return deck;
    }
}

