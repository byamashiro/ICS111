import java.awt.Color;


public class project_1 {

	public static void main(String[] args) {
		// initial stats
		float water = 0.5f;
		float fertilizer = 0.5f;
		float plant_hp = 1.0f;
		float plant_size = 0.1f;
		

		
		//============== EZ setup
		
		EZ.initialize(700,500); // set up graphics
		  
		// Set the background color to dark green
		EZ.setBackgroundColor(new Color(135,206,235)); // R G B
		  
		// Add an image of the chicken and place it at position 200,200
		EZImage pic_manure = EZ.addImage("manure.png", 200, 430);
		
		EZText kalo_title = EZ.addText(100, 10, "Tarogotchi Kalo Simulator 2017 v1.0");
		
		
		
		//rules 
		EZ.addText(170, 120, "Instructions",Color.black, 20);
		// EZ.addLine(100, 140, 300, 140, Color.black);
		EZText task_1 = EZ.addText(220, 150, "1. Get the plant size to 100%                           ",Color.black, 14);
		EZText task_2 = EZ.addText(220, 170, "2. Do not let the plant HP drop below 0%                ",Color.black, 14);
		EZText task_3 = EZ.addText(220, 190, "3. Keep the water above 0% but under 100%               ",Color.black, 14);
		EZText task_4 = EZ.addText(220, 210, "4. Keep the fertilizer above 0% but under 100%          ",Color.black, 14);
		task_1.setColor(Color.green);
	
		
		/*
		// Add an image of the finger and place it at 0,0
		// EZImage pic_water_drop = EZ.addImage("water_drop_v6.png", 100, 100);
		int[] water_drop_x = {100, 110, 120, 125, 110, 100, 90, 85, 95, 100};
		int[] water_drop_y = {70, 80, 90, 100, 118, 120, 110, 100, 80, 70};
		EZPolygon water_drop_poly = EZ.addPolygon(water_drop_x, water_drop_y, Color.black, true);
		water_drop_poly.scaleBy(2.0);
		*/
		  
		/* // previously running code
		int[] taro_stem_x = {306, 308, 308, 306, 306};
		int[] taro_stem_y = {440, 440, 600, 600, 440};
		EZPolygon taro_stem = EZ.addPolygon(taro_stem_x, taro_stem_y, Color.green, true);
		*/
		
		
		
		// int[] taro_stem_x = {200, 220, 220, 200}; // {300, 320, 320, 300};
		// int[] taro_stem_y = {320, 320, 600, 600};
		// EZPolygon taro_stem = EZ.addPolygon(taro_stem_x, taro_stem_y, new Color(98,122, 50), true); // using line instead of polygon
		
		EZLine taro_stem = EZ.addLine(210, 320, 210, 320, new Color(98,122, 50));
		EZImage pic_taro = EZ.addImage("taro.png", 200, 430);
		pic_taro.scaleBy(0.75);
		
		
		

		// Add an image of the finger and place it at 0,0
		EZImage pic_water_can = EZ.addImage("water_can.png", 600, 200);
		pic_water_can.scaleTo(0.5);
		
		
		// Add an image of the finger and place it at 0,0
		

		
		EZSound you_lose = EZ.addSound("willy_wonka_you_lose.wav");
		EZSound digging = EZ.addSound("dig.wav");
		EZSound applause = EZ.addSound("applause.wav");
		EZSound water_bloop = EZ.addSound("water_splat.wav");
		

		
		int[] soil_x = {0, 700, 700, 0};
		int[] soil_y = {450, 450, 650, 650}; // center is located at 550
		
		EZPolygon soil = EZ.addPolygon(soil_x, soil_y, Color.gray, true);
		
		EZImage pic_wheelbarrow = EZ.addImage("wheelbarrow.png", 600, 400);

		
		
		float counter_size = 0f;
		float counter_height = 0f;
		
		// manure piles
		EZImage pic_manure_pile_1 = EZ.addImage("manure_pile.png", 100, 450);
		pic_manure_pile_1.scaleTo(0.1f);
		pic_manure_pile_1.pushToBack();
		pic_manure_pile_1.hide();
		
		EZImage pic_manure_pile_2 = EZ.addImage("manure_pile.png", 300, 450);
		pic_manure_pile_2.scaleTo(0.1f);
		pic_manure_pile_2.pushToBack();
		pic_manure_pile_2.hide();
		
		EZImage pic_manure_pile_3 = EZ.addImage("manure_pile.png", 400, 450);
		pic_manure_pile_3.scaleTo(0.1f);
		pic_manure_pile_2.pushToBack();
		pic_manure_pile_3.hide();
		
		

		int clickX = 0;
		int clickY = 0;
		
		// need to put size of ez somewhere here
		long lastSec = 0;
		

		// visual polygon bars
		
		// int[] water_bar_x = {690, 500, 500, 690, 690, 502, 502, 690, 690}; // top right, to top left, to bottom left, ...
		// int[] water_bar_y = {20, 20, 30, 30, 28, 28, 22, 22, 20}; // center is located at 550
		int[] water_bar_x = {450, 500, 500, 690, 690, 692, 692, 450, 450}; // top left, to top left, to bottom left, ...
		int[] water_bar_y = {16, 16, 28, 28, 16, 16, 30, 30, 16}; // center is located at 550
		EZPolygon water_bar = EZ.addPolygon(water_bar_x, water_bar_y, Color.black, true);
		EZLine water_line = EZ.addLine(500, 25, 500, 25, Color.blue, 4);
		EZLine water_line_2 = EZ.addLine(500, 25, 500, 25, Color.cyan, 4);

		
		// int[] fertilizer_bar_x = {690, 500, 500, 690, 690, 502, 502, 690, 690}; // top right, to top left, to bottom left, ...
		// int[] fertilizer_bar_y = {50, 50, 60, 60, 58, 58, 52, 52, 50}; // center is located at 550
		int[] fertilizer_bar_x = {450, 500, 500, 690, 690, 692, 692, 450, 450}; // top left, to top left, to bottom left, ...
		int[] fertilizer_bar_y = {46, 46, 58, 58, 46, 46, 60, 60, 46}; // center is located at 550
		EZPolygon fertilizer_bar = EZ.addPolygon(fertilizer_bar_x, fertilizer_bar_y, Color.black, true);
		EZLine fertilizer_line = EZ.addLine(500, 55, 500, 55, Color.green, 4);
		EZLine fertilizer_line_2 = EZ.addLine(500, 55, 500, 55, Color.red, 4);

		
		// int[] health_bar_x = {690, 500, 500, 690, 690, 502, 502, 690, 690}; // top right, to top left, to bottom left, ...
		// int[] health_bar_y = {80, 80, 90, 90, 88, 88, 82, 82, 80}; // center is located at 550
		int[] health_bar_x = {450, 500, 500, 690, 690, 692, 692, 450, 450}; // top left, to top left, to bottom left, ...
		int[] health_bar_y = {76, 76, 88, 88, 76, 76, 90, 90, 76}; // center is located at 550
		EZPolygon health_bar = EZ.addPolygon(health_bar_x, health_bar_y, Color.black, true);
		EZLine health_line = EZ.addLine(500, 85, 500, 85, Color.red, 4);
		EZLine health_line_2 = EZ.addLine(500, 85, 500, 85, Color.yellow, 4);
		EZLine health_line_3 = EZ.addLine(500, 85, 500, 85, Color.green, 4);
		
		int[] plant_bar_x = {450-430, 500-430, 500-430, 690-300, 690-300, 692-300, 692-300, 450-430, 450-430}; // top left, to top left, to bottom left, ...
		int[] plant_bar_y = {76-50, 76-50, 88-20, 88-20, 76-50, 76-50, 90-20, 90-20, 76-50}; // center is located at 550
		EZPolygon plant_bar = EZ.addPolygon(plant_bar_x, plant_bar_y, Color.black, true);
		EZLine plant_line = EZ.addLine(500-430, 88-20-12, 500-430, 88-20-12, new Color(0, 102, 0), 20); // 500 - 430
		
		
		EZText water_text = EZ.addText(475, 23, "WP:", Color.white, 12);
		EZText fertilizer_text = EZ.addText(475, 53, "FP:", Color.white, 12);
		EZText health_text = EZ.addText(475, 83, "HP:", Color.white, 12);
		EZText plant_text = EZ.addText(45, 88-40, "PS:", Color.white, 14);

		
		/*// failed attempts with EZPolygon and EZRectangle, a hope for line...

		EZRectangle water_fill = EZ.addRectangle(502, 25, 0, 4, Color.blue, true);
		*/
		
		
		// cursor
		EZImage pic_finger = EZ.addImage("hand.png", 0, 0);
		pic_finger.scaleTo(0.05f);
		
		// ========== text with percentages of status
		EZText water_level = EZ.addText(600, 40, "Water Level: " + (water/1)*100 + "%");
		if (water > 1.0f || water == 0f) {
			water_level.setColor(new Color(180,0,0));
		} else {
			water_level.setColor(Color.black);
		}
		
		EZText fertilizer_level = EZ.addText(600, 70, "Fertilizer Level: " + (fertilizer/1)*100 + "%");
		if (fertilizer > 1.0f) {
			fertilizer_level.setColor(new Color(180,0,0));
		} else {
			fertilizer_level.setColor(Color.black);
		}
		
		EZText hp_level = EZ.addText(600, 100, "Plant Health: " + (plant_hp/1)*100 + "%");
		if (plant_hp < 0.4f) {
			hp_level.setColor(new Color(180,0,0));
		} else {
			hp_level.setColor(Color.black);
		}
		
		EZText growth_level = EZ.addText((690-400), (90-20+10), "Plant Size: " + (plant_size/1)*100 + "%");
		if (plant_size > 0.8f) {
			growth_level.setColor(new Color(0,190,0));
		} else {
			growth_level.setColor(Color.black);
		}
		
		// ========================== START OF WHILE LOOP
		while(plant_size < 1 && plant_hp > 0f) { // while loop
			// update stats
			water_level.setMsg("Water Level: " + (water/1)*100 + "%");
			fertilizer_level.setMsg("Fertilizer Level: " + (fertilizer/1)*100 + "%");
			hp_level.setMsg("Plant Health: " + (plant_hp/1)*100 + "%");
			growth_level.setMsg("Plant Size: " + (plant_size/1)*100 + "%");
			
			

			// Initialize the indicator bars // 30, 60, 90

			
			long sec = System.currentTimeMillis() / 1000;
			
			// Get the mouseʻs X and Y position
			clickX = EZInteraction.getXMouse();
			clickY = EZInteraction.getYMouse();
			
			pic_finger.translateTo(clickX, clickY);
			
			if (EZInteraction.wasMouseLeftButtonReleased()) { // if loop for time
				
				if (pic_water_can.isPointInElement(clickX, clickY)) {		    	  
					water += 0.3f;
					water_bloop.play();
					// System.out.println("I am being triggered!");
				} else if (pic_wheelbarrow.isPointInElement(clickX, clickY)) {	
					digging.play();
					fertilizer += 0.3f;
				}
			}
			

			
			if (sec != lastSec) { // https://stackoverflow.com/questions/13121885/run-code-every-second-by-using-system-currenttimemillis
	
				System.out.println("Plant size: " + plant_size + "  " + "Plant HP: " +  plant_hp + "  " + "Water/Fertilizer: " +  water + "/" + fertilizer);


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
				
				
				// as program iterates, global conditions
			
				
				// decrease in materials
				water = (water - (plant_size * 0.05f)); // was using plant_size, but prompted with "growth"
				water = water - 0.001f;
				water = water - (fertilizer * 0.01f); // water decreases as a function of growth, and due to evaporation most decrease comes from here
				fertilizer = fertilizer - ((plant_hp * 0.001f) * 0.05f); // was using plant_size, but prompted with "growth rate"
				fertilizer = fertilizer - 0.001f;
				
				
				
				if (water < 0) {
					water = 0f;
					plant_hp = plant_hp - 0.02f;
				} else if (water > 1) { // plant is over watered
					plant_hp = plant_hp - 0.03f;
				}
				
				if (fertilizer < 0) {
					fertilizer = 0f;
					plant_hp = plant_hp - 0.01f;
				} else if (fertilizer > 1) { // plant is over fed
					plant_hp = plant_hp - 0.02f;
				}
				
				counter_height += 0.1f;
				counter_size += plant_size;
				
				plant_hp += 0.02f; // plant health gain 0.02f
				plant_size += plant_hp * 0.001f; //plant size gain original (plant_hp * 0.001f); quick win 0.7f
				
				if (fertilizer > 1.0f) {
					pic_manure_pile_1.show();
					// pic_manure_pile_1.pushToBack();
					
					if (fertilizer > 1.5f) {
						pic_manure_pile_2.show();
						// pic_manure_pile_2.pushToBack();
						
						if (fertilizer > 2.0f) {
							pic_manure_pile_3.show();
							// pic_manure_pile_3.pushToBack();
							
							if (fertilizer > 2.5f) {
								System.out.println("There is a lot of manure here.");
							}
							//pic_manure_pile_3.hide();
						}
						// pic_manure_pile_3.hide();
					}
					// pic_manure_pile_2.hide();
				} else if (fertilizer < 1.0f) {
					pic_manure_pile_1.hide();
					pic_manure_pile_2.hide();
					pic_manure_pile_3.hide();
				}
				
				lastSec = sec; // end of if statement of second
				
		    }
			
			// plant characteristics
			pic_taro.translateBy(0, -plant_size * 0.04f); // 0.5f originally
			taro_stem.translateBy(0, -plant_size * 0.02f); //taro_stem.translateBy(0, -plant_size * 0.04f);
			
			pic_taro.scaleTo(plant_size* 1.5f); // originally did not chant scaling
			// taro_stem.scaleTo(plant_size*1.5f);
			taro_stem.setThickness((int) (plant_size*1.5f)); // check if this works
			
			// manure pile
			pic_manure_pile_1.scaleTo(fertilizer * 0.25f);
			// pic_manure_pile_1.pushToBack();
			pic_manure_pile_1.translateTo(200, 400);
			
			

			if (plant_hp < 0.5f) {
				taro_stem.setColor(Color.red);
			} else if (plant_hp < 0.8f) {
				taro_stem.setColor(Color.yellow);
			}
			
			/* // come up with a more clever way, maybe using rectangles?
			int water_filler = (int) (water/1) * (680 - 502); // the difference between the bar filled maximum // if statement for maximum, change array to default // (int) ((water/1)*100) / (680 - 502);
			int[] water_fill_x = {502, 502, 502+ water_filler, 502+water_filler, 502}; // top left, bottom left, bottom right, ...
			int[] water_fill_y = {22, 28, 28, 22, 22};
			
			EZPolygon water_fill = EZ.addPolygon(water_fill_x, water_fill_y, Color.blue, true);
			*/ 
			
			/*// using a rectangle was clearly not a good option either, since the setWidth is limited to ints
			water_fill.translateTo(  502 + (  (water/1) * (680 - 502)    /     2     ), 25);
			water_fill.setWidth((int) (water/1) * (680 - 502)); // will disappear for anything under 1
			*/
			
			
			// ============ Visual bars
			// task_1) plant size 100
			// task_2) hp
			// task_3) water
			// task_4) fertilizer
			
			// water
			int water_int =  (int) ((water/1) * (690 - 500)); // System.out.println(water_int);
			if (water <= 1.0f) {
				task_3.setColor(Color.green);
				if (water >= 0f && water < 0.6f) {
					water_line.setColor(Color.green);
					
				} else if (water >= 0.9f && water < 1.0f) {
					water_line.setColor(Color.yellow);
				}
				
				water_line_2.setPoint2(500, 25); // this resets the water line 2 for the second case
				water_line.setPoint2(500 + (  water_int    ), 25);
			} else if (water > 1.0f && water <= 2.0f) {
				task_3.setColor(Color.red);
				water_line_2.setColor(Color.red);
				water_line.setPoint2(500 + (  690 - 500    ), 25);
				water_line_2.setPoint2(500 + (  water_int  - (690 - 500)  ), 25);
			} else if (water > 2.0f) {
				water_line_2.setColor(Color.red);
				water_line_2.setPoint2(500 + (  (690 - 500)  ), 25);
				
			}
			
			
			// fertilizer
			int fertilizer_int =  (int) ((fertilizer/1) * (690 - 500)); // System.out.println(water_int);
			if (fertilizer <= 1.0f) {
				task_4.setColor(Color.green);
				// experimental color changing code (remove if error)
				if (fertilizer >= 0f && fertilizer < 0.6f) {
					fertilizer_line.setColor(Color.green);
				} else if (fertilizer >= 0.6f && fertilizer < 1.0f) {
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
				
				
				/*
				else {
					fertilizer_line.setPoint2(500 + (  690 - 500    ), 55);
					fertilizer_line_2.setPoint2(500 + (690 - 500), 55); // fertilizer_line_2.setPoint2(500 + (  fertilizer_int - (690 - 500)   ), 55);
				}*/

				
				
			}
			
			
			// plant health
			int health_int =  (int) ((plant_hp/1) * (690 - 500)); // System.out.println(health_int);
			if (plant_hp <= 1.0f) {
				task_2.setColor(Color.red);
				health_line_2.setPoint2(500, 85);
				health_line.setPoint2(502 + (  health_int    ), 85);
			} else if (plant_hp > 1.0f && plant_hp <= 2.0f) {
				task_2.setColor(Color.green);
				health_line_3.setPoint2(500, 85);
				health_line.setPoint2(500 + (  690 - 500    ), 85);
				health_line_2.setPoint2(500 + (  health_int - (690 - 500)    ), 85);
			} else if (plant_hp > 2.0f) {
				task_2.setColor(Color.green);
				health_line.setPoint2(500 + (  690 - 500    ), 85);
				health_line_2.setPoint2(500 + (  690 - 500    ), 85);
				health_line_3.setPoint2(500 + (  health_int - (2* (690 - 500))    ), 85);
				
			}
			
			
			// int[] plant_bar_x = {450-430, 500-430, 500-430, 690-300, 690-300, 692-300, 692-300, 450-430, 450-430}; // top left, to top left, to bottom left, ...
			// int[] plant_bar_y = {76-50, 76-50, 88-20, 88-20, 76-50, 76-50, 90-20, 90-20, 76-50}; // center is located at 550
			// (plant_size/1)*100
			
			int plant_int =  (int) ((plant_size/1) * ((690-300) - (500-430))); // System.out.println(health_int);
			plant_line.setPoint2((500-430) + (  plant_int    ), 88-20-12);

			/*
			if (plant_hp <= 1.0f) {
				health_line_2.setPoint2(500, 85);
				health_line.setPoint2(502 + (  health_int    ), 85);
			} else if (plant_hp > 1.0f && plant_hp <= 2.0f) {
				health_line_3.setPoint2(500, 85);
				health_line.setPoint2(500 + (  690 - 500    ), 85);
				health_line_2.setPoint2(500 + (  health_int - (690 - 500)    ), 85);
			} else if (plant_hp > 2.0f) {
				health_line.setPoint2(500 + (  690 - 500    ), 85);
				health_line_2.setPoint2(500 + (  690 - 500    ), 85);
				health_line_3.setPoint2(500 + (  health_int - (2* (690 - 500))    ), 85);
				
			}
			*/
			
			
			// water_fill.hide();
			
			// update stats
			water_level.setMsg("Water Level: " + (water/1)*100 + "%");
			fertilizer_level.setMsg("Fertilizer Level: " + (fertilizer/1)*100 + "%");
			hp_level.setMsg("Plant Health: " + (plant_hp/1)*100 + "%");
			growth_level.setMsg("Plant Size: " + (plant_size/1)*100 + "%");
			
			EZ.refreshScreen(); // refreshes EZ screen
			
			
			/*// old refreshing text feature, remove when new functions are implemented
			water_level.hide();
			fertilizer_level.hide();
			hp_level.hide();
			growth_level.hide();
			*/

			// int[] water_bar_x = {690, 500, 500, 690, 690, 502, 502, 690, 690}; // top right, to top left, to bottom left, ...
			// int[] water_bar_y = {20, 20, 30, 30, 28, 28, 22, 22, 20}; // center is located at 550
			
			

			

		}
		
		
		// outside of the while loop after code
		if (plant_size >= 1.0f) {
			// EZImage winner = EZ.addImage("winner.png", 250, 700);
			// winner.scaleTo(4.0);
			// winner.translateTo(0, 100);
			
			applause.play();
			String[] color_array = {"blue","cyan","gray","green","magenta","orange","pink","red","yellow"};
			
			// for(String s: color_array) {
			for(int i = 0; i < color_array.length; i++) {
				//EZ.setBackgroundColor(new Color(0,0,100));
				String winning_color = color_array[i];
				System.out.println(winning_color);
				
				EZRectangle winning_background = EZ.addRectangle(350, 250, 700, 500, new Color(0,200,0), true);
				EZText winning_text = EZ.addText(350, 100, "YOU WIN!");
				
				
			}

			
			
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
			
			// System.out.println("You Win!");
		} else if (plant_hp < 0f) {
			EZImage wonka_gif = EZ.addImage("wonka.gif", 350, 250);
			wonka_gif.scaleTo(3.0);
			you_lose.play();
			// System.out.println("YOU LOSE!");
		}
		
		
		// TODO Auto-generated method stub

	}

}
