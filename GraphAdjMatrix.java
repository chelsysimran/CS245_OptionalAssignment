//Chelsy Simran 
//CS 245: Optional Assignment

public class GraphAdjMatrix implements Graph 
{
    int[][] matrix; //2D matrix
    
    public GraphAdjMatrix(int size) //constructor
    {
        matrix = new int[size][size];    
        
        for (int i = 0; i < size; i++)
            
            for(int j = 0; j < size; j++)
                
                matrix[i][j] = -1;
    }

    public void addEdge(int v1, int v2) 
    {
        //"vestigial", said in instructions that these can be left unimplemented
    }

    public void topologicalSort() 
    {
        //"vestigial", said in instructions that these can be left unimplemented
 
    }

    public void addEdge(int v1, int v2, int weight) 
    {
        matrix[v1][v2] = weight;
        matrix[v2][v1] = weight;

    }

    public int getEdge(int v1, int v2) 
    {
        return matrix[v1][v2];
    }
    
    public int createSpanningTree()
    {
        int V = matrix.length;
        int vertex[] = new int[V];
        vertex[0] = -1;
        int tree[] = new int [V];
       
       Boolean visited[] = new Boolean[V];
        
        for (int i = 0; i < V; i++)
        {
            tree[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        
        tree[0] = 0;
        
        for (int i = 0; i < V-1; i++)
        {
            int index = minValue(tree, visited);
            
            visited[index] = true;
            
            for (int target = 0; target < V; target++)
                
                if (matrix[index][target]!= -1 && visited[target] == false && matrix[index][target] < tree[target])
                {
                    vertex[target]  = index; 
                    tree[target] = matrix[index][target];
                }
        }
        
        int result = 0;
        
        for (int i = 1; i < V; i++) 
        {
            result += matrix[i][vertex[i]];
        }

        return result;

    }
    
    public int minValue(int tree[], Boolean visited[])
    {
        int V = matrix.length;
        int minVal = Integer.MAX_VALUE;
        int minIndex = -1;
        
        for (int i = 0; i < V; i++)
            
            if (visited[i] == false && tree[i] < minVal)
            {
                minVal = tree[i];
                minIndex = i;
            }

        return minIndex;
    }
}
