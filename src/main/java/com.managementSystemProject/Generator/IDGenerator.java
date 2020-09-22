package com.managementSystemProject.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IDGenerator {

    private static String id = "0123456789";
    public static final int ID_LENGTH = 6;

    private static String generate (int length) {
        Random random = new Random();
        StringBuilder stringBuilderb = new StringBuilder(length);
        shuffle(id);
        char c;
        for (int i = 0; i < length;) {
            c = id.charAt(random.nextInt(id.length()));
            if (stringBuilderb.indexOf(String.valueOf(c))==-1) {
                stringBuilderb.append(c);
                i++;
            }
        }
        return stringBuilderb.toString();
    }

    private static void shuffle(String input){
        List<Character> characters = new ArrayList<>();
        for(char c:input.toCharArray()){
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(input.length());
        while(characters.size()!=0){
            int randPicker = (int)(Math.random()*characters.size());
            output.append(characters.remove(randPicker));
        }
        id = output.toString();
    }

    public static String randomId() {return generate(ID_LENGTH);}
}
