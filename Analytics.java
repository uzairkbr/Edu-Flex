public class Analytics {
  private int studentEngagement;
  private float courseCompletionRate;

  public void setStudentEngagement(int engagement) {
      this.studentEngagement = engagement;
  }

  public void setCourseCompletionRate(float rate) {
      this.courseCompletionRate = rate;
  }

  public void showEngagementDate() {
      System.out.println("Student engagement: " + studentEngagement + "%");
  }

  public void showCompletionRate() {
      System.out.println("Course completion rate: " + courseCompletionRate + "%");
  }
}
