package com.kreasi.beautyclass.Model;

public interface LoginInView {
    void showLoading(String loading_message);
    void hideLoading();
    void dataFail(String Message);
    void dataSuccess();
}
