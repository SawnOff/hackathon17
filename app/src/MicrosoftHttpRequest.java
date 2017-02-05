import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

final class MicrosoftHttpRequest {

  static String[] sendText(String txt) {
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

      String str = response.toString().split(",")[0];
      String trimmed = str.substring(11, str.length() - 1);

      return trimmed.split(":");
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
