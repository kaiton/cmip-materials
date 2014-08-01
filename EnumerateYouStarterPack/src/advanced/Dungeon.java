package advanced;
import java.util.Random;

class Dungeon {
	
	static int rounds = 1;
	
	public static void main(String[] args){
		Random randomGenerator = new Random();
		String playerName = "Bruce the Brave";
		Player player = new Player(playerName);
		
		Monster[] monsters  = Monster.values();
		Food[] foods  = Food.values();
		Weapon[] weapons = Weapon.values();
		
		for(int i = 1; i <= rounds; i++){
			Monster monster = monsters[randomGenerator.nextInt(monsters.length)];
			Weapon weapon = weapons[randomGenerator.nextInt(weapons.length)];
			
			System.out.println("Round [" + i + "]");
			System.out.println("******************");
			
			System.out.println("Player [" + player.name + "] fights Monster [" + monster + "]");
			System.out.println("Player [" + player.name + "] uses  Weapon [" + weapon + "]");
			
			player.getWeapon(weapon);
			int attacks = 0;
			while(monster.getLifeMeter() >= 0 || player.getLifeMeter() >= 0) {
				attacks++;
				System.out.println(player + " attack #" + attacks + "! ");
				System.out.println(player + " life meter =  " + player.getLifeMeter());
				System.out.println(monster + " life meter =  " + monster.getLifeMeter());
	
				player.fight(monster);
				monster.fight(player);
			}
			
		}
	}
}