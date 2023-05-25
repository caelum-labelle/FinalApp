package com.example.finalapp;

public class HomeCryptoData {
    String cryptoname;
    String lastprice;
    String changes;


    public HomeCryptoData(String cryptoname, String lastprice, String changes) {
        this.cryptoname = cryptoname;
        this.lastprice = lastprice;
        this.changes = changes;
    }


    public String getCryptoname() {
        return cryptoname;
    }

    public String getLastprice() {
        return lastprice;
    }

    public String getChanges() {
        return changes;
    }
}
