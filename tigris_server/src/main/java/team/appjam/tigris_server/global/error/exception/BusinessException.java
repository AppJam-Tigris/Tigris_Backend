package team.appjam.tigris_server.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import team.appjam.tigris_server.global.error.ErrorCode;

@Getter
@RequiredArgsConstructor
public class BusinessException extends RuntimeException {

    private final ErrorCode errorCode;

}
