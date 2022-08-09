import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class InputData {

    private final LocalDate date1;
    private final String name1;
    private final String name2;
    private final String phone;
    private final LocalDate date2;
}
