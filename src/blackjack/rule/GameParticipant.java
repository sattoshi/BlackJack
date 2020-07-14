package blackjack.rule;

import java.util.ArrayList;

public abstract class GameParticipant {
	private ArrayList<Integer> holdingCard = new ArrayList<Integer>();
	Card card = new Card();

	//セッター
	public void setHoldingCard(int cardNum) {
		this.holdingCard.add(cardNum);
	}

	//ゲッター
	public ArrayList<Integer> getHoldingCard() {
		return holdingCard;
	}

	//最終的な合計点を返す。
	public abstract int endDrow(Deck deck) ;

	//点数計算
	public int getPoint(ArrayList<Integer> cardList) {
		int sumPoint = 0;
		for(int i = 0; i < cardList.size(); i++) {
			int num = cardList.get(i) % 100;
			switch (num) {
				case 11:
				case 12:
				case 13: num = 10; break;
			}
			sumPoint += num;
		}
		return sumPoint;
	}

	//手持ちカードを全て表示する。
	public void showCard(ArrayList<Integer> cardList) {
		for(int i = 0; i < cardList.size(); i++) {
			System.out.println(card.getMark(cardList.get(i)) +" の "+ card.getNum(cardList.get(i)));
		}
	}

	//手持ちカードを一枚だけ表示する。
	public void showOnlyCard(ArrayList<Integer> cardList) {
		System.out.println(card.getMark(cardList.get(0)) +" の "+ card.getNum(cardList.get(0)));
	}

}
