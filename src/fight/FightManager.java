package fight;

import monsters.Monster;
import characters.Character;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class FightManager implements Runnable {
	private ArrayList<Character> characters;
	private ArrayList<Monster> monsters;
	private Map<Character, CharacterAction> actions;

	private Random randomGenerator;
	private boolean charactersTurn;

	public FightManager(Map<Character, CharacterAction> actions) {
		this.actions = actions;
		characters = new ArrayList<>();
		monsters = new ArrayList<>();
		randomGenerator = new Random();
		charactersTurn = false;
	}

	@Override
	public void run() {
		while (!isOver()) {
			if (charactersTurn) {
				playersTurn();
			} else {
				monstersTurn();
			}

			charactersTurn = !charactersTurn;
		}
	}

	private boolean isOver() {
		return monsters.isEmpty() || characters.isEmpty();
	}

	private boolean isAllCharactersReady() {
		for (Character character: characters) {
			if (actions.get(character) == CharacterAction.UNDEFINED) {
				return false;
			}
		}

		return true;
	}

	private void playersTurn() {

	}

	private void monstersTurn() {
		for (Monster monster: monsters) {
			// Attack a random character
			monster.attack(characters.get(randomGenerator.nextInt(characters.size())));
		}
	}
}
