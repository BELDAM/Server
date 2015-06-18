package fight;

import monsters.Monster;
import characters.Character;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class FightManager {

    private ArrayList<Character> players;
    private ArrayList<Monster> monsters;
    private Map<Character, CharacterAction> actions;

    private Random randomGenerator;
    private boolean playersTurn;

    public FightManager() {
        players = new ArrayList<>();
        monsters = new ArrayList<>();
        randomGenerator = new Random();
        playersTurn = false;
    }

    public void setAction(Character player, CharacterAction action) {
        actions.replace(player, action);

        if (areAllCharactersReady()) {
            fight();
        }
    }

    private void fight() {
        if (playersTurn) {
            playersTurn();
        } else {
            monstersTurn();
        }

        playersTurn = !playersTurn;

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
