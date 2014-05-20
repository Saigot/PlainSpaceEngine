/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plainspaceengine;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael17
 */
public class Vec {
    float x;
    float y;
    float z;
    Point anchor;
    boolean twoD = false;
    boolean anchored;
    
    public Vec(float x, float y , float z){
        this.x = x;
        this.y = y;
        this.z = z;
        twoD = false;
        anchored = false;
    }
    public Vec(float x, float y , float z, Point p){
        this.x = x;
        this.y = y;
        this.z = z;
        twoD = false;
        anchored = true;
        anchor = p;
    }
    public Vec(float x, float y , float z, boolean twoD){
        this.x = x;
        this.y = y;
        this.z = z;
        twoD = false;
        if(twoD){
            this.z = 0;
            twoD = true;
        }
    }
    public Vec(float x, float y , float z, Point p, boolean twoD){
        this.x = x;
        this.y = y;
        this.z = z;
        twoD = false;
        if(twoD){
            this.z = 0;
            twoD = true;
        }
        anchored = true;
    }
    public Vec(float x, float y ){
        twoD = true;
        this.x = x;
        this.y = y;
        this.z = 0;
    }
    
    public float dot( Vec v){
        return x * v.x + y *v.y + z * v.z;
    }
    
    public Vec cross(Vec v){
        Vec ret = new Vec(y * v.z - v.y*z,
                z * v.x - x * v.z, 
                x * v.y - v.x * y);
        return ret;
    }
    
    public static Vec add(Vec vec1, Vec vec2){
        Vec ret = new Vec(vec1.x + vec2.x, vec1.y + vec2.y, vec1.z + vec2.z);
        return ret;
    }
    
    public Vec scale(float n){
        return new Vec(x*n, y*n, z*n);
    }
    
    // projection of vec onto this.
    public Vec proj(Vec vec){
        float constant = dot(vec) / dot(this);
        Vec ret;
        try {
            ret = (Vec)this.clone();
        } catch (CloneNotSupportedException ex) {
           System.out.print("Error could not copy");
           ret = null;
        }
        ret.scale(constant);
        return ret;
    }
    public Vec perp(Vec vec){
        return add(vec,proj(vec).scale(-1));
    }
    
    public Point getTerminalPoint(){
        return new Point(x+anchor.x, y+anchor.y, z+anchor.z);
    }
}
