package com.company;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String FILE_SOURCE = "resource/students.csv"; //имя файла
        StudentSearcher studentSearcher = new StudentSearcher();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_SOURCE))){
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals("Студент;Курс;Баллы;Сдал/Не сдал"))
                    continue;
                String[] row = line.split(";");
                Student student = new Student();
                for(int i = 0; i < row.length; i++) {
                    switch (i) {
                        case 0:
                            student.setName(row[i]);
                            break;
                        case 1:
                            student.setCourseNum(Integer.parseInt(row[i]));
                            break;
                        case 2:
                            student.setScore(Integer.parseInt(row[i]));
                            break;
                        case 3:
                            student.setPassed(row[i].equals("сдал"));
                            break;
                        default:
                            break;
                    }
                }

                studentSearcher.addStudent(student);
            }
        } catch (IOException e) {
            System.out.println("Ошибка работы" + e.getLocalizedMessage());
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите фамилию студента:");
            String next = scanner.next();
            if (next.equals("exit")) {
                System.out.println("exit from program");
                break;
            }

            if (next == null || next.isEmpty()) {
                System.out.println("Введена пустая строка");
                continue;
            }

            List<Student> students = studentSearcher.getStudent(next);
            if (students.isEmpty()) {
                System.out.println("Не найден");
            }

            for (Student student : students) {
                System.out.println(student.toString());
            }
        }
    }
}
