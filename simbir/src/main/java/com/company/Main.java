package com.company;

import  java.io.*;
import org.jsoup.Jsoup;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> letters = new HashMap<String, Integer>();
        ArrayList<String> words = new ArrayList();
        String taboo = "-—©•<>''[]{}«»…,.1234567890!@#$%^&*()_+!№;%:?*/\\\"~";
        ArrayList<String> ListWords = new ArrayList<String>();
        String textOnly = " ";
        String query = "https://simbirsoft.com";
        HttpURLConnection connection = null;

        try {
            connection = (HttpURLConnection) new URL(query).openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setConnectTimeout(250);
            connection.setReadTimeout(250);
            connection.connect();

            StringBuilder sb = new StringBuilder();

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String line;
                while ((line = in.readLine()) != null) {
                    sb.append(line);
                }

                textOnly = Jsoup.parse(sb.toString()).text();

                for (char c : taboo.toCharArray()) {
                    textOnly = textOnly.replace(c, ' ');
                }

                String[] textOnly2 = textOnly.split(" ");

                for (int i = 0; i < textOnly2.length; i++) {
                    ListWords.add(textOnly2[i]);
                }

                Iterator<String> count = ListWords.iterator();
                while (count.hasNext()) {
                    String s = count.next();
                    if (s == null || s.isEmpty()) {
                        count.remove();
                    }
                }

                for (int i = 0; i < ListWords.size(); i++) {
                    String tempChar = ListWords.get(i);

                    if (!letters.containsKey(tempChar)) {
                        letters.put(tempChar, 1);
                    } else {
                        letters.put(tempChar, letters.get(tempChar) + 1);
                    }
                }
                FileWriter fileWriter = new FileWriter("a.html");
                fileWriter.write(ListWords.toString());
                for (Map.Entry<String, Integer> entry : letters.entrySet()) {
                    System.out.println("Слово= " + entry.getKey() + ", Повторений = " + entry.getValue());
                }

            } else {
                System.out.println("Fail:" + connection.getResponseCode() + ", " + connection.getResponseMessage());
            }

        } catch (Throwable cause) {
            cause.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}