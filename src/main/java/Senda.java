import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Senda {

    public static String checkOrg(String a, String b) throws IOException {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        Stream stream = list.stream();
        String c = null;

        URL url = new URL("https://api-fns.ru/api/egr?req=" + a + "&key=" + b);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);

        try (OutputStream output = connection.getOutputStream();
             PrintStream sender = new PrintStream(output)) {
            sender.println(a);
        }

        try (InputStream input = connection.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            while (reader.ready()) {
                //           System.out.println(reader.readLine());
                c = reader.readLine();
                return c;
            }
        }
        return c;
    }
}
