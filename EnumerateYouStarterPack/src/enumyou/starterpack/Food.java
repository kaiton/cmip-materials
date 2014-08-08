package enumyou.starterpack;

import java.util.Random;

/* 
 * Food is something you can encounter in the dungeon
 * TODO: add more foods, possibly even some that are toxic 
 */
enum Food implements Encounterable {
	
	Lettuce(5), Patty(10), WaterCrackers(20);
	
	int energy;
	
	Food(int energy){
		this.energy = energy;
	}
	
	// all Foods have some energy value
	int getValue(){
		return this.energy;
	}
	
	// this returns a short description of item:
	// Lettuce => "F/Le", Patty => "F/Pa"
	// TODO: Setup a better display
	public String display(){
		return this.getClass().getSimpleName().substring(0,1) + "/" + this.toString().substring(0,2);
	}
	
	// get a random food from our collection of constants
	public static Food getRandomItem(){
		Random randomGenerator = new Random();
		return values()[randomGenerator.nextInt(values().length)];
	}
	
	// foods can be picked up and carried
	public boolean canBePickedUp() {
		return true;
	}
}