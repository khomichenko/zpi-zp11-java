package tasks.task3.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import tasks.task3.model.cards.Card;
import tasks.task3.model.cards.CardType;
import tasks.task3.model.exceptions.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor @NoArgsConstructor
public class Tourniquet {
    protected @NonNull TicketIssuer ticketsIssuer;
    protected @NonNull Double price;
    private @Getter Map<Card, Map<Date,Object>> history = new HashMap<>();
    public void apply(Card card) throws CardNoIssuedException, CardExpiredException, CardNoMoneyException, CardNoCapacityException  {
        if (history.get(card)==null) {
            history.put(card, new HashMap<>());
        }
        Boolean isIssued = ticketsIssuer.isIssued(card);
        if (isIssued) {
            if (card.getExpired()!=null && new Date().getTime()>card.getExpired().getTime()) {
                history.get(card).put(new Date(),new CardExpiredException());
                throw new CardExpiredException();
            }
            CardType type = card.getType();
            if (type==CardType.NORMAL && card.getAmount()!=null) {
                Boolean res = card.minusPrice(price);
                if (res==false) {
                    history.get(card).put(new Date(),new CardNoMoneyException());
                    throw new CardNoMoneyException();
                }
                history.get(card).put(new Date(),"-"+price+" грн.");
                return;
            }
            if (card.getCapacity()!=null) {
                Boolean res = card.plusUsed();
                if (res==false) {
                    history.get(card).put(new Date(),new CardNoCapacityException());
                    throw new CardNoCapacityException();
                }
                history.get(card).put(new Date(),-1);
                return;
            }
            history.get(card).put(new Date(),-1);
            return;
        }
        if (history.get(null)==null) {
            history.put(null, new HashMap<>());
        }
        history.get(null).put(new Date(),null);
        throw new CardNoIssuedException();
    };
}
