package team.appjam.tigris_server.global.exception;

import team.appjam.tigris_server.global.error.exception.BusinessException;
import team.appjam.tigris_server.global.error.ErrorCode;

public class ExpiredTokenException extends BusinessException {

    public static BusinessException EXCEPTION =
            new ExpiredTokenException();

    private ExpiredTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }

}
