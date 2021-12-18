package team.appjam.tigris_server.domain.authcode.exception;

import team.appjam.tigris_server.global.error.ErrorCode;
import team.appjam.tigris_server.global.error.exception.BusinessException;

public class NullCodeExceptoin extends BusinessException {
    public NullCodeExceptoin() {
        super(ErrorCode.NULL_CODE);
    }
}
