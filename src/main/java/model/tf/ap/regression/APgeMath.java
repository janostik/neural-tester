package model.tf.ap.regression;

import model.Individual;
import model.tf.ap.APtf;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.rank.Median;

/**
 *
 * EUR USD
 * 
 * @author adam
 */
public class APgeMath extends APtf {

    double[][] points = new double[][]{{1,0.186997},{2,0.128876},{3,0.061911},{4,0.0631746},{5,0.0998159},{6,0.0568572},{7,0.0505396},{8,0.0353778},{9,0.0252699},{10,0.},{11,0.00126347},{12,0.0341143},{13,0.0581207},{14,0.0884445},{15,0.113714},{16,0.127613},{17,0.101079},{18,0.0328508},{19,0.0631746},{20,0.0391682},{21,0.0795998},{22,0.112451},{23,0.0732824},{24,0.116241},{25,0.118768},{26,0.13393},{27,0.144038},{28,0.150356},{29,0.165517},{30,0.198368},{31,0.200895},{32,0.211003},{33,0.209728},{34,0.23523},{35,0.23013},{36,0.258182},{37,0.324488},{38,0.321938},{39,0.334689},{40,0.34999},{41,0.318112},{42,0.29261},{43,0.313012},{44,0.262008},{45,0.29006},{46,0.23013},{47,0.23268},{48,0.259457},{49,0.213554},{50,0.265833},{51,0.247981},{52,0.29006},{53,0.250532},{54,0.259457},{55,0.268383},{56,0.242881},{57,0.196977},{58,0.182951},{59,0.190602},{60,0.223755},{61,0.184226},{62,0.188051},{63,0.200803},{64,0.231405},{65,0.211003},{66,0.209728},{67,0.301536},{68,0.656016},{69,0.543806},{70,0.556557},{71,0.522129},{72,0.499178},{73,0.495352},{74,0.466025},{75,0.415021},{76,0.451999},{77,0.444348},{78,0.437972},{79,0.448173},{80,0.478776},{81,0.47495},{82,0.473675},{83,0.503003},{84,0.497902},{85,0.453274},{86,0.439247},{87,0.468575},{88,0.509379},{89,0.453274},{90,0.4673},{91,0.490252},{92,0.515754},{93,0.497902},{94,0.503003},{95,0.508103},{96,0.545081},{97,0.555282},{98,0.550182},{99,0.52978},{100,0.52978},{101,0.543806},{102,0.497902},{103,0.499178},{104,0.505553},{105,0.531055},{106,0.496627},{107,0.500453},{108,0.494077},{109,0.505553},{110,0.543806},{111,0.528505},{112,0.513204},{113,0.490252},{114,0.491527},{115,0.497902},{116,0.540339},{117,0.523622},{118,0.546769},{119,0.563486},{120,0.526193},{121,0.497903},{122,0.504332},{123,0.446464},{124,0.437463},{125,0.449036},{126,0.464468},{127,0.404028},{128,0.424603},{129,0.350018},{130,0.366735},{131,0.398884},{132,0.424603},{133,0.449036},{134,0.463182},{135,0.497903},{136,0.523622},{137,0.510762},{138,0.473469},{139,0.445178},{140,0.397598},{141,0.332014},{142,0.357734},{143,0.377023},{144,0.397598},{145,0.379595},{146,0.377023},{147,0.347446},{148,0.351304},{149,0.377023},{150,0.368021},{151,0.337158},{152,0.395026},{153,0.326871},{154,0.34616},{155,0.337158},{156,0.374451},{157,0.391168},{158,0.373165},{159,0.329443},{160,0.260001},{161,0.182844},{162,0.0902555},{163,0.0130981},{164,0.108259},{165,0.236854},{166,0.256143},{167,0.212421},{168,0.0915411},{169,0.180272},{170,0.172556},{171,0.106973},{172,0.230424},{173,0.1777},{174,0.194418},{175,0.229138},{176,0.205991},{177,0.274147},{178,0.355162},{179,0.30975},{180,0.23839},{181,0.276016},{182,0.278611},{183,0.282504},{184,0.252662},{185,0.25396},{186,0.174814},{187,0.208548},{188,0.292883},{189,0.288991},{190,0.32532},{191,0.500477},{192,0.561458},{193,0.623736},{194,0.65747},{195,0.66266},{196,0.665255},{197,0.636711},{198,0.601679},{199,0.65747},{200,0.780729},{201,0.782026},{202,0.75478},{203,0.763862},{204,0.858577},{205,0.849494},{206,0.854684},{207,0.843007},{208,0.833925},{209,0.827438},{210,0.772944},{211,0.835222},{212,0.859874},{213,0.853387},{214,0.866361},{215,0.90269},{216,0.880634},{217,0.92864},{218,1.},{219,0.933829},{220,0.949399},{221,0.959779},{222,0.954589},{223,0.980538},{224,0.948102},{225,0.998703},{226,0.98962},{227,0.998703},{228,0.959779},{229,0.959779},{230,0.905285},{231,0.935127},{232,0.909178},{233,0.916963},{234,0.976646},{235,0.961076},{236,0.937722},{237,0.974051},{238,0.997405},{239,0.946804}};

    @Override
    protected double getDistance(double[] vector) {

        double sum = 0, a, b;
        double[] distance_array = new double[points.length];
        
        for (int i = 0; i < points.length; i++) {
            a = ap.dsh(vector, points[i][0]);
            if(Double.isNaN(a) || Double.isInfinite(a)){
                return Double.MAX_VALUE;
            }
            b = points[i][1];

            distance_array[i] = Math.abs(a-b);
        }
        
        return (new Median().evaluate(distance_array)) + (new Mean().evaluate(distance_array));

    }

    @Override
    public String name() {
        return "AP_ge_mathematica";
    }

    public static void main(String[] args) throws Exception {
    
        double[] vector = new double[]{2.78997802734375, 5.1953125, 7.0, 2.748046875, 0.15625, 0.0, 2.890625, 5.3125, 1.96484375, 0.3802490234375, 3.111328125, 5.921875, 0.75, 6.90234375, 3.59375, 0.0, 6.28515625, 3.748046875, 6.226318359375, 3.03125};
        APtf tf = new APgeMath();
        
        System.out.println(tf.fitness(vector));
        
    }
    
}
