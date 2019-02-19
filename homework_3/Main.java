package homework_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Задание №1
        System.out.println("********************* Начало программы №1 *********************");
        int count = 0;
        List<String> list = addArrayList(count);
        addHashMap(list, count);

        // **********
        // Задание №2
        System.out.println("********************* Начало программы №2 *********************");

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("555-55-55", "Ivanov");
        phoneBook.add("444-44-44", "Sidorov");
        phoneBook.add("333-33-33", "Petrov");
        phoneBook.add("111-11-11", "Sobolev");
        phoneBook.add("222-22-22", "Ivanov");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите фамилию для поиска в справочнике");
        try {
            phoneBook.get(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List addArrayList (int count) {
        System.out.println("***************** Создание и вывод ArrayList *****************");

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("A");
        list.add("A");
        list.add("D");
        list.add("B");
        list.add("B");
        list.add("B");

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).equalsIgnoreCase(list.get(j))) {
                    count++;
                }
            }
            System.out.println(list.get(i) + " - " + count + " Количество одинаковых элементов");
            count = 0;
        }
        return list;
    }

    public static void addHashMap (List<String> list, int count) {
        System.out.println("****************** Создание и вывод HashMap ******************");
        Map<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {

            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).equalsIgnoreCase(list.get(j))) {
                    count++;
                    hm.put(list.get(i), count);
                }
                else {
                    hm.put(list.get(i), count);
                }
            }
            count = 0;
        }

        for (Map.Entry<String, Integer> o : hm.entrySet()) {
            System.out.println("Количество одинаковых элементов " + o.getKey() + ": " + o.getValue());
        }
    }
}
