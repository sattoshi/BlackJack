package blackjack.main;

import java.util.Scanner;

import blackjack.rule.Dealer;
import blackjack.rule.Deck;
import blackjack.rule.Player;

public class Rungame {

	public static void main(String[] args) {

		Deck deck = new Deck();

		//カードを二枚に引きプレイヤーの手札にセット
		Player player = new Player();
		player.setPlayerCard(deck.DrawCard());
		player.setPlayerCard(deck.DrawCard());
		System.out.println("プレイヤーの手札を表示");
		player.showCard(player.getPlayerCard());
		System.out.println("現時点の合計ポイント ： " + player.getPoint(player.getPlayerCard()));

		System.out.println();

		//カードを二枚に引きディーラーの手札にセット
		Dealer dealer = new Dealer();
		dealer.setDealerCard(deck.DrawCard());
		dealer.setDealerCard(deck.DrawCard());
		System.out.println("ディーラーの手札を1枚目のみ表示");
		dealer.showOnlyCard(dealer.getDealerCard());

		System.out.println();


		//新たにカードを引く場合はループ
		Scanner scan = new Scanner(System.in);
		while(player.getPoint(player.getPlayerCard()) <= 21) {

			String str;

	        do {
	        	System.out.println("新たにカードを引きますか？ 引く場合:q / 勝負する場合:p");
	            str = scan.next();
	            System.out.println();
	        }while(!(str.equals("q") || str.equals("p")));

	        if(str.equals("q")) {
	        	player.setPlayerCard(deck.DrawCard());
	        	System.out.println("プレイヤーの手札を表示");
	    		player.showCard(player.getPlayerCard());
	    		System.out.println("現時点の合計ポイント ： " + player.getPoint(player.getPlayerCard()));
	        }else if(str.equals("p")) {
	        	break;
	        }
	        if(player.getPoint(player.getPlayerCard()) > 21) {
				System.out.println("バースト！!");
				System.exit(0);
			}
        }
		 scan.close();

		 //ディーラーの手札が17以上になるまで引く
		 while(dealer.getPoint(dealer.getDealerCard()) < 17) {
			 dealer.setDealerCard(deck.DrawCard());
		 }

		 System.out.println("勝負します！！");

		 System.out.println();

		//ディーラーの手札公開
		System.out.println("ディーラーの手札を表示");
		dealer.showCard(dealer.getDealerCard());
 		System.out.println("合計ポイント ： " + dealer.getPoint(dealer.getDealerCard()));

 		System.out.println();

 		if(dealer.getPoint(dealer.getDealerCard()) > 21) {
 			System.out.println("ディーラーがバーストしました。");
 			System.out.println("You Win!");
 		}else if (dealer.getPoint(dealer.getDealerCard()) < player.getPoint(player.getPlayerCard())) {
 			System.out.println("You Win!");
 		}else if (dealer.getPoint(dealer.getDealerCard()) == player.getPoint(player.getPlayerCard())) {
 			System.out.println("Drow");
 		}else {
 			System.out.println("You Lose...");
 		}
	}
}
