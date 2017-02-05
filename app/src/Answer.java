public class Answer {

  private final String command;
  private final String theOtherOne;
  private final double theNumberOne;

  public Answer(String command, String theOtherOne, double theNumberOne) {
    this.command = command;
    this.theOtherOne = theOtherOne;
    this.theNumberOne = theNumberOne;
  }

  public String getCommand() {
    return command;
  }

  public String getTheOtherOne() {
    return theOtherOne;
  }

  public double getTheNumberOne() {
    return theNumberOne;
  }
}
