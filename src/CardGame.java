import java.util.ArrayList;
import java.util.Collections;

class Card {
	private int number;

	public Card(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
	
	public String toString() {
		return Integer.toString(number);
	}
}

class Deck {
	public static final int MAX_NUMBER=50;
	private ArrayList <Card>deck = new ArrayList<Card>();
	
	// 카드를 생성하여 덱에 넣는다.
	public Deck() {
		// 52장의 카드를 가지고 있는 덱을 만든다.
		for(int i=0;i<MAX_NUMBER;i++) {
			deck.add(new Card(i));
		}
	}

	// 카드를 섞는다.
	public void shuffle() {
		Collections.shuffle(deck);
	}

	// 덱의 처음에서 카드를 제거하여서 반환한다.
	public Card deal() {
		return deck.remove(0);
	}

}

class Player {
	private ArrayList<Card> list = new ArrayList<Card>();

	public void getCard(Card card) {
		list.add(card);
	}

	public void showCards() {
		System.out.println(list);
	}
	
	// 자신이 지닌 카드 중 최대 카드를 리스트에서 삭제하고 리턴하는 메소드
	public int getMaxCard() {
		int maxCard=0;
		int maxValue=list.get(0).getNumber();
		for(int i=0;i<list.size();i++) {
			if(list.get(maxCard).getNumber()<list.get(i).getNumber()) {
				maxCard=i;
				maxValue=list.get(i).getNumber();
			}
		}
		list.remove(maxCard);
		return maxValue;
	}
	
}

public class CardGame {
	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.shuffle();
		Player p1 = new Player();
		Player p2 = new Player();
		System.out.println("p1과 p2의 카드 목록");
		//p1과 p2에게 번갈아가며 5장씩 카드를 나누어줌
		for(int i=0;i<5;i++) {
			p1.getCard(deck.deal());
			p2.getCard(deck.deal());
		}
		//p1, p2의 카드 목록을 출력
		p1.showCards();
		p2.showCards();
		System.out.println(" ");
		System.out.println("p1과 p2의 최대 카드");
		//p1, p2의 최대 카드를 알아내되 최대 카드를 버림
		int num1=p1.getMaxCard();
		int num2=p2.getMaxCard();
		System.out.println("p1="+num1);
		System.out.println("p2="+num2);
		//게임 룰에 따라 승자가 누구인지 출력
		if(num1>num2) {
			System.out.println("p1의 승리!");
		}
		else if(num1<num2) {
			System.out.println("p2의 승리!");
		}
		else {
			System.out.println("무승부");
		}
		System.out.println(" ");
		//p1, p2의 카드 목록을 출력
		p1.showCards();
		p2.showCards();
	}
}
