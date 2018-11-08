import java.util.List;
import java.util.ArrayList;


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
	private List<Spot> spots;
	private int numSpots;
	private double[][] distanceMatrix;

	public SpotsCollection() {
		spots = new ArrayList<Spot>();
		numSpots = 0;
	}

	public List<Spot> getSpots() {
		return spots;
	}

	public int getNumSpots() {
		return numSpots;
	}

	public void setNumSpots(int numSpots){
		this.numSpots = numSpots;
	}

	public double[][] getDistanceMatrix() {
		return distanceMatrix;
	}

	public void addSpot(String name) {
	    spots.add(new Spot(name));
	    numSpots++;
    }

    public void deleteSpot() {
        spots.remove(spots.size()-1);
		numSpots--;
    }

    public void setDistanceMatrix(double[][] distanceMatrix) {
		this.distanceMatrix = distanceMatrix;
	}

	public void saveDistancesToMatrix() throws Exception {
		distanceMatrix = new double[numSpots][numSpots];
		for(int i = 0; i < numSpots; i++) {
			for(int j = 0;j < numSpots; j++) {
				if(i == j)
					distanceMatrix[i][j] = 0.0;
				else
					distanceMatrix[i][j]= GoogleMapsHandler.Distance(spots.get(i).getName(), spots.get(j).getName());
			}
		}
	}
}
