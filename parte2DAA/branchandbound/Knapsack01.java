package tema6_byb;

import java.util.*;


public class Knapsack01 {

    static class Item {
        private int value;
        private int weight;
        private float ratio;

        Item(int v, int w) {
            this.value = v;
            this.weight = w;
            this.ratio = v / (float) w;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "value=" + value +
                    ", weight=" + weight +
                    ", ratio=" + ratio +
                    '}';
        }
    }

    public static void main(String[] args) {

        int[] values = new int[]{10, 10, 12, 18};
        int[] weights = new int[]{2, 4, 6, 9};
        int max_weight = 15;
        Solution solution = solve(values, weights, max_weight);
        System.out.println("Solucion:" + solution);
        System.out.println("Nodos generados: " + nodosGenerados);
    }

    private static int nodosGenerados = 0;

    public static Solution solve(int[] values, int[] weights, int max_weight) {
        //Preparar datos
        Item[] items = sortedItems(values, weights);
        //Cota inicial
        Solution bestSolution = initSolution(items, max_weight);
        //Ramificacion y poda
        PriorityQueue<Solution> pq = new PriorityQueue<>();
        Solution solution = new Solution(items, max_weight);
        pq.add(solution);
        nodosGenerados = 1;
        while (!pq.isEmpty()) {
            solution = pq.poll();
            if (solution.isSolution() && solution.getValue() > bestSolution.getValue()) {
                bestSolution.copySol(solution);
            } else if (solution.getUpperBound() > bestSolution.getValue()) {
                for (Solution child : solution.getChildren()) {
                    //getChildren solo devuelve hijos factibles
                    if (child.getUpperBound() > bestSolution.getValue()) {
                        pq.add(child);
                        nodosGenerados++;
                    }
                }
            }
        }
        return bestSolution;
    }

    private static Item[] sortedItems(int[] values, int[] weights) {
        int n = values.length;
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(values[i], weights[i]);
        }
        Arrays.sort(items, Comparator.comparing(item -> -(item.ratio)));
        return items;
    }

    private static Solution initSolution(Item[] items, int max_weight) {
        Solution solution = new Solution(items, max_weight);
        for (int i = 0; i < items.length; i++) {
            if (solution.isCandidate(i)) {
                solution.addNextElement();
            } else {
                solution.skipNextElement();
            }
        }
        return solution;
    }


    static class Solution implements Comparable<Solution> {
        private double value;        //valor de los elementos en la mochila
        private double freeSpace;    //espacio libre restante
        private int next;            // indice del elemento siguiente
        private int[] result;        //Array binario: indica si el elemento i-esimo esta (1) o no (0)
        private double upperBound;  //Estimacion o cota superior (mejor solucion alcanzable)
        private Item[] items;

        /**
         * Constructor solucion vacia a partir de los datos
         */
        public Solution(Item[] items, int max_weight) {
            this.items = items;
            result = new int[items.length];
            this.freeSpace = max_weight;
            this.upperBound = items[0].ratio * this.freeSpace;
        }

        /**
         * Constructor copia a partir de otra solucion
         */
        public Solution(Solution other) {
            this.items = other.items;
            this.value = other.getValue();
            this.result = other.result.clone();
            this.freeSpace = other.freeSpace;
            this.next = other.next;
            this.upperBound = other.upperBound;
        }

        /**
         * Mete el siguiente elemento en la mochila
         */
        public void addNextElement() {
            result[next] = 1;
            value += items[next].value;
            freeSpace -= items[next].weight;
            next++;
            upperBound = value;
            if (next < items.length) {
                upperBound += this.items[next].ratio * this.freeSpace;
            }
        }

        /**
         * Salta el siguiente elemento (no lo mete en la mochila)
         */
        public void skipNextElement() {
            result[next] = 0;
            next++;
            upperBound = value;
            if (next < items.length) {
                upperBound += this.items[next].ratio * this.freeSpace;
            }
        }

        /**
         * Valor total de los objetos en la mochila
         */
        public double getValue() {
            return value;
        }

        public void copySol(Solution sol) {
            this.items = sol.items; //Comparten referencia a los datos.
            this.value = sol.getValue();
            this.result = sol.result.clone();
            this.freeSpace = sol.freeSpace;
            this.next = sol.next;
            this.upperBound = sol.upperBound;
        }

        /**
         * Devuelve true si es una solucion completa y factible
         */
        public boolean isSolution() {
            return next == items.length && freeSpace >= 0.0D;
        }

        /**
         * Devuelve true si el candidato es prometedor
         */
        public boolean isCandidate(int index) {// EsPrometedor
            return freeSpace - items[index].weight >= 0.0;
        }


        /**
         * Devuelve la cota superior (valor+estimacion optimista)
         */
        public double getUpperBound() {
            return this.upperBound;
        }

        /**
         * Devuelve una lista con las soluciones factibles que
         * son hijas de esta solucion actual.
         */
        public List<Solution> getChildren() {
            List<Solution> children = new ArrayList<Solution>(2);
            //Hijo 0: pasar al siguiente elemento
            Solution child0 = new Solution(this);
            child0.skipNextElement();
            children.add(child0);
            //Hijo 1: meter el elemento actual
            if (this.isCandidate(next)) {
                Solution child1 = new Solution(this);
                child1.addNextElement();
                children.add(child1);
            }
            return children;
        }

        @Override
        public int compareTo(Solution o) {

            /* Dar prioridad a las soluciones mas completas */
            int nivel = Integer.compare(this.next, o.next);
            if (nivel != 0)
                return -nivel; //Signo negativo para ordenar de mayor a menor
            /* Si estan al mismo nivel la mas prometedora*/
            return -Double.compare(this.upperBound, o.upperBound);
        }

        @Override
        public String toString() {
            return "Solution{" +
                    "value=" + value +
                    ", freeSpace=" + freeSpace +
                    ", next=" + next +
                    ", result=" + Arrays.toString(result) +
                    ", upperBound=" + upperBound +
                    ", items=" + Arrays.toString(items) +
                    '}';
        }
    }

}




