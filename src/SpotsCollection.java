import java.io.IOException;
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
public class SpotsCollection extends GoogMatrixRequest{
	private List<String> names;
	private int size;
	private double[][] distances;
	
	
	public SpotsCollection() {
		names = new ArrayList<String>();
		size = 0;
		distances = new double[size][size];
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
		this.distances = new double[this.size][this.size];
	}

	public double[][] getDistances() {
		return distances;
	}

	public List<String> getNames() {
		return names;
	}

	public void addSpot(String name) {
	    names.add(name);
    }

    public void setDistances() throws IOException {
    	System.out.println(this.distances.length);
		for(int i=0;i<this.size;i++) {
			for(int j=0;j<this.size;j++) {
				if(i==j) {
					this.distances[i][j] = 0;
				}else {
					this.distances[i][j]=Distance(this.names.get(i),this.names.get(j));
				}
			}
		}
//		this.distances = distances;
	}
}
