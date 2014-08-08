package enumyou.starterpack;

import java.util.Random;

// a monster is both encounterable and fightable
enum Monster implements Fightable, Encounterable {
	Dragon(100, 10), 
	Turtle(60, 14), 
	Ninja(30,34), 
	Kitten(1,1), 
	Wolf(30, 13);
	
	// monsters have a lifeMeter & are worth a certain # of points
	private int points, lifeMeter;
	
	Monster(int lifeMeter, int points){
		this.lifeMeter = lifeMeter;
		this.points = points;
	}
	
	
	// get the points for this monster
	int getPoints(){
		return this.points;
	}
	
	// provide a shortcode description for this Monster
	// Dragon => M/Dr, Kitten => M/Ki
	public String display(){
		return this.getClass().getSimpleName().substring(0,1) + "/" + this.toString().substring(0,2);
	}
	
	// is the monster still alive?
	public boolean isAlive(){
		return (getLifeMeter() > 0);
	}
	
	// get the current level of the monster's life meter
	public int getLifeMeter() {
		return this.lifeMeter;
	}
	
	
	public static Monster getRandomItem(){
		Random randomGenerator = new Random();
		return values()[randomGenerator.nextInt(values().length)];
	}
	
	// monster's can't be picked up, for now
	public boolean canBePickedUp() {
		return false;
	}


	/* TODO: define some logic that dictates how many damage points can a Monster hit for
	 * 		 this could be based on player attributes, cell location, etc.
	 */
	public int generateHit(Fightable player) {
		return this.points;
	}

	/*
	 * TODO: Decide if Monsters can have armour or other defences against damage
	 */
	public void applyDamage(int damage) throws MonsterHasDied {
		this.lifeMeter -= damage;
		if(!isAlive()){
			throw new MonsterHasDied(this + "has died");
		}
	}

	
}
	