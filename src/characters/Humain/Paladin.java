package characters.Humain;

import Interface.FightInterface;
import Visitors.IVisitor;

/**
 * Created by bastiangardel on 25.05.15.
 */
public class Paladin extends HumainDecorator {

    public Paladin(HumainInterface humainInterface) {
        humain = humainInterface;
    }

    @Override
    public void attack(FightInterface character) {

    }

    @Override
    public void magicAttack(FightInterface character) {
        //TODO implementation
    }

    @Override
    public void takeMagicDmg(int dmg) {
        //TODO implementation
    }

    @Override
    public void takeDmg(int dmg) {
        //TODO implementation
    }

    @Override
    public void accept(IVisitor visitor) {
        //TODO implementation
    }

    @Override
    public int getXp() {
        return 0;
    }

    @Override
    public void setXp(int xp) {

    }

    @Override
    public int getGiveXP() {
        return 0;
    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public int getHP() {
        return 0;
    }

    @Override
    public void setHP(int HP) {

    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public void setLevel(int level) {

    }

    @Override
    public void setDead(boolean dead) {

    }

    @Override
    public int getStrength() {
        return 0;
    }

    @Override
    public void setStrength(int strength) {

    }

    @Override
    public int getIntelligence() {
        return 0;
    }

    @Override
    public void setIntelligence(int intelligence) {

    }

    @Override
    public int getPhysicalDefence() {
        return 0;
    }

    @Override
    public void setPhysicalDefence(int physicalDefence) {

    }

    @Override
    public int getMagicalDefence() {
        return 0;
    }

    @Override
    public void setMagicalDefence(int magicalDefence) {

    }

}
