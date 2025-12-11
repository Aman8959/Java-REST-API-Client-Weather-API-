import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeatherAPIClientSatna {

    public static void main(String[] args) {
        try {
            String apiURL = "https://api.open-meteo.com/v1/forecast?latitude=24.60&longitude=80.85&current_weather=true";

            URL url = new URL(apiURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder jsonResponse = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                jsonResponse.append(line);
            }
            conn.disconnect();

            String json = jsonResponse.toString();

           
            String cwJson = extractCurrentWeatherBlock(json);

            
            String temperature = findRegex(cwJson, "\"temperature\"\\s*:\\s*([+-]?\\d+(?:\\.\\d+)?)");
            String windspeed   = findRegex(cwJson, "\"windspeed\"\\s*:\\s*([+-]?\\d+(?:\\.\\d+)?)");
            String time        = findRegex(cwJson, "\"time\"\\s*:\\s*\"([^\"]+)\"");

            if (temperature == null) temperature = "N/A";
            if (windspeed == null) windspeed = "N/A";
            if (time == null) time = "N/A";

            
            System.out.println("🌦️ WEATHER REPORT – SATNA (M.P.)");
            System.out.println("------------------------------------");
            System.out.println("Temperature : " + temperature + " °C");
            System.out.println("Wind Speed  : " + windspeed + " km/h");
            System.out.println("Time        : " + time);
            System.out.println("------------------------------------");

        } catch (Exception e) {
            System.out.println("Error fetching data: " + e.getMessage());
        }
    }

    
    private static String extractCurrentWeatherBlock(String json) {
        String key = "\"current_weather\"";
        int idx = json.indexOf(key);
        if (idx == -1) return "";

        
        int braceStart = json.indexOf('{', idx);
        if (braceStart == -1) return "";

        int i = braceStart;
        int depth = 0;
        for (; i < json.length(); i++) {
            char c = json.charAt(i);
            if (c == '{') depth++;
            else if (c == '}') {
                depth--;
                if (depth == 0) {
                   
                    return json.substring(braceStart, i + 1);
                }
            }
        }
        return "";
    }

    
    private static String findRegex(String text, String patternStr) {
        if (text == null || text.isEmpty()) return null;
        Pattern p = Pattern.compile(patternStr);
        Matcher m = p.matcher(text);
        if (m.find()) {
            return m.group(1);
        }
        return null;
    }
}
