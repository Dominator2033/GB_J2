package homework_3;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {


    private Map<String, String> phonebook;

    public PhoneBook() {
        phonebook = new HashMap<>();
    }

    public void add(String key, String value) {
        phonebook.put(key, value.toUpperCase());
    }

    public void get(String family) {
        if (phonebook.containsValue(family.toUpperCase())) {
            Map<String, String> map = phonebook;
            for (Map.Entry<String, String> o: map.entrySet()) {
                if (o.getValue().equalsIgnoreCase(family))
                {
                    System.out.println(o.getKey() + ": " + o.getValue().toUpperCase());
                }
            }
        }
        else {
            System.out.println("Введенная фамилия в справочнике не найдена");
        }
    }
}
