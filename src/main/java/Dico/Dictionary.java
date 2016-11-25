package Dico;

import Cuckoo.CuckooTable;
import Cuckoo.HashableString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {

    public String getWord() {
        return word;
    }

    private String word;
    private Trigram trigram;
    private CuckooTable<HashableString, List<String>> dicoTrigrams;
    private List<String> wordTrigrams = new ArrayList<>();
    private List<List<String>> usedTrigrams = new ArrayList<>();

    public Dictionary() {
        trigram = new Trigram();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            word = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fillWordTrigrams(){
        try {
            if((dicoTrigrams = trigram.makeDictionaryTrigramFromFile(word, "minidico.txt")) != null)
                wordTrigrams = trigram.getTrigrams(word);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fillUsedTrigrams(){
        for(String s : wordTrigrams){
            usedTrigrams.add(dicoTrigrams.get(new HashableString(s)));
        }
    }

    public void init(){
        fillWordTrigrams();
        fillUsedTrigrams();
    }

    public Map<String, Integer> getMapOccurences(){
        Map<String, Integer> mapOccurences = new HashMap<>();
        for (String s : wordTrigrams) {
            List<String> list = usedTrigrams.get(wordTrigrams.indexOf(s));
            if (list != null) {
                for (String string : list) {
                    String[] test = string.split(", ");
                    for(String str : test) {
                        int count = 0;
                        if (mapOccurences.get(str) != null) {
                            count = mapOccurences.get(str);
                            mapOccurences.remove(str);
                        }
                        mapOccurences.put(str, ++count);
                    }
                }
            }
        }
        return mapOccurences;
    }

    public List<String> getBestSuggestions(Map<String, Integer> map){
        List<String> bestSuggestions = new ArrayList<>();
        for(String str : map.keySet()){
            Levenshtein levenshtein = new Levenshtein(word, str);
            if(levenshtein.getDistance() <= 2){
                bestSuggestions.add(str);
            }
        }
        return bestSuggestions;
    }
}
