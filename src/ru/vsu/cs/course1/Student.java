package ru.vsu.cs.course1;

import com.sun.javafx.binding.StringFormatter;

public class Student {
    public String name;
    public String surname;
    public String patronymic;
    public double score;
    public String sex;
    public int course;


    public Student(String name,String surname, String patronymic, double score, String sex,int course) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.score = score;
        this.sex = sex;
        this.course = course;
    }
    @Override
    public String toString() {
        return String.format("Имя - %5s    Фамилия - %7s    Отчество - %7s    Пол - %5s    Средний бал - %3s    Курс - %d",this.name,this.surname,this.patronymic,this.sex,this.score,this.course);
    }
    public  String[] getMatrixStudent(){
        return new String[] {this.name,this.surname,this.patronymic,String.valueOf(this.score), this.sex,String.valueOf(this.course)};
    }
}

