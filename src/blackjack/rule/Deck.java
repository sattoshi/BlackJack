package blackjack.rule;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	//先頭の要素がマークを表す。
		//101~113:スペードのトランプ
		//201~213:クローバーのトランプ
		//301~313:ハートのトランプ
		//401~413:ダイヤのトランプ
		private ArrayList<Integer> deck = new ArrayList<Integer>();

		//コンストラクタ：山札を初期化シャッフル
		public Deck() {
			for(int i = 1; i <= 4; i++) {
				for(int j = 1; j <= 13 ;j++) {
					deck.add(i*100 + j);
				}
			}
			Collections.shuffle(deck);
		}

		//デッキからトランプを一枚引く
		public int DrawCard() {
			int cardNum = deck.get(0);
			deck.remove(0);
			return cardNum;
		}

}
