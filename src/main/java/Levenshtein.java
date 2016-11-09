import static java.lang.Math.abs;

public class Levenshtein {

    private String mot1;
    private String mot2;
    private int distance;

    public Levenshtein(String mot1, String mot2) {
        this.mot1 = mot1;
        this.mot2 = mot2;
        distance = 0;
    }

    private String balanceString(int nbSpaces, String word){
        System.out.println(word);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nbSpaces; ++i){
            sb.append(" ");
        }
        sb.append(word);
        return sb.toString();
    }

    private void swap(){
        String tmp;
        tmp = mot1;
        mot1 = mot2;
        mot2 = tmp;
    }

    public int getDistance(){
        if (mot1.length() == 0) return distance;

        if(mot1.length() > mot2.length())
            swap();

        char lastChar1 = mot1.charAt(mot1.length()-1);
        char lastChar2 = mot2.charAt(mot2.length()-1);

        if (lastChar1 == lastChar2) {
            System.out.println("==");
            mot1 = mot1.substring(0, mot1.length() - 1);
            mot2 = mot2.substring(0, mot2.length() - 1);
            getDistance();
        }
        else {
            System.out.println(mot1 + " != " + mot2);
            if (mot1.length() < mot2.length() && mot1.indexOf(lastChar2) == -1) {
                System.out.println("add");
                mot1 += lastChar2;
                System.out.println(mot1);
            }
            else {
                mot1 = mot1.replace(lastChar1, lastChar2);
                System.out.println("replace");
            }
            ++distance;
            System.out.println(distance);
            getDistance();
        }
        return distance;
    }

}
