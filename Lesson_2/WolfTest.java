
public class WolfTest {
    public static void main(String[] args) {
        Wolf myWolf = new Wolf();
        myWolf.sex = "мужской";
        myWolf.name = "Боб";
        myWolf.weight = 25.5f;
        myWolf.age = 10;
        myWolf.color = "Коричневый";
        System.out.println("Пол: " + myWolf.sex);
        System.out.println("Имя: " + myWolf.name);
        System.out.println("Вес: " + myWolf.weight);
        System.out.println("Возраст :" + myWolf.age);
        System.out.println("Цвет: " + myWolf.color);
        myWolf.run();
        myWolf.sit();
        myWolf.go();
        myWolf.howl();
        myWolf.hunt();
    }
}