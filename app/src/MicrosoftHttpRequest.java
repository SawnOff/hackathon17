import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

final class MicrosoftHttpRequest {

  public static Answer sendText(String txt) {
    HttpURLConnection con = null;
    
    try {
      String urlStr = "http://h17.duckdns.org/request.php";
      URL url = new URL(urlStr);
      con = (HttpURLConnection) url.openConnection();
      
      con.setRequestMethod("POST");
      
      String urlParameters = "text=" + txt;
      
      con.setDoOutput(true);
      DataOutputStream wr = new DataOutputStream(con.getOutputStream());
      wr.writeBytes(urlParameters);
      wr.flush();
      wr.close();
      
      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
      String inputLine;
      StringBuffer response = new StringBuffer();
      
      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();

      String resp = response.toString();
      JSONObject obj = new JSONObject(resp);

      String[] ans = obj.getString("answer").split(":");
      Double score = obj.getDouble("score");

      return new Answer(ans[0], ans[1], score);

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    } finally {
      if (con != null) {
        con.disconnect();
      }
    }
  }
  
}
