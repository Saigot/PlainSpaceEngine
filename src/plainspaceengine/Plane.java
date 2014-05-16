/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plainspaceengine;

/**
 *
 * @author Michael17
 */
public class Plane {
    Vec vec1;
    Vec vec2;
    Vec norm;
    boolean normDefined;
    boolean vectorDefined;
    
    /**All finite planes must be vectordefined. 
     * A finite plane is defined as:
     * plane = a*vec1 + b*vec2 
     * where scalarmin1 <= a <= scalarmax1
     * with the same case for b
     * if either of the scalar maxima are 0, they will be treated as unbounded.
     * for a finite plane, at least one of the scalar maxima for each vector must be defined.
     */
    boolean finite;
    float scalarmax1;
    float scalarmax2;
    float scalarmin1;
    float scalarmin2;
}
