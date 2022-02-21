package restaurant.JSON;

import com.google.gson.Gson;
import restaurant.SQL.SQLquery;

import java.io.*;
import java.sql.SQLException;
import java.time.LocalDate;


public class ToJSON {

    public void ConvertToJson(String x) throws SQLException, IOException {

        SQLquery query = new SQLquery();
        Gson gson = new Gson();
        query.CreateSelect(x);
        File rest = null;
        BufferedWriter writer = null;
        try {
            rest = new File("restaurant_" + LocalDate.now() + ".json");
            writer =  new BufferedWriter(new FileWriter(rest));
            writer.write((gson.toJson(query.Get())));
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
