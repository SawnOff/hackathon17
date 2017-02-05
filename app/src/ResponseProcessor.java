import java.util.List;
import java.lang.Math;
import java.util.ArrayList;

public final class ResponseProcessor {
  
  private static String[] TYPE1_1 = {"To ", "If you want to "};
  private static String[] TYPE1_2 = {" use ", " use the command ", " type ", " type the command "};
  
  private static List<String> errs = new ArrayList<String>();
  private static List<String> cmds = new ArrayList<String>();
  
  //TODO
  private static float diValue = 3;
  
  static String respondToQ(String[] processed) {
    short r1 = (short) Math.floor(Math.random() * TYPE1_1.length);
    short r2 = (short) Math.floor(Math.random() * TYPE1_2.length);
    
    String response = TYPE1_1[r1] + processed[0] + TYPE1_2[r2]
      + processed[1];
    return response;
  }
  
  public static String processCliError(String input, String err, Boolean first) {
    
    if (first) {
      cmds.clear();
      errs.clear();
    }
    
    String cmd = input.split(" ")[0];
    cmds.add(cmd);
    errs.add(err);
    
    if (errs.size() < diValue) {
      return null;
    }
    
    String error = findPopularError();
    
    //TODO: this
    return null;
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
    
    return maxErr;
  }
}