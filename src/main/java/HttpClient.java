import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class HttpClient {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        var sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, null, null);
        var socket = sslContext
            .getSocketFactory()
            .createSocket("www.rfc-editor.org", 443);

        socket.getOutputStream().write((
            "GET /rfc/rfc7230 HTTP/1.1\r\n" +
            "Connection: close\r\n" +
            "Host: www.rfc-editor.org\r\n" +
            "\r\n"
        ).getBytes());

        int c;

        while((c = socket.getInputStream().read()) != -1) {
            System.out.print((char) c);
        }
    }
}
