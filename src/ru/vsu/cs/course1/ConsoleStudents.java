package ru.vsu.cs.course1;

import ru.vsu.cs.util.ArrayUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ConsoleStudents {
    public static List<Course> fileToList(String inputFileName) throws FileNotFoundException {
        List<Course> courses = new ArrayList<Course>();
        String[] matrixResult = ArrayUtils.readLinesFromFile(inputFileName);
        Course course1 = new Course(1);
        Course course2 = new Course(2);
        Course course3 = new Course(3);
        Course course4 = new Course(4);
        for (int i = 0; i < matrixResult.length; i++) {
            String[] splitedMatrixResult = matrixResult[i].split(" ");
            String name = splitedMatrixResult[0];
            String surname = splitedMatrixResult[1];
            String patronymic = splitedMatrixResult[2];
            String sex = splitedMatrixResult[3];
            double score = Double.parseDouble(splitedMatrixResult[4]);
            int col = Integer.parseInt(splitedMatrixResult[5]);

            switch (col) {
                case 1:
                    course1.addStudent(new Student(name, surname, patronymic, score, sex));
                    break;
                case 2:
                    course2.addStudent(new Student(name, surname, patronymic, score, sex));
                    break;
                case 3:
                    course3.addStudent(new Student(name, surname, patronymic, score, sex));
                    break;
                case 4:
                    course4.addStudent(new Student(name, surname, patronymic, score, sex));
                    break;
            }
        }
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
        return courses;
    }
}
