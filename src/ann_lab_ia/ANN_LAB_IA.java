/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ann_lab_ia;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author juanp
 */
public class ANN_LAB_IA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int d, m, n;
        
        d=input.nextInt();
        m=input.nextInt();
        n=input.nextInt();
        
        String[] vector=new String[n+m];
        double[][] data = new double[m][d+1];
        int[] output = new int[m];
        double[] in = new double[d];
        
        vector[0]=input.nextLine();
        for(int i=0; i<m+n; i++){
            vector[i]=input.nextLine();
        }        
        
        double aux;
        String[] array=new String[100];
             
        for(int i=0; i<m; i++){
            array=vector[i].split(",");  
            for(int j=0; j<d; j++){
                aux=Double.parseDouble(array[j]);
                data[i][j]=aux;
            }
            output[i]=(int)(Double.parseDouble(array[d]));
        }
        
        Perceptron perceptron=new Perceptron();
        perceptron.Train(data, output, 1);
        
        if(!perceptron.getSolved()){
                System.out.println("no solution found");
                return;
        }
        else{
            for(int i=m; i<m+n; i++){
                array=vector[i].split(",");  
                for(int j=0; j<d; j++){
                    aux=Double.parseDouble(array[j]);
                    in[j]= aux;
                }
                System.out.println(perceptron.Output(in));
            }
        }
    }
    
}
