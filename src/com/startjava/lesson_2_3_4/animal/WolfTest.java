package com.startjava.lesson_2_3_4.animal;

public class WolfTest {
    public static void main(String[] args) {
        Wolf myWolf = new Wolf();
        myWolf.setSex("мужской");
        myWolf.setName("Боб");
        myWolf.setWeight(25.5f);
        myWolf.setAge(10);
        myWolf.setColor("Коричневый");

        System.out.println("Пол: " + myWolf.getSex());
        System.out.println("Имя: " + myWolf.getName());
        System.out.println("Вес: " + myWolf.getWeight());
        System.out.println("Возраст :" + myWolf.getAge());
        System.out.println("Цвет: " + myWolf.getColor());

        myWolf.run();
        myWolf.sit();
        myWolf.go();
        myWolf.howl();
        myWolf.hunt();
    }
}