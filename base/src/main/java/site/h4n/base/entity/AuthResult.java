package site.h4n.base.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class AuthResult extends Result {
    private String token;
    private String refreshToken;
    private Integer tokenTTL = -1;
    private LocalDateTime refreshTokenExpire;

    public static AuthResult success(Object data, String token) {
        return success(data, token, null);
    }

    public static AuthResult success(Object data, String token, String refreshToken) {
        AuthResult result = new AuthResult();
        result.setCode(2000);
        result.setMessage("成功");
        result.setData(data);
         result.setToken(token);
        result.setRefreshToken(refreshToken);
        return result;
    }
}
