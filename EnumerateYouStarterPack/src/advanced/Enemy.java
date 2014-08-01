package advanced;
enum Enemy implements Fightable {
	Dragon(100, 10), Turtle(60, 14), Ninja(30,34), Kitten(1,-10), Wolf(30, 13);
	
	private int points;
	private int lifeMeter;
	
	Enemy(int lifeMeter, int points){
		this.points = points;
		this.lifeMeter = lifeMeter;
	}
	
	int getPoints(){
		return this.points;
	}
	
	int getLifeMeter() {
		return this.lifeMeter;
	}
	
	public void fight(Fightable player){
		
	}
	
	public void getHit(int damage){
		// take a hit
	}
}
	