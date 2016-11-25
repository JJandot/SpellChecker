import Utils.MapUtils;

import java.io.*;
import java.util.*;

public class Application {

    public static void main(String[] args) throws IOException {

        Dico.Dictionary dictionary = new Dico.Dictionary();

        dictionary.init();

        long initTime = System.nanoTime();

        Map<String, Integer> mapOccurences = dictionary.getMapOccurences();

        int maxValue = MapUtils.getMaxValueFromMap(mapOccurences);

        System.out.println(mapOccurences);
        HashMap<String, Integer> map = MapUtils.getMaxValueOccurences(mapOccurences, maxValue);

        List<String> bestSuggestions = dictionary.getBestSuggestions(map);

        long endTime = System.nanoTime();
        String unknownWord = ". \nJe ne connais pas ce mot, ni aucun mot qui s'en rapproche";
        String knownWord = ". \nVouliez vous plutot dire : " + bestSuggestions + " ?";

        String printedStr = unknownWord;
        if(!bestSuggestions.isEmpty())
            printedStr = knownWord;


        System.out.println("Vous avez saisi : " + dictionary.getWord() + printedStr);
        System.out.println("Traitement effectué en : " + (endTime - initTime) + " nanosecondes.");
    }
}
