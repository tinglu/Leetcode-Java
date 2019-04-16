import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Dog implements Comparable<Dog> {
    String name;
    int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int compareTo(Dog dog2) {
        return this.age - dog2.age;
    }
}


class Cat implements Comparator<Cat> {
    String name;
    int age;

    public Cat() {

    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int compare(Cat cat1, Cat cat2) {
        return cat1.age - cat2.age;
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}


public class TestComparator2 {


    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Tommy", 12));
        dogs.add(new Dog("Lulu", 5));
        Collections.sort(dogs);
        for (Dog o : dogs) {
            System.out.println(String.format("%s - %d", o.name, o.age));
        }

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("CatA", 10));
        cats.add(new Cat("CatB", 8));
//        Collections.sort(cats, new Cat());
        cats.sort(new Cat());
        for (Cat o : cats) {
            System.out.println(String.format("%s - %d", o.name, o.age));
        }


        class ComparatorA implements Comparator<Person> {
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        }

        List<Person> people = new ArrayList<>();
        people.add(new Person("PersonA", 32));
        people.add(new Person("PersonB", 20));
        Comparator comp1 = new ComparatorA();
        Collections.sort(people, comp1);
        System.out.println("sorting people ascending...");
        for (Person o : people) {
            System.out.println(String.format("%s - %d", o.name, o.age));
        }


        List<Person> people2 = new ArrayList<>();
        people2.add(new Person("PersonC", 12));
        people2.add(new Person("PersonD", 66));
        Collections.sort(people2, new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o2.age - o1.age;
            }
        });
        System.out.println("sorting people descending...");
        for (Person o : people2) {
            System.out.println(String.format("%s - %d", o.name, o.age));
        }
    }
}
