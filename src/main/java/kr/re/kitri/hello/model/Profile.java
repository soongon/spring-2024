package kr.re.kitri.hello.model;

public class Profile {
    private long id;
    private String name;
    private String gender;
    private String grade;

    public Profile() {}

    public Profile(long id, String name, String gender, String grade) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.grade = grade;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
