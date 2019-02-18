package homework_1.particiant;

public class Dog extends Animal
{
    private String type;

    public final static String TYPE_BULDOG = "BULDOG_TYPE";
    public final static String TYPE_GERMAN = "GERMAN_TYPE";
    private final static double COEF_OF_JUMP_BULDOG = 0.4;
    private final static double COEF_OF_JUMP_GERMAN = 0.8;
    private final static double DEFAULT_JUMP_VALUE = 8.0;

    //// SWIM constans
    private final static double COEF_OF_SWIM_BULDOG = 1.2;
    private final static double COEF_OF_SWIM_GERMAN = 1.3;
    private final static double DEFAULT_SWIM_VALUE = 15;

    public Dog(int age, String name, String type)
    {
        super(age, name);
        this.type = type;
    }

    @Override
    public boolean jump(double distanceJump)
    {
        if (type.equalsIgnoreCase(TYPE_BULDOG))
        {
            return distanceJump <= DEFAULT_JUMP_VALUE * COEF_OF_JUMP_BULDOG * COEF_FOR_DOG;
        }
        else if (type.equalsIgnoreCase(TYPE_GERMAN))
        {
            return distanceJump <= DEFAULT_JUMP_VALUE * COEF_OF_JUMP_GERMAN * COEF_FOR_DOG;
        }
        else
        {
            return false;
        }
    }

    @Override
    public String toString()
    {
        return "Dog{" + "type='" + type + '\'' + "} " + super.toString();
    }

    @Override
    public boolean swim(double distanceToSwim) {
        if (type.equalsIgnoreCase(TYPE_BULDOG))
        {
            return distanceToSwim < DEFAULT_SWIM_VALUE * COEF_OF_SWIM_BULDOG * COEF_FOR_DOG;
        }
        else if (type.equalsIgnoreCase(TYPE_GERMAN))
        {
            return distanceToSwim < DEFAULT_JUMP_VALUE * COEF_OF_SWIM_GERMAN * COEF_FOR_DOG;
        }
        else
        {
            return false;
        }
    }
}

