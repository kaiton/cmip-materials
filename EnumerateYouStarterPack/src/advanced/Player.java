package advanced;

class Player implements Fightable {
	
	Weapon weapon; 
	Skill skill;
	Armour armour;
	
	int lifeMeter;
	int points;
	
	public void fight(Fightable enemy){
		enemy.getHit(0); // how much damage do we inflict?
	}
	
	
	public void getHit(int damage){
		this.lifeMeter -= damage;
		if(this.lifeMeter <= 0){
			// we're dead
		}
	}
	void eatFood(Food food){		
	}
	
	void putOnArmour(Armour armour){
	}
	
	void getWeapon(Weapon weapon){
	}

}