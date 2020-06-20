import java.util.Scanner;

public class PatchworkSimple {

	public static void main(String[] args) {
		Game game = new Game();
		Scanner scan = new Scanner(System.in);
		Piece piece1, piece2, piece3;
		int choice = 0;
		System.out.println("Welcome to Patchwork!");
		
		while (game.isInProgress()) {
			//game status
			System.out.println("\nPlayer 1 \t\tPlayer 2");
			System.out.println("Money: " + game.getP1Money() + "\t\tMoney: " + game.getP2Money());
			System.out.println("Time: " + game.getP1TimeRemaining() + "\t\tTime: " + game.getP2TimeRemaining());
			System.out.println("Spaces: " + game.getP1UncoveredSpaces() + "\t\tSpaces: " + game.getP2UncoveredSpaces());
			System.out.println("Buttons: " + game.getP1Buttons() + "\t\tButtons: " + game.getP2Buttons());
			System.out.println("Score: " + game.getP1Score() + "\t\tScore: " + game.getP2Score());
			
			//turn
			piece1 = game.getOffer().peek(0);
			piece2 = game.getOffer().peek(1);
			piece3 = game.getOffer().peek(2);
			System.out.println("\nPlayer " + (game.isP1Turn() ? "1" : "2") + "'s turn");
			System.out.println("Offer:\n");
			System.out.println("Piece 1 \t\tPiece 2 \t\tPiece 3");
			System.out.println("Cost: " + piece1.getCost() + "  \t\tCost: " + piece2.getCost() + "  \t\tCost: " + piece3.getCost());
			System.out.println("Time: " + piece1.getTime() + "   \t\tTime: " + piece2.getTime() + "   \t\tTime: " + piece3.getTime());
			System.out.println("Spaces: " + piece1.getSpaces() + "\t\tSpaces: " + piece2.getSpaces() + "\t\tSpaces: " + piece3.getSpaces());
			System.out.println("Buttons: " + piece1.getButtons() + "\t\tButtons: " + piece2.getButtons() + "\t\tButtons: " + piece3.getButtons());
			
			//prompt
			System.out.println("\n0 for pass, 1 for 1st piece, 2 for 2nd piece, 3 for 3rd piece");
			System.out.print("Player " + (game.isP1Turn() ? "1" : "2") + "'s choice: ");
			choice = scan.nextInt();
			if(choice == 0)
				game.advance();
			else
				game.buy(choice-1);
		}
		
		System.out.println("\nGame over");
		System.out.println("Player 1 \t\tPlayer 2");
		System.out.println("Money: " + game.getP1Money() + "\t\tMoney: " + game.getP2Money());
		System.out.println("Time: " + game.getP1TimeRemaining() + "  \t\tTime: " + game.getP2TimeRemaining());
		System.out.println("Spaces: " + game.getP1UncoveredSpaces() + "\t\tSpaces: " + game.getP2UncoveredSpaces());
		System.out.println("Income: " + game.getP1Buttons() + "\t\tButtons: " + game.getP2Buttons());
		System.out.println("Score: " + game.getP1Score() + "\t\tScore: " + game.getP2Score());
		
		scan.close();
	}

}
