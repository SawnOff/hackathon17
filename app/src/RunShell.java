import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RunShell {
  
  static String response;
  
  public static void parseFile(String fileLoc) {
    
    try {
      File f = new File(fileLoc);
      Scanner sc = new Scanner(f);
      
      String input;
      String output;
      
      input = sc.nextLine();
      if (sc.hasNextLine()) {
        output = sc.nextLine();
        response = ResponseProcessor.processCliError(output);
      } else {
        output = "";
      }
    } catch (FileNotFoundException e) {
      //
    }
  }
  
  public static String getResponse() {
    return response;
  }
  public static void Terminal() {
    //TODO: make it do somthing
  }
  
}
