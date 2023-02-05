import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Senda {

    /**
     * используй осмысленные имена переменных
     * так легче читать код
     * например a - inn, b -key
     */
    public static String checkOrg(String a, String b) throws IOException {
        List<String> list = new ArrayList<String>(); // так не пишут  среда тебе подсвечивает. List<String> list = new ArrayList();
        list.add("a"); // вообще смысл этого листа???
        list.add("b");
        Stream stream = list.stream(); // переменная неиспользуется. серая. среда подсвечивает
        String c = null;
/**
* такие вещи как строка урл и другие постоянные принято ыносить в константы
 * может даже в отдельный класс  вдруг еще где будешь использовать, и в таком
 * случае урл достаточно булет поменять в одном месте
 * параметры в урле аналогично
 */
        URL url = new URL("https://api-fns.ru/api/egr?req=" + a + "&key=" + b);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);

        /**
         * два блока try и ниодного catch. а что будет если в
         * трвй будет исключительная ситуация?? например нет интернет соединения
         * что получит пользак в ответ?
         */

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
        return c; // опять же если в трай исключение. то в с явно не ожидаемый результат прилитет
    }
}
