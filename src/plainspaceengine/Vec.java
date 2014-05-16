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
    boolean twoD = false;
    Point anchor;
    
    public Vec(float x, float y , float z){
        this.x = x;
        this.y = y;
        this.z = z;
        twoD = false;
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
    
    public Vec(float x, float y ){
        twoD = true;
        this.x = x;
        this.y = y;
        this.z = 0;
    }
    
    public Vec(float x, float y , float z, Point a){
        this.x = x;
        this.y = y;
        this.z = z;
        twoD = false;
        anchor = a;
    }
    
    public Vec(float x, float y , float z, Point a, boolean twoD){
        this.x = x;
        this.y = y;
        this.z = z;
        twoD = false;
        if(twoD){
            this.z = 0;
            twoD = true;
        }
        anchor = a;
    }
    
    public Vec(float x, float y , Point a){
        twoD = true;
        this.x = x;
        this.y = y;
        this.z = 0;
        anchor =a;
    }
    
    public static float dot(Vec vec1, Vec vec2){
        return vec1.x * vec2.x + vec1.y *vec2.y + vec1.z * vec2.z;
    }
    
    public static Vec cross(Vec vec1, Vec vec2){
        Vec ret = new Vec(vec1.y * vec2.z - vec2.y*vec1.z,
                vec1.z * vec2.x - vec1.x * vec2.z, 
                vec1.x * vec2.y - vec2.x * vec1.y);
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
        float constant = dot(this,vec) / dot(this, this);
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
    
}
