package annotations;

import annotations.annotations.Email;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataSample {

    private final String text;

    private int number;

    @Email
    private String email;
}
