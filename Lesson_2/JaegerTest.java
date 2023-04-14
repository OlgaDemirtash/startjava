public class JaegerTest {
    public static void main(String[] args) {
        Jaeger myJaeger1 = new Jaeger();
        myJaeger1.setModelName("Gipsy Danger");
        myJaeger1.setMark("Mark-3");
        myJaeger1.setOrigin("USA");
        myJaeger1.setHeight(79.25f);
        myJaeger1.setWeight(1.980f);
        myJaeger1.setSpeed(7);
        myJaeger1.setStrength(8);
        myJaeger1.setArmor(6);
        System.out.println("Модель: " + myJaeger1.getModelName());
        myJaeger1.move();
        System.out.println(myJaeger1.scanKaiju());
        myJaeger1.usePlasmaCannon();
        myJaeger1.leap();
        myJaeger1.setSpeed(5);
        myJaeger1.move();

        Jaeger myJaeger2 = new Jaeger("Crimson Typhoon", "Mark-4", "China", 
                76.2f,1.722f,9,8,6);

        System.out.println("Модель: " + myJaeger2.getModelName());
        myJaeger2.move();
        System.out.println(myJaeger2.scanKaiju());
        myJaeger2.usePlasmaCannon();
        myJaeger2.leap();
        myJaeger2.setSpeed(3);
        myJaeger2.move();
    }
}