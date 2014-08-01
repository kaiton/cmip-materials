package advanced;
enum Enemy {
	Dragon(10), Turtle(14), Ninja(34), Kitten(-10), Wolf(13);
	
	private int points;
	
	Enemy(int points){
		this.points = points;
	}
	
	int getPoints(){
		return this.points;
	}
}
	