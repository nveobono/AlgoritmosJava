import java.util.List;

//medianaArray

public class ejercicio2{
    
    public static void main(String[] args) {

        
    }

    public static int median(List<Integer> v){
        int relative_oder = (v.size() - 1)/2;
        return methodSmallestElemnet(v, relative_oder);
    }

    private static int methodSmallestElemnet( List<Integer> list, int n) {
        int pivot;
        int result;
        List<Integer> underPivot = new ArrayList<>();
        List<Integer> equllPivot = new ArrayList<>();
        List<Integer> overPivot = new ArrayList<>();

        pivot = list.get(0);

        for(Integer c:list){
            if(c < pivot){
                underPivot.add(c);
            }else if(c > pivot){
                overPivot.add(c);
            }else{
                equllPivot.add(c);
            }
        }
        if( n < underPivot.size()){
            result = methodSmallestElemnet(underPivot, n);
        }else if(n < underPivot.size() + equllPivot.size()){
            result =pivot;
        }else{
            result = methodSmallestElemnet(overPivot, n - underPivot.size() - equllPivot.size());
        }
        return result;     
    }
}