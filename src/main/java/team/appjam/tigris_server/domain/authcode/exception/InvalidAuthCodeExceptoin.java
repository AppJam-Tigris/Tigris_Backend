package team.appjam.tigris_server.domain.authcode.exception;

import team.appjam.tigris_server.global.error.ErrorCode;
import team.appjam.tigris_server.global.error.exception.BusinessException;

public class InvalidAuthCodeExceptoin extends BusinessException {

    public InvalidAuthCodeExceptoin() {
        super(ErrorCode.INVALID_CODE);
    }
}
