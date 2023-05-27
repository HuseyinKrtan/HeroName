package hero;

public class Heros {

    private String name;

    private Integer healt;

    private Integer mana;

    public Heros() {
    }

    public Heros(String name, Integer healt, Integer mana) {
        this.name = name;
        this.healt = healt;
        this.mana = mana;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHealt() {
        return healt;
    }

    public void setHealt(Integer healt) {
        this.healt = healt;
    }

    public Integer getMana() {
        return mana;
    }

    public void setMana(Integer mana) {
        this.mana = mana;
    }
}
