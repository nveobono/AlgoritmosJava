public class IndexSearch{

    public static void main(String[] args){
        int[] v = {-3, -2, -1, 0, 1, 5};
        int[] found = indexSearch(v);
    }

    public static int indexSearch(int[] v){
        return auxIndexSearch(v, 0, v.length);
    }
    
    private static int auxIndexSearch(int[] v, int start, int end) {
        if(start > end){
            return -1;
        }
        int mid = (start + end)/2;
        if(mid == v[mid]){
            return v[mid]; //o simplemente mid;
        }else if(mid < v[mid]){
            return auxIndexSearch(v, start, mid - 1);
        }else{
            return auxIndexSearch(v, mid + 1, end);
        }
    }

}