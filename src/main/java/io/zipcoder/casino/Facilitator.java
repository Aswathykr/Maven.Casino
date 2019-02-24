package io.zipcoder.casino;

import io.zipcoder.casino.cardgames.Card;
import io.zipcoder.casino.cardgames.Deck;
import io.zipcoder.casino.cardgames.SignType;
import io.zipcoder.casino.player.CardPlayer;
import io.zipcoder.casino.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Facilitator {

    private CardPlayer currentPlayer;
    private List<CardPlayer > playerList;

    public CardPlayer getWinner() {
        return winner;
    }

    private CardPlayer winner;
    Deck deck;


    public Facilitator(List<CardPlayer> playerList, Deck deck) {
        this.playerList = playerList;
        this.deck = deck;
    }

    public boolean evaluateTurn() {

        boolean didWin = false;
        for(CardPlayer player : playerList) {
            if(player.getNumberOfCardsInHand() == 0){
                winner = player;
                didWin = true;
                break;
            }
        }

        return didWin;

    }

    public void distributeCards() {

        int i = 0;
        int currentCard;

        for (int rank = 1; rank <= 5; rank++) {
            for (CardPlayer player : playerList) {
                Card card = deck.draw();
                player.addCardToHand(card);
            }
        }
    }
}
