package com.example.ihateprogrammingavz;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RepairRequestAdapter adapter;
    private SupabaseService supabaseService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String baseUrl = "https://azfpxmllywzanltckntr.supabase.co";
        String apiKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImF6ZnB4bWxseXd6YW5sdGNrbnRyIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzIyNTY5NTEsImV4cCI6MjA0NzgzMjk1MX0.uT60Vl6fUa6tQZWbBRwwhHB-8FFAM8-02GJPTRZgDcM";
        String authToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImF6ZnB4bWxseXd6YW5sdGNrbnRyIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzIyNTY5NTEsImV4cCI6MjA0NzgzMjk1MX0.uT60Vl6fUa6tQZWbBRwwhHB-8FFAM8-02GJPTRZgDcM";

        supabaseService = RetrofitClient.getClient(baseUrl).create(SupabaseService.class);

        supabaseService.getRepairRequests(apiKey, authToken).enqueue(new Callback<List<RepairRequest>>() {
            @Override
            public void onResponse(Call<List<RepairRequest>> call, Response<List<RepairRequest>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter = new RepairRequestAdapter(response.body());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<RepairRequest>> call, Throwable t) {
                Log.e("MainActivity", "Error fetching data: " + t.getMessage());
            }
        });
    }
}
