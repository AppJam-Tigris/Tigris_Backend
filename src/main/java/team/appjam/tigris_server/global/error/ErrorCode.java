package team.appjam.tigris_server.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INVALID_TOKEN(401, "Invalid Token"),
    EXPIRED_TOKEN(401, "Expired Token"),

    USER_ALREADY_EXISTS(409, "User Already Exists"),
    USER_NOT_FOUND(404, "User Not Found"),

    INVALID_PASSWORD(401, "Invalid Password"),


    INVALID_CODE(404, "Invalid Code"),
    NULL_CODE(404, "Code Could not be null")
    ;

    private final int status;
    private final String message;

}
