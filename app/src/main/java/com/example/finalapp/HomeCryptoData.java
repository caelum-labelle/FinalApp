package com.example.finalapp;

public class HomeCryptoData {
    String cryptoname;
    String lastprice;
    String changes;

    int type;


    public HomeCryptoData(String cryptoname, String lastprice, String changes, int type) {
        this.cryptoname = cryptoname;
        this.lastprice = lastprice;
        this.changes = changes;
        this.type = type;
    }

    public void setCryptoname(String cryptoname) {
        this.cryptoname = cryptoname;
    }

    public void setLastprice(String lastprice) {
        this.lastprice = lastprice;
    }

    public void setChanges(String changes) {
        this.changes = changes;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
