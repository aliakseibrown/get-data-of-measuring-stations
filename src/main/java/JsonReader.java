import org.json.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.json.simple.JSONObject;

public class JsonReader {

    public static void makeJsonFile(String str) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter out = null;
        try {
            fw = new FileWriter("output.json", true);
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);
            out.println(str);
            out.close();
            System.out.println("file \"output.json\" has been created ");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("file couldn't be created");
            }
        }

        public static List<String> getValuesForGivenKey(String jsonArrayStr, String key) {
        JSONArray jsonArray = new JSONArray(jsonArrayStr);
        return IntStream.range(0, jsonArray.length())
                .mapToObj(index -> ((org.json.JSONObject)jsonArray.get(index)).optString(key))
                .collect(Collectors.toList());
    }
}

// [{
//        "id": 14,
//        "stationName": "Działoszyn",
//        "gegrLat": "50.972167",
//        "gegrLon": "14.941319",
//        "city": {
//        "id": 192,
//        "name": "Działoszyn",
//        "commune": {
//        "communeName": "Bogatynia",
//        "districtName": "zgorzelecki",
//        "provinceName": "DOLNOŚLĄSKIE"
//        }
//        },
//        "addressStreet": null
//        }]