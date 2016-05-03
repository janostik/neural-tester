package model;

/**
 *
 * Individual extended by:
 * - node centrality
 * - position in node list ordered by centrality
 * - position in node lsit ordered by fitness value
 * 
 * @author wiki on 02/05/2016
 */
public class NetworkIndividual extends Individual {
    
    public int degree;
    public int position_centrality;
    public int position_fitness;

    public NetworkIndividual() {
    }

    public NetworkIndividual(String id, double[] vector, double fitness, int degree, int position_centrality, int position_fitness) {
        super(id, vector, fitness);
        this.degree = degree;
        this.position_centrality = position_centrality;
        this.position_fitness = position_fitness;
    }

    public NetworkIndividual(Individual individual, int degree, int position_centrality, int position_fitness) {
        super(individual);
        this.degree = degree;
        this.position_centrality = position_centrality;
        this.position_fitness = position_fitness;
    }
    
    
    
}