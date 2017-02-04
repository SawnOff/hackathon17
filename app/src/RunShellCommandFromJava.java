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

    }
  }

  public static void main(String[] args) {
//    executeCommand("cd ~");
    Scanner sc = new Scanner(System.in);
    String current;
    try {
      for (int i = 0; true; i++) {
        System.out.print("> CLIPPY:~ ");
        current = new java.io.File(".").getCanonicalPath();
        System.out.print(current + "$ ");
        executeCommand(sc.nextLine());
      }
    } catch (IOException e) {

    }
    System.out.println();
  }

}