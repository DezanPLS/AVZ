package com.example.ihateprogrammingavz;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface SupabaseService {

    @GET("/rest/v1/repair_request") // Путь к таблице repair_request
    Call<List<RepairRequest>> getRepairRequests(
            @Header("apikey") String apiKey,         // Заголовок для API ключа
            @Header("Authorization") String authToken // Заголовок для авторизации
    );
}
