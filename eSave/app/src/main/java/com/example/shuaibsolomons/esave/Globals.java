package com.example.shuaibsolomons.esave;

public class Globals{

    private static Globals instance;
    private static float ans;
    private static boolean cash, card;

    private Globals(){}

    public void setAns(float t){
        Globals.ans = t;
    }

    public float getAns(){
        return Globals.ans;
    }

    public void setCardSelected(boolean t)
    {
        Globals.card = t;
    }

    public boolean getCardSelected()
    {
        return Globals.card;
    }

    public void setCashSelected(boolean t)
    {
        Globals.cash = t;
    }

    public boolean getCashSelected()
    {
        return Globals.cash;
    }

    public static synchronized Globals getInstance(){
        if(instance == null)
        {
            instance = new Globals();
        }
        return instance;
    }
}
