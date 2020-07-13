package blackjack.rule;

import java.util.ArrayList;

public class Card {

	//引いたカードを表示する。
	public void showCard(ArrayList<Integer> cardList) {
		for(int i = 0; i < cardList.size(); i++) {
			System.out.println(getMark(cardList.get(i)) +" の "+ getNum(cardList.get(i)));
		}
	}

	//トランプマークを返す。
	protected String getMark(int cardNum) {
		switch (cardNum / 100) {
			case 1: return "スペード";
			case 2: return "クローバー";
			case 3: return "ハート";
			case 4: return "ダイヤ";
			default: return null; //エラー
		}
	}

	//トランプ番号を返す
	protected String getNum(int cardNum) {
		int num = cardNum % 100;
		switch (num) {
			case 1: return "A";
			case 11: return "J";
			case 12: return "Q";
			case 13: return "K";
			default: return String.valueOf(num);
		}
	}

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



}
