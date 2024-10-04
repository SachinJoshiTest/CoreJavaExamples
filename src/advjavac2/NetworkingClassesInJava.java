package advjavac2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class NetworkingClassesInJava {
    public static void main(String[] args) throws IOException, URISyntaxException {
        URL google = new URL("https://www.google.com");
        System.out.println(google.getHost());
        System.out.println(google.getPort());
        System.out.println(google.getContent());
        System.out.println(google.getPath());
        System.out.println(google.getProtocol());


        URI googleURI = new URI("https://www.google.com");
        System.out.println(googleURI.getHost());
        System.out.println(googleURI.getPort());


        // Connect to googe.com and read data
        HttpURLConnection googleConn = (HttpURLConnection) google.openConnection();
        googleConn.setRequestMethod("GET");

        BufferedReader br = new BufferedReader(new InputStreamReader(googleConn.getInputStream()));
        String input;
        while((input=br.readLine()) != null){
            System.out.println(input);
        }
    }
}
