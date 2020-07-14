package blackjack.rule;

import java.util.ArrayList;

public class Dealer extends GameParticipant {
	//コンストラクタ（カードを２枚引く）
	public Dealer(Deck deck) {
		super.setHoldingCard(deck.DrawCard());
		super.setHoldingCard(deck.DrawCard());

		//持ち札を1枚だけ表示
		System.out.println("ディーラーの手札を1枚目のみ表示");
		ArrayList<Integer> holdingCardList = super.getHoldingCard();
		showOnlyCard(holdingCardList);
		System.out.println();
	}

	public int endDrow(Deck deck) {
		 //ディーラーの手札が17以上になるまで引く
		 while(super.getPoint(super.getHoldingCard()) < 17) {
			 super.setHoldingCard(deck.DrawCard());
		 }
		 return super.getPoint(super.getHoldingCard());
	}

}
