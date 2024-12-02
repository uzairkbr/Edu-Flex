import java.util.ArrayList;
import java.util.List;

public class Student extends EduFlex {
    private List<Course> enrolledCourses = new ArrayList<>();
    private List<Certificate> certificates = new ArrayList<>();

    public void enrollInCourse(Course course) {
        if (!isEnrolled(course)) {
            enrolledCourses.add(course);
            course.addStudent(this);
            System.out.println("Enrolled in course: " + course.getTitle());
        } else {
            System.out.println("You are already enrolled in this course: " + course.getTitle());
        }
    }

    public boolean isEnrolled(Course course) {
        return enrolledCourses.contains(course);
    }

    public void viewProgress() {
        if (enrolledCourses.isEmpty()) {
            System.out.println("You are not enrolled in any courses.");
        } else {
            System.out.println("Viewing progress for enrolled courses:");
            for (Course course : enrolledCourses) {
                System.out.println("- Course: " + course.getTitle());
            }
        }
    }

    public void leaveReview(Course course, Review review) {
        if (isEnrolled(course)) {
            System.out.println("Review left for course: " + course.getTitle());
            System.out.println("Rating: " + review.getRating() + ", Comment: " + review.getComment());
        } else {
            System.out.println("You can only leave reviews for courses you are enrolled in.");
        }
    }

    public void addCertificate(Certificate certificate) {
        certificates.add(certificate);
        System.out.println("Certificate added for course: " + certificate.getCourse().getTitle());
    }
}
