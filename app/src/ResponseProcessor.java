import java.lang.Math;

public final class ResponseProcessor {

	private final String[] TYPE1_1 = { "To ", "If you want to " };
	private final String[] TYPE1_2 = { " use ", " use the command ", " type ", " type the command " };

	private static String[] errCodes = new String[3];

  public static String respondToQ(Query processed) {
  	float r1 = Math.floor( Math.random() * TYPE1_1.length );
  	float r2 = Math.floor( Math.random() * TYPE1_2.length );

  	String response = TYPE1_1[r1] + processed.desc + TYPE1_2[r2]
  		+ processed.cmd + "\n\n" + processed.man;

  	return response;
  }

  public static String processCliError(String input, String err, Bool first) {
  	String cmd = input.split(' ')[0];

  	return "";
  }
}
