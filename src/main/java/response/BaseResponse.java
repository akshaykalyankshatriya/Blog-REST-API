package response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


public class BaseResponse {
    private String ResponseStatus;
    private HttpStatus httpStatus;
    private Object data;

    public BaseResponse(String responseStatus, HttpStatus httpStatus, Object data) {
        ResponseStatus = responseStatus;
        this.httpStatus = httpStatus;
        this.data = data;
    }
}
