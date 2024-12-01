import java.util.ArrayList;
import java.util.List;

public class Instructor extends EduFlex {
    private List<Course> createdCourses = new ArrayList<>();

    public void createCourse(Course course) {
        createdCourses.add(course);
        System.out.println("Course created: " + course.getTitle());
    }

    public void manageCourse(Course course) {
        System.out.println("Managing course: " + course.getTitle());
    }

    public void getAnalytics(Course course) {
        System.out.println("Getting analytics for course: " + course.getTitle());
    }
}
