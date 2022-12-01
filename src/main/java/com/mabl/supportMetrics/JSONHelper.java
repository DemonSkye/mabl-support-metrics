package com.mabl.supportMetrics;

import org.json.JSONObject;
import org.json.JSONArray;

public class JSONHelper {
    public static String getLastConversationID(String json){
        JSONObject jsonObj = new JSONObject(json.toString());
        JSONArray convoArray = new JSONArray(jsonObj.getJSONArray("conversations"));
        JSONObject lastConversation = convoArray.getJSONObject(convoArray.length()-1);
        String lastID = lastConversation.getString("id");
        System.out.println(lastID);
        return lastID;
    }
}
