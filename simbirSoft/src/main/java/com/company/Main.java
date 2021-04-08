package com.company;
import org.jsoup.Jsoup;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {

        String text = "  ";
        String query = "https://www.simbirsoft.com";
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

                text = Jsoup.parse(sb.toString()).text();
                System.out.println(text);

                String taboo = "-©•<«»…,.1234567890!@#$%^&*()_+!№;%:?*/\\\"~";

                for (char c : taboo.toCharArray()) {
                    text = text.replace(c, ' ');
                }
                 while ((line = in.readLine()) != null) {
                    sb.append(line);

                }
                text = text.replaceAll("  ", " ");



                FileWriter writer = new FileWriter("ex.txt");
                String[] words = text.split(" ");

                for (String word : words) {
                    writer.write(word+ "\n");
                }

                FileWriter writerCount = new FileWriter("count.txt");
                for (int i=0;i< words.length;i++){
                    int count = 0;
                    if (words[i].equals(" ")) { continue;}
                    for (String word:words) {

                         if (word.equals(words[i])) {
                            count++;
                        }
                    }

                    System.out.println(words[i]+ "  =  "+ count);
                    writerCount.write(words[i]+ "  =  "+ count+ "\n");
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