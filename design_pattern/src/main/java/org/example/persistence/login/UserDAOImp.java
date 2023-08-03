package org.example.persistence.login;

public class UserDAOImp implements UserDAO {
    private final UserGateWay userGateWay;

    public UserDAOImp(UserGateWay userGateWay) {
        this.userGateWay = userGateWay;
    }


    //Login
    @Override
    public boolean login(String username, String password) {
        return userGateWay.login(username, password);
    }

    //Get MaNguoiMoGioi
    @Override
    public int getMaNguoiMoGioi(String username) {
        return userGateWay.getMaNguoiMoGioi(username);
    }
}
