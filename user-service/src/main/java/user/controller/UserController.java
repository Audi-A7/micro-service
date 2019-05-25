package user.controller;

import com.audi.user.UserApi;
import com.audi.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户controller
 *
 * @author WangQuanzhou
 * @date 2019-05-24
 */
@RestController
@Slf4j
public class UserController implements UserApi {
    @Override
    public boolean register(User user) {
        return false;
    }

    @Override
    public boolean login(String userName, String email, String pwd) {
        return false;
    }

    @Override
    public User query(String email) {
        log.info("enter query method, email = {}", email);
        return null;
    }

    @Override
    public boolean sendVerifyCode(String email) {
        return false;
    }
}
