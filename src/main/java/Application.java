import java.io.*;
import java.net.URISyntaxException;


public class Application {

    public static void main(String[] args) throws IOException, URISyntaxException {
        /*long initTime = System.nanoTime();
        Levenshtein levenshtein = new Levenshtein("choufleur", "chouxfleur");
        System.out.println(levenshtein.getDistance());
        long endTime = System.nanoTime();
        System.out.println("Temps algo : " + (endTime - initTime) + " nanosecondes.");*/

        /*CuckooTable cuckooTable = new CuckooTable(10);
        Trigram t = new Trigram();
        cuckooTable = t.addTrigram(cuckooTable, "choufleur");
        System.out.println(cuckooTable);
        cuckooTable = t.addTrigram(cuckooTable, "chouxlfeur");
        System.out.println(cuckooTable);*/

        /*
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        InputStream is = cl.getResourceAsStream("minidico.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        String string;
        while((string = bufferedReader.readLine()) != null)
            System.out.println(string);*/
    }
}
