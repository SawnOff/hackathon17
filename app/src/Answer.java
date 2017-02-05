public class Answer {

  private final String command;
  private final String description;
  private final double score;

  public Answer(String command, String description, double score) {
    this.command = command;
    this.description = description;
    this.score = score;
  }

  public String getCommand() {
    return command;
  }

  public String getDescription() {
    return description;
  }

  public double getScore() {
    return score;
  }
}
