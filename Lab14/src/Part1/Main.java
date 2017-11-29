package Part1;

public class Main {

	public static void main(String[] args) {
		//Create an array of type Character called chars of size 4
		Character[] chars = new Character[4];
		
		//Initialize the elements (cells) of the array with the objects of Wizard, Troll, Warrior and Basilisk classes respectively
		//eg. chars[0] = new Wizard();
		chars[0] = new Wizard();
		chars[1] = new Troll();
		chars[2] = new Warrior();
		chars[3] = new Basilisk();
		
		
		//Use a for loop to call the walk(), talk(), attack() and die() functions for all the elements 
		for (int i = 0; i<4; i++) {
			chars[i].walk();
			chars[i].talk();
			chars[i].attack();
			chars[i].die();

		}

	}

}
