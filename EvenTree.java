import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static class Tree
    {
        Set<Tree> children;
        final int value;
        
        public Tree(int value)
        {
            this.children = new HashSet<>();
            this.value = value;
        }
        
        public void add(Tree t)
        {
            if(t != null)
            {
                this.children.add(t);    
                t.children.add(this);
            }
        }
        
        public void remove(Tree t)
        {
            if(t != null)
            {
                this.children.remove(t);
                t.children.remove(this);
            }
        }
        
        public int size()
        {
            return children.stream().mapToInt(c -> c.size(this)).sum() + 1;
        }
        
        public int size(Tree parent)
        {
            return children.stream().filter(c -> c != parent).mapToInt(c -> c.size(this)).sum() + 1;
        }
    }

    static int evenTree(int n, int m, int[][] tree) {
        Map<Integer, Tree> trees = IntStream.rangeClosed(1, n).
            boxed().
            collect(Collectors.toMap(k -> k, v -> new Tree(v)));
        
        Stream.of(tree).forEach(edge -> trees.get(edge[0]).add(trees.get(edge[1])));
        Tree root = trees.get(1);
        
        return tree.length - partition(root, null);
    }
    
    static int partition(Tree t, Tree root)
    {
        if(t == null)
        {
            return 0;
        }

        int edges = 0;
        for(Tree c : new HashSet<>(t.children))
        {
            if(c != root)
            {
                if(c.size(t) % 2 == 0)
                {
                    t.remove(c);
                    edges += partition(c, null);
                }
                else
                {
                    edges += partition(c, t);
                }
            }
        }
        
        return edges + (root == null ? t.size() - 1 : 0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] tree = new int[m][2];
        for(int tree_i = 0; tree_i < m; tree_i++){
            for(int tree_j = 0; tree_j < 2; tree_j++){
                tree[tree_i][tree_j] = in.nextInt();
            }
        }
        int result = evenTree(n, m, tree);
        System.out.println(result);
        in.close();
    }
}
