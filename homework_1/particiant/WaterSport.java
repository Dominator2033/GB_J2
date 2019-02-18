package homework_1.particiant;

public class WaterSport implements Let  {
    private double length;

    public WaterSport(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    @Override
    public boolean doIt(Animal animal) {
        if (animal instanceof SportSwiming) {
            return ((SportSwiming) animal).sportswim(length);
        }
        else {
            return false;
        }
    }
}
