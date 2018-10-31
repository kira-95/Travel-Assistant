import java.util.*;
import java.util.Stack;

/**
 * @author Haoran Geng, Xijie Guo
 * 
 * Each time finding the min path along the nodes
 * store the nodes into the stack
 *
 */
public class ShortestRout {

	public static List<String> findShortest(SpotsCollection spots) {
		int [][] distances = spots.getDistances();
		List<String> names = spots.getNames();
		int numberOfNodes = spots.getSize();

		List<String> result = new ArrayList<String>();
		Stack<String> stack = new Stack<String>();
		int[] visited = new int[numberOfNodes + 1];
		visited[0]= 1;
		int element, dst = 0, i = 0, min = Integer.MAX_VALUE;
		boolean minFlag = false;

		stack.push(names.get(0));
		result.add(names.get(0));

		for(int k = 1; k < numberOfNodes - 1; k++) {
			for(int j = 1; j <= numberOfNodes - 1; j++) {
				if(distances[k][j] == 1 && distances[j][k] == 0) {
					distances[j][k] = 1;
				}
			}
		}
		
		while(!stack.isEmpty()) {
			element = names.indexOf(stack.peek());
			i = 0;
			min = Integer.MAX_VALUE;
			while(i < numberOfNodes) {
				if(distances[element][i] > 1 && visited[i] == 0 && min > distances[element][i]) {
					min  = distances[element][i];
					dst = i;
					minFlag = true;
				}
				i++;
			}
			if(minFlag) {
				visited[dst] = 1;
				stack.push(names.get(dst));
				result.add(names.get(dst));
				minFlag = false;
				continue;
			}
			stack.pop();
		}

		return result;
	}
}
