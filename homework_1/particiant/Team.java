package homework_1.particiant;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    List<Animal> test;

    // Создание команды
    public Team(String teamName, List<Animal> membersTeam) {
        this.teamName = teamName;
        this.test = membersTeam;
    }

    @Override
    public String toString()
    {
        return "Название команды: " + teamName  + "\nИнформация о всех членах команды: ";
    }

    // Метод вывода информации обо всех членах команды
    public void showResults() {
        System.out.println(toString());
        System.out.println();
        for (Animal a: test) {
            System.out.println(a);
            System.out.println("Jump "+ a.getName() + " " + a.jump(1));
            if (a instanceof Swiming) {
                System.out.println("Swim " + a.getName() + " " + ((Swiming) a).swim(5));
            }
            if (a instanceof SportSwiming) {
                System.out.println("SportSwiming " + a.getName() + " " + ((SportSwiming) a).sportswim(10));
            }
            System.out.println();

        }
    }
    // Метод вывода информации о членах команды, которые завершили дистанцию
    public void showResultsFinished() {
        System.out.println(teamName + "\n");
        for(Animal a : test) {
            if(a.passing){
                System.out.println(a + " successfully passed the distance.\n");
            } else {
                System.out.println(a + " did not pass the distance.\n");
            }
            System.out.println();
        }
    }

}
