package dto;

import enums.RequestType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

@Data
public class Request {
    private static AtomicLong counter = new AtomicLong(0);
    @EqualsAndHashCode.Exclude
    private final long id = counter.addAndGet(1);
    private final RequestType type;
    private BigDecimal sum;
}
