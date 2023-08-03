package org.example.persistence.login;

public interface UserDAO {
    boolean login(String username, String password);
    int getMaNguoiMoGioi(String username);
}
