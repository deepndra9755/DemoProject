package com.jacksonTest;

public class StudentApp {
    private Integer id;
    private String name;
    private String enrollment;



    public StudentApp(Integer id, String name, String enrollment) {
        this.id = id;
        this.name = name;
        this.enrollment = enrollment;
    }

    public StudentApp()
    {
     super();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEnrollment() {
        return enrollment;
    }

    @Override
    public String toString() {
        return "StudentApp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", enrollment='" + enrollment + '\'' +
                '}';
    }
}
