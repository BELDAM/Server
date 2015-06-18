package fight;

import monsters.Monster;
import characters.Character;
import utils.IllegalTargetException;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class FightManager {

    private ArrayList<Character> players;
    private ArrayList<Monster> monsters;
    private Map<Character, CharacterAction> actions;
    private Map<Character, Monster> focuses;

    private Random randomGenerator;

    public FightManager() {
        players = new ArrayList<>();
        monsters = new ArrayList<>();
        randomGenerator = new Random();
    }

    public void attackMonster(Character player, int monsterId) throws IllegalTargetException {
        if (monsterId > 0 && monsters.size() <= monsterId) {
            focuses.put(player, monsters.get(monsterId));
        } else {
            throw new IllegalTargetException();
        }

        actions.replace(player, CharacterAction.ATTACK);

        if (areAllCharactersReady()) {
            fight();
        }
    }

    /*
    public void defend(Character player) {
        actions.replace(player, CharacterAction.DEFENCE);

        if (areAllCharactersReady()) {
            fight();
        }
    }
    */

    public void joinFight(Character player) {
        players.add(player);
        actions.put(player, CharacterAction.UNDEFINED);
    }

    private void fight() {
        playersTurn();
        monstersTurn();

        if (isOver()) {
            endFight();
        }
    }

    private boolean isOver() {
        return monsters.isEmpty() || players.isEmpty();
    }

    private boolean areAllCharactersReady() {
        return players.stream().noneMatch((character) -> (actions.get(character) == CharacterAction.UNDEFINED));
    }

    private void resetActions() {
        for (Character player: players) {
            actions.replace(player, CharacterAction.UNDEFINED);
        }
    }

    private void endFight() {
        // TODO implement me
    }

    private void playersTurn() {
        resetActions();
    }

    private void monstersTurn() {
        for (Monster monster : monsters) {
            // Attack a random character
            monster.attack(players.get(randomGenerator.nextInt(players.size())));
        }
    }
}
