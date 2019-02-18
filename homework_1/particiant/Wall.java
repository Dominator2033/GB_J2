package homework_1.particiant;

public class Wall implements Let {
    private double height;

    public Wall(double height) {
        this.height = height;
    }

    @Override
    public boolean doIt(Animal animal) {
        if (animal instanceof Jumping) {
            return ((Swiming) animal).swim(height);
        }
        else
            return false;
    }

    public double getHeight() {
        return height;
    }
}
