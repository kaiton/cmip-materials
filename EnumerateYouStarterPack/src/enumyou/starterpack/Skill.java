package enumyou.starterpack;

import java.util.Random;

/*
 * We decided that our player can have a skill
 * TODO: Decide how this works. Where do you pick up a skill? How does a Skill affect gameplay?
 * TODO: Change the skills that exist now
 */
enum Skill {
	Charisma, Magic, Strength, Speed;
	
	public static Skill getRandomItem(){
		Random randomGenerator = new Random();
		return values()[randomGenerator.nextInt(values().length)];
	}
	
}