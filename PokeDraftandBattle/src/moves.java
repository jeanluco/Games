
class moves {

    private String name;
    private int damage;
    private  String type;
    private String physical;

    moves() {
    }

    public moves(String name, int damage, String type, String physical) {
        this.name = name;
        this.damage = damage;
        this.type = type;
        this.physical = physical;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhysical() {
        return physical;
    }

    public void setPhysical(String physical) {
        this.physical = physical;
    }
}