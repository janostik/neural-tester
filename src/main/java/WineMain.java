
import algorithm.de.ShaDE;
import java.util.stream.DoubleStream;
import model.Individual;
import model.tf.TestFunction;
import model.tf.WineDataset;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.stat.descriptive.rank.Median;

/**
 *
 * @author adam on 19/11/2015
 */
public class WineMain {

    public static Individual solveByShade(){
        
        int dimension = 39;
        int NP = 100;
        int MAXFES = 100000;
        TestFunction tf = new WineDataset(false);
        int H = 100;

        ShaDE shade;
        shade = new ShaDE(dimension, MAXFES, tf, H, NP);

        shade.run();
        
//        shade.getBestHistory().stream().forEach((ind) -> {
//            System.out.println(ind.fitness);
//        });
        
        return shade.getBest();
        
    }
    
    public static Individual solveNormalizedByShade(){
        
        int dimension = 39;
        int NP = 100;
        int MAXFES = 100000;
        TestFunction tf = new WineDataset(true);
        int H = 100;

        ShaDE shade;
        shade = new ShaDE(dimension, MAXFES, tf, H, NP);

        shade.run();
        
//        shade.getBestHistory().stream().forEach((ind) -> {
//            System.out.println(ind.fitness);
//        });
        
        return shade.getBest();
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        WineDataset tf;
        Individual best;
        
        int runs = 51;
        double[] results;
        
        results = new double[runs];
        for(int i=0;i<runs;i++){
            
            tf = new WineDataset(false);
            best = solveByShade();
            
            results[i] = tf.getAccuracyE(best);
            
        }

        System.out.println("Not normalized");
        System.out.println("=================================");
        System.out.println("Min: " + DoubleStream.of(results).max().getAsDouble());
        System.out.println("Max: " + DoubleStream.of(results).min().getAsDouble());
        System.out.println("Mean: " + new Mean().evaluate(results));
        System.out.println("Median: " + new Median().evaluate(results));
        System.out.println("Std. Dev.: " + new StandardDeviation().evaluate(results));
        System.out.println("=================================");
        
        results = new double[runs];
        for(int i=0;i<runs;i++){
            
            tf = new WineDataset(true);
            best = solveNormalizedByShade();
            
            results[i] = tf.getAccuracyE(best);
            
        }

        System.out.println("Normalized");
        System.out.println("=================================");
        System.out.println("Min: " + DoubleStream.of(results).max().getAsDouble());
        System.out.println("Max: " + DoubleStream.of(results).min().getAsDouble());
        System.out.println("Mean: " + new Mean().evaluate(results));
        System.out.println("Median: " + new Median().evaluate(results));
        System.out.println("Std. Dev.: " + new StandardDeviation().evaluate(results));
        System.out.println("=================================");
        
    }
    
}