
package algorithm.discrete.aco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.dicsrete.Solution;
import model.dicsrete.tf.DiscreteTestFunction;
import model.dicsrete.tf.MinBin;
import util.random.UniformRandom;

/**
 *
 * Rank Based Ant System
 * 
 * @author wikki on 03/05/2019
 */
public class RBAS implements algorithm.discrete.Algorithm {

    protected List<Solution> P;
    protected DiscreteTestFunction f;
    protected int NP;
    protected List<double[]> tau;
    protected List<double[]> probabilityMatrix;
    protected double alpha;
    protected double sigma;
    protected double sigma2;
    protected double p;
    protected double q0;
    
    private int[] dimensions;
    private int FES;
    private int MAXFES;
    private Solution best;
    private List<Solution> bestHistory;

    /**
     * 
     * @param f
     * @param NP
     * @param alpha
     * @param sigma
     * @param sigma2
     * @param p
     * @param q0 
     */
    public RBAS(DiscreteTestFunction f, int MAXFES, int NP, double alpha, double sigma, double sigma2, double p, double q0) {
        this.f = f;
        this.NP = NP;
        this.alpha = alpha;
        this.sigma = sigma;
        this.sigma2 = sigma2;
        this.p = p;
        this.q0 = q0;
        this.MAXFES = MAXFES;

        this.dimensions = this.f.getDimensions();
        
    }

    private boolean checkFES() {
        return this.FES >= this.MAXFES;
    }
    
    /**
     * Also probability matrix
     */
    protected void initializeTau() {
        
        this.tau = new ArrayList<>();
        this.probabilityMatrix = new ArrayList<>();
        double c = 1;
        
        for(int i = 0; i < this.dimensions.length; i++) {
            tau.add(new double[this.dimensions[i]]);
            probabilityMatrix.add(new double[this.dimensions[i]]);
            for(int j = 0; j < this.tau.get(i).length; j++) {
                this.tau.get(i)[j] = c;
                this.probabilityMatrix.get(i)[j] = c;
            }
        }
        
    }
    
    protected void initializePopulation() {
        
        this.P = new ArrayList<>();
        
        Solution sol;
        int[] vector;
        
        for(int i = 0; i < NP; i++) {
            
            vector = this.f.generateTrial();
            sol = new Solution(vector, this.f.fitness(vector));
            this.P.add(sol);
            this.FES++;
            if(this.best == null || sol.fitness <= this.best.fitness) {
                this.best = sol;
            }
            this.bestHistory.add(this.best);
            
            if(this.checkFES()) {
                return;
            }
            
        }
        
    }
    
    protected void updateTau() {
        
        double Q;
        
        for (Solution sol : this.P) {
            
            Q = 1/sol.fitness;
            
            for(int i = 0; i < sol.vector.length; i++) {
                this.tau.get(i)[sol.vector[i]] += Q;
            }
            
        }
        
    }
    
    protected void computeProbabilityMatrix() {
        
        double sum;
        
        for(int j = 0; j < this.probabilityMatrix.size(); j++) {
            
            sum = 0;
            for(int k = 0; k < this.tau.get(j).length; k++) {
                sum += Math.pow(this.tau.get(j)[k], 2);
            }

            for(int k = 0; k < this.probabilityMatrix.get(j).length; k++) {

                this.probabilityMatrix.get(j)[k] = Math.pow(this.tau.get(j)[k],this.alpha) / sum;
                
            }
            
        }
        
    }
    
    protected void evaporateTau() {
        
        double sum;
        
        for(int j = 0 ; j < this.tau.size(); j++) {
            
            sum = Arrays.stream(this.tau.get(j)).sum();
            
            for(int k = 0; k < this.tau.get(j).length; k++) {
                
                this.tau.get(j)[k] = (1-this.p)*(this.tau.get(j)[k]/sum);
                
            }
            
        }
        
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public Solution run() {
        
        UniformRandom randGen = new UniformRandom();
        
        /**
         * Initialize
         */
        this.FES = 0;
        this.best = null;
        this.bestHistory = new ArrayList<>();
        this.initializeTau();
        this.initializePopulation();
        
        if(this.checkFES()) {
            return this.best;
        }
        
        /**
         * Update tau
         */
        this.updateTau();
        
        Solution x;
        List<Solution> newPop;
        double max, prob, sum;
        int arg = 0;
        
        /**
         * until stopping criterion is not met
         */
        while(true) {
            
            newPop = new ArrayList<>();
            
            this.computeProbabilityMatrix();
            
            /**
             * population cycle
             */
            for(int i = 0; i < this.P.size(); i++) {
            
                x = this.P.get(i);
                /**
                 * generate new trail
                 */
                for(int d = 0; d < x.vector.length; d++) {
                    if(randGen.nextDouble() > this.q0) {

                        sum = Arrays.stream(this.probabilityMatrix.get(d)).sum();
                        prob = randGen.nextDouble(0, sum);
                        
                        arg = 0;
                        prob -= this.probabilityMatrix.get(d)[arg];
                        while(prob > 0) {
                            
                            arg++;
                            prob -= this.probabilityMatrix.get(d)[arg];

                        }

                    } else {
                        /**
                         * find the max
                         */
                        max = Double.MIN_VALUE;
                        for(int l = 0; l < this.tau.get(d).length; l++) {
                            if(this.tau.get(d)[l] >= max) {
                                max = this.tau.get(d)[l];
                                arg = l;
                            }
                        }
                        
                    }
                    
                    x.vector[d] = arg;
                }
                
                x.fitness = this.f.fitness(x.vector);
                if(x.fitness <= this.best.fitness) {
                    this.best = x;
                }
                this.FES++;
                newPop.add(x);
                
                if(this.checkFES()) {
                    break;
                }
            }
            
            this.P = newPop;
            this.evaporateTau();
            
            if(this.checkFES()) {
                    break;
                }
            
        }

        return this.best;
        
    }

    public Solution getBest() {
        
        return this.best;
        
    }
    
    @Override
    public List<? extends Solution> getPopulation() {
        return P;
    }

    @Override
    public DiscreteTestFunction getTestFunction() {
        return f;
    }

    @Override
    public String getName() {
        return "RBAS";
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int dim = 10;
        int NP = 50;
        int MAXFES = 1000;
        double alpha = 0.2;
        double sigma = 0.68;
        double sigma2 = 0.1;
        double p = 0.2;
        double q0 = 0.5;
        RBAS alg;
        
        Solution sol;
        
        int runs = 10;
        
        for(int i = 0; i < runs; i++) {
        
            alg = new RBAS(new MinBin(dim), MAXFES, NP, alpha, sigma, sigma2, p, q0);

            sol = alg.run();
            
            System.out.println(i + ". run");
            System.out.println(Arrays.toString(sol.vector));
            System.out.println(sol.fitness);
            System.out.println("==================");
        }
        
    }
    
}
