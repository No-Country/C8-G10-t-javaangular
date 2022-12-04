package NoCountry.YouTech.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CustomResponse {
    private boolean success;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String error;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Object data;

    public CustomResponse(boolean status, Object data) {
        this.success = status;
        this.data = data;
    }

    public CustomResponse(boolean success, String error) {
        this.success = success;
        this.error = error;
    }
}

