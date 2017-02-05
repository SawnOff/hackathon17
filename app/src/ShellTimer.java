import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
  
  public class ShellTimer extends TimerTask {
    
    @Override
    public void run() {
      RunShell.parseFile("output.txt");
    }
    
    // simulate a time consuming task
    private void doSomeWork() {
      try {
        
        Thread.sleep(10000);
        
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    
    public static void activateTimer() {
      
      TimerTask timerTask = new ShellTimer();
      // running timer task as daemon thread
      Timer timer = new Timer(true);
      timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }
    
  }
