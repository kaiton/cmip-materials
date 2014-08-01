package advanced;

enum Weapon {
	RolledUpSock(2), PieceOfTwine(1), StaleLoafOfBread(10), FourxFour(30), Halberd(40), Bomb(100);
	
	private int hitValue;
	
	Weapon(int hitValue){ 
		this.hitValue = hitValue;
	}
	
	int getHitValue(){ // type matches that set in the enumeration above 
		return this.hitValue;
	}

}