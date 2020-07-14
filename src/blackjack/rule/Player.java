package blackjack.rule;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends GameParticipant{
	//コンストラクタ（2枚カードを引く）
	public Player(Deck deck) {
		super.setHoldingCard(deck.DrawCard());
		super.setHoldingCard(deck.DrawCard());


		//持ち札を全て表示
		ArrayList<Integer> holdingCardList = super.getHoldingCard();
		System.out.println("プレイヤーの手札を表示");
		showCard(holdingCardList);
		System.out.println("現時点の合計ポイント ： " + super.getPoint(super.getHoldingCard()));
		System.out.println();
	}

	//カードを任意の枚数引いて最終的な合計ポイントを返却する。
	public int endDrow(Deck deck) {
		//新たにカードを引く場合はループ
		Scanner scan = new Scanner(System.in);
		while(super.getPoint(super.getHoldingCard()) <= 21) {

			String str;

	        do {
	        	System.out.println("新たにカードを引きますか？ 引く場合:q / 勝負する場合:p");
	            str = scan.next();
	            System.out.println();
	        }while(!(str.equals("q") || str.equals("p")));

	        if(str.equals("q")) {
	        	super.setHoldingCard(deck.DrawCard());
	        	System.out.println("プレイヤーの手札を表示");
	    		showCard(super.getHoldingCard());
	    		System.out.println("現時点の合計ポイント ： " + super.getPoint(super.getHoldingCard()));
	        }else if(str.equals("p")) {
	        	break;
	        }
	        if(super.getPoint(super.getHoldingCard()) > 21) {
				System.out.println("バースト！!");
				System.exit(0);
			}
        }
		 scan.close();

		 return super.getPoint(super.getHoldingCard());
	}

}
