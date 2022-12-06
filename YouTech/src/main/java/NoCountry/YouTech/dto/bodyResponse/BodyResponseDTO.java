package NoCountry.YouTech.dto.bodyResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BodyResponseDTO {
    private int status;
    private String[] data;
    private String[] error;

}
