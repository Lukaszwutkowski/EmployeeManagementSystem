package com.managementSystemProject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SingletonCache {

   private List<String> logList = new ArrayList<>();



   private Integer sequence = 1;

   public static String getFormattedDate(){
       String formattedDate = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss").format(new Date());
       return formattedDate;
   }

    private static SingletonCache instance = new SingletonCache();

    // metoda log przyjmuje Stringa

    public void log(String operation) {
        logList.add(sequence++ + " " + operation + " " + getFormattedDate());
    }

    public String getLog(){
       return logList.toString();
    }


    public static SingletonCache getInstance() {
        return instance;
    }
}
