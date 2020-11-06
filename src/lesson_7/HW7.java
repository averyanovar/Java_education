package lesson_7;

public class HW7 {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Мурзик", 15), new Cat("Васька", 10), new Cat("Вискас", 20)
        };
        Plate plate = new Plate(50, 30);
        System.out.println(plate);


        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat);
        }


        System.out.println(plate);
        plate.add(40);
        System.out.println(plate);


        for (Cat cat : cats) {
            cat.setFullness(false);
            cat.eat(plate);
            System.out.println(cat);
        }
        System.out.println(plate);
    }
}

class Cat {
    protected String name;
    protected int appetite;
    protected boolean fullness;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        fullness = false;
    }

    void setFullness(boolean status) {
        fullness = status;
    }

    void eat(Plate plate) {
        if (!fullness)
            fullness = plate.decreaseFood(appetite);
    }

    @Override
    public String toString() {
        return "{name=" + name + ", appetite=" +
                appetite + ", fullness=" + fullness + "}";
    }
}

class Plate {
    protected int volume;
    protected int food;

    Plate(int volume, int food) {
        this.volume = volume;
        this.food = food;
    }

    boolean decreaseFood(int portion) {
        if (food < portion) return false;
        food -= portion;
        return true;
    }

    void add(int food) {
        if (this.food + food <= volume)
            this.food += food;
    }

    @Override
    public String toString() {
        return "plate: " + food;
    }
}

