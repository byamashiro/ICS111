
public class TrafficLight {

	// possible states
	static final int RED = 0;
	static final int YELLOW = 1;
	static final int GREEN = 2;

	// current state
	int state;

	// make a constructor that takes in the initial state
	TrafficLight(int initState) {
		state = initState;
	}

	// make a processStates() function of type void, and make it do the following
	void processStates() {
		switch(state) { // switch state

		case RED: // case RED,
			System.out.println("Red"); // println "Red"
			if(EZInteraction.wasMouseLeftButtonPressed()) { // if left mouse pressed, then switch state to GREEN
				state = GREEN;
			}
			break;

		case YELLOW: // case YELLOW,
			System.out.println("Yellow"); // println "Yellow"
			if(EZInteraction.wasMouseLeftButtonPressed()) { // if left mouse pressed, then switch state to RED
				state = RED;
			}
			break;

		case GREEN: // case GREEN,
			System.out.println("Green"); // println "Green"
			if(EZInteraction.wasMouseLeftButtonPressed()) { // if left mouse pressed, then switch state to YELLOW
				state = YELLOW;
			}
			break;
		}

	}

}
