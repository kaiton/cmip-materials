package advanced;
enum Monster implements Fightable {
	Dragon(100, 10), Turtle(60, 14), Ninja(30,34), Kitten(1,-10), Wolf(30, 13);
	
	private int points;
	private int lifeMeter;
	
	Monster(int lifeMeter, int points){
		this.lifeMeter = lifeMeter;
		this.points = points;
	}
	
	int getPoints(){
		return this.points;
	}
	
	int getLifeMeter() {
		return this.lifeMeter;
	}
	
	public void fight(Fightable player){
		try {
			int damage = this.points;
			System.out.println(this + " hits " + player + " for damage: " + damage);
			player.getHit(damage); // how much damage do we inflict?
		} catch (FightableIsDead e) {
			// do something when enemy is dead
		}
	}
	
	public void getHit(int damage){
		this.lifeMeter -= damage;
		if(this.lifeMeter <= 0){
			// we're dead
		} else {
			// we're going to hit back
		}
	}
}
	