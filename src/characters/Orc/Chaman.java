package characters.Orc;

import Interface.FightInterface;
import Visitors.IVisitor;

/**
 * Created by bastiangardel on 25.05.15.
 */
public class Chaman extends OrcDecorator {

    private int mana;
    private static final int MANA = 3;

    public Chaman(OrcInterface orcInterface) {
        orc = orcInterface;
    }

    @Override
    public void attack(FightInterface character) {
        //TODO implementation
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
        return orc.isDead();
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

    @Override
    public int getRage() {
        return orc.getRage();
    }

    @Override
    public void setRage(int rage) {
        orc.setRage(rage);
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}
