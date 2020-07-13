package blackjack.rule;

import java.util.ArrayList;

public class Player extends Card{
	private ArrayList<Integer> playerCard = new ArrayList<Integer>();

	public void setPlayerCard(int cardNum) {
		this.playerCard.add(cardNum);
	}

	public ArrayList<Integer> getPlayerCard() {
		return playerCard;
	}
}
