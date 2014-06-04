/* 
 * File:   Point.h
 * Author: Michael17
 *
 * Created on May 30, 2014, 11:43 AM
 */

#ifndef POINT_H
#define	POINT_H

class Point {
public:
    float x;
    float y;
    float z;
    Point();
    Point(float x, float y, float z);
    bool operator==(const Point  &pt);
    Point(const Point& orig);
    virtual ~Point();
private:

};

#endif	/* POINT_H */

