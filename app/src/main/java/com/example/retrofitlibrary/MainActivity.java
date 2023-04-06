package com.example.retrofitlibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DevelopersAdapter myAdapter;
    //declare the Developers List
    private List<DeveloperList> developerList;

    //    private static final String URL_DATA =
//            "https://api.github.com/search/users?q=language:java+location:nairobi";
private static final String URL_DATA =
        "https://api.github.com/";

    ListView superListView;
    private ArrayList<UserArray> user_array;


    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        developerList= new ArrayList<>();
        getData();


    }
    public void getData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_DATA)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<UserData> call=request.getJson();
        call.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                user_array = new ArrayList<>(response.body().getUserArray());

                try {
                    for (int i = 0; i < user_array.size(); i++) {
                        DeveloperList developers = new DeveloperList(user_array.get(i).getLogin(),user_array.get(i).getAvatar_url(),
                                user_array.get(i).getHtml_url());
                        developerList.add(developers);
                        Log.d("res","developers"+ developers);
                    }
                    myAdapter = new DevelopersAdapter(developerList, getApplicationContext());
                    recyclerView.setAdapter(myAdapter);
                } catch(Exception e){
                    e.printStackTrace();
                }
                for (int i = 0; i < user_array.size(); i++) {
                    Log.e("success",user_array.get(i).getLogin());
                }
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {

            }
//            @Override
//            public void onResponse(Call<UserData> call, Response<JsonObject> response) {
////                progressDialog.dismiss();
//                Log.e("success", String.valueOf(response));
////                String s= String.valueOf(response. get("username"));
////                JsonArray user_array= response. getAsJsonArray("user_array");
//            }
//
//            @Override
//            public void onFailure(Call<JsonObject> call, Throwable t) {
////                progressDialog.dismiss();
////                Toast.makeText(PrintTicket.this,t.toString(),Toast.LENGTH_SHORT).show();
//            }
//
        });
    }

}