package ru.vsu.cs.course1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static List<Student> solution(List<Course> courses, int N, double X) {
        /*
        Перебираю по курсам
        Получаю список студентов курса
        Если студентов больше чем N то
            Если score > X то запоминаю в result этого студента
            Уменьшаю N на кол-во уже отчисленных
        Иначе скип
        Ну и возвращаю список студентов не отчисленных
         */
        List<Student> result = new ArrayList<Student>();
        for (Course course : courses) {
            List<Student> students = course.getStudents();
            students.sort(Comparator.comparingDouble(student -> student.score));// надо разобраться как это работает
            if (students.size() - N > 0) {
                int k = 0;
                for (Student student : students) {
                    if ((student.score < X && k < N) || (student.score >= X && k >= N)) {
                        k++;
                    }
                    else{
                        result.add(student);
                    }
                }
                N -= k;
            }
            else continue;
        }
        return result;
    }
}
