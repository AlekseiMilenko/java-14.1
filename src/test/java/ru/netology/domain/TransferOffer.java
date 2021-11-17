package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.TicketManager;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TransferOfferTest {
    private TransferOffer one = new TransferOffer(111, 1000, "SPb", "Msk", 90);
    private TransferOffer two = new TransferOffer(2222, 2000, "SPb", "Msk", 100);
    private TransferOffer three = new TransferOffer(333, 5000, "Msk", "SPb", 90);
    private TransferOffer four = new TransferOffer(444, 4000, "Msk", "SPb", 100);

    TicketManager manager = new TicketManager(new TicketRepository());



    @Test
    public void shouldFindNoData() {

        TransferOffer[] expected = new TransferOffer[]{};
        TransferOffer[] actual = manager.findAll("SPb", "Msk");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNoResult() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);


        TransferOffer[] expected = new TransferOffer[]{};
        TransferOffer[] actual = manager.findAll("LDN", "Msk");
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindOneResult() {
        manager.add(one);
        manager.add(three);
        manager.add(four);

        TransferOffer[] expected = new TransferOffer[]{one};
        TransferOffer[] actual = manager.findAll("SPb", "Msk");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAndSort() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);

        TransferOffer[] expected = new TransferOffer[]{four,three};
        TransferOffer[] actual = manager.findAll("Msk", "SPb");

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }
}