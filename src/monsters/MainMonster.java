package monsters;


/**
 * Created by Simon on 04.06.2015.
 */
public class MainMonster {
    public static void main(String[] args){

        MonsterFactory mf = new MonsterFactory();
        Troll t1= mf.createTroll();
        Dragon d1 = mf.createDragon();
        System.out.println(t1.toString());
        System.out.println(d1.toString());
    }
}
