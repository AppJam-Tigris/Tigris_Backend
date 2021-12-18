package team.appjam.tigris_server.domain.survey.exception;

import team.appjam.tigris_server.global.error.ErrorCode;
import team.appjam.tigris_server.global.error.exception.BusinessException;

public class ClinicNotFoundException extends BusinessException {
    public ClinicNotFoundException() {
        super(ErrorCode.CLINIC_NOT_FOUND);
    }
}
