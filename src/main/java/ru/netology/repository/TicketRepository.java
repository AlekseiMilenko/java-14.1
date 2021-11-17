package ru.netology.repository;

import ru.netology.domain.TransferOffer;

public class TicketRepository {

    private TransferOffer[] items = new TransferOffer[0];

    public void save(TransferOffer item) {
        int length = items.length + 1;
        TransferOffer[] tmp = new TransferOffer[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        TransferOffer[] tmp = new TransferOffer[length];
        int index = 0;
        for (TransferOffer item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public TransferOffer[] findAll() {
        return items;
    }
}
