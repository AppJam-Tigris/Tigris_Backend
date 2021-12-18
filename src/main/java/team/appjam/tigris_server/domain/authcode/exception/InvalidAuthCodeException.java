package team.appjam.tigris_server.domain.authcode.exception;

import team.appjam.tigris_server.global.error.ErrorCode;
import team.appjam.tigris_server.global.error.exception.BusinessException;

public class InvalidAuthCodeException extends BusinessException {

    public static BusinessException EXCEPTION =
            new InvalidAuthCodeException();

    private InvalidAuthCodeException() {
        super(ErrorCode.INVALID_CODE);
    }
}
