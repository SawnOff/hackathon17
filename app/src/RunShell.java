import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RunShell {
  
  public static void parseFile(String fileLoc) {
    
    try {
      File f = new File(fileLoc);
      Scanner sc = new Scanner(f);
      
      String input;
      String output;
      
      input = sc.nextLine();
      output = sc.nextLine();
      
      if (!output.equals("Success")) {
        //TODO: smth
      }
      
    } catch (FileNotFoundException e) {
      //
    }
  }
  
  public static void Terminal() {
    //TODO: make it do somthing
  }
  
}
