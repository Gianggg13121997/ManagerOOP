package object;

import java.util.ArrayList;

public class Student {
    int id;
    String name;
    int age;
    ArrayList<Integer> score;

    public Student(int id, String name, int age, ArrayList<Integer> score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = new ArrayList<>(score);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Integer> getScore() {
        return score;
    }

    public void setScore(ArrayList<Integer> score) {
        this.score = score;
    }
}
