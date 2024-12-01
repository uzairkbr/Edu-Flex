import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean exit = false;

    List<Admin> admins = new ArrayList<>();
    List<Instructor> instructors = new ArrayList<>();
    List<Student> students = new ArrayList<>();

    List<Course> courses = new ArrayList<>();
    List<Quiz> quizzes = new ArrayList<>();

    while (!exit) {
      System.out.println("\n\n--- EduFlex Menu ---\n");
      System.out.println("1. Create Account");
      System.out.println("2. Log In");
      System.out.println("3. Show Registered Users");
      System.out.println("4. Exit");
      System.out.print("Select an option (1-4): ");

      int choice = scanner.nextInt();
      scanner.nextLine();

      if (choice == 1) {
        System.out.println("\n\n--- Create Account ---\n");
        System.out.println("1. Admin Account");
        System.out.println("2. Instructor Account");
        System.out.println("3. Student Account");
        System.out.print("Select an account type (1-3): ");
        int accountType = scanner.nextInt();
        scanner.nextLine();

        System.out.print("\nEnter your name: ");
        String name = scanner.nextLine();

        String email;
        while (true) {
          System.out.print("Enter your email: ");
          email = scanner.nextLine();
          if (isValidEmail(email)) {
            break;
          } else {
            System.out.println("Invalid email! \nPlease ensure it ends with '@gmail.com' and is correctly formatted.");
          }
        }

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (accountType == 1) {
          Admin admin = new Admin();
          admin.setName(name);
          admin.setEmail(email);
          admin.setPassword(password);
          admins.add(admin);
          System.out.println("\nAdmin account created successfully!");
        } else if (accountType == 2) {
          Instructor instructor = new Instructor();
          instructor.setName(name);
          instructor.setEmail(email);
          instructor.setPassword(password);
          instructors.add(instructor);
          System.out.println("\nInstructor account created successfully!");
        } else if (accountType == 3) {
          Student student = new Student();
          student.setName(name);
          student.setEmail(email);
          student.setPassword(password);
          students.add(student);
          System.out.println("\nStudent account created successfully!");
        } else {
          System.out.println("\nInvalid account type selected.");
        }
      } else if (choice == 2) {
        System.out.println("\n--- Log In ---\n");
        System.out.print("Enter your email: ");
        String loginEmail = scanner.nextLine();
        System.out.print("Enter your password: ");
        String loginPassword = scanner.nextLine();

        boolean loggedIn = false;

        for (Admin admin : admins) {
          if (admin.getEmail().equals(loginEmail) && admin.getPassword().equals(loginPassword)) {
            loggedIn = true;
            adminMenu(scanner, admin);
            break;
          }
        }

        if (!loggedIn) {
          for (Instructor instructor : instructors) {
            if (instructor.getEmail().equals(loginEmail) && instructor.getPassword().equals(loginPassword)) {
              loggedIn = true;
              instructorMenu(scanner, instructor, courses);
              break;
            }
          }
        }

        if (!loggedIn) {
          for (Student student : students) {
            if (student.getEmail().equals(loginEmail) && student.getPassword().equals(loginPassword)) {
              loggedIn = true;
              studentMenu(scanner, student, courses, quizzes);
              break;
            }
          }
        }

        if (!loggedIn) {
          System.out.println("\nInvalid email or password. Please try again.");
        }
      } else if (choice == 3) {
        System.out.println("\n\n--- Registered Users ---\n");
        printTable("Admins", admins);
        printTable("Instructors", instructors);
        printTable("Students", students);
      } else if (choice == 4) {
        System.out.println("\nExiting the program. Thank you for using EduFlex!");
        exit = true;
      } else {
        System.out.println("\nInvalid choice. Please select a valid option.");
      }
    }

    scanner.close();
  }

  private static boolean isValidEmail(String email) {
    String emailRegex = "^[A-Za-z0-9._%+-]+@gmail\\.com$";
    return Pattern.matches(emailRegex, email);
  }

  private static void adminMenu(Scanner scanner, Admin admin) {
    System.out.println("\n\n--- Admin Menu ---");
    admin.login();
    System.out.println("1. Manage Users");
    System.out.println("2. View Platform Stats");
    System.out.println("3. Approve Courses");
    System.out.println("4. Log Out");
    System.out.print("Select an option (1-4): ");
    int choice = scanner.nextInt();

    if (choice == 1) {
      admin.manageUsers();
    } else if (choice == 2) {
      admin.viewPlateformStats();
    } else if (choice == 3) {
      admin.approveCourse();
    } else if (choice == 4) {
      admin.logout();
    } else {
      System.out.println("Invalid option selected.");
    }
  }

  private static void instructorMenu(Scanner scanner, Instructor instructor, List<Course> courses) {
    System.out.println("\n\n--- Instructor Menu ---");
    instructor.login();
    System.out.println("1. Create Course");
    System.out.println("2. Manage Courses");
    System.out.println("3. View Analytics");
    System.out.println("4. Log Out");
    System.out.print("Select an option (1-4): ");
    int choice = scanner.nextInt();
    scanner.nextLine();

    if (choice == 1) {
      System.out.print("Enter course title: ");
      String title = scanner.nextLine();
      System.out.print("Enter course description: ");
      String description = scanner.nextLine();
      Course course = new Course();
      course.setTitle(title);
      course.setDescription(description);
      courses.add(course);
      instructor.createCourse(course);
    } else if (choice == 2) {
      for (Course c : courses) {
        instructor.manageCourse(c);
      }
    } else if (choice == 3) {
      for (Course c : courses) {
        instructor.getAnalytics(c);
      }
    } else if (choice == 4) {
      instructor.logout();
    } else {
      System.out.println("Invalid option selected.");
    }
  }

  private static void studentMenu(Scanner scanner, Student student, List<Course> courses, List<Quiz> quizzes) {
    System.out.println("\n--- Student Menu ---");
    student.login();
    System.out.println("1. Enroll in a Course");
    System.out.println("2. View Progress");
    System.out.println("3. Take Quiz");
    System.out.println("4. Leave Review");
    System.out.println("5. Log Out");
    System.out.print("Select an option (1-5): ");
    int choice = scanner.nextInt();
    scanner.nextLine();

    if (choice == 1) {
      System.out.println("Available courses:");
      for (Course c : courses) {
        System.out.println("- " + c.getTitle());
      }
      System.out.print("Enter course title to enroll: ");
      String courseTitle = scanner.nextLine();
      for (Course c : courses) {
        if (c.getTitle().equalsIgnoreCase(courseTitle)) {
          student.enrollInCourse(c);
          break;
        }
      }
    } else if (choice == 2) {
      student.viewProgress();
    } else if (choice == 3) {
      for (Quiz q : quizzes) {
        q.gradeQuiz();
      }
    } else if (choice == 4) {
      System.out.print("Enter your review: ");
      String comment = scanner.nextLine();
      System.out.print("Enter your rating (1-5): ");
      int rating = scanner.nextInt();
      Review review = new Review();
      review.setComment(comment);
      review.setRating(rating);
      student.leaveReview(review);
    } else if (choice == 5) {
      student.logout();
    } else {
      System.out.println("Invalid option selected.");
    }
  }

  private static void printTable(String title, List<? extends EduFlex> users) {
    System.out.println("\n" + title + ":");
    if (users.isEmpty()) {
      System.out.println("  No users registered.");
    } else {
      System.out.println("  -----------------------------------------");
      System.out.printf("  | %-3s | %-20s | %-30s |\n", "No.", "Username", "Email");
      System.out.println("  -----------------------------------------");
      int index = 1;
      for (EduFlex user : users) {
        System.out.printf("  | %-3d | %-20s | %-30s |\n", index++, user.getName(), user.getEmail());
      }
      System.out.println("  -----------------------------------------");
    }
  }
}
