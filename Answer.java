public class Answer {
  private int id;
  private String content;

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

  @Override
  public String toString() {
      return "Answer{id=" + id + ", content='" + content + "'}";
  }
}
