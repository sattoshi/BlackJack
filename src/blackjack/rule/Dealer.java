package blackjack.rule;

import java.util.ArrayList;

public class Dealer extends Card {
	private ArrayList<Integer> dealerCard = new ArrayList<Integer>();

	public void setDealerCard(int cardNum) {
		this.dealerCard.add(cardNum);
	}
	public ArrayList<Integer> getDealerCard() {
		return dealerCard;
	}

	public void showOnlyCard(ArrayList<Integer> cardList) {
		System.out.println(super.getMark(cardList.get(0)) +" の "+ super.getNum(cardList.get(0)));
	}

}
