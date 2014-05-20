/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plainspaceengine.Shapes;

import plainspaceengine.Vec;

/**
 *
 * @author Michael17
 */
public class Plane {
    private Vec vec1;
    private Vec vec2;
    private Vec norm;
    
    /**All finite planes must be vectordefined. 
     * A finite plane is defined as:
     * plane = a*vec1 + b*vec2 
     * where scalarmin1 <= a <= scalarmax1
     * with the same case for b
     * if either of the scalar maxima are 0, they will be treated as unbounded.
     * for a finite plane, at least one of the scalar maxima for each vector must be defined.
     */
    private boolean finite;
    private float scalarmax1;
    private float scalarmax2;
    private float scalarmin1;
    private float scalarmin2;
    
    //assumes infinite
    public Plane(Vec v1, Vec v2){
       this(v1,v2,false);
    }
    
    public Plane(Vec v1, Vec v2, boolean finite){
        norm = v1.cross(v2);
        this.finite = finite;
        if(finite){
            scalarmax1 = 1;
            scalarmax2 = 1;
            scalarmin1 = -1;
            scalarmin2 = -1;
        }
    }
    
    //getters and setters
    public float getMax1(){
        return scalarmax1;
    }
    public float getMax2(){
        return scalarmax2;
    }
    public float getMin1(){
        return scalarmin1;
    }
    public float getMin2(){
        return scalarmin2;
    }
    
    public void setMax(float n1,float n2){
        scalarmax1 = n1;
        scalarmax2 = n2;
    }
    public void setMin(float n1,float n2){
        scalarmin1 = n1;
        scalarmin2 = n2;
    }
    
    
    //
    //Actual  Functions
    //
    public Vec proj(Vec v){        
        return norm.perp(v);
    }
}
