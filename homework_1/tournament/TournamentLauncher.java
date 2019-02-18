package homework_1.tournament;

import homework_1.particiant.*;

import java.util.ArrayList;
import java.util.List;

public class TournamentLauncher
{

    public static void main(String[] args)
    {
        List<Animal> members = new ArrayList<>();

        //Animal member1 = new Cat(5, "BARSIK", Cat.TYPE_BRITYSH);
        Animal member1 = new Human(25,"Mariya", Gender.FEMALE);
        Animal member2 = new Cat(10, "KISYA", Cat.TYPE_PERSIA);
        Animal member3 = new Dog(3, "MUHTAR", Dog.TYPE_BULDOG);
        Animal member4 = new Human(23, "Ivan ivanov", Gender.MALE);


        /********** YOU CAN NO CHAGE ****************/


        members.add(member1);
        members.add(member2);
        members.add(member3);
        members.add(member4);

        for (Animal animal : members)
        {
            System.out.println(animal.toString() + ": Прыжки " + animal.jump(1));
        }

        Swiming swiming1 = new Dog(3, "MUHTAR", Dog.TYPE_BULDOG);
        Swiming swiming2 = new Human(23, "Ivan ivanov", Gender.MALE);
        Swiming swiming3 = new Human(25,"Mariya", Gender.FEMALE);

        List<Swiming> swimings = new ArrayList<>();
        swimings.add(swiming1);
        swimings.add(swiming2);
        swimings.add(swiming3);

        System.out.println();
        for (Swiming swiming : swimings)
        {
            System.out.println(swiming.toString() + ": Плавание " + swiming.swim(5));
        }


        SportSwiming sportSwiming1 = new Human(25,"Mariya", Gender.FEMALE);
        SportSwiming sportSwiming2 = new Human(23, "Ivan ivanov", Gender.MALE);
        List<SportSwiming> sportSwimings = new ArrayList<>();
        sportSwimings.add(sportSwiming1);
        sportSwimings.add(sportSwiming2);

        System.out.println();
        for (SportSwiming sportSwiming : sportSwimings) {
            System.out.println(sportSwiming.toString() + ": Спортивное плавание " + sportSwiming.sportswim(10));
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("         Total RESULT         ");
        }

        Course c = new Course();
        Team team = new Team("TESTB", members);
        c.printInfoAboutLet();
        c.passage(team);
        team.showResults();
        System.out.println("PROPUSK");
        team.showResultsFinished();


    }
}

