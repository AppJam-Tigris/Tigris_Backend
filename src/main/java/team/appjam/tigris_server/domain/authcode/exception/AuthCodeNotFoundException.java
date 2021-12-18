package team.appjam.tigris_server.domain.authcode.exception;

import team.appjam.tigris_server.global.error.ErrorCode;
import team.appjam.tigris_server.global.error.exception.BusinessException;

public class AuthCodeNotFoundException extends BusinessException {

    public static BusinessException EXCEPTION =
            new AuthCodeNotFoundException();

    private AuthCodeNotFoundException() {
        super(ErrorCode.AUTH_CODE_NOT_FOUND);
    }

}
