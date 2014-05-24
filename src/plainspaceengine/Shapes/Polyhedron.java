
package plainspaceengine.Shapes;

import java.util.ArrayList;
import plainspaceengine.Point;

/**
 * We store a list of Vertexes, to add more vertexes we must specify a list of 
 * indexes of points we are connecting to. From the vectors we have an addToSpace
 * which places the vectors in order form furthest to greatest.
 * The vectors are placed and stored relative to an anchor point
 * @author Michael Scovell
 */
public class Polyhedron {
    Point Anchor;
    ArrayList<Vertex> vert = new ArrayList<>();
    //Moves the Anchor Relative to the vertexes, useful for changing the point being rotated from
    public void MoveAnchor(Point newLocation){
    }
    public void MoveTo(Point newLocation){
        Anchor = newLocation;
    }
    
    public Polyhedron Merge(Polyhedron toAdd, int mergedPts1[], int mergedPts2[] ){
        return null;
    }
    
    public void addPoint(Point p, int... connections){
        
    }
}
