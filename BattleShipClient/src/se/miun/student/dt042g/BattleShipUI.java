package se.miun.student.dt042g;

import java.io.IOException;
import java.util.Scanner;

public class BattleShipUI implements IBattleShipUI {

	int xMove = -1;
	int yMove = -1;
	@Override
	public void updateGameBoard(GameBoard[] gameBoard) {

		clearScreen();

		for (int i = 0; i < 10; i++) {
			System.out.print("  " + i);
		}

		System.out.print("    ");

		for (int i = 0; i < 10; i++) {
			System.out.print("  " + i);
		}

		System.out.println();

		for (int outer = 0; outer < 10; outer++) {

			System.out.print(outer + " ");

			for (int inner1 = 0; inner1 < 10; inner1++) {
				EnumCellStatus tmpValue = gameBoard[0].getPositionValue(outer,
						inner1);
				System.out.print(getCellStatusChar(tmpValue));
				System.out.print("  ");
			}

			System.out.print(" " + outer + "  ");

			for (int inner1 = 0; inner1 < 10; inner1++) {
				EnumCellStatus tmpValue = gameBoard[1].getPositionValue(outer,
						inner1);
				System.out.print(getCellStatusChar(tmpValue));
				System.out.print("  ");
			}
			System.out.print("\n");
		}

		System.out.println("Skriv uttrycket du vill f� utr�knat.");
		System.out.print("Input: ");
	}

	private char getCellStatusChar(EnumCellStatus tmpValue) {

		switch (tmpValue) {
		case EMPTY:
			return '.';

		case MISS:
			return 'X';
		case SUBMARINE:
		case DESTROYER:
		case CARRIER:
			return 'O';

		case SUBMARINE_HIT:
		case DESTROYER_HIT:
		case CARRIER_HIT:
			return '*';
		}
		return '.';
	}

	@Override
	public MessageMove getMove() {
		Scanner input = new Scanner(System.in);	
		System.out.print("Vart vill du bomba X,Y? ");
		String inputString = new String(input.nextLine());
		String[] movePointsinput = inputString.split(",");
		xMove = Integer.parseInt(movePointsinput[0]);
		yMove = Integer.parseInt(movePointsinput[1]);
		return null;
	}

	@Override
	public ShipPlacement getPlacement() {
		writeBoard();
		
		Scanner input = new Scanner(System.in);	
		String inputString = "";
		System.out.println("1. Ub�t");
		System.out.println("2. Jagare");
		System.out.println("3. Hangarfartyg");
		System.out.print("Vad f�r fartyg vill du placera ut? ");
		
		while (!(inputString.equals("1") || inputString.equals("2") || inputString.equals("3"))) {
			inputString = new String(input.nextLine());
		}
		return null;
	}



	private void writeBoard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Message getLobbyChoice() {
		Scanner input = new Scanner(System.in);	
		System.out.print("Vill du spela mot en AI eller mot en klient (A/K)?");
		String inputString = new String(input.nextLine());	
		
		if (inputString.equals("A")) {
			return new MessageLobbyChoice(EnumLobbyChoice.PLAY_VS_AI);
		}
		else {
			return new MessageLobbyChoice(EnumLobbyChoice.WAIT_FOR_PLAYER);
		}
	}
	
	private void clearScreen() {
		try {

			if (System.getProperty("os.name").toLowerCase().contains("window")) {
				Runtime.getRuntime().exec("cmd /c cls");

			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int getMoveX() {
		int returnValue = xMove;
		xMove = -1;
		return returnValue;
	}

	@Override
	public int getMoveY() {
		int returnValue = yMove;
		yMove = -1;
		return returnValue;
	}

}
