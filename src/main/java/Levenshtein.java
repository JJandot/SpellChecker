public class Levenshtein {

    private String mot1;
    private String mot2;

    public Levenshtein(String mot1, String mot2) {
        this.mot1 = mot1;
        this.mot2 = mot2;
    }

    public int getDistance(){
        char lastChar1 = mot1.charAt(mot1.length()-1);
        char lastChar2 = mot2.charAt(mot2.length()-1);

        if(lastChar1 == lastChar2) {
            System.out.println("==");
            mot1 = mot1.substring(0, mot1.length() - 1);
            mot2 = mot2.substring(0, mot2.length() - 1);
            getDistance();
        }
        else {
            System.out.println(mot1 + " != " + mot2);
        }
        return 0;
    }

}
