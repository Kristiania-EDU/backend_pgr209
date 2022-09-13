import java.io.IOException;
import java.net.Socket;

public class HttpClient {
    public static void main(String[] args) throws IOException {
        var socket = new Socket("www.rfc-editor.org", 80);

        socket.getOutputStream().write((
                "GET /rfc/rfc7230 HTTP/1.1\r\n" +
                        "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9\r\n" +
                        "Accept-Encoding: gzip, deflate, br\r\n" +
                        "Accept-Language: nb,no;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6\n" +
                        "Cache-Control: max-age=0\r\n" +
                        "Connection: keep-alive\r\n" +
                        "Host: www.rfc-editor.org\r\n" +
                        "Sec-Fetch-Dest: document\r\n" +
                        "Sec-Fetch-Mode: navigate\r\n" +
                        "Sec-Fetch-Site: none\r\n" +
                        "Sec-Fetch-User: ?1\r\n" +
                        "Upgrade-Insecure-Requests: 1\r\n" +
                        "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36 Edg/105.0.1343.33\r\n" +
                        "sec-ch-ua: \"Microsoft Edge\";v=\"105\", \" Not;A Brand\";v=\"99\", \"Chromium\";v=\"105\"\r\n" +
                        "sec-ch-ua-mobile: ?0"
        ).getBytes());


        int c;

        while((c = socket.getInputStream().read()) != -1) {
            System.out.print((char) c);
        }
    }
}
