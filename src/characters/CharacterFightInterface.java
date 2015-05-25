package characters;

/**
 * Created by bastiangardel on 25.05.15.
 */
public interface CharacterFightInterface {

    void attack(CharacterFightInterface character);

    void takeDammage(int dammage);

    void die();

}
