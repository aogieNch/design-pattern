package org.example.domain.model.service.user;

public interface UserService {
    boolean checkLogin(String username, String password);
    int getMaNguoiMoGioi(String username);
}
