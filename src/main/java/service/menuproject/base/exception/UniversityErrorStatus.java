package service.menuproject.base.exception;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import service.menuproject.domain.University;

@Getter
public enum UniversityErrorStatus implements BaseErrorCodeInterface {
    UNIVERSITY_NOT_FOUND(HttpStatus.BAD_REQUEST, "UNIVERSITY_4001", "존재하지 않는 대학교입니다."),
    UNIVERSITY_EXIST(HttpStatus.BAD_REQUEST, "UNIVERSITY_4002", "이미 존재하는 대학교입니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
    private final boolean isSuccess = false;


    UniversityErrorStatus(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    @Override
    public BaseCodeDto getErrorCode() {
        return BaseCodeDto.builder()
                .httpStatus(httpStatus)
                .isSuccess(isSuccess)
                .code(code)
                .message(message)
                .build();
    }
}