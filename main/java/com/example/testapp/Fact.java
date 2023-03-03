package com.example.testapp;

public class Fact {

    private String mFact;
  public Fact(){

   }
    public Fact(String mFact) {
        this.mFact = mFact;
    }

    public String getmFact() {
        return mFact;
    }

    public void setmFact(String mFact) {
        this.mFact = mFact;
    }

    @Override
    public String toString() {
        return "Fact{" +
                "mFact='" + mFact + '\'' +
                '}';
    }
}
