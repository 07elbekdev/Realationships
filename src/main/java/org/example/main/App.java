package org.example.main;

import org.example.repository.impl.PersonRepositoryImpl;
import org.example.repository.impl.PhonesRepoImpl;
import org.example.unit.Person;
import org.example.unit.Phones;

public class App {
    public static void main(String[] args) {
        Phones phones = new Phones("Iphone", 2005);
        phones.setPerson(new Person("Kutman", 16, phones));
        Phones phones1 = new Phones("Samsung", 2009);
        phones1.setPerson(new Person("Dustman", 18, phones1));
        Phones phones2 = new Phones("Xiaomi", 2015);
        phones2.setPerson(new Person("Arie", 17, phones2));

        PhonesRepoImpl phonesRepo = new PhonesRepoImpl();
        PersonRepositoryImpl personRepository = new PersonRepositoryImpl();
    }
}