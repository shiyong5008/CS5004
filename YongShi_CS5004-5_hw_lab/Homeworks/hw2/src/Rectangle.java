import java.util.NoSuchElementException;

/**
 * CS 5004 summer, homework2
 * write a class Rectangle
 * @author Yong Shi
 * 2021.6.11
 */
public class Rectangle {
    private int x;
    private int y;
    private int w;
    private int h;

    /**
     * Write a constructor that creates a rectangle
     * using the x, y coordinates of its lower left corner,
     * its width and its height in that order.
     * Creating a rectangle with non-positive width or height should not be allowed,
     * although x and y are allowed to be negative.
     */
    public Rectangle(int x, int y, int w, int h){
        if (w<=0 || h<=0) {
            throw new IllegalArgumentException("height and width wrong!");
        }
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
    }

    /**
     * Write a method overlap(Rectangle other).
     * This method should return
     * true if this rectangle overlaps with other, false otherwise.
     * Rectangles that touch each other are not considered to be overlapping.
     */
    public boolean overlap(Rectangle other){
        if (other.x>=this.x+this.w || other.x+other.w<=this.x || other.y>=this.y+this.h || other.y+other.h<=this.y){
            return false;
        } // use the point to check if one rectangle is completely outside the other one.
        return true;
    }

    /**
     * Write a method intersect(Rectangle other).
     * This method should return a Rectangle object
     * that represents the overlap of the two rectangles.
     * If no intersection exists, it should throw a
     * NoSuchElementException with a helpful message.
     */
    public Rectangle intersect(Rectangle other){
        if (other.x>=this.x+this.w || other.x+other.w<=this.x || other.y>=this.y+this.h || other.y+other.h<=this.y){
            throw new NoSuchElementException("there is no overlap!");
        }// same as above if no overlap.

        int xBottomLeft = this.x;
        int yBottomLeft = this.y;

        int xTopRight = this.x + this.w;
        int yTopRight = this.y + this.h;

        int xBottomLeftOther = other.x;
        int yBottomLeftOther = other.y;

        int xTopRightOther = other.x + other.w;
        int yTopRightOther = other.y + other.h;

        int xBottomLeftInter = Math.max(xBottomLeft, xBottomLeftOther);
        int yBottomLeftInter = Math.max(yBottomLeft, yBottomLeftOther);

        int xTopRightInter = Math.min(xTopRight, xTopRightOther);
        int yTopRightInter = Math.min(yTopRight, yTopRightOther);

        if (xBottomLeftInter > xTopRightInter || yBottomLeftInter > yTopRightInter) {
            throw new NoSuchElementException("there is no overlap!");
        }

        // return the new inter rectangle.
        Rectangle interR = new Rectangle(xBottomLeftInter, yBottomLeftInter,
                xTopRightInter - xBottomLeftInter, yTopRightInter - yBottomLeftInter);
        return interR;
    }

    /**
     * Write a method union(Rectangle other).
     * This method returns a Rectangle object
     * that represents the union of this rectangle and the other rectangle.
     * The union is the smallest rectangle that contains both rectangles.
     * Note that unlike the intersection, the union always exists.
     */
    public Rectangle union(Rectangle other) {
        int xBottomLeft = Math.min(this.x, other.x);
        int yBottomLeft = Math.min(this.y, other.y);
        int yTopLeft = Math.max(this.y + this.h, other.y + other.h);
        int xTopRight = Math.max(this.x + this.w, other.x + other.w);
        int xBottomRight = xTopRight;

        // return the new union rectangle.
        Rectangle unionR = new Rectangle(xBottomLeft, yBottomLeft, xBottomRight - xBottomLeft,
                yTopLeft - yBottomLeft);
        return unionR;
    }

    /** Write a method toString that returns a String.
     * The string should be formatted exactly as:
     * x:2, y:3, w:4, h:5 without the quotation marks
     * and replacing the numbers with the actual attributes of the object.
     */
    public String toString() {
        return ("x:" + x + ", y:" + y + ", w:" + w + ", h:" + h);
    }

}
