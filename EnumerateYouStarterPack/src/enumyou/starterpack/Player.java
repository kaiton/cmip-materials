package enumyou.starterpack;

import java.util.Random;


/* 
 * This class represents our player
 * TODO: Implement a points system that the player gains from fighting, etc
 */
class Player implements Fightable {
	
	
	// A Bagfull exception means that the player has no room for any items
	class BagFull extends ImpossibleAction {
		BagFull(){
			super();
		}
	}

	// A player can have a weapon
	Weapon weapon; 
	
	// a player has some skill
	Skill skill;
	
	// a player can be equipped with some armour
	Armour armour;
		
	// We can collect points along the way and we have a life meter
	private int points, lifeMeter;
	
	// our player has a lifeMeter, of a maximum size
	private final int MAX_LIFE_METER = 50;
		
	//  A player has a name
	public String name; 
	
	
	// Our player has a bag that can contain some things found along the way
	Encounterable[] bag;
	
	// but this bag can only hold 2 things
	final int MAX_BAG_ITEMS = 2;
	
	
	Player(String name){
		
		this.name = name;
		
		// create a new empty item bag with MAX_BAG_ITEMS slots
		this.bag = new Encounterable[MAX_BAG_ITEMS];
		
		// our player has a lifeMeter, by default set to 50
		this.lifeMeter = MAX_LIFE_METER;
		
		// TODO: allow the interface to choose a skill
		this.skill = Skill.getRandomItem();
	}
	
	// Add an item to our bag if possible. If all spaces are taken throw an exception
	void addItemToBag(Encounterable item) throws ImpossibleAction {
		for(int i = 0; i<MAX_BAG_ITEMS; i++){
			if(this.bag[i] == null) {
				this.bag[i] = item;
				return;
			}
		}
		throw new BagFull();
	}
	
	// get all the items in the player's bag
	Encounterable[] getBagContents(){
		return this.bag;
	}
	
	// remove item in position <at> from the player's Bag and use it
	void useItemFromBag(int at){
		Encounterable item = this.bag[at];
		this.bag[at] = null;
		if (item instanceof Food){
			eat( (Food) item );
		} else if (item instanceof Weapon){
			equip( (Weapon) item );
		} 
	}
	
	
	
	// is our Player still alive? Check life meter
	public boolean isAlive(){
		return (getLifeMeter() > 0);
	}
	
	// get current lifeMeter level
	public int getLifeMeter(){
		return this.lifeMeter;
	}
	
	// recharge life meter by amount
	//TODO: decide how to increase our player's LifeMeter by amount up to MAX_LIFE_METER
	private void increaseLifeMeter(int amount){
	}
	
	
	// take some energy from food
	void eat(Food food){
		increaseLifeMeter(food.energy);
	}
	
	// try to evade a monster. 
	// If successful, you'll be able to avoid fighting
	// if not, the monster will be able to hit you first
	// TODO: implement evasion for another skill, or change how the logic/chance works now 
	// TODO: use the kind of monster to influence how likely evasion will be (Ninjas should be unlikey, for e.g.)
	boolean evade(Monster monster){
		Random randomGenerator = new Random();
		switch(skill){
		case Speed: 
			return (randomGenerator.nextInt(10) >= 4);
		default: 
			return (randomGenerator.nextInt(10) >= 6);
		}
	}

	
	// TODO: putting on armour should allow us to take more damage. Implement this
	void putOnArmour(Armour armour){
	}
	
	// TODO: Decide what happens to our previous weapon. Does it get dropped in the cell? Put in bag?
	void equip(Weapon weapon){
		this.weapon = weapon;
	}

	// TODO: provide more information than just name for the String representation of a player
	public String toString(){
		return this.name;
	}

	/* TODO: decide how we calculate the damage level against an opponent. S
	 * Should it just be based on the weapon? Do weapons do the same damage every time?
	 */ 
	public int generateHit(Fightable enemy) {
		return this.weapon.getHitValue();
	}

	// take some damage. TODO: decide how Armour affects this. Or skills
	public void applyDamage(int damage) throws PlayerHasDied {
		this.lifeMeter -= damage;
		if(!isAlive()){
			throw new PlayerHasDied(this.name + " has died");
		}		
	}


}