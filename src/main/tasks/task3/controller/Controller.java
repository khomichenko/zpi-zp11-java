package tasks.task3.controller;

import tasks.task3.model.TicketIssuer;
import tasks.task3.model.Tourniquet;
import tasks.task3.view.TicketIssuerView;
import tasks.task3.view.TourniquetView;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<TicketIssuerView> ticketIssuers = new ArrayList<>();
    private List<Tourniquet> tourniquets = new ArrayList<>();

    public TourniquetView createTourniquet(TicketIssuer ticketsIssuer, Double price){
        TourniquetView tourniquet = new TourniquetView(ticketsIssuer,price);
        tourniquets.add(tourniquet);
        return tourniquet;
    }

    public TicketIssuerView createTicketIssuer(){
        TicketIssuerView ticketIssuer = new TicketIssuerView();
        ticketIssuers.add(ticketIssuer);
        return ticketIssuer;
    }

}
