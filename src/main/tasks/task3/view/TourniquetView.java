package tasks.task3.view;

import tasks.task3.model.TicketIssuer;
import tasks.task3.model.Tourniquet;

public class TourniquetView extends Tourniquet {
    public TourniquetView(TicketIssuer ticketsIssuer, Double price){
        super(ticketsIssuer,price);
    };
}
