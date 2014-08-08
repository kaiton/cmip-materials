# The enumyou starter pack
Inside you'll find a skeleton and more for a simple console-based adventure game called **Enum You!** **Enum You!** is a simple game for demonstrating the features of the Java language we've been introduced to so far. The core logic of this game as it stands is as follows:

> We have a Player who must make his way through a Dungeon that consists of a series of Cells that teleport between various locations. Each cell contains either Food, a Weapon, or a Monster who our player must defeat (or evade) to continue. The game is won if our player stays alive long enough to get to the final cell and defeat the last monster. 

Your task is turn this shell of a game into something that is challenging but fun and winnable, using your imagination and all the Java skills we've learned up to this point (you're free to use more if you'd like). I've added code for functionality we hadn't covered in class yet (like getting interactive input from the command line) and provided enough implementation that you can see how to expand things. I've also left some bugs that will need to be addressed for the game to work consistently.

The code as it stands will run but the gameplay is not fully implemented and so it's not "fun". To help you get it to fun I've commented the code liberally and added TODO items to help guide you in fleshing it out. Many of these are suggestions but the ones in bold **must** be done for your solution to be accepted. The code and the TODO items represent a starting point. You can feel free to change as much as you'd like, as long as the key behaviors are implemented.


### Work items

- Setup an interface so that players can choose a skill. You may want to have pre-configured character classes instead (you can use more enums for this, or plain classes)
- **Implement some logic for increasing our player's LifeMeter by amounts up to the maximum but not beyond it**
- **Add more kinds of Armour and implement how armour will be put on and will work in battle**. 
- Putting on armour should allow the wearer to take more damage but may affect the ability to Run/Evade
- **Provide more information than just name for the String representation of a player (points, skills, weapons, etc)**
- **Implement a points system that the player gains from fighting, etc**
- **Keep track of and show how many points the Player has, among other things, on exit**
- Create your own text-based graphics to replace or complement those in the Banners class
- **Fully implement Player.evade behaviour based on skills, monsters, and locations as appropriate. You might use the kind of monster to influence how likely evasion will be (Ninjas should be unlikey, for example). Or if you're strong you might be slow in a Swampy location and less likely to evade. Using random numbers and probabilities like I've shown is a way to make this slightly unpredicatable (but favor certain skills)**
- **Define some logic or changes to the enum that dictates how many damage points can a Monster hit for. It should be more involved than just using their point value as it is now.**
- Decide whether Monsters can have armour or other defences against damage. Should the same weapon have the same effect on all monsters?
- **Define your own weapons and make weapon behaviour more complex. For instance, should hit values be the same constantly? Perhaps Bombs randomly fizzle or only apply a fraction of their damage points. Perhaps if you don't have a skill like Speed sometimes Bombs hurt you too**
- Add more foods, possibly even some that are toxic
- Decide what happens to our Player's previous weapon when he picks up another. Does it get dropped in the cell? Put in bag?
- **Implement Player Bag/Inventory functionality. I've included some code in the Player class and some example code in the EnumerateYou main game runner that you can use to jumpstart this functionality working**
- Decide how to calculate the damage level against a specific opponents based on weapons, locations, or whatever you choose.	
- Provide more information than just name for the String representation of a player
- Perhaps allow the  player to choose a weapon initially and a skill, rather than the current default random selection
- Change the skills that exist now and decide how they work. Where do you pick up a skill? How does a Skill affect gameplay?
- **Do better than a random monster in the Dungeon's final cell. Create a FinalBoss class that implements Fightable & Encounterable and give it some "interesting" attributes. The final boss cannot be evaded**
- Implement Location effects for weapons, monsters, etc.


## Submitting solutions
You can fork this repository to your github spaces and begin there. Once you have code committed that you're happy with, send me a link to your repo and I'll clone it, compile the code, and run the game. This means that:

1. It should compile, and I should be able to run it interactively in Eclipse console, or through my command prompt / terminal
2. It should work: exceptions should be handled, and the application should not crash during gameplay
3. It should let me know if I'm attempting unsupported actions in a friendly way. The starterpack code demonstrates this to some degree


## Assessing solutions
There is no rigid formula for assessing these games. If they don't work, I'll still look at your code, but I won't apply any fixes to make it work so make sure you at least have a simple version that works that you can tag and go back to before implementing any crazy features. 

I'll be assigning "points" based on code, the style of gameplay, interesting characters and objects, and challenge level (while remaining possible). We'll be playing each other's games and commenting and voting on the experience.