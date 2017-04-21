/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ann_lab_ia;
import java.util.Random;
/**
 *
 * @author juanp
 */
public class Perceptron {
    public static final int EPOCH=50;
    
    double[] weights;
    double threshold;
    boolean solved;
    public void Train(double[][] inputs, int[] outputs, double threshold){

        Random r = new Random();
        this.threshold = threshold;
        weights = new double[inputs[0].length];
        int totalError, error, output;
        

        //initialize weight to random values
        for(int i=0;i<inputs[0].length;i++){
            weights[i] = r.nextDouble();
        }

        for(int i=0;i<EPOCH;i++){
            totalError = 0;
            for(int j =0;j<outputs.length;j++){
                output = Output(inputs[j]);
                error = outputs[j] - output;
                totalError +=error;
               
                for(int k = 0;k<inputs[0].length;k++){
                    double delta = inputs[j][k] * error;
                    weights[k] += delta;
                }
            }
//            System.out.println("Error="+totalError);
            if(totalError == 0){
                solved=true;
                break;
            }
            else solved=false;
        }
    }

    public int Output(double[] input){
            double sum = 0.0;
            for(int i=0;i<input.length;i++){
                sum += weights[i]*input[i];
            }

            if(sum>threshold)return 1;
            else return 0;
      }
    
    public boolean getSolved(){
        return solved;
    }
        
}
