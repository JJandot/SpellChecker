public class Application {

    public static void main(String[] args) {
        long initTime = System.nanoTime();
        Levenshtein levenshtein = new Levenshtein("choufleur", "chouxfleur");
        System.out.println(levenshtein.getDistance());
        long endTime = System.nanoTime();
        System.out.println("Temps algo : " + (endTime - initTime) + " nanosecondes.");
    }
}
