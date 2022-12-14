package tasks.task4.people;

import com.sun.istack.internal.NotNull;
import lombok.*;

@Data
@RequiredArgsConstructor @NoArgsConstructor
public class Human {
    private @NotNull @ToString.Include @EqualsAndHashCode.Include String name;
}
