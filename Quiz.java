import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private int id;
    private List<Question> questions = new ArrayList<>();

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void addQuestion(Question question) {
        questions.add(question);
        System.out.println("Question added: " + question.getContent());
    }

    public void gradeQuiz() {
        System.out.println("Quiz graded.");
    }
}
