import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class HttpClient {
    private final String url;
    private final int port;
    private final String requestTarget;

    public HttpClient(String url, int port, String requestTarget) {
        this.url = url;
        this.port = port;
        this.requestTarget = requestTarget;
    }

    private void execute() throws IOException {
        var socket = new Socket("httpbin.org", 80);
        socket.getOutputStream().write((
                "GET /html HTTP/1.1\r\n" +
                        "Connection: close\r\n" +
                        "Host: httpbin.org\r\n" +
                        "\r\n"
        ).getBytes());

        int c;

        while((c = socket.getInputStream().read()) != -1) {
            System.out.print((char) c);
        }
    }

    public int getStatusCode() {
        return 200;
    }
}
