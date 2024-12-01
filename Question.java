public class Question {
  private int id;
  private String content;
  private Answer correctAnswer;

  public void setId(int id) {
      this.id = id;
  }

  public int getId() {
      return id;
  }

  public void setContent(String content) {
      this.content = content;
  }

  public String getContent() {
      return content;
  }

  public void setCorrectAnswer(Answer answer) {
      this.correctAnswer = answer;
  }

  public Answer getCorrectAnswer() {
      return correctAnswer;
  }
}
