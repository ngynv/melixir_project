package com.example.melixir.ultis;

// Giao diện CallBackFragment định nghĩa các phương thức để xử lý sự kiện click từ Fragment
public interface CallBackFragment {
    void onRegisterClicked();

    void onLoginClicked();

    void onInfoClicked();

    void onHomeClicked();
    void onLoginSuccess();
}
