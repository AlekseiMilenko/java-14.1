package ru.netology.manager;

import ru.netology.domain.TransferOffer;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {

    private TicketRepository repo;
    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }
    public void add(TransferOffer ticket) {
        repo.save(ticket);
    }

    public TransferOffer[] findAll(String departureAirport, String arrivalAirport) {
        TransferOffer[] result = new TransferOffer[0];
        for (TransferOffer ticket : repo.findAll()) {
            if (ticket.matches(departureAirport, arrivalAirport)) {
                TransferOffer[] tmp = new TransferOffer[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
                Arrays.sort(result);
            }
        }
        return result;
    }
}
