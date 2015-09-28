import java.util.Scanner;

public class _10_MagicCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] cards = scanner.nextLine().split("\\s+");
        String oddOrEven = scanner.nextLine();
        String magicCard = scanner.nextLine();

        int magicCardValue = getCardValue(magicCard);
        String magicCardSuit = getCardSuit(magicCard);

        int index = 0;
        if (oddOrEven.equals("odd")) {
            index = 1;
        }

        int sum = 0;
        for (int i = index; i < cards.length; i += 2) {
            String card = cards[i];
            int value = getCardValue(card);
            String suit = getCardSuit(card);

            if (value == magicCardValue) {
                value *= 3;
            }else if (suit.equals(magicCardSuit)) {
                value *= 2;
            }

            sum += value;
        }

        System.out.println(sum);
    }

    private static int getCardValue(String card) {
        int value = 0;
        String cardValue = card.substring(0, 1);
        switch (cardValue) {
            case "1": value = 100;
                break;
            case "J": value = 120;
                break;
            case "Q": value = 130;
                break;
            case "K": value = 140;
                break;
            case "A": value = 150;
                break;
            default: value = Integer.parseInt(cardValue)*10;
        }

        return value;
    }

    private static String getCardSuit(String card) {
        String cardSuit = card.substring(card.length() - 1);
        return cardSuit;
    }
}
