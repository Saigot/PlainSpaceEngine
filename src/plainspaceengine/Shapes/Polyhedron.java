
package plainspaceengine.Shapes;

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
    
    //Moves the Anchor Relative to the vertexes, useful for changing the point being rotated from
    public void MoveAnchor(Point newLocation){
    }
    public void MoveTo(Point newLocation){
        Anchor = newLocation;
    }
}
