package language;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Use Country using Lambda
 * Created by Wajahat
 **/
public class CountryApp {

    int getPopulation(List<Country> countries, String continent) {
        return countries.stream()
                .map(c -> c.getContinent().equals(continent) ? c.getPopulation() : 0)
                .reduce(0, (a, b) -> a+b);
    }

    @Test
    public void testGetPopulation() {
        List<Country> list = new ArrayList<>();
        list.add(new Country("india", 100, "asia"));
        list.add(new Country("japan", 12, "asia"));
        list.add(new Country("madagaskar", 1, "africa"));

        assertEquals(112, getPopulation(list, "asia"));

    }
}
