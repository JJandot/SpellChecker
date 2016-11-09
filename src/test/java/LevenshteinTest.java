import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class LevenshteinTest {
    @Test
    public void getDistance() throws Exception {
        Levenshtein levenshtein = new Levenshtein("logarytmique", "algorithmique");
        assertThat(levenshtein.getDistance(), equalTo(5));
    }

}