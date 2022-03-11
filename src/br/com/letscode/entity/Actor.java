package br.com.letscode.entity;

import static java.lang.Integer.parseInt;

public class Actor implements Comparable{
    private int id;
    private int year;
    private int age;
    private String name;
    private String movie;

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

    public int getId() {return id;}

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

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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
        if(this.age < ator.age){
            return -1;
        }
        if(this.age > ator.age){
            return 1;
        }
        return 0;
    }
}
