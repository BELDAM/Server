package characters;

import characters.Elf.Elf;
import characters.Humain.Human;
import characters.Orc.Orc;

public class CharacterFactory {

    public Character createCharacter(String name, char avatar, String race) {
        Character character = null;
        switch (race.toLowerCase()) {
            case "elf":
                character = new Elf(name, avatar);
                break;
            case "human":
                character = new Human(name, avatar);
                break;
            case "orc":
                character = new Orc(name, avatar);
        }
        return character;
    }
}
