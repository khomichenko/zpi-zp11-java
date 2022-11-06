package tasks.task3.model;

import tasks.task3.model.cards.Card;
import tasks.task3.model.cards.CardType;
import tasks.task3.model.exceptions.CardIssueException;

import java.time.Duration;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TicketIssuer {

    private Set<Card> cards = new HashSet<>();

    public Card issue(CardType type, Duration duration) {
        return issue(type,duration,null);
    }
    public Card issue(CardType type, Duration duration, Integer capacity) {
        Card card = new Card(type);
        card.setExpired(new Date(new Date().getTime()+duration.toMillis()));
        card.setCapacity(capacity);
        cards.add(card);
        return card;
    }

    public Card issue(CardType type, Integer capacity) {
        Card card = new Card(type);
        card.setCapacity(capacity);
        cards.add(card);
        return card;
    }

    public Card issue(CardType type, Double amount) throws CardIssueException {
        if (type==CardType.PUPIL || type==CardType.STUDENT) {
            throw new CardIssueException();
        }
        Card card = new Card(type);
        card.setAmount(amount);
        cards.add(card);
        return card;
    }

    protected Boolean isIssued(Card card) {
        return card!=null && cards.stream().filter((c)->c.getNumber().equals(card.getNumber())).collect(Collectors.toSet()).size()==1;
    }

}
