package service.menuproject.base.exception;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum RestaurantErrorStatus implements BaseErrorCodeInterface {
    RESTAURANT_NOT_FOUND(HttpStatus.BAD_REQUEST, "RESTAURANT_4001", "존재하지 않는 식당입니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
    private final boolean isSuccess = false;


    RestaurantErrorStatus(HttpStatus httpStatus, String code, String message) {
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