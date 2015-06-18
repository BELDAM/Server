package fight;

import monsters.Monster;
import characters.Character;
import monsters.MonsterFactory;
import server.ConnectionHandler;
import server.GameManager;
import server.PlayerState;
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
        focuses = new HashMap<>();

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
        if (monsterId > 0 && monsterId <= monsters.size()) {
            focuses.put(player, monsters.get(monsterId - 1));
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

        broadcastMessage(monstersToString());

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
        for (Character player: players) {
            GameManager.getInstance().getConnectionForPlayer(player).setState(PlayerState.MAIN);
        }

        GameManager.getInstance().removeFight(room);
    }

    private void playersTurn() {
        for (Character player : players) {
            Monster target = focuses.get(player);

            if (target != null) {
                player.attack(target);
            }
        }

        ArrayList<Monster> aliveMonsters = new ArrayList<>();

        for (Monster monster: monsters) {
            if (monster.isDead()) {
                room.addItems(monster.dropItems());
                broadcastMessage("The " + monster.getClass().getSimpleName() + " is dead.");
                printItems();
            } else {
                aliveMonsters.add(monster);
            }
        }

        monsters = aliveMonsters;

        resetActions();
    }

    private void monstersTurn() {
        for (int i = 0; i < monsters.size(); i++) {
            Character target = players.get(randomGenerator.nextInt(players.size()));
            broadcastMessage("Monster #" + (i+1) + "(" + monsters.get(i).getClass().getSimpleName() + ") attacks " + target.getName() + "!");
            monsters.get(i).attack(target);
        }

        ArrayList<Character> alivePlayers = new ArrayList<>();

        for (Character player: players) {
            if (player.isDead()) {
                room.addItems(player.getItems());
                broadcastMessage(player.getName() + " is dead! ='(");
                printItems();
            } else {
                alivePlayers.add(player);
            }
        }

        players = alivePlayers;
    }

    private String monstersToString() {
        String str = "";

        for (int i = 0; i < monsters.size(); i++) {
            str += (i + 1) + ") " + monsters.get(i).getClass().getSimpleName() + "\r\n";
        }

        return str;
    }

    private void printItems() {
        if (room.getItems().size() != 0) {
            broadcastMessage("There is some items on the floor.");
            String str = "";

            for (int i = 0; i < room.getItems().size(); i++) {
                str += (i + 1) + ") " + room.getItems().get(i) + "\r\n";
            }

            broadcastMessage(str);
        }
    }

    public void broadcastMessage(String message) {
        for (Character player : players) {
            ConnectionHandler connection = GameManager.getInstance().getConnectionForPlayer(player);
            connection.printMessage(message + "\r\n ");
        }
    }
}
