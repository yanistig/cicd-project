package entities;

public class Client {

    private String firstname;
    private String lastname;
    private int age;
    private String job;
    private int height;
    private int weight;
    private String city;

    public Client(String firstname, String lastName, int age, String job, int height, int weight, String city) {
        this.firstname = firstname;
        this.lastname = lastName;
        this.age = age;
        this.job = job;
        this.height = height;
        this.weight = weight;
        this.city = city;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstname + '\'' +
                ", lastName='" + lastname + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", city='" + city + '\'' +
                '}';
    }
}
