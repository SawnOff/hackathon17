import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RunShellCommandFromJava {
  
  public static void executeCommand(String command) {
    
    try {
      Process proc = Runtime.getRuntime().exec(command);
      // Read the output
      BufferedReader reader =
          new BufferedReader(new InputStreamReader(proc.getInputStream()));
      String line = "";
      while ((line = reader.readLine()) != null) {
        System.out.print(line + "\n");
      }
      proc.waitFor();
    } catch (IOException | InterruptedException e) {
      //
    }
  }
  
  private static String sugarPath(String path) {
    String result = path.substring(path.indexOf("/") + 1);
    String withName = result.substring(result.indexOf("/") + 1);
    return "~/" + withName.substring(withName.indexOf("/") + 1);
  }
  
  public static void Terminal() {
    Scanner sc = new Scanner(System.in);
    String current;
    String newLoc;
    try {
  
      System.out.print("clippy:@");
      current = new java.io.File(".").getCanonicalPath();
      current = sugarPath(current);
      System.out.print(current + "$ ");
      
      while (true) {
        String input = sc.nextLine();
        try {
          if (input.substring(0, input.indexOf(" ")).equals("cd")) {
            newLoc = input.substring(input.indexOf(" ") + 1);
            System.out.print("clippy:@");
            System.out.print(newLoc + "$ ");
  
          } else {
            executeCommand(input);
            System.out.print("clippy:@");
            current = new java.io.File(".").getCanonicalPath();
            current = sugarPath(current);
            System.out.print(current + "$ ");
            
          }
        } catch (ArrayIndexOutOfBoundsException e) {
          System.out.println("CUNT!");
        }
      }
    } catch (Exception e) {
      //
    }
    System.out.println();
  }
  
}