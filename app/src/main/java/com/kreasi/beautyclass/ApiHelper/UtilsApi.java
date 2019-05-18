package com.kreasi.beautyclass.ApiHelper;

public class UtilsApi {
    public static final String BASE_URL_API = "https://api-learning.puspidep.org/";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
