package homework_1.particiant;

import java.util.Random;

public class Course {
    Let[] lets = new Let[3];

    // Создаем полосу препятствий
    Random random = new Random();
    public Course() {
        Wall wall = new Wall(random.nextDouble() * 10);
        Water water = new Water(random.nextInt(100));
        WaterSport waterSport = new WaterSport(random.nextInt(150));

        lets[0] = wall;
        lets[1] = water;
        lets[2] = waterSport;
    }

    // Информация о полосе препятствий
    public void printInfoAboutLet() {
        System.out.println("Высота прыжка: " + ((Wall) lets[0]).getHeight());
        System.out.println("Дистанция плавания: " + ((Water) lets[1]).getLength());
        System.out.println("Дистанция спортивного плавания: " + ((WaterSport) lets[2]).getLength());
        System.out.println();
    }

    // Прохождение полосы
    public void passage(Team team) {
        for (Animal animal : team.test) {
            for(Let l : lets) {
                if (!l.doIt(animal)) {
                    animal.setPassing(l.doIt(animal));
                    break;
                }
                animal.setPassing(true);
            }
        }
    }
}

