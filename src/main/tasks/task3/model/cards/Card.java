package tasks.task3.model.cards;

import lombok.*;

import java.util.Date;

@Data @RequiredArgsConstructor
public class Card {
    private @ToString.Include @EqualsAndHashCode.Include String number = java.util.UUID.randomUUID().toString(); // унікальний ідентифікатор карти
    private @ToString.Include @EqualsAndHashCode.Include @NonNull CardType type; // тип картки
    private @ToString.Include @EqualsAndHashCode.Include Date expired; // термін дії
    private @ToString.Include @EqualsAndHashCode.Include Integer capacity; // кількість поїздок
    private @ToString.Include @EqualsAndHashCode.Exclude Integer used = 0; // кількість використаних поїздок
    private @ToString.Include @EqualsAndHashCode.Exclude Double  amount; // сума в грн, для CardType.NORMAL
    public Boolean minusPrice(Double price) {
        if (amount!=null && amount-price>=0) {
            amount -= price;
            return true;
        }
        return false;
    }
    public Boolean plusUsed() {
        if (capacity!=null && used+1<=capacity) {
            used = used + 1;
            return true;
        }
        return false;
    }
}
