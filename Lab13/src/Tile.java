
public class Tile {

	public static final int DIRT = 0;
	public static final int GRASS = 1;
	public static final int LAVA = 2;

	EZImage dirt, grass, lava;
	int state = DIRT;

	Tile(int x, int y) {
		dirt = EZ.addImage("dirt.png", x, y);
		grass = EZ.addImage("grass.png", x, y);
		lava = EZ.addImage("lava.png", x, y);
		grass.hide();
		lava.hide();
	}

	public void changeState() {
		switch (state) {
		case DIRT:
			state = GRASS;
			dirt.hide();
			grass.show();
			break;
		case GRASS:
			state = LAVA;
			grass.hide();
			lava.show();
			break;
		case LAVA:
			state = DIRT;
			lava.hide();
			dirt.show();
			break;
		}
	}
	
	char getChar() {
		switch (state) {
		case DIRT:
			return 'R';
		case GRASS:
			return 'G';
		case LAVA:
			return 'L';
		}
		return '.';
	}
}
