package dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
public class Request {
    private static long counter = 0;
    @EqualsAndHashCode.Exclude
    private final long id = counter++;
    private final RequestType type;
    private BigDecimal sum;
}
