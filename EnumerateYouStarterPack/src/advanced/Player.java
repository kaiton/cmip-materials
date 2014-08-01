package advanced;

class Player implements Fightable {
	
	Weapon weapon; 
	Skill skill;
	Armour armour;
	
	int lifeMeter = 50;
	int points;
	public String name; 
	
	Player(String name){
		this.name = name;
	}
	
	public void fight(Fightable enemy){
		try {
			int damage = this.weapon.getHitValue();
			System.out.println(this.name + " hits " + enemy + " for damage: " + damage);
			enemy.getHit(damage); // how much damage do we inflict?
		} catch (FightableIsDead e) {
			// do something when enemy is dead
		}
	}
	
	public int getLifeMeter(){
		return this.lifeMeter;
	}
	
	public void getHit(int damage) throws FightableIsDead {
		this.lifeMeter -= damage;
		if(this.lifeMeter <= 0){
			System.out.println("Player [" + this.name + "]  has died");
		}
	}
	void eatFood(Food food){		
	}
	
	void putOnArmour(Armour armour){
	}
	
	void getWeapon(Weapon weapon){
		this.weapon = weapon;
	}

	public String toString(){
		return this.name;
	}
}