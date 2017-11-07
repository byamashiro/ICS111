
public class Part3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EZ.initialize(512, 512);
		EZ.addImage("city.png", 256, 256);
		HeroPlus myHeroPlus = new HeroPlus(256,400);
		
		while(true){
			myHeroPlus.processStates();
			
			EZ.refreshScreen();
		}
	}

}
