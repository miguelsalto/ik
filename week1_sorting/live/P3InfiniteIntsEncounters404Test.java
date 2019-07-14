package week1_sorting.live;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class P3InfiniteIntsEncounters404Test {

    @Test
    void findTopEnconters404() {
        P3InfiniteIntsEncounters404 sol = new P3InfiniteIntsEncounters404();
        List<List<Integer>> result = sol.findTopEnconters404(new int[]{1, 100, 30, 404, 2, 90, 404, 97, 404}, 3);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 100, 30),
                Arrays.asList(100, 30, 90),
                Arrays.asList(100, 90, 97)
        );
        assertThat(result.size(), is(expected.size()));
        for (int i = 0; i < result.size(); i++) {
            List<Integer> actual = result.get(i);
            List<Integer> exp = expected.get(i);
            assertThat(actual.size(), is(exp.size()));
            for (int j = 0; j < actual.size(); j++) {
                assertThat(actual.get(j), is(exp.get(j)));
            }
        }
    }
}