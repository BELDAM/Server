package fight;

import monsters.Monster;
import characters.Character;
import monsters.MonsterFactory;
import server.ConnectionHandler;
import server.GameManager;
import utils.IllegalTargetException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import userInterface.screens.map.Room;

public class FightManager {

    private ArrayList<Character> players;
    private ArrayList<Monster> monsters;
    private Map<Character, CharacterAction> actions;
    private Map<Character, Monster> focuses;
    private Room room;

    private Random randomGenerator;

    public FightManager(Room room) {
        this.room = room;
        players = new ArrayList<>();
        monsters = new ArrayList<>();
        randomGenerator = new Random();
        actions = new HashMap<>();

        createMonsters();
    }

    private void createMonsters() {
        MonsterFactory factory = new MonsterFactory();

        int numberOfMonsters = randomGenerator.nextInt(3) + 1;

        for (int i = 0; i < numberOfMonsters; i++) {
            monsters.add(factory.createRandomMonster(GameManager.getInstance().getPartyLevel(), GameManager.getInstance().getPartySize()));
        }
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

        GameManager.getInstance().getConnectionForPlayer(player).printMessage(monstersToString());
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
        for (Character player : players) {
            actions.replace(player, CharacterAction.UNDEFINED);
        }
    }

    private void endFight() {
        // TODO implement me
    }

    private void playersTurn() {
        for (Character player : players) {
            Monster target = focuses.get(player);

            if (target != null) {
                player.attack(target);
            }
        }

        resetActions();
    }

    private void monstersTurn() {
        for (Monster monster : monsters) {
            // Attack a random character
            monster.attack(players.get(randomGenerator.nextInt(players.size())));
        }
    }

    private String monstersToString() {
        String str = "";

        for (int i = 0; i < monsters.size(); i++) {
            str += (i + 1) + ") " + monsters.get(i).getClass().getSimpleName() + "\r\n";
        }

        return str;
    }

    public void broadcastMessage(String message) {
        for (Character player : players) {
            System.out.println(player);
            ConnectionHandler connection = GameManager.getInstance().getConnectionForPlayer(player);

            System.out.println(connection);
            connection.printMessage(message);
        }
    }
}
