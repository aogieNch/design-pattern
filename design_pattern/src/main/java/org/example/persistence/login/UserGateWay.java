package org.example.persistence.login;

public interface UserGateWay {
    boolean login(String username, String password);
    int getMaNguoiMoGioi(String username);
}
