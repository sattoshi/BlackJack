package blackjack.main;

import blackjack.rule.Dealer;
import blackjack.rule.Deck;
import blackjack.rule.Player;

public class Rungame {

	public static void main(String[] args) {

		Deck deck = new Deck();

		//カードを二枚に引きプレイヤーの手札にセット
		Player player = new Player(deck);

		//カードを二枚に引きディーラーの手札にセット
		Dealer dealer = new Dealer(deck);

		//プレイヤーの操作
		int playerPoint = player.endDrow(deck);

		//ディーラーの操作
		int dealerPoint = dealer.endDrow(deck);

		 System.out.println("勝負します！！");
		 System.out.println();

		//ディーラーの手札公開
		System.out.println("ディーラーの手札を表示");
		dealer.showCard(dealer.getHoldingCard());
 		System.out.println("合計ポイント ： " + dealerPoint);

 		System.out.println();

 		if(dealerPoint > 21) {
 			System.out.println("ディーラーがバーストしました。");
 			System.out.println("You Win!");
 		}else if (dealerPoint < playerPoint) {
 			System.out.println("You Win!");
 		}else if (dealerPoint == playerPoint) {
 			System.out.println("Drow");
 		}else {
 			System.out.println("You Lose...");
 		}
	}
}
