	import java.util.Random;

public class Card {
	static int getCard() {
		Random random = new Random();
		 int card = random.nextInt(13)+1;
		 return card;
	}
	static int getNextCard() {
		Random random = new Random();
		int nextCard = random.nextInt(13)+1;
		return nextCard;
	}
}