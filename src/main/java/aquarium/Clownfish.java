package aquarium;

public class Clownfish extends Fish{

    public Clownfish(String name, int weight, String color) {
        super(name, weight, color,false);
    }

    @Override
    public void feed() {
        super.setWeight(super.getWeight()+1);
    }
}
