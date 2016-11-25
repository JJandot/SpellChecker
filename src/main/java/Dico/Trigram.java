package Dico;

import Cuckoo.CuckooTable;
import Cuckoo.HashableString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

class Trigram {

    private CuckooTable<HashableString, List<String>> addTrigram(CuckooTable<HashableString, List<String>> cuckooTable, String word){
        List<String> trigrams = getTrigrams(word);
        for (String trigram : trigrams) {
            List<String> words = new ArrayList<>();
            if(cuckooTable.get(new HashableString(trigram)) != null) {
                StringBuilder sb = new StringBuilder(cuckooTable.get(new HashableString(trigram)).toString());
                cuckooTable.remove(new HashableString(trigram));
                sb.deleteCharAt(0);
                sb.deleteCharAt(sb.length() - 1);
                String s = sb.toString();
                words.add(s);
            }
            words.add(word);
            cuckooTable.put(new HashableString(trigram), words);
        }
        return cuckooTable;
    }

    CuckooTable<HashableString, List<String>> makeDictionaryTrigramFromFile(String word, String fileName) throws IOException {
        CuckooTable<HashableString, List<String>> cuckooTable = new CuckooTable<>(50000);
        Trigram t = new Trigram();

        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        InputStream is = cl.getResourceAsStream(fileName);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        String string;
        while((string = bufferedReader.readLine()) != null) {
            if (string.equals(word)) {
                System.out.println(word + " est bien écrit");
                exit(0);
            }
            cuckooTable = t.addTrigram(cuckooTable, string);
        }
        return cuckooTable;
    }


    List<String> getTrigrams(String word){
        List<String> trigrams = new ArrayList<>();
        word = "<" + word + ">";
        for (int i = 0; i < word.length() - 2; ++i){
            trigrams.add(word.substring(i, i + 3));
        }
        return trigrams;
    }
}