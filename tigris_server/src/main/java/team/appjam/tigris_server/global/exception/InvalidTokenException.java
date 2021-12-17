package team.appjam.tigris_server.global.exception;

import team.appjam.tigris_server.global.error.BusinessException;
import team.appjam.tigris_server.global.error.ErrorCode;

public class InvalidTokenException extends BusinessException {

    public static BusinessException EXCEPTION =
            new InvalidTokenException();

    private InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }

}
