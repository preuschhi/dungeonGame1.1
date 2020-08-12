# dungeonGame1.1
I coded this little game to improve and strengthen my skills in Java. 
There are still some things that I need to fix, but as I said this little project was more for practice and fun. 
If you look closely, you can even see my improvement in terms of dealing with methods. 
In the class Spieler I wrote one big angriff() method with just a couple of little mehtods; 
but in the class Waffe, I split up the waffenKonfiguration() method in many little ones.

This is what happens in the game: When you start the game, you can choose between: 
[1] Angriff (attack) 
If you pick this option, a method creates a random enemy object. After that you have the options to either attack this enemy, or cancel the attack.
If you pick the option to attack the enemy, you get the chance to upgrade one of your weapons. You can choose between 3 options (fire, ice or normal).
The weapons are then either buffed or nerfed depending on the roomtype you are in (fire, ice or normal). 
If you pick a fire upgrade in an iceroom, your weapon will be getting nerfed. If you do the same upgrade in a fireroom, it will be buffed.

After you improved your weapon, the actual attack happens. First you attack the enemy. After that the method checks if the enemy is still alive.
If not, you will get some gold and if you want, you can pick up his weapon. If he is still alive, the enemy attack() method gets activated. 
The enemy has a 60% chance to hit you. After the enemy attack, you will get the option to heal yourself. 
After you have picked one of the options, the method attack() starts all over again. This time you cannot improve your weapon.

[2] Heilen (heal) 
Here can you heal your character. 
If you do this, one of your healing potions will be removed. 
You health will increase by 10.

[3] Iventar (inventory) Here you can see your ammount of gold, healing potions and your weapons.

[4] Neuer Raum (new room)
Every time you go to a new room, a random generator decides if you find a chest or a dealer in the new room.
If you find a chest, you get gold and one healing potion. If you find a dealer, you can use the gold to buy healing potions and new weapons.

[5] Spiel beenden (end game)
