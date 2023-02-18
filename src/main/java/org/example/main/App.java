package org.example.main;

import org.example.repository.impl.PersonRepositoryImpl;
import org.example.unit.Person;
import org.example.unit.Phones;

public class App {
    public static void main(String[] args) {
        Phones phones = new Phones("Iphone", 2005);
        Phones phones1 = new Phones("Samsung", 2009);
        Phones phones2 = new Phones("Xiaomi", 2015);

        Person person = new Person("Kutman", 16, phones);
        Person person1 = new Person("Dustman", 18, phones1);
        Person person2 = new Person("Arie", 17, phones2);

        PersonRepositoryImpl personRepository = new PersonRepositoryImpl();
        
    }
}