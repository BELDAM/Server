package characters;


import characters.Elf.Elf;
import characters.Elf.Hunter;
import monsters.BlackElf;
import monsters.Troll;

/**
 * Created by bastiangardel on 25.05.15.
 */
public class CharacterMain {

    public static void main(String[] args){

        Hunter hunter = new Hunter(new Elf("Elrond",'E'));

        Troll troll = new Troll(3);


        hunter.attack(troll);
        hunter.attack(troll);
        hunter.attack(troll);
        hunter.attack(troll);
        hunter.attack(troll);
        hunter.attack(troll);

        hunter.setXp(120);






    }
}
