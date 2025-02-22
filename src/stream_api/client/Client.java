package stream_api.client;

import java.util.Objects;

import static stream_api.client.GenderType.FEMALE;
import static stream_api.client.GenderType.MALE;

public class Client {
    private int id;
    private String gender;
    private String name;
    private String surname;
    private int age;
    private String job;
    private double salary;


    public Client() {
    }


    public Client(int id, String gender, String name, String surname, int age, String job, double salary) {
        this.setId(id);
        this.setGender(gender);
        this.name = name;
        this.surname = surname;
        this.setAge(age);
        this.job = job;
        this.setSalary(salary);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 1) {
            throw new IllegalArgumentException("ID не может быть меньше 1");
        } else {
            this.id = id;
        }
    }

    public String getGender() {
        return gender;
    }

    private void setGender(String gender) {
        if (gender.equalsIgnoreCase(MALE.getGenderType())) {
            this.gender = MALE.getGenderType();
        } else if (gender.equalsIgnoreCase(FEMALE.getGenderType())) {
            this.gender = FEMALE.getGenderType();
        } else {
            throw new IllegalArgumentException("Пол может быть \"Мужской\" или \"Женский\"");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFullName() {
        return this.name + " " + this.surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Возраст должен быть в диапазоне от 0 до 150");
        }
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Зарплата не может быть отрицательной");
        }
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Client client)) {
            return false;
        }
        return id == client.id
                && age == client.age
                && Double.compare(salary, client.salary) == 0
                && Objects.equals(gender, client.gender)
                && Objects.equals(name, client.name)
                && Objects.equals(surname, client.surname)
                && Objects.equals(job, client.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gender, name, surname, age, job, salary);
    }
}
