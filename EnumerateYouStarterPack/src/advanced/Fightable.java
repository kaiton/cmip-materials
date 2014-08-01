package advanced;
interface Fightable {
	void getHit(int damage) throws FightableIsDead;
	void fight(Fightable other);
}