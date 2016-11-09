public class Levenshtein {

    private String mot1;
    private String mot2;
    private int distance;

    public Levenshtein(String mot1, String mot2) {
        this.mot1 = mot1;
        this.mot2 = mot2;
        distance = 0;
    }

    private void swap(){
        String tmp;
        tmp = mot1;
        mot1 = mot2;
        mot2 = tmp;
    }

    private void reduceWords(){
        mot1 = mot1.substring(0, mot1.length() - 1);
        mot2 = mot2.substring(0, mot2.length() - 1);
    }

    public int getDistance(){
        if(mot1.length() > mot2.length())
            swap();

        if (mot1.length() == 0) return distance;

        char lastChar1 = mot1.charAt(mot1.length()-1);
        char lastChar2 = mot2.charAt(mot2.length()-1);

        if (lastChar1 == lastChar2) {
            reduceWords();
            getDistance();
        }
        else {
            if (mot1.length() < mot2.length() && mot1.indexOf(lastChar2) == -1)
                mot1 += lastChar2;
            else
                mot1 = mot1.replace(lastChar1, lastChar2);
            ++distance;
            getDistance();
        }
        return distance;
    }
}
