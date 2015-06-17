package monsters;


import java.util.LinkedList;

/**
 * Created by Simon on 04.06.2015.
 */
public class MainMonster {
    public static void main(String[] args){

        System.out.println("yolloo");
        MonsterFactory mf = new MonsterFactory();
        Troll t1= mf.createTroll();
        System.out.println("yolloo");
        Dragon d1 = mf.createDragon();
        Manwe m1 = mf.createManwe();

        System.out.println("yolloo");
        System.out.println(t1.toString());
        System.out.println(d1.toString());
        System.out.println(m1.toString());
        m1.attack(t1);
        m1.magicAttack(t1);
        LinkedList drop = m1.dropItem();
        for(int i = 0 ; i < drop.size(); i++)
        {
            System.out.println(drop.get(i));
        }
    }
}
