public class HeroPlus {
	EZImage heroStand;
	EZImage heroJump;
	EZImage heroLand;
	EZImage heroHover;
	EZImage heroPunch; // PUNCH
	int posx = 0;
	int posy = 0;
	int heroState = 1;
	
	static final int STAND = 1;
	static final int JUMP = 2;
	static final int LAND = 3;
	static final int HOVER = 4;
	static final int PUNCH = 5;
	static final int JUMPHEIGHT = 100;
	static final int PUNCHDISTANCE = 50; // PUNCH

	int punchCounter = 0; // PUNCH
	int jumpCounter = 0;

	HeroPlus(int x, int y) {
		posx = x;
		posy = y;
		heroStand = EZ.addImage("superstand.png", posx, posy);
		heroLand = EZ.addImage("superland.png", posx, posy);
		heroJump = EZ.addImage("superjump.png", posx, posy);
		heroHover = EZ.addImage("superhover.png", posx, posy);
		heroPunch = EZ.addImage("superpunch.png", posx, posy);
		hideHero();
		heroStand.show();
	}

	void hideHero() {
		heroStand.hide();
		heroLand.hide();
		heroJump.hide();
		heroHover.hide();
		heroPunch.hide(); // PUNCH
	}

	void positionHero(int x, int y) {
		heroStand.translateTo(x, y);
		heroJump.translateTo(x, y);
		heroLand.translateTo(x, y);
		heroHover.translateTo(x, y);
		heroPunch.translateTo(x, y); // PUNCH
	}

	void processStates() {
		switch (heroState) {

		case STAND:
			if (EZInteraction.wasKeyPressed('j')) {
				heroState = JUMP;
				jumpCounter = 0;
				hideHero();
				heroJump.show();
			}
			break;
		case JUMP:
			jumpCounter++;
			if (EZInteraction.wasKeyPressed('p')) {
				punchCounter = 0;
				hideHero();
				heroPunch.show();
				heroState = PUNCH;
			}	
			
			if (EZInteraction.wasKeyPressed('l')) { // added landing feature while jumping
				heroState = LAND;
				hideHero();
				heroLand.show();
				}
			
			if (jumpCounter > JUMPHEIGHT) {
				heroState = LAND;
				hideHero();
				heroLand.show();
				

			
			} else {
				posy -= 2;
				positionHero(posx, posy);
				if (EZInteraction.wasKeyPressed('h')) {
					heroState = HOVER;
					hideHero();
					heroHover.show();
				}
			}
			break;

		case PUNCH: // PUNCH
			punchCounter++;
			posx += 2;
			positionHero(posx, posy);
			
			if (EZInteraction.wasKeyPressed('l')) { // added landing feature while punching
				heroState = LAND;
				hideHero();
				heroLand.show();
				}
			
			if (punchCounter > PUNCHDISTANCE) { // when hero is done punching, make the hero state hover
				heroState = HOVER;
				hideHero();
				heroHover.show();
			}
			
			break;
		case LAND:
			jumpCounter--;
			if (jumpCounter <= 0) {
				heroState = STAND;
				hideHero();
				heroStand.show();
			} else {
				posy += 2;
				positionHero(posx, posy);
				if (EZInteraction.wasKeyPressed('h')) {
					heroState = HOVER;
					hideHero();
					heroHover.show();
				}
			}
			break;
		case HOVER:
			if (EZInteraction.wasKeyPressed('l')) {
				heroState = LAND;
				hideHero();
				heroLand.show();
			}
			break;
		}
	}

}
