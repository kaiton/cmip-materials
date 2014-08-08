package enumyou.starterpack;

/* 
 * This is the interface that all Fightable objects must implement in order to battle
 * This applies to Players and Monsters at present
 */
interface Fightable {	
	// is Fightable still alive?
	boolean isAlive();
	
	// get current life meter level
	int getLifeMeter();
	
	// based on its own features and that of the enemy, 
	// a fightable object should be able to generate a hit of int damage level 
	int generateHit(Fightable enemy);
	
	
	// apply generated damage to self. How much this will effect your lifemeter 
	// will depend on armour, skills, and whatever other factors you can think up
	void applyDamage(int damage) throws PlayerHasDied, MonsterHasDied;
}