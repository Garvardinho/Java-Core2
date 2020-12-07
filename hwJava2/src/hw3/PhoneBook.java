package hw3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {
    TreeMap<String, HashMap<String, String>> data;

    PhoneBook() {
        data = new TreeMap<>();
    }

    @Override
    public String toString() {
        String result = "";

        for (Map.Entry<String, HashMap<String, String>> pb : data.entrySet())
            for (Map.Entry<String, String> p : pb.getValue().entrySet())
                result += pb.getKey() + '\t' + p.getKey() + '\t' + p.getValue() + '\n';

        return result;
    }

    public void add(Person person) {
        // This code below allows to identify an attempt to add a person
        // with a phone number already existing in the phonebook
        for (Map.Entry<String, HashMap<String, String>> pb : data.entrySet())
            for (Map.Entry<String, String> p : pb.getValue().entrySet())
                if (p.getKey().equals(person.getPhoneNum()))
                    return;

        HashMap<String, String> p = (data.containsKey(person.getName())) ? data.get(person.getName()) : new HashMap<>();
        p.put(person.getPhoneNum(), person.getEmail());
        data.put(person.getName(), new HashMap<>(p));
    }

    public ArrayList<String> getPhone(String name) {
        ArrayList<String> numbers = new ArrayList<>();

        for (Map.Entry<String, String> person : data.get(name).entrySet())
            numbers.add(person.getKey());

        return numbers;
    }

    public ArrayList<String> getEmail(String name) {
        ArrayList<String> emails = new ArrayList<>();

        for (Map.Entry<String, String> person : data.get(name).entrySet())
            emails.add(person.getValue());

        return emails;
    }
}
