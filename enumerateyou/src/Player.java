public class Player {
	
	String name;
	double skill;
	int lifeMeter = 50;
	
	Player(String name){
		this.name = name;
		this.skill = Math.round(Math.random() * 10);
	}
	
	int getLifeMeter(){
		return this.lifeMeter;
	}
	void fight(Enemy enemy){
		switch(enemy) {
			case Ninja:
				if(this.skill * Math.random() > 0.5){
					this.lifeMeter += enemy.getPoints();
					System.out.println("Defeated a ninja and took <" + enemy.getPoints() + "> points");
				} else {
					this.lifeMeter = 0;
					System.out.println("Lost to ninja and lost all points");
				}
				break;
			default:
				this.lifeMeter += enemy.getPoints();
				System.out.println("Defeated enemy and took <" + enemy.getPoints() + "> points");
		}
	}
}