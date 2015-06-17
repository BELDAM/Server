package fight;

import monsters.Monster;
import characters.Character;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class FightManager implements Runnable {

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

    @Override
    public void run() {
        while (!isOver()) {
            if (playersTurn) {
                playersTurn();
            } else {
                monstersTurn();
            }

            playersTurn = !playersTurn;
        }
    }

    private boolean isOver() {
        return monsters.isEmpty() || players.isEmpty();
    }

    private boolean areAllCharactersReady() {
        return players.stream().noneMatch((character) -> (actions.get(character) == CharacterAction.UNDEFINED));
    }

    private void playersTurn() {

    }

    private void monstersTurn() {
        for (Monster monster : monsters) {
            // Attack a random character
            monster.attack(players.get(randomGenerator.nextInt(players.size())));
        }
    }
}
