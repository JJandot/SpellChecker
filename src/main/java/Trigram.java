import Cuckoo.CuckooTable;
import Cuckoo.HashableString;

import java.util.ArrayList;
import java.util.List;

public class Trigram {

    public CuckooTable addTrigram(CuckooTable cuckooTable, String word){
        List<String> trigrams = getTrigrams(word);
        for (String trigram : trigrams) {
            List<String> words = new ArrayList<>();
            if(cuckooTable.get(new HashableString(trigram)) != null) {
                System.out.println("building...");
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

    private List<String> getTrigrams(String word){
        List<String> trigrams = new ArrayList<>();
        StringBuilder sb = new StringBuilder("<");
        sb.append(word);
        sb.append(">");
        word = sb.toString();

        for (int i = 0; i < word.length() - 2; ++i){
            trigrams.add(word.substring(i, i + 3));
        }

        return trigrams;
    }



}
