import java.awt.Color;


public class project_1_test {
	
	// initial stats
	static float water = 0.5f;
	static float fertilizer = 0.5f;
	static float plant_hp = 1.0f;
	static float plant_size = 0.1f;
	
	// rules
	static EZText task_1;
	static EZText task_2;
	static EZText task_3;
	static EZText task_4;
	
	// sounds
	static EZSound you_lose;
	static EZSound digging;
	static EZSound applause;
	static EZSound water_bloop;
	
	//first layer images
	// static EZImage pic_manure;
	static EZImage pic_taro;
	static EZImage pic_water_can;
	static EZImage pic_manure_pile_1;
	static EZImage pic_manure_pile_2;
	static EZImage pic_manure_pile_3;
	
	// second layer images
	static EZImage pic_wheelbarrow;
	
	// third layer images
	static EZImage pic_hand;

	
	//soil
	// static EZPolygon soil;
	static EZLine soil;

	
	// bars
	static EZPolygon water_bar;
	static EZLine water_line;
	static EZLine water_line_2;
	static EZPolygon fertilizer_bar;
	static EZLine fertilizer_line;
	static EZLine fertilizer_line_2;
	static EZPolygon health_bar;
	static EZLine health_line;
	static EZLine health_line_2;
	static EZLine health_line_3;
	static EZPolygon plant_bar;
	static EZLine plant_line;
	static EZText water_text;
	static EZText fertilizer_text;
	static EZText health_text;
	static EZText plant_text;
	
	//text percentages
	static EZText water_level;
	static EZText fertilizer_level;
	static EZText hp_level;
	static EZText growth_level;

	

	
	static float water_decrease(float water, float plant_size, float fertilizer) {
		water = (water - (plant_size * 0.05f)); // was using plant_size, but prompted with "growth"
		water = water - 0.001f;
		water = water - (fertilizer * 0.01f); // water decreases as a function of growth, and due to evaporation most decrease comes from here
		if (water < 0.0f) {
			water = 0.0f;
		}
		return water;
	}
	
	static float water_detriment(float water, float plant_hp) {
		if (water <= 0) {
			plant_hp = plant_hp - 0.02f;
		} else if (water > 1) { // plant is over watered
			plant_hp = plant_hp - 0.03f;
		}
		return plant_hp;
	}
	
	
	static float fertilizer_decrease(float fertilizer, float plant_hp) {
		// fertilizer = fertilizer - ((plant_hp * 0.001f) * 0.05f); // was using plant_size, but prompted with "growth rate"
		fertilizer = fertilizer - (plant_size * 0.05f);
		fertilizer = fertilizer - 0.001f;
		if (fertilizer < 0) {
			fertilizer = 0f;
		}
		return fertilizer;
	}
	
	static float fertilizer_detriment(float fertilizer, float plant_hp) {
		if (fertilizer <= 0) {
			plant_hp = plant_hp - 0.01f;
		} else if (fertilizer > 1) { // plant is over fed
			plant_hp = plant_hp - 0.02f;
		}
		return plant_hp;
	}
	
	// public static float fertilizer_decrease(float fertilizer, float plant_hp) {

	static void setupEZ() {
		EZ.initialize(700,500); // set up graphics
		EZ.setBackgroundColor(new Color(135,206,235)); // R G B
		EZ.addText(100, 10, "Tarogotchi Kalo Simulator 2017 v1.0");
		EZ.addText(170, 120, "Instructions",Color.black, 20);
	}
	
	static void imagesEZ_firstLayer() {
		// pic_manure = EZ.addImage("manure.png", 200, 430);

		pic_water_can = EZ.addImage("water_can.png", 600, 200);
		pic_water_can.scaleTo(0.5);
		
		pic_manure_pile_1 = EZ.addImage("manure_pile.png", 100, 450);
		pic_manure_pile_2 = EZ.addImage("manure_pile.png", 300, 450);
		pic_manure_pile_3 = EZ.addImage("manure_pile.png", 400, 450);
	}
	
	static void imagesEZ_secondLayer() {
		pic_wheelbarrow = EZ.addImage("wheelbarrow.png", 600, 350);
	}
	
	static void imagesEZ_thirdLayer() {
		pic_taro = EZ.addImage("taro.png", 200, 430);
		pic_taro.scaleBy(0.75);
		pic_taro.pullToFront();
	}
	
	static void imageEZ_thirdLayer() {
		pic_hand = EZ.addImage("hand.png", 0, 0); // bring to front
		pic_hand.scaleTo(0.05f);
	}
	
	static void gameRules() {
		task_1 = EZ.addText(220, 150, "1) Get the plant size to 100%                           ",Color.black, 14);
		task_1.setColor(Color.green);
		task_2 = EZ.addText(220, 170, "2) Do not let the plant HP drop below 0%                ",Color.black, 14);
		task_3 = EZ.addText(220, 190, "3) Keep the water above 0% but under 100%               ",Color.black, 14);
		task_4 = EZ.addText(220, 210, "4) Keep the fertilizer above 0% but under 100%          ",Color.black, 14);
	}
	
	static void soundsEZ() {
		you_lose = EZ.addSound("willy_wonka_you_lose.wav");
		digging = EZ.addSound("dig.wav");
		applause = EZ.addSound("applause.wav");
		water_bloop = EZ.addSound("water_splat.wav");
	}

	static void manureSetup() {
		pic_manure_pile_1.scaleTo(0.1f);
		pic_manure_pile_1.pushToBack();
		pic_manure_pile_1.hide();
		
		pic_manure_pile_2.scaleTo(0.1f);
		pic_manure_pile_2.pushToBack();
		pic_manure_pile_2.hide();
		
		pic_manure_pile_3.scaleTo(0.1f);
		pic_manure_pile_2.pushToBack();
		pic_manure_pile_3.hide();
	}
	
	static void soil() {
		/*// polygon is not great for translating realtime data
		int[] soil_x = {0, 700, 700, 0};
		int[] soil_y = {450, 450, 650, 650}; // center is located at 550
		soil = EZ.addPolygon(soil_x, soil_y, Color.gray, true);
		*/
		soil = EZ.addLine(350, 650, 350, 450, Color.gray, 700);
		
	}
	
	static void plantHP() {
		plant_hp = water_detriment(water, plant_hp);
		plant_hp = fertilizer_detriment(fertilizer, plant_hp);
		plant_hp += 0.02f; // plant health gain 0.02f
	}
	
	static void visualBars() { // initialize
		int[] water_bar_x = {450, 500, 500, 690, 690, 692, 692, 450, 450}; // top left, to top left, to bottom left, ...
		int[] water_bar_y = {16, 16, 28, 28, 16, 16, 30, 30, 16}; // center is located at 550
		water_bar = EZ.addPolygon(water_bar_x, water_bar_y, Color.black, true);
		water_line = EZ.addLine(500, 25, 500, 25, Color.green, 4);
		water_line_2 = EZ.addLine(500, 25, 500, 25, Color.yellow, 4);

		

		int[] fertilizer_bar_x = {450, 500, 500, 690, 690, 692, 692, 450, 450}; // top left, to top left, to bottom left, ...
		int[] fertilizer_bar_y = {46, 46, 58, 58, 46, 46, 60, 60, 46}; // center is located at 550
		fertilizer_bar = EZ.addPolygon(fertilizer_bar_x, fertilizer_bar_y, Color.black, true);
		fertilizer_line = EZ.addLine(500, 55, 500, 55, Color.green, 4);
		fertilizer_line_2 = EZ.addLine(500, 55, 500, 55, Color.red, 4);


		int[] health_bar_x = {450, 500, 500, 690, 690, 692, 692, 450, 450}; // top left, to top left, to bottom left, ...
		int[] health_bar_y = {76, 76, 88, 88, 76, 76, 90, 90, 76}; // center is located at 550
		health_bar = EZ.addPolygon(health_bar_x, health_bar_y, Color.black, true);
		health_line = EZ.addLine(500, 85, 500, 85, Color.red, 4);
		health_line_2 = EZ.addLine(500, 85, 500, 85, Color.yellow, 4);
		health_line_3 = EZ.addLine(500, 85, 500, 85, Color.green, 4);
		
		int[] plant_bar_x = {450-430, 500-430, 500-430, 690-300, 690-300, 692-300, 692-300, 450-430, 450-430}; // top left, to top left, to bottom left, ...
		int[] plant_bar_y = {76-50, 76-50, 88-20, 88-20, 76-50, 76-50, 90-20, 90-20, 76-50}; // center is located at 550
		plant_bar = EZ.addPolygon(plant_bar_x, plant_bar_y, Color.black, true);
		plant_line = EZ.addLine(500-430, 88-20-12, 500-430, 88-20-12, new Color(0, 102, 0), 20); // 500 - 430
		
		
		water_text = EZ.addText(475, 23, "WP:", Color.white, 12);
		fertilizer_text = EZ.addText(475, 53, "FP:", Color.white, 12);
		health_text = EZ.addText(475, 83, "HP:", Color.white, 12);
		plant_text = EZ.addText(45, 88-40, "PS:", Color.white, 14);
	}
	
	static void textPercentages() { // initialize the percentages used for stats
		water_level = EZ.addText(600, 40, "Water Level: " + (water/1)*100 + "%");
		if (water > 1.0f || water == 0f) {
			water_level.setColor(new Color(180,0,0));
		} else {
			water_level.setColor(Color.black);
		}
		
		fertilizer_level = EZ.addText(600, 70, "Fertilizer Level: " + (fertilizer/1)*100 + "%");
		if (fertilizer > 1.0f) {
			fertilizer_level.setColor(new Color(180,0,0));
		} else {
			fertilizer_level.setColor(Color.black);
		}
		
		hp_level = EZ.addText(600, 100, "Plant Health: " + (plant_hp/1)*100 + "%");
		if (plant_hp < 0.4f) {
			hp_level.setColor(new Color(180,0,0));
		} else {
			hp_level.setColor(Color.black);
		}
		
		growth_level = EZ.addText((690-400), (90-20+10), "Plant Size: " + (plant_size/1)*100 + "%");
		if (plant_size > 0.8f) {
			growth_level.setColor(new Color(0,190,0));
		} else {
			growth_level.setColor(Color.black);
		}
	}
	
	static void updatePercentages() { // show the stats of water, fertilizer, health, and growth as percentages
		water_level.setMsg("Water Level: " + (water/1)*100 + "%");
		fertilizer_level.setMsg("Fertilizer Level: " + (fertilizer/1)*100 + "%");
		hp_level.setMsg("Plant Health: " + (plant_hp/1)*100 + "%");
		growth_level.setMsg("Plant Size: " + (plant_size/1)*100 + "%");
	}
	
	static void soilChanges(float water) { // as a value of water, change the color of the soil and size if there is too much
		soil.translateTo(350, 550);
		if (water == 0f) {
			soil.setColor(new Color(139,69,19));
		} else if (water > 0f && water < 0.2f) { // yellow 255,255,0 -> brown 139,69,19
			soil.setColor(new Color(255,255,0));
		} else if (water > 0.2f && water < 0.4f) { // yellow 255,255,0 -> brown 139,69,19
			soil.setColor(new Color(173,255,47)); 
		} else if (water > 0.4f && water < 0.6f) { // yellow 255,255,0 -> brown 139,69,19
			soil.setColor(new Color(154,205,50)); 
		} else if (water > 0.6f && water < 0.8f) { // yellow 255,255,0 -> brown 139,69,19
			soil.setColor(new Color(50,205,50)); 
		} else if (water > 0.8f && water < 1.0f) { // yellow 255,255,0 -> brown 139,69,19
			soil.setColor(new Color(0,128,0));
		} else if (water > 1.0f && water < 1.2f) {
			soil.setColor(new Color(0,0,255)); 
			soil.translateTo(350, 530);
		} else if (water > 1.2f) {
			soil.setColor(new Color(0,0,135)); 
			soil.translateTo(350, 500);
		}
	}
	
	static void manureChanges() { // show more piles of manure as the fertilizer increases
		if (fertilizer > 0.0f && fertilizer <= 1.0f) {
			pic_manure_pile_1.show();
			pic_manure_pile_2.hide();
			pic_manure_pile_3.hide();
			if (fertilizer > 1.0f && fertilizer <= 2.0f) {
				pic_manure_pile_2.show();
				if (fertilizer > 2.0f  && fertilizer <= 3.0f) {
					pic_manure_pile_3.show();
				}
			}
		} else if (fertilizer <= 0.0f) { // if fertilizer drops below the danger level, remove manure piles
			pic_manure_pile_1.hide();

		}
	}
	
	static float plantSize() {
		plant_size += plant_hp * 0.001f; // 0.001f; //plant size gain original (plant_hp * 0.001f); quick win 0.7f
		return plant_size;
	}
	
	static void visualStatusBars() { // create dynamic visual stats bars
		int water_int =  (int) ((water/1) * (690 - 500)); // initialize the stats bar and limit the bar to a given length with division
		if (water <= 1.0f) { // if water drops below 1.0f 
			task_3.setColor(Color.green); // set the color of the rule to green when in the safe parameters
			if (water >= 0f && water < 0.9f) { // safe parameters for water
				water_line.setColor(Color.green);
				
			} else if (water >= 0.9f && water < 1.0f) { // warning parameters for water
				water_line.setColor(Color.yellow);
			}
			water_line_2.setPoint2(500, 25); // this resets the water line 2 for the second case
			water_line.setPoint2(500 + (  water_int    ), 25);
		} else if (water > 1.0f && water <= 2.0f) { // water parameter in the danger zone
			task_3.setColor(Color.red);
			water_line_2.setColor(Color.red);
			water_line.setPoint2(500 + (  690 - 500    ), 25);
			water_line_2.setPoint2(500 + (  water_int  - (690 - 500)  ), 25);
		} else if (water > 2.0f) { // water is far in the danger zone and set the line to a set position
			water_line_2.setColor(Color.red);
			water_line_2.setPoint2(500 + (  (690 - 500)  ), 25);
		}
		
		// fertilizer
		int fertilizer_int =  (int) ((fertilizer/1) * (690 - 500));
		if (fertilizer <= 1.0f) {
			task_4.setColor(Color.green);
			if (fertilizer >= 0f && fertilizer < 0.9f) {
				fertilizer_line.setColor(Color.green);
			} else if (fertilizer >= 0.9f && fertilizer < 1.0f) {
				fertilizer_line.setColor(Color.yellow);
			}
			fertilizer_line_2.setPoint2(500, 55);
			fertilizer_line.setPoint2(500 + (  fertilizer_int    ), 55);
		} else if (fertilizer > 1.0f) {
			task_4.setColor(Color.red);
			if (fertilizer > 1.0f && fertilizer < 2.0f) {
				fertilizer_line.setPoint2(500 + (  690 - 500    ), 55);
				fertilizer_line_2.setPoint2(500 + (  fertilizer_int - (690 - 500)   ), 55);
			} else if (fertilizer > 2.0f) {
				fertilizer_line_2.setPoint2(500 + (  (690 - 500)  ), 55);	
			}
		}
		
		
		int health_int =  (int) ((plant_hp/1) * (690 - 500));
		if (plant_hp <= 1.0f) {
			task_2.setColor(Color.red);
			health_line_2.setPoint2(500, 85);
			health_line.setPoint2(502 + (  health_int    ), 85);
		} else if (plant_hp > 1.0f && plant_hp <= 2.0f) {
			task_2.setColor(Color.green);
			health_line_3.setPoint2(500, 85);
			health_line.setPoint2(500 + (  690 - 500    ), 85);
			health_line_2.setPoint2(500 + (  health_int - (690 - 500)    ), 85);
		} else if (plant_hp > 2.0f && plant_hp <= 3.0f) {
			task_2.setColor(Color.green);
			health_line.setPoint2(500 + (  690 - 500    ), 85);
			health_line_2.setPoint2(500 + (  690 - 500    ), 85);
			health_line_3.setPoint2(500 + (  health_int - (2* (690 - 500))    ), 85);
		} else if (plant_hp > 3.0f) {
			health_line_3.setColor(Color.green);
			health_line_3.setPoint2(500 + (  690 - 500  ), 85);
		}
	}


	public static void main(String[] args) {
		
		setupEZ(); // setup EZ environment
		imagesEZ_firstLayer(); // load first layer images and modify them for use
		soundsEZ(); // load sounds
		gameRules(); //rules 
		
		EZLine taro_stem = EZ.addLine(210, 550, 210, 430, new Color(98,122, 50), 10);
		
		imagesEZ_secondLayer();
		imagesEZ_thirdLayer();
		soil();
		manureSetup();

		/*// ask about this, can you have an "f-string" for the variable name
		static void manureSetup(int j) {
			pic_manure_pile_j.scaleTo(0.1f);
			
		}
		 */
		int clickX = 0;
		int clickY = 0;
		
		long lastSec = 0;

		visualBars(); // frames for visual polygon bars
		imageEZ_thirdLayer(); // cursor
		textPercentages(); // initialize realtime stats
		
		int x_timer = 0;
		int x_counter = 0;
		
		
		// ========================== START OF WHILE LOOP
		while(plant_size < 1 && plant_hp > 0f) { // while loop
			updatePercentages(); // update stats within loop
			
			long sec = System.currentTimeMillis() / 100; // originally 1000 // define a second using current time in milliseconds and converting to seconds
			
			clickX = EZInteraction.getXMouse(); // Get the mouseʻs X and Y position
			clickY = EZInteraction.getYMouse();
			
			pic_hand.translateTo(clickX, clickY);
			
			if (EZInteraction.wasMouseLeftButtonReleased()) {
				if (pic_water_can.isPointInElement(clickX, clickY)) { // detect when the mouse is clicked in the water can image   	  
					water += 0.3f; // add 0.3f to the static value of water every click of water
					water_bloop.play(); // play the sound when clicked
				} else if (pic_wheelbarrow.isPointInElement(clickX, clickY)) {  
					digging.play();
					fertilizer += 0.3f;
				}
			}
			
			if (sec != lastSec) { // https://stackoverflow.com/questions/13121885/run-code-every-second-by-using-system-currenttimemillis
				// System.out.println("Plant size: " + plant_size + "  " + "Plant HP: " +  plant_hp + "  " + "Water/Fertilizer: " +  water + "/" + fertilizer);
				soilChanges(water); // change soil color according to water level, and add more when over watered
				
				water = water_decrease(water, plant_size, fertilizer); // decrease in water every second per given parameters
				fertilizer = fertilizer_decrease(fertilizer, plant_hp);

				plantHP(); // update plant health per second // should this be a float function? (delete)
				plantSize(); // update plant growth per second // should this not return a float?

				
				manureChanges(); // initialize manure image as the manure increases or decreases
				
				
				if (x_timer > 10) {
					x_counter++;
					x_timer = 0;
				}
				
				x_timer++;
				lastSec = sec; // end of if statement of second to determine a cycle of a full second
		    }
			
			//=============== outside time [second] loop
			pic_taro.translateTo(203-x_counter, 430+(-plant_size*200f)); // move taro to be near stem at all points of growth
			pic_taro.scaleTo(plant_size * 1.5f); // increase size of taro per function of growth
			
			taro_stem.setThickness((int) ((plant_size*30))); // change the thickness of the taro stem
			taro_stem.setPoint2(210, (int) (430 - ((430-180)*(plant_size)))); // change length of taro stem as a function of plant size
			
			
			pic_manure_pile_1.scaleTo(fertilizer * 0.25f); // scale the size of the manure pile with the size of fertilizer
			pic_manure_pile_1.translateTo(200, 440); // relocate pile of manure on creation
			
			
			if (plant_hp < 0.5f) { // change taro stem color according to plant health
				taro_stem.setColor(Color.red);
			} else if (plant_hp < 0.8f) {
				taro_stem.setColor(Color.yellow);
			}
			
			
			visualStatusBars(); // change the status bars according to health, growth, water, and fertilizer
			
			int plant_int =  (int) ((plant_size/1) * ((690-300) - (500-430))); // make a dynamic stats bar for change in growth
			plant_line.setPoint2((500-430) + ( plant_int ), 88-20-12);
			
			// update stats
			updatePercentages(); //update realtime percentages after applying increases and decreases to static variables

			
			EZ.refreshScreen(); // refreshes EZ screen
		}
		
		if (plant_size >= 1.0f) { // winning parameters
			// EZImage winner = EZ.addImage("winner.png", 250, 700);
			// winner.scaleTo(4.0);
			// winner.translateTo(0, 100);

			EZ.addImage("star.png", 350, 250);
			EZ.addText(350, 150, "YOU WIN!!", Color.red, 60);
			applause.play();			
			



		} else if (plant_hp < 0f) {
			EZImage wonka_gif = EZ.addImage("wonka.gif", 350, 250);
			wonka_gif.scaleTo(3.0);
			EZ.addText(350, 150, "YOU LOSE!!", Color.red, 60);
			you_lose.play();
			
		}
	}
}


/*
// ================= Useful code
// Use an array to return multiple values, but not needed for this project, but important to keep
public static float[] initial_stats() {
	float water = 0.5f;
	float fertilizer = 0.5f;
	float plant_hp = 1.0f;
	float plant_size = 0.1f;
	return new float[] {water, fertilizer, plant_hp, plant_size};
}
// initial stats in main function
float initial_stats[] = initial_stats();
float water = initial_stats[0];
float fertilizer = initial_stats[1];
float plant_hp = initial_stats[2];
float plant_size = initial_stats[3];



*/



/*
while(true) {
	// System.out.println("YOU WIN!");
	
	
	// for(int i = 0; i < color_array.length; i++) {
	for (String i: color_array) {
		System.out.println(i);
		// EZ.setBackgroundColor(Color.i); // broken here for i
	}
	
}
*/


/*
String[] color_array = {"blue","cyan","gray","green","magenta","orange","pink","red","yellow"};

// for(String s: color_array) {
for(int i = 0; i < color_array.length; i++) {
	//EZ.setBackgroundColor(new Color(0,0,100));
	String winning_color = color_array[i];
	System.out.println(winning_color);
	
	EZRectangle winning_background = EZ.addRectangle(350, 250, 700, 500, new Color(0,200,0), true);
	EZText winning_text = EZ.addText(350, 100, "YOU WIN!");
}
*/



