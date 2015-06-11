package monsters;


/**
 * Created by Simon on 04.06.2015.
 */
public class MainMonster {
    public static void main(String[] args){

        MonsterFactory mf = new MonsterFactory();
        Troll t1= mf.createTroll();
        Dragon d1 = mf.createDragon();
        Manwe m1 = mf.createManwe();

        System.out.println(t1.toString());
        System.out.println(d1.toString());
        System.out.println(m1.toString());
        m1.attack(t1);
        m1.magiclAttack(t1);
    }
}
