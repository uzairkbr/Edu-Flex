import java.util.Date;

public class Certificate {
    private int id;
    private Course course;
    private Date dateIssued;

    public Certificate(int id, Course course) {
        this.id = id;
        this.course = course;
        this.dateIssued = new Date();
    }

    public int getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public Date getDateIssued() {
        return dateIssued;
    }

    @Override
    public String toString() {
        return "Certificate{id=" + id + ", course=" + course.getTitle() + ", dateIssued=" + dateIssued + "}";
    }
}
