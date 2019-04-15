/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsteam;

/**
 *
 * @author Carlos
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
        
public class DSTeam {
    
    public static void main(String[] args){
        Data data = new Data(); 
        Scanner sc = new Scanner(System.in);
        int items = sc.nextInt();
        data.profit = new double[items];
        data.weight = new double[items];
        data.name = new String[items];
        int peso = sc.nextInt();
        Scanner scanner = new Scanner(System.in);
        String tipo = scanner.nextLine();
        switch(tipo){
            case "ligero":
                data.MaxWeight = 0.5 * peso;
                break;
            case "medio":
                data.MaxWeight = 0.75 * peso;
                break;
            case "pesado":
                data.MaxWeight = peso;
                break;
        } 
        for(int i = 0; i < items; i++){
            Scanner scanner1 = new Scanner(System.in);
            String line = scanner1.nextLine();
            String[] lines = line.split(" ");
            data.name[i] = lines[0];
            data.weight[i] = Integer.parseInt(lines[1]);
            data.profit[i] = Integer.parseInt(lines[2]);
        }
        double[] sol = greedyAlgorithmKS(data);
        
        /*printSol(data, sol);
        for(int j = 0; j < items; j++){
            System.out.println(data.name[j]);
        }*/
    }
    
    public static class Data{
        double[] profit;
        double[] weight;
        String[] name;
        double MaxWeight;
    }
    
    public static double[] greedyAlgorithmKS(Data data){
        int n = data.profit.length;
        List<Integer> cand = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            cand.add(i);
        }
        double[] sol = new double[n];
        double freeWeight = data.MaxWeight;
        boolean isSol = false;
        while(!cand.isEmpty() && !isSol){
            int bestItemIdx = getBestItem(cand, data);
            int bestItem = cand.remove(bestItemIdx);
            if(isFeasible(data, bestItem, freeWeight)){
                sol[bestItem] = 1.0;
                freeWeight -= data.weight[bestItem];
            } else{
                sol[bestItem] = freeWeight / data.weight[bestItem];
                isSol = true;
            }
        }
        return sol;
    }
    
    public static int getBestItem(List<Integer> cand, Data data){
        double bestRatio = 0;
        int bestItem = 0;
        for (int i = 0; i < cand.size(); i++) {
            int c = cand.get(i);
            double r = data.profit[c] / data.weight[c];
            if (r > bestRatio) {
                bestRatio = r;
                bestItem = i;
            }
        }
        return bestItem;
    }
    
    public static boolean isFeasible(Data data, int bestItem, double freeWeight){
        return (freeWeight - data.weight[bestItem] > 0);
    }
    
     public static void printSol(Data data, double[] sol) {
        System.out.println("item" +"\t" + "profit"  +"\t" +   "weight"  +"\t" +   "Ratio"  +"\t" +  "%Item");
        int n = data.profit.length;
        for (int i = 0; i < n; i++) {
            System.out.println(i + "\t\t" + data.profit[i] + "\t"
                    + data.weight[i] + "\t" + String.format("%.2f",data.profit[i] / data.weight[i])
                    + "\t" + String.format("%.2f",sol[i]));
        }
    }
}
