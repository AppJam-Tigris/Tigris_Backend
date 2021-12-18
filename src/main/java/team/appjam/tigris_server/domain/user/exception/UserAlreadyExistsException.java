package team.appjam.tigris_server.domain.user.exception;

import team.appjam.tigris_server.global.error.ErrorCode;
import team.appjam.tigris_server.global.error.exception.BusinessException;

public class UserAlreadyExistsException extends BusinessException {

    public static BusinessException EXCEPTION =
            new UserAlreadyExistsException();

    private UserAlreadyExistsException() {
        super(ErrorCode.USER_ALREADY_EXISTS);
    }

}
