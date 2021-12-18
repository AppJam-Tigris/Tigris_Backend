package team.appjam.tigris_server.domain.clinic.exception;

import team.appjam.tigris_server.global.error.ErrorCode;
import team.appjam.tigris_server.global.error.exception.BusinessException;

public class ClinicNotFoundException extends BusinessException {

    public static BusinessException EXCEPTION =
            new ClinicNotFoundException();

    private ClinicNotFoundException() {
        super(ErrorCode.CLINIC_NOT_FOUND);
    }

}
