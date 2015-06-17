package fight;

import monsters.Monster;
import characters.Character;
import java.util.ArrayList;
import java.util.Random;

public class FightManager implements Runnable {
	ArrayList<Character> characters = new ArrayList<>();
	ArrayList<Monster> monsters = new ArrayList<>();
	private Random randomGenerator = new Random();

	@Override
	public void run() {
		while (!isOver()) {
			playersTurn();
			monstersTurn();
		}
	}

	private boolean isOver() {
		return monsters.isEmpty() || characters.isEmpty();
	}

	private void playersTurn() {

	}

	private void monstersTurn() {
		for (Monster monster: monsters) {
			monster.attack(characters.get(randomGenerator.nextInt(characters.size())));
		}
	}
}
