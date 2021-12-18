package team.appjam.tigris_server.domain.user.exception;

import team.appjam.tigris_server.global.error.ErrorCode;
import team.appjam.tigris_server.global.error.exception.BusinessException;

public class InvalidPasswordException extends BusinessException {

    public static BusinessException EXCEPTION =
            new InvalidPasswordException();

    private InvalidPasswordException() {
        super(ErrorCode.INVALID_PASSWORD);
    }

}
