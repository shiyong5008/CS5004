//Write a class Vector3D that represents a 3D vector. This class should contain the following:
        import java.lang.*;
public class Vector3D {
    //instance variables
    double x;
    double y;
    double z;
    //1-A constructor that takes in x, y, z components of the vector.
    public Vector3D(double v1,double v2,double v3){
        this.x=v1;
        this.y=v2;
        this.z=v3;
    }
    //2-Methods to get the values of individual components (e.g. getX ,etc.).
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public double getZ(){
        return this.z;
    }
    //3-A toString method that returns a string that describes this vector. This string should be of the form “(x,y,z)” replacing the letters with their values. Each component should be formatted to round to exactly two decimal places (look at the String.format method to see how to do this).
    public String toString(){
        //displays only two decimal values
        return ("("+String.format("%.2f",this.x)+", "+String.format("%.2f",this.y)+", "+String.format("%.2f",this.z)+")");
    }
    //4-A method getMagnitude that returns its magnitude.
    public double getMagnitude(){
        double val=Math.pow(this.x,2)+Math.pow(this.y,2)+Math.pow(this.z,2);
        return(Math.sqrt(val));
    }
    //5-A method normalize that returns a normalized version of this vector.It should throw an IllegalStateException object if this operation cannot be completed.
    public double normalize() {
        double v1,v2,v3;
        double val=Math.pow(this.x,2)+Math.pow(this.y,2)+Math.pow(this.z,2);
        double vn = Math.sqrt(val);
        v1 = this.x / vn;
        v2 = this.y / vn;
        v3 = this.z / vn;
        return v1;
        //return ("(" + String.format("%.2f", v1) + "," + String.format("%.2f", v2) + "," + String.format("%.2f", v3) + ")");
    }
    //6-A method add that returns the result of adding this vector to another vector. It should not change the vectors that are being added.
    public String add(Vector3D o){
        double v1,v2,v3;
        v1=this.x+o.x;
        v2=this.y+o.y;
        v3=this.z+o.z;
        return ("("+String.format("%.2f",v1)+","+String.format("%.2f",v2)+","+String.format("%.2f",v3)+")");
    }
    //7-A method multiply that returns the result of multiplying this vector by a constant. It should not change the vector that is being multiplied
    public String multiply(double n){
        double v1,v2,v3;
        v1=this.x*n;
        v2=this.y*n;
        v3=this.z*n;
        return("("+String.format("%.2f",v1)+","+String.format("%.2f",v2)+","+String.format("%.2f",v3)+")");
    }
    //8-A method dotProduct that returns the dot product of this vector and another vector. It should not change the two vectors
    public double dotProduct(Vector3D o){
    //a.b=|a|*|b|*cos(angle)
        double dot_value;
        dot_value=this.getMagnitude()*o.getMagnitude();
        dot_value=dot_value*Math.cos(this.angleBetween(o));
        return dot_value;
    }
    //9-A method angleBetween that returns the angle between two vectors in degrees. It should not change the two vectors. It should throw an IllegalStateException if this operation cannot be completed.
    public double angleBetween(Vector3D o){
        //angle=cos^-1(a.b/|a|.|b|)
        double simpleDotProduct=this.x*o.x+this.y*o.y+this.z*o.z;
        double value1=(simpleDotProduct/(this.getMagnitude()*o.getMagnitude()));
        double angle=Math.acos(value1); //finds cos inverse
        return angle;
    }
    //my tests in the codes
    public static void main(String args[]){
        Vector3D v1=new Vector3D(2.3, 3.5, 4.4);
        Vector3D v2=new Vector3D(6.67, 3.45, 9.23);
        System.out.println("Vector 1 : "+v1.toString());
        System.out.println("Vector 2 : "+v2.toString());
        System.out.println("The magnitude of vector v1 :"+String.format("%.2f",v1.getMagnitude()));
        System.out.println("The magnitude of vector v2 :"+String.format("%.2f",v2.getMagnitude()));
        System.out.println("The normalize of vector v1.x :"+v1.normalize());
        System.out.println("The normalize of vector v2.x :"+v2.normalize());
        System.out.println("The addition of vector v1 and v2 :"+v1.add(v2));
        System.out.println("The vector v1 multiplied by constant 5 :"+v1.multiply(5));
        System.out.println("The Dot product of two vectors v1 and v2 :"+String.format("%.2f",v1.dotProduct(v2)));
        System.out.println("The angle between 2 vectors :"+String.format("%.2f",v1.angleBetween(v2)));
    }
}

