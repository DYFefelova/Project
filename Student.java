package com.company;

import java.util.Objects;

public class Student {
    private String name;
    private int courseNum;
    private int score;
    private boolean isPassed;

    public Student() {
    }

    public Student(String name, int courseNum, int score, boolean isPassed) {
        this.name = name;
        this.courseNum = courseNum;
        this.score = score;
        this.isPassed = isPassed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(int courseNum) {
        this.courseNum = courseNum;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return courseNum == student.courseNum && score == student.score && isPassed == student.isPassed && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, courseNum, score, isPassed);
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name='" + name + '\'' +
                ", courseNum=" + courseNum +
                ", score=" + score +
                ", isPassed=" + isPassed +
                '}';
    }
}
