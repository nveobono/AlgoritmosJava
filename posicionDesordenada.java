public class PosicionDesordenada {

    public static void main(String[] args) {
        
        int v[] = {1,2,3,4,5,3,7};
        int pos = DyV(v,0,v.length-1);
        System.out.println("pos: " + pos);
    }

    private static int DyV(int v[], int ini, int fin){
        if(ini==fin){
        return -1;
        }else{
        int medio = (ini+fin)/2;
        if ((medio-1 >= 0)&& (v[medio-1] > v[medio]))
        return medio;
        if ((medio+1 <= v.length)&&(v[medio+1]<v[medio]))
        return medio;
        int r1 = DyV(v,ini,medio-1);
        int r2 = DyV(v,medio+1,fin);
        if (r1>r2)
        return r1;
        else
        return r2;
        }
    }
}