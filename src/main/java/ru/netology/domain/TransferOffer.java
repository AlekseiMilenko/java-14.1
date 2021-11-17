package ru.netology.domain;

    public class TransferOffer implements Comparable<TransferOffer> {
        private int id;
        private int price;
        private String departureAirport;
        private String arrivalAirport;
        private int travelTime;

        public boolean matches(String from, String to) {
            return departureAirport.contains(from) && arrivalAirport.contains(to);
        }

        public TransferOffer() {
        }

        public TransferOffer(int id, int price, String departureAirport, String arrivalAirport, int travelTime) {
            this.id = id;
            this.price = price;
            this.departureAirport = departureAirport;
            this.arrivalAirport = arrivalAirport;
            this.travelTime = travelTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getDepartureAirport() {
            return departureAirport;
        }

        public void setDepartureAirport(String departureAirport) {
            this.departureAirport = departureAirport;
        }

        public String getArrivalAirport() {
            return arrivalAirport;
        }

        public void setArrivalAirport(String arrivalAirport) {
            this.arrivalAirport = arrivalAirport;
        }

        public int getTravelTime() {
            return travelTime;
        }

        public void setTravelTime(int travelTime) {
            this.travelTime = travelTime;
        }

        @Override
        public int compareTo(TransferOffer o) {
            TransferOffer a = (TransferOffer) o;

            return price - a.price;
        }


}
