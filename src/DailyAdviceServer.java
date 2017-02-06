import java.io.*;
import java.net.*;

/**
 * Borrowed from Head First Java, p484
 */
public class DailyAdviceServer {

  public String[] adviceList = {"take smaller bites.", "go for looser jeans.", "get a " +
      "new haircut.", " get some exercise.", "eat your wheaties.", "relax more", "read more."};

  public void go() {
    try {
      ServerSocket serverSocket = new ServerSocket(8242);
      while (true) {
        Socket socket = serverSocket.accept();
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        String advice = getAdvice();
        writer.println(advice);
        writer.close();
        System.out.println(advice);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private String getAdvice() {
    int random = (int) (Math.random() * adviceList.length);
    return adviceList[random];
  }

  public static void main(String[] args) {
	  DailyAdviceServer server = new DailyAdviceServer();
	  server.go();
   }
}
