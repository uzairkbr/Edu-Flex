import java.util.ArrayList;
import java.util.List;

public class Course {
    private int id;
    private String title;
    private String description;
    private float price;
    private List<Quiz> quizzes = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    public void addQuiz(Quiz quiz) {
        quizzes.add(quiz);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void issueCertificate(Student student) {
        Certificate certificate = new Certificate(id, this);
        student.addCertificate(certificate);
        System.out.println("Certificate issued to student for course: " + title);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }
}
