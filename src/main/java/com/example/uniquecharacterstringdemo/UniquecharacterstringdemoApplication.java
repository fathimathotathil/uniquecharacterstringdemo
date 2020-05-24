package com.example.uniquecharacterstringdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class UniquecharacterstringdemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(UniquecharacterstringdemoApplication.class, args);

        boolean unique = hasUniqueCharacters("Amazon");

        System.out.println("Is the string unique? "+unique);


    }

    private static boolean hasUniqueCharacters(String sample) {

        List repeatedCharacters = new ArrayList();
        if(sample== null || sample.length()==0){
            return false;
        }

        else{
            HashMap<Character,Integer> charachterOccurenceHashMap = new HashMap<Character,Integer>();

            char[] arrayOfCharactersInString = sample.toLowerCase().toCharArray();

            for(char characterInString: arrayOfCharactersInString){
                if(charachterOccurenceHashMap.containsKey(characterInString)){
                    charachterOccurenceHashMap.put(characterInString,charachterOccurenceHashMap.get(characterInString) + 1);
                }
                else{
                    charachterOccurenceHashMap.put(characterInString,1);
                }
            }

            Iterator charachterOccurenceHashMapIterator = charachterOccurenceHashMap.entrySet().iterator();

            while(charachterOccurenceHashMapIterator.hasNext()){
                HashMap.Entry characterEntry = (HashMap.Entry) charachterOccurenceHashMapIterator.next();
                if(!characterEntry.getValue().equals(new Integer(1))){
                    repeatedCharacters.add(characterEntry.getKey());
                }
            }
        }

        if(repeatedCharacters.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }

}
