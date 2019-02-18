package homework_1.examplesclass;


public class ExampleForMethodClass
{

    public void sum(int a, int b)
    {
        a = 10;
        b = 11;
        int c = a + b;
        System.out.println(c);
    }

    public void toDo(LinkedExampleClass linkedExampleClass)
    {
        linkedExampleClass.setField(6);
        System.out.println(linkedExampleClass.toString());
    }
}