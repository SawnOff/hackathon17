import java.util.List;
import java.lang.Math;
import java.util.ArrayList;

public final class ResponseProcessor {
  
  private static String[] TYPE1_1 = {"To ", "If you want to "};
  private static String[] TYPE1_2 = {" use ", " use the command ", " type ", " type the command "};
  
  private static List<String> errs = new ArrayList<String>();
  
  private static float diValue = 3;
  
  static String respondToQ(Answer processed) {
    short r1 = (short) Math.floor(Math.random() * TYPE1_1.length);
    short r2 = (short) Math.floor(Math.random() * TYPE1_2.length);

    if (processed.getScore() < 50) {
      return "I didn't understand your question.";
    }
    
    String response = TYPE1_1[r1] + processed.getDescription() + TYPE1_2[r2]
      + processed.getCommand();
    return response;
  }
  
  public static String processCliError(String output) {
    
  String[] arr = output.split(":");
    String error = arr[arr.length - 1];
    
    if (error != " not found" && error != " missing operand") {
      return null;
    }
    
    errs.add(output);
    
    if (errs.size() < diValue) {
      return null;
    }
    
    String[] errorSplit = findPopularError().split(":");
    error = errorSplit[errorSplit.length - 1];
    
    diValue *= 1.1;

    switch (error) {
    case " not found":
      return "Try asking me for help";
    case " missing operand":
      return "Use man " + arr[0] + " to find out more";
    default:
      return "You really fucked up: " + error;
  }
    
  }
  
  private static String findPopularError() {
    short maxErrReps = 0;
    String maxErr = "";
    
    short curErrReps = 0;
    String curErr = "";
    
    errs.remove(curErr);
    
    while (!errs.isEmpty()) {
      if (errs.contains(curErr)) {
        curErrReps++;
        errs.remove(curErr);
      } else {
        if (curErrReps >= maxErrReps) {
          maxErrReps = curErrReps;
          maxErr = curErr;
        }
        
        curErrReps = 1;
        curErr = errs.get(0);
        errs.remove(curErr);
      }
    }
    errs.clear();
    return maxErr;
  }
}