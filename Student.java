import java.util.ArrayList;
import java.util.List;

public class Student extends EduFlex {
    private List<Course> enrolledCourses = new ArrayList<>();
    private List<Certificate> certificates = new ArrayList<>();

    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
        course.addStudent(this);
        System.out.println("Enrolled in course: " + course.getTitle());
    }

    public void viewProgress() {
        System.out.println("Viewing progress for enrolled courses...");
        for (Course course : enrolledCourses) {
            System.out.println("Course: " + course.getTitle());
        }
    }

    public void leaveReview(Review review) {
        System.out.println("Review left: Rating " + review.getRating() + ", Comment: " + review.getComment());
    }

    public void addCertificate(Certificate certificate) {
        certificates.add(certificate);
        System.out.println("Certificate added: " + certificate);
    }
}
