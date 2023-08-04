package com.ada.privacy.chatgpt;

import com.ada.privacy.request.IncomingText;

import java.util.ArrayList;


public class Message {
    ArrayList<String> textList = new ArrayList<>();

    public String retrieveText(IncomingText incomingText) {
        String text = incomingText.getText();
        return text;
    }

    public ArrayList<String> divideText (String text){
        if (text.length() <= 14000) {
            textList.add(text);
            return textList;
        }

        if (text.length() > 14000) {
            int mid = text.length() / 2;

            while (text.charAt(mid) != ' ') {
                mid += 1;
            }
            String firstHalf = text.substring(0, mid);
            String secondHalf = text.substring(mid);

            divideText(firstHalf);
            divideText(secondHalf);

        }
        return textList;
    }

}
