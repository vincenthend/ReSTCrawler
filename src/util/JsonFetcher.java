package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Kelas JsonFetcher, mengambil data JSON dari URL tertentu.
 *
 * @author Vincent Hendryanto Halim / 13515089
 */
public class JsonFetcher {

  /**
   * Mengambil data JSON dari lokasi URL tertentu.
   *
   * @param link URL lokasi file JSON
   * @return JSONObject berisi data JSON dari URL
   */
  public static String getJsonString(String link) {
    StringBuilder jsonString = new StringBuilder();
    HttpURLConnection connection;
    try {
      connection = (HttpURLConnection) new URL(link).openConnection();
      connection.setRequestMethod("GET");
      connection.connect();
      int response = connection.getResponseCode();
      if (response == 200 || response == 201) {
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(connection.getInputStream()));
        String line;
        line = reader.readLine();
        while (line != null) {
          jsonString.append(line);
          line = reader.readLine();
        }
        reader.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return jsonString.toString();
  }
}
