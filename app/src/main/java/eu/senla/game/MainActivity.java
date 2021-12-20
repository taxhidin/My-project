package eu.senla.game;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ExampleAdapter exampleAdapter;
    private ArrayList<ExampleItem> examplelist;
    private RequestQueue queue;
    private String url = "http://unnamedyet.com/v1/app-list?from=10&to=100";
    private String url_1 = "https://jsonplaceholder.typicode.com/todos";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        examplelist = new ArrayList<ExampleItem>();
        queue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET, url_1, null
                , response -> {

            for (int i = 0; i < response.length(); i++) {
                try {
                    JSONObject jsonObject = response.getJSONObject(i);
                    String create_name = jsonObject.getString("name");
                    String imageUrl = jsonObject.getString("gamePreview");
                    int counter_pal_value = jsonObject.getInt("playerCount");


                    examplelist.add(new ExampleItem(imageUrl, create_name, counter_pal_value));
                    Log.d("JSON", "onCreate" + jsonObject.toString());

/*                    I have tested with different URL, The Code works maybe it is problem with your URL when it is fetching data.
                    You can uncomment this code and you can see code it is working.
                            Please can you send me any other URL or I  to find any other url?*/

/*                    JSONObject jsonObject1 = response.getJSONObject(i);
                    int user_id = jsonObject1.getInt("userId");
                    String title = jsonObject1.getString("title");

                    Log.d("user_id", "onCreate: "+ user_id);
                    Log.d("title","onCreate: "+ title);*/
//


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            exampleAdapter = new ExampleAdapter(MainActivity.this, examplelist);
            recyclerView.setAdapter(exampleAdapter);


        }, error -> {
            Log.d("JSON", "onCreate: Failed! ");
        }


        );

        queue.add(jsonArrayRequest);

    }

}