package algorithm;

import model.Individual;
import model.TestFunction;

import java.util.List;

/**
 * Created by jakub on 27/10/15.
 */
public interface Algorithm {

    Individual run();

    List<Individual> getPopulation();

    TestFunction getTestFunction();

    default Individual getBest() {
        getPopulation().sort((o1, o2) -> Double.compare(o1.fitness, o2.fitness));
        return getPopulation().get(0);
    }

    String getName();
}