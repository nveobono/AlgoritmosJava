package tema6_byb;

import java.util.*;

public class TaskAssign {

    private static class Solution {
        private int[] sol;
        private int[][] costs;
        private int[] minCostVector;
        private int cost;
        private boolean[] candidates;
        private int lowerBound;
        private int nextAgent;

        public Solution(int[][] costs) {
            sol = new int[costs.length];
            this.minCostVector = new int[costs.length];
            this.costs = costs;
            cost = 0;
            candidates = new boolean[costs.length];
            Arrays.fill(candidates, true);
            lowerBound = 0;
            for(int a=0; a<costs.length; a++) {
                int minCost=Integer.MAX_VALUE;
                for(int t=0; t<costs.length; t++) {
                    if(costs[a][t]<minCost) {
                        minCost=costs[a][t];
                    }
                }
                this.minCostVector[a] = minCost;
                this.lowerBound += minCost;
            }
        }

        public Solution(Solution sol) {
            this.sol = sol.sol.clone();
            this.costs = sol.costs;
            this.minCostVector = sol.minCostVector.clone();
            this.cost = sol.cost;
            this.candidates = sol.candidates.clone();
            this.lowerBound = sol.lowerBound;
            this.nextAgent = sol.nextAgent;
        }

        public void addTask(int task) {
            sol[nextAgent] = task;
            candidates[task] = false;
            cost += costs[nextAgent][task];
//            updateLowerBound1(task);
            updateLowerBound2();
            nextAgent++;
        }

        private void updateLowerBound1(int task) {
            lowerBound -= minCostVector[nextAgent];
            lowerBound += costs[nextAgent][task];
        }

        private void updateLowerBound2() {
            lowerBound = 0;
            for (int a = nextAgent+1; a < sol.length; a++) {
                int minCost = Integer.MAX_VALUE;
                for (int t = 0; t < costs.length; t++) {
                    if (costs[a][t] < minCost && candidates[t]) {
                        minCost = costs[a][t];
                    }
                }
                this.minCostVector[a] = minCost;
                lowerBound+=minCost;
            }
            lowerBound += cost;
        }

        public boolean isSolution() {
            return nextAgent == costs.length;
        }

        public int getCost() {
            return cost;
        }

        public int getLowerBound() {
            return lowerBound;
        }

        public List<Solution> getChildren(){
            List<Solution> children = new ArrayList<Solution>();
            for(int i=0; i< costs.length; i++) {
                if(candidates[i]) {
                    Solution child = new Solution(this);
                    child.addTask(i);
                    children.add(child);
                }
            }
            return children;
        }

        @Override
        public String toString() {
            return Arrays.toString(sol);
        }
    }

    public static int[] minimumCosts(int[][] costs) {
        int[] minCosts = new int[costs.length];
        for (int i = 0; i < costs.length; i++) {
            minCosts[i] = Integer.MAX_VALUE;
            for (int j = 0; j < costs[i].length; j++) {
                minCosts[i] = Math.min(costs[i][j], minCosts[i]);
            }
        }
        return minCosts;
    }

    public static Solution initSol(int[][] costs) {
        Solution sol = new Solution(costs);
        for (int i = 0; i < costs.length; i++) {
            sol.addTask(i);
        }
        return sol;
    }

    public static Solution taskAssign(int[][] costs) {
        int nodosGenerados = 0;
        PriorityQueue<Solution> q = new PriorityQueue<>(costs.length, Comparator.comparingInt(s -> s.cost));
        Solution bestSol = initSol(costs);
        q.add(new Solution(costs));
        nodosGenerados++;
        while (!q.isEmpty()) {
            Solution current = q.poll();
            if (current.isSolution()) {
                if (current.cost < bestSol.getCost()) {
                    bestSol = current;
                }
            } else {
                if (current.getLowerBound() < bestSol.getCost()) {
                    for (Solution child : current.getChildren()) {
                        if (child.getLowerBound() < bestSol.getCost()) {
                            q.add(child);
                            nodosGenerados++;
                        }
                    }
                }
            }
        }
        System.out.println("Nodos generados: "+nodosGenerados);
        return bestSol;
    }

    public static void main(String[] args) {
        int[][] costs = new int[][] {
                {11, 12, 18, 40},
                {14, 15, 13, 22},
                {11, 17, 19, 23},
                {17, 14, 20, 28}
        };

        Solution best = taskAssign(costs);
        System.out.println(best);
        System.out.println("Cost: "+best.getCost());
    }
}
