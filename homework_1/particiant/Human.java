package homework_1.particiant;

public class Human extends Animal implements SportSwiming
{
    private Gender gender;

    private final static double DEFAULT_JUMP_VALUE = 100.0;
    private final static double DEFAULT_SWIM_VALUE = 100.1;
    private final static double DEFAULT_SPORT_SWIM_VALUE = 200.6;

    public Human(int age, String name, Gender gender)
    {
        super(age, name);
        this.gender = gender;
    }

    @Override
    public boolean jump(double distanceJump)
    {
        return distanceJump <= gender.getCoef() * COEF_FOR_HUMAN * DEFAULT_JUMP_VALUE;
    }

    @Override
    public boolean swim(double distanceToSwim)
    {
        return distanceToSwim <= gender.getCoef() * COEF_FOR_HUMAN * DEFAULT_SWIM_VALUE;
    }

    @Override
    public boolean sportswim(double distanceToSwim) {
        return distanceToSwim <= gender.getCoef() * COEF_FOR_HUMAN * DEFAULT_SPORT_SWIM_VALUE;
    }

    @Override
    public String toString()
    {
        return "Human{" + "gender=" + gender + "} " + super.toString();
    }
}

