package br.com.letscode.entity;

import static java.lang.Integer.parseInt;

public class Actor implements Comparable{
    private final int id;
    private final int year;
    private final int age;
    private final String name;
    private final String movie;

    public Actor(int id, int year, int age, String name, String movie){
        this.id = id;
        this.year = year;
        this.age = age;
        this.name = name;
        this.movie = movie;
    }

    public static Actor fromLine(String line){
        String[] split = line.split(";");//regex ,(?=\S)
        return new Actor(
                parseInt(split[0]),
                parseInt(split[1].replace(" ", "")),
                parseInt(split[2].replace(" ", "")),
                split[3].substring(1),
                split[4].substring(1)
        );
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMovie() {
        return movie;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id='" + id + '\'' +
                ", year='" + year + '\'' +
                ", age='" + age + '\'' +
                ", name='" + name + '\'' +
                ", movie='" + movie + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object other) {
        Actor ator = (Actor) other;
        return Integer.compare(this.age, ator.age);
    }
}
