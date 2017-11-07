package prelab11;

public class Main {

	public static void main(String[] args) {
		EZ.initialize(500,500);
		Coin coin = new Coin();
		while(true) {
			coin.processStates();
			EZ.refreshScreen();
		}

	}

}
