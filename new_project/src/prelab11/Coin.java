package prelab11;

public class Coin {
	static final int HEADS=0;
	static final int TAILS=1;
	
	int state;
	
	void processStates() {
		switch(state) {
		
		case HEADS:
			System.out.println("Heads");
			if (EZInteraction.wasMouseLeftButtonPressed()) {
				state = TAILS;
			}
			break;
			
		case TAILS:
			System.out.println("Tails");
			if(EZInteraction.wasMouseLeftButtonPressed()) {
				state = HEADS;
			}
			break;
		}
	}
}
