import java.util.*;

public class P399_除法求值 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = doGraph(equations, values);
        double[] res = new double[queries.size()];
        int index = 0;
        for (List<String> query : queries) {
            res[index++] = dfs(graph, new HashSet<>(), query.get(0), query.get(1), 1);
        }
        return res;
    }

    public double dfs(Map<String, Map<String, Double>> graph, Set<String> visited,
                      String start, String end, double ans) {
        if(!graph.containsKey(start) || !graph.containsKey(end)) return -1;
        Map<String, Double> edges = graph.get(start);
        for (String s : edges.keySet()) {
            if(!visited.contains(s)) {
                visited.add(s);
                double v = edges.get(s);
                if(s.equals(end)) return ans*v;
                double d = dfs(graph, visited, s, end, ans*v);
                if(d != -1) return d;
            }
        }
        return -1;
    }


    private Map<String, Map<String, Double>> doGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        int i = 0;
        for (List<String> equation : equations) {
            String s = equation.get(0);
            String t = equation.get(1);
            double val = values[i];
            Map<String ,Double> edge1 = graph.getOrDefault(s, new HashMap<>());
            edge1.put(t, val);
            graph.put(s, edge1);

            Map<String ,Double> edge2 = graph.getOrDefault(t, new HashMap<>());
            edge2.put(s, 1/val);
            graph.put(t, edge2);
            i++;
        }
        return graph;
    }
}
