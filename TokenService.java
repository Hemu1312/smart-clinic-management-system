public class TokenService {

    public String generateToken(String username) {
        return "token-for-" + username;
    }

    public String validateToken(String token) {
        return "Token is valid";
    }

    public String getUsernameFromToken(String token) {
        return "username";
    }
}
