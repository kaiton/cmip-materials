package enumyou.starterpack;

import java.util.Random;

/* 
 * The weapons that our player can encounter
 * TODO: Define your own weapons and make behavour more complex. 
 * TODO: Should hit values be the same constantly? Perhaps Bombs randomly fizzle.
 * TODO: Perhaps if you don't have a Speed Skill sometimes Bombs hurt you too
 */
enum Weapon implements Encounterable{
	RolledUpSock(2), PieceOfTwine(1), StaleLoafOfBread(10), FourxFour(30), Halberd(40), Bomb(100);
	
	private int hitValue;
	
	Weapon(int hitValue){ 
		this.hitValue = hitValue;
	}
	
	int getHitValue(){ 
		return this.hitValue;
	}
	
	public String display(){
		return this.getClass().getSimpleName().substring(0,1) + "/" + this.toString().substring(0,2);
	}
	
	public static Weapon getRandomItem(){
		Random randomGenerator = new Random();
		return values()[randomGenerator.nextInt(values().length)];
	}
	
	public boolean canBePickedUp() {
		return true;
	}
	
}