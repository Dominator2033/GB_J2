package homework_1.particiant;

public class Water implements Let {
    private double length;

    public Water(double length) {
        this.length = length;
    }

    @Override
    public boolean doIt(Animal animal) {
        if (animal instanceof Swiming) {
            return ((Swiming) animal).swim(length);
        }
        else {
            return false;
        }
    }

    public double getLength() {
        return length;
    }
}

