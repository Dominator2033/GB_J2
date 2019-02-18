package homework_1.particiant;

public class Cat extends Animal
{
    private String type;
    public final static String TYPE_PERSIA = "PERSIA_TYPE";
    public final static String TYPE_BRITYSH = "BRITISH_TYPE";
    // JUMP_constans
    private final static double COEF_OF_JUMP_BRITYSH = 0.5;
    private final static double COEF_OF_JUMP_PERSIN = 0.6;
    private final static double DEFAULT_JUMP_VALUE = 5.0;



    public Cat(int age, String name, String type)
    {
        super(age, name);
        this.type = type;
    }

    @Override
    public boolean jump(double distanceJump)
    {
        if (type.equalsIgnoreCase(TYPE_PERSIA))
        {
            return distanceJump < DEFAULT_JUMP_VALUE * COEF_OF_JUMP_PERSIN * COEF_FOR_CAT;
        }
        else if (type.equalsIgnoreCase(TYPE_BRITYSH))
        {
            return distanceJump < DEFAULT_JUMP_VALUE * COEF_OF_JUMP_BRITYSH * COEF_FOR_CAT;
        }
        else
        {
            return false;
        }
    }

    @Override
    public String toString()
    {
        return "Cat{" + "type='" + type + '\'' + "} " + super.toString();
    }

    @Override
    public boolean swim(double distanceToSwim) {
        return false;
    }
}

