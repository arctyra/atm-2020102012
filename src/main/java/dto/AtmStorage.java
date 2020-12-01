package dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AtmStorage {
    @Setter(AccessLevel.NONE)
    private final int id;
    private CashContainer cashContainer;

}
