package enumyou.starterpack;
import java.util.Random;
import java.util.Scanner;

/* 
 * This is the main class that will control our game play
 */
class EnumerateYou {
	
	// how many rooms or cells must our player go through before exiting the dungeon?
	static int numCells = 10;
		
	// a convenience method for showing our game's start up header screen.
	// feel free to change this to whatever suits you. This is an example of 
	// what's possible.
	static void printHeader(){
		 printSlow(Banners.title(),1);
	}
	

	// method for presenting a prompt on the command line and getting a response in turn
	public static String presentPromptAndGetResponse(String prompt) {
	   System.out.println(prompt);
       Scanner scanIn = new Scanner(System.in);
	   String response = scanIn.nextLine();         
	   return response;   
	}
	
	// prompt user for player name [ and more later ] 
	public static String getPlayerName(){
	   return presentPromptAndGetResponse("Choose a name, player:");
	}
	
	// present an action prompt and get the response. Response must be one of the 
	// options declared in Action enum
	public static Action getAction() throws ImpossibleAction {    
		String response = "";
		try {
			response = presentPromptAndGetResponse("Choose an action:");
			return Action.valueOf(response);
		} catch (IllegalArgumentException e) {
			throw new ImpossibleAction("Unspported action: " + response);
		}
	}
		
	
	// don't print slow. Here for convenience.
	static void printSlow(String text){
		printSlow(text, 0);
	}
	
	// prints out text to the screen a single character at a time, determined by <speed>
	// packed with more brooding and suspense than a simple call to System.out.println.
	// experiment with different sleep times (in milliseconds) for effect.
	static void printSlow(String text, int speed){
		char[] chars = text.toCharArray();
		for(char c : chars){
			System.out.print(c);
			try {
			    Thread.sleep(speed);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}
		System.out.println();
	}
		

	// describe the contents of a cell or room that the user has entered
	static void describeCell(Cell cell){
		if( cell.isOccupied){
			if(cell.getContents() instanceof Monster){
				printSlow("^^^^^^^ A monster emerges...... ^^^^^^",15);
				printSlow("It is a " + cell.getContents().toString(),7);
			} else {
				printSlow("You have found a " + cell.getContents(),7);
			}
		}
	}
	
	static void stageFight(Fightable first, Fightable second) throws PlayerHasDied, MonsterHasDied {
		while(first.isAlive() && second.isAlive()){
			int damage = first.generateHit(second);
			System.out.println(first + " attacks " + second + " for " + damage + " points");
			second.applyDamage(damage);
			
			damage = second.generateHit(first);
			System.out.println(second + " strikes back for " + damage + " points");
			first.applyDamage(damage);
		}
	}
	
	// TODO: implement putting on armour
	static void takePlayerAction(Player player, Action action, Cell cell) 
		throws ImpossibleAction, PlayerHasDied, MonsterHasDied {
		switch(action){
		case Eat:
			if (cell.getContents() instanceof Food) {
				Food food =  (Food) cell.takeContents();
				player.eat( food );
				System.out.println("You eat " + food + " of energy = " + food.getValue());
				System.out.println("Player lifemeter = " + player.getLifeMeter());
				return;
			} else {
				break;
			}
		case Fight:
			if (cell.getContents() instanceof Monster) {
				Monster monster = (Monster) cell.getContents();
				System.out.println("Armed with " + player.weapon + " you go to fight " + monster);
				stageFight(player, monster);
				return;
			} else {
				break;
			}
		case Run:
			if (cell.getContents() instanceof Monster) {
				Monster monster = (Monster) cell.getContents();
				boolean evaded = player.evade( monster );
				if(evaded){
					System.out.println("You have successfully evaded the " + monster);
					return;
				} else {
					System.out.println("You have failed to evade the " + monster);
					System.out.println("It will attack first");
					stageFight(monster, player);
					return;
				}
			} else {
				return;
			}
     	/* 
		* case Take:
		*
		*	try {
		*		item = cell.takeContents();
		*		player.addItemToBag(item);
		*		return;
		*	} catch (Player.BagFull bfe) {
		*		System.out.println(bfe);
		*		cell.setContents(item);
		*	}
		*/
		case Use:
			if (cell.getContents() instanceof Weapon) {
				Weapon weapon = (Weapon) cell.takeContents();
				System.out.println("Dropping your " + player.weapon + ", you arm yourself with " + weapon);
				player.equip( weapon );
				return;
			} else {
				break;
			}
		case Quit:
			exitGame();
		}
		throw new ImpossibleAction("Cannot perform <" + action +"> against <"+ cell.getContents() +">");
	}
	
	public static void exitGame(){
		printSlow("See ya.", 2);
		System.exit(0);
	}
	
	public static void main(String[] args){
		
		printHeader(); // print our game's welcome header
		
		
		// A stack dungeon is a simple dungeon implementation based 
		// on a series of rooms connected in series
		StackDungeon dungeon = new StackDungeon(numCells);
		
		printSlow("Welcome to the Stack Dungeon!!");
		printSlow(numCells + " cells await you.");
		
		// Here's how you'd get the player's name interactively. 
		// You could also get this via ``args''
		// TODO: allow the  player to choose a weapon initially and a skill
		Player player = new Player(getPlayerName());
		
		printSlow(player.name + ", you have been equipped with a " + Weapon.StaleLoafOfBread);
		player.equip(Weapon.StaleLoafOfBread);

		printSlow("Good luck " + player.name + ". The game begins now");
		printSlow("--------------------------------------------------");
	
		for(int i = 0; i < numCells; i++){
			boolean takeNextStep = false;
			Cell cell = dungeon.cellAt(i);
			printSlow("You are in Room #" + i + ". " + cell.location.description);
			describeCell(cell);
			
			while(!takeNextStep){
				try {
					Action action = getAction();
					takePlayerAction(player, action, cell);
					takeNextStep = true;
				} catch (ImpossibleAction ia) {
					System.out.println(ia);
				} catch (MonsterHasDied mDead) {
					System.out.println(mDead);
					takeNextStep = true;
				} catch (PlayerHasDied pDead) {
					System.out.println(pDead);
					exitGame();
				}
			}
		}
		
		// TODO: show how many points the players has, among other things, on exit
		printSlow("You have defeated the stack dungeon");
		printSlow(Banners.griffin(),2);
		exitGame();
	}
}