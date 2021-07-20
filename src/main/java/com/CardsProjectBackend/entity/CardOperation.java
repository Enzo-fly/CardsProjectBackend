package com.CardsProjectBackend.entity;

import javax.persistence.*;


@Entity
@Table(name="transactions")
public class CardOperation {

        @Column(name="sender_number")
        private String senderNumber;

        @Column(name="sender_date")
        private long senderDate;

        @Column(name="sender_cvc2")
        private long senderCvc2;

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name="id")
        private int id;

        @Column(name="sender_amount")
        private float senderAmount;

        @Column(name="receiver_number")
        private String receiverNumber;

        @Column(name="receiver_amount")
        private float receiverAmount;

        @Column(name="sender_fee")
        private float senderFee;

        @Column(name="receiver_fee")
        private float receiverFee;

        @Column(name="phone")
        private long phone;

        @Column(name="receiver_notification")
        private boolean receiverNotification;

        @Column(name="email")
        private boolean email;

        public CardOperation() {
        }
        public CardOperation(String senderNumber, long senderDate, long senderCvc2, float senderAmount,
                             String receiverNumber, float receiverAmount, float senderFee, float receiverFee,
                             long phone, boolean receiverNotification, boolean email) {
            this.senderNumber = senderNumber;
            this.senderDate = senderDate;
            this.senderCvc2 = senderCvc2;
            this.senderAmount = senderAmount;
            this.receiverNumber = receiverNumber;
            this.receiverAmount = receiverAmount;
            this.senderFee = senderFee;
            this.receiverFee = receiverFee;
            this.phone = phone;
            this.receiverNotification = receiverNotification;
            this.email = email;
        }
        public String getSenderNumber() {
            return senderNumber;
        }
        public void setSenderNumber(String senderNumber) {
            this.senderNumber = senderNumber;
        }

        public long getSenderDate() {
            return senderDate;
        }
        public void setSenderDate(long senderDate) {
            this.senderDate = senderDate;
        }

        public long getSenderCvc2() {
            return senderCvc2;
        }
        public void setSenderCvc2(long senderCvc2) {
            this.senderCvc2 = senderCvc2;
        }

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }

        public float getSenderAmount() {
            return senderAmount;
        }
        public void setSenderAmount(float senderAmount) {
            this.senderAmount = senderAmount;
        }

        public String getReceiverNumber() {
            return receiverNumber;
        }
        public void setReceiverNumber(String receiverNumber) {
            this.receiverNumber = receiverNumber;
        }

        public float getReceiverAmount() {
            return receiverAmount;
        }
        public void setReceiverAmount(float receiverAmount) {
            this.receiverAmount = receiverAmount;
        }

        public float getSenderFee() {
            return senderFee;
        }
        public void setSenderFee(float senderFee) {
            this.senderFee = senderFee;
        }

        public float getReceiverFee() {
            return receiverFee;
        }
        public void setReceiverFee(float receiverFee) {
            this.receiverFee = receiverFee;
        }

        public long getPhone() {
            return phone;
        }
        public void setPhone(long phone) {
            this.phone = phone;
        }

        public boolean getReceiverNotification() {
        return receiverNotification;
    }
        public void setReceiverNotification(boolean receiverNotification) {this.receiverNotification = receiverNotification;}

        public boolean getEmail() {
            return email;
        }
        public void setEmail(boolean email) {
            this.email = email;
        }
        @Override
        public String toString() {
            return "CardOperation [senderNumber=" + senderNumber + ", senderDate=" + senderDate + ", senderCvc2=" + senderCvc2
                    + ", id=" + id + ", senderAmount=" + senderAmount + ", receiverNumber=" + receiverNumber
                    + ", receiverAmount=" + receiverAmount + ", senderFee=" + senderFee + ", receiverFee=" + receiverFee
                    + "]";
        }
 }
