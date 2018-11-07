import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Xijie Guo, Haoran Geng
 * 
 * Each time finding the min path along the nodes
 * store the nodes into the stack
 *
 */
public class ShortestRoute {

	public static List<String> findNearestNeighbor(SpotsCollection sc) {
		double[][] distances = sc.getDistanceMatrix();
		List<Spot> spots = sc.getSpots();
		int numberOfNodes = sc.getNumSpots();

		List<String> result = new ArrayList<String>();
		Stack<String> stack = new Stack<String>();
		int[] visited = new int[numberOfNodes + 1];
		visited[0]= 1;
		int element = 0, dst = 0, i = 0;
		double min = Double.MAX_VALUE;
		boolean minFlag = false;

		stack.push(spots.get(0).getName());
		result.add(spots.get(0).getName());

		for(int k = 1; k < numberOfNodes - 1; k++) {
			for(int j = 1; j <= numberOfNodes - 1; j++) {
				if(distances[k][j] == 1 && distances[j][k] == 0) {
					distances[j][k] = 1;
				}
			}
		}
		
		while(!stack.isEmpty()) {

			String name = stack.peek();
			for (Spot spot: spots) {
				if (spot.getName().equals(name))
					element = spots.indexOf(spot);
			}

			i = 0;
			min = Double.MAX_VALUE;
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
				stack.push(spots.get(dst).getName());
				result.add(spots.get(dst).getName());
				minFlag = false;
				continue;
			}
			stack.pop();
		}

		return result;
	}

	/**
	 * Calculate a shortest path among those spots in a brute force but the most optimal way
	 * due to the number of spots
	 */
	public static List<String> findShortestPath(SpotsCollection sc) {
		List<Spot> spots = sc.getSpots();
		List<String> res = new ArrayList<String>();
		return res;
	}
}
