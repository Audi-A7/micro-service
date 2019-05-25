package user.sevice;


import com.audi.user.model.User;

public interface UserService {

    boolean register(User user);

    boolean login(String userName, String email, String pwd);

    User query(String email);

    boolean sendVerifyCode(String email);
}
