package tasks.task3;

import lombok.SneakyThrows;
import tasks.task3.controller.Controller;
import tasks.task3.model.Tourniquet;
import tasks.task3.model.cards.Card;
import tasks.task3.model.cards.CardType;
import tasks.task3.model.exceptions.*;
import tasks.task3.view.TicketIssuerView;
import tasks.task3.view.TourniquetView;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 3.4. Написати програму, використовуючи архітектурний шаблон MVC, яка
 * моделює роботу вбудованого процесору турнікету швидкісного трамваю.
 * Турнікет контролює вхід пасажирів на перон. Для проходу на перон можуть
 * використовуватися проїзні картки, які поділяються на:
 * a. Учнівські, Студентські, Звичайні.
 * b. По терміну дії: на місяць, на 10 днів.
 * c. По кількості поїздок: на 5, на 10.
 * d. Накопичувальні картки (можуть бути тільки «звичайного» типу – не
 * можуть бути учнівські та студентські) – можуть поповнюватися на
 * певну суму, з якої при кожній поїздці знімається вартість проїзду.
 * Такі картки не мають обмежень по терміну дії.
 *
 * Турнікет повинен бути зв’язаний з системою, в який ведеться реєстр виданих
 * карток. В цій системі можливо:
 * 1. випустити проїзну картку.
 * Дані щодо картки зберігаються на самій картці, а саме: унікальний
 * ідентифікатор, тип картки, термін дії, кількість поїздок тощо.
 * Турнікет зчитує дані з картки та виконує її перевірку. Якщо дані не вдалося
 * зчитати, чи картка прострочена, чи на ній не залишилося кредитів для поїздок, то
 * прохід заборонено. Інакше з картки знімається одна і прохід дозволяється.
 * Турнікет здійснює облік дозволів та відмов проходу. При цьому турнікет вміє
 * видавати по запиту 1) сумарні дані та 2) дані розбиті по типах проїзних квитків.
 */
public class Task3 {
    @SneakyThrows public static void main(String[] args){
        Controller controller     = new Controller();

        TicketIssuerView ticketsIssuer = controller.createTicketIssuer();

        List<Card> cards = new ArrayList<Card>() {{
            for (int i = 0; i < 10; i++) {
                add(ticketsIssuer.issue(CardType.STUDENT, Duration.ofDays(ThreadLocalRandom.current().nextInt(-7, 7 + 1)))); // на random днів
                add(ticketsIssuer.issue(CardType.PUPIL, ThreadLocalRandom.current().nextInt(1, 10 + 1))); // на random дозволів
                add(ticketsIssuer.issue(CardType.NORMAL, ThreadLocalRandom.current().nextDouble(100, 140 + 1))); // на random (ві 100 до 300) грн
            }
        }};

        TourniquetView tourniquet = controller.createTourniquet(ticketsIssuer,20.0);
        for (int i = 0; i < 10; i++) {
            for (Card card: cards) {
                try {
                    tourniquet.apply(card);
                    System.out.println("Проїзна карта "+card+" : дозволено");
                } catch (CardNoIssuedException e) {
                    System.out.println("Проїзна карта "+card+" : не була випущена");
                } catch (CardNoMoneyException e) {
                    System.out.println("Проїзна карта "+card+" : не достатньо на балансі");
                } catch (CardExpiredException e) {
                    System.out.println("Проїзна карта "+card+" : прострочена");
                } catch (CardNoCapacityException e) {
                    System.out.println("Проїзна карта "+card+" : нульова кількість доступних проїздів");
                }
            }
        }
        Integer cardNoIssued =  0, cardNoMoney = 0, cardExpired = 0, cardNoCapacity = 0, cardAllowedByMoney = 0, cardAllowed = 0;
        Map<Card, Map<Date, Object>> history = tourniquet.getHistory();
        for (Card card: history.keySet()) {
            Map<Date, Object> records = history.get(card);
            for (Object val: records.values()) {
                if (val instanceof CardNoIssuedException) cardNoIssued ++; else
                if (val instanceof CardNoMoneyException)  cardNoMoney ++;  else
                if (val instanceof CardExpiredException)  cardExpired ++;  else
                if (val instanceof CardNoCapacityException)  cardNoCapacity ++; else
                if (val instanceof String) cardAllowedByMoney ++; else
                if (val instanceof Integer) cardAllowed++;
            }
        }
        System.out.println("cardNoIssued = "+cardNoIssued+", cardNoMoney = "+cardNoMoney+", cardExpired = "+cardExpired+", cardNoCapacity = "+cardNoCapacity+", cardAllowedByMoney = "+cardAllowedByMoney+", cardAllowed = "+cardAllowed);
    }
}
