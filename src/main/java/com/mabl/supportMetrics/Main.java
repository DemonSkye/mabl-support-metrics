package com.mabl.supportMetrics;

public class Main {
    public static void main (String args[]){
        String s = RequestHandler.intercomRequest("");
        JSONHelper.getLastConversationID(s);
    }
}
