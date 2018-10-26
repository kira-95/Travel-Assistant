import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 */

/**
 * @author genghaoran
 * 
 * Each time finding the min path along the nodes
 * store the nodes into the stack
 *
 */
public class ShortestRout {
	public static ArrayList<String> FindShortest(SpotsCollection Spots){
		
		ArrayList<String> result = new ArrayList<String>();
		Stack<String>  names = new Stack<String>();
		int numberofNodes = Spots.size;
		int[] visited = new int[numberofNodes + 1];
		visited[0]= 1;
		names.push(Spots.names.get(0));
		int element,dst = 0,i;
		int min = Integer.MAX_VALUE;
		boolean minFlag = false;
		result.add(Spots.names.get(0));
		
		for(int k = 1; k < numberofNodes-1;k++) {
			for(int j = 1;j<=numberofNodes-1;j++) {
				if(Spots.distances[k][j]==1 && Spots.distances[j][k]==0) {
					Spots.distances[j][k]=1;
				}
			}
		}
		
		while(!names.isEmpty()) {
			element = Spots.names.indexOf(names.peek());
			i = 0;
			min = Integer.MAX_VALUE;
			while(i < numberofNodes) {
				if(Spots.distances[element][i] > 1 && visited[i]==0) {
					if(min > Spots.distances[element][i]) {
						min  = Spots.distances[element][i];
						dst = i;
						minFlag = true;
					}
				}
				i++;
			}
			if(minFlag) {
				visited[dst] = 1;
				names.push(Spots.names.get(dst));
				result.add(Spots.names.get(dst));
				minFlag = false;
				continue;
			}
			names.pop();
		}
		

		return result;
	}
}
