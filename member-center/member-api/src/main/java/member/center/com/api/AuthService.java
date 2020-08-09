package member.center.com.api;

public interface AuthService {

    /**
     * 用户名及密码验证
     * @param username
     * @param password
     * @return
     */
    String accredit(String username, String password);
}
