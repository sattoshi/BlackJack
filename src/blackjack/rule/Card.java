package blackjack.rule;

public class Card {

	//トランプマークを返す。
	public String getMark(int cardNum) {
		switch (cardNum / 100) {
			case 1: return "スペード";
			case 2: return "クローバー";
			case 3: return "ハート";
			case 4: return "ダイヤ";
			default: return null; //エラー
		}
	}

	//トランプ番号を返す
	public String getNum(int cardNum) {
		int num = cardNum % 100;
		switch (num) {
			case 1: return "A";
			case 11: return "J";
			case 12: return "Q";
			case 13: return "K";
			default: return String.valueOf(num);
		}
	}
}
