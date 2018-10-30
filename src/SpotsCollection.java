import java.util.*;


/**
 * @author Haoran Geng, Xijie Guo
 *This class contains a collection of spots
 *It contains a list of spots and distance between each spots
 *
 *The list of each spots will store in a stack
 *
 *The distance between each spots will store in a 2D array
 *EXAMPLE:
 *  A,B,C,D
 *A:0,1,2,3
 *B:1,0,4,6
 *C:2,4,0,7
 *D:3,6,7,0
 *Each row represent different spots. The number in the row represent the distance between 
 *the spots and another spots.
 *In the example graph: the disterence between each spots are:
 *A-B:1,A-C:2,A-D:3,B-C:4,B-D:6,C-D:7
 */
public class SpotsCollection {
	private List<String> names;
	private int size;
	private int[][] distances;
	
	
	public SpotsCollection() {
		names = new ArrayList<String>();
		size = 0;
		distances = new int[size][size];
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int[][] getDistances() {
		return distances;
	}

	public List<String> getNames() {
		return names;
	}

	public void addSpots(String name) {
	    names.add(name);
    }

    public void setDistances(int[][] distances) {
		this.distances = distances;
	}
}
