package ru.vsu.cs.course1;

import com.sun.javafx.binding.StringFormatter;

public class Student {
    public String name;
    public double score;
    public String sex;

    public Student(String name, double score, String sex) {
        this.name = name;
        this.score = score;
        this.sex = sex;
    }
    @Override
    public String toString() {
        return String.format("Имя - %7s    Пол - %7s    Средний бал - %3s",this.name,this.sex,this.score);
    }
}

