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
	
	// ī�带 �����Ͽ� ���� �ִ´�.
	public Deck() {
		// 52���� ī�带 ������ �ִ� ���� �����.
		for(int i=0;i<MAX_NUMBER;i++) {
			deck.add(new Card(i));
		}
	}

	// ī�带 ���´�.
	public void shuffle() {
		Collections.shuffle(deck);
	}

	// ���� ó������ ī�带 �����Ͽ��� ��ȯ�Ѵ�.
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
	
	// �ڽ��� ���� ī�� �� �ִ� ī�带 ����Ʈ���� �����ϰ� �����ϴ� �޼ҵ�
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
		System.out.println("p1�� p2�� ī�� ���");
		//p1�� p2���� �����ư��� 5�徿 ī�带 ��������
		for(int i=0;i<5;i++) {
			p1.getCard(deck.deal());
			p2.getCard(deck.deal());
		}
		//p1, p2�� ī�� ����� ���
		p1.showCards();
		p2.showCards();
		System.out.println(" ");
		System.out.println("p1�� p2�� �ִ� ī��");
		//p1, p2�� �ִ� ī�带 �˾Ƴ��� �ִ� ī�带 ����
		int num1=p1.getMaxCard();
		int num2=p2.getMaxCard();
		System.out.println("p1="+num1);
		System.out.println("p2="+num2);
		//���� �꿡 ���� ���ڰ� �������� ���
		if(num1>num2) {
			System.out.println("p1�� �¸�!");
		}
		else if(num1<num2) {
			System.out.println("p2�� �¸�!");
		}
		else {
			System.out.println("���º�");
		}
		System.out.println(" ");
		//p1, p2�� ī�� ����� ���
		p1.showCards();
		p2.showCards();
	}
}
