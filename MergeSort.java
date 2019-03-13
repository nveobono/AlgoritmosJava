import java.util.Arrays;

public class MergeSort{

    public static void main(String[] args) {
        int[] v = {1,9,31,14,5,7,9,3};
        System.out.println("Array no ordenado: " + Arrays.toString(v));
        int[] merger = mergeSort(v);
        System.out.println("Ordenado: ");
    }

    private static int[] mergeSort(int[] v){
        if(v.length == 1){
            return v;
        }
        int mid = v.length/2;
        int[] vlow = Arrays.copyOfRange(v, 0, mid);
        int[] vhigh = Arrays.copyOfRange(v, mid, v.length);

        vlow = mergeSort(vlow);
        vhigh = mergeSort(vhigh);

        int[] vSorted = merge(vlow, vhigh);
        return vSorted;
    }

    public static int[] merge(int[] vlow, int[] vhigh){
        int[] mix = new int[vlow.length + vhigh.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < vlow.length && j < vhigh.length){
            if(vlow[i] <= vhigh[j]){
                mix[k] = vlow[i];
                i++;
            }else{
                mix[j] = vhigh[j];
                j++; 
            }
            k++;
        }
        while(i < vlow.length){
            mix[k] = vlow[i];
            i++;
            k++;
        }
        while(j < vhigh.length){
            mix[k] = vhigh[j];
            j++;
            k++;
        }
        return mix;
    }
}