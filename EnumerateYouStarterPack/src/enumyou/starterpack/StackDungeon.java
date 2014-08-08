package enumyou.starterpack;
import java.util.Random;

/* 
 * A stack dungeon is a simple set of connected rooms built on top of an array
 * The dungeon contains numItems amount of cells, each of which can contain
 * one of our Encounterable objects: an Enemy, Food, or Weapon, etc.
 * A more complicated dungeon would have a 2nd dimension.
 */
class StackDungeon {

	// stack is the array that represents our series of cells
	Cell[] stack;
	
	// construct a new dungeon with ``numberOfCells`` # of cells to be filled. 
	StackDungeon(int numberOfCells){
		this.stack = new Cell[numberOfCells]; 		
		populateCells();
	}
	
	/* go through all the cells save for the last and populate them randomly with some objects
	 * use a distribution such that roughly ensures that:
	 *  - 20% contain a randomly chosen Food, 
	 *  - 25% contain a randomly chosen Weapon, 
	 *  - the remainder contain some kind of Monster.
	 *  Once complete, make sure the final cell has a Monster in it.
	 *  TODO: tweak this logic to make your game challenging but fun.
	 */
	private void populateCells() {
		Random randomGenerator = new Random();
		int numberOfCells = this.stack.length;
		for(int i = 0; i < numberOfCells - 1; i++){
			// make the i'th item in the stack contain a Cell with a row set to i, and a column set to zero
			this.stack[i] = new Cell(i,0);
			
			// Give this cell a random background location
			this.stack[i].setLocation(Cell.Location.getRandomItem());
			
			
			// get a random number that is within the range of our stack array
			int randomCellIndex = randomGenerator.nextInt(numberOfCells-1);
			
			// normalize that index number to a percentage 
			// this makes our distribution math below easier to read
			// this also allows us to do our distribution calculations without having 
			// to reference the actual index #'s
			double asPerc = 100 * randomCellIndex / (numberOfCells-1);
			
			if(asPerc <= 20) {
				this.stack[i].setContents(Food.getRandomItem());
			} else if(asPerc>20 && asPerc<=75){
				this.stack[i].setContents(Monster.getRandomItem());
			} else if(asPerc>75 && asPerc<=100){
				this.stack[i].setContents(Weapon.getRandomItem());
			}
		}
		
		// set the final boss to a random monster (last cell should not be food, etc)
		// TODO: Do better than a random monster. Create a FinalBoss class that implements Fightable & Encounterable
		// 		 and place in cell
		this.setFinalBoss(Monster.getRandomItem());

	}
	
	public void setFinalBoss(Fightable monster){
		this.stack[this.stack.length - 1] = new Cell(this.stack.length-1,0);
		this.stack[this.stack.length - 1].setContents((Encounterable) monster);
		this.stack[this.stack.length - 1].setLocation(Cell.Location.getRandomItem());
	}
	
	// return the cell at any point in the dungeon
	public Cell cellAt(int at){
		return this.stack[at];
	}
	
	// shorthand for getting the final cell
	public Cell finalCell(){
		return cellAt(this.stack.length - 1);
	}
	
	public Fightable finalBoss(){
		return (Fightable) this.finalCell().getContents();
	}
	
	public boolean complete(){
		return finalBoss().isAlive();
	}
	
	// a convenience method to print out all the cells in our stack dungeon
	// and display the contents. This way we can check to see how items
	// are distributed
	
	public String toString(){
		String dungeonAsString="";
		for(Cell cell : this.stack){
			String rowAsString = "-----\n";
			rowAsString += ("|"+ cell.display() + "|\n"); 
			dungeonAsString += rowAsString;
		}
		return dungeonAsString;
	}
}
