import java.io.*;
import java.net.*;

/**
 *
 */
public class DailyAdviceClient {

  public void go() {
    try {
      Socket socket = new Socket("127.0.0.1", 8242);
      InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
      BufferedReader bufferedReader = new BufferedReader(streamReader);
      String advice = bufferedReader.readLine();

      System.out.println("Good day! Today you should " + advice);

      bufferedReader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    DailyAdviceClient client = new DailyAdviceClient();
    client.go();
  }
}
