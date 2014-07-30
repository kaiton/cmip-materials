class SimpleGame {
	
	static int rounds = 10;
	public static void main(String[] args){
		java.util.Random generator = new java.util.Random();
		Player player = new Player("Mario"); 
		Enemy[] enemies = Enemy.values();
		for(int i = 1; i <= rounds; i++){
			System.out.println("Round " + i + "!");
			System.out.println("Player lifemeter = " + player.getLifeMeter());
			int enemyIndex = generator.nextInt(enemies.length);
			System.out.println(enemyIndex);
			Enemy enemy = enemies[enemyIndex];
			System.out.println("Player " + player.name + " fights a " + enemy.name());
			player.fight(enemy);
		}
	}
}