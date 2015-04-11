package math;

import java.util.Scanner;

public class Point3D{
	public double x, y, z;


	public Point3D(String v) {
		Scanner s = new Scanner(v);
		x = s.nextDouble();
		y = s.nextDouble();
		z = s.nextDouble();
		s.close();
	}

	//TODO add methods/more constructors here
	public Point3D(Point3D p2){
		this.x = p2.x;
		this.y = p2.y;
		this.z = p2.z;
	}
	
	public void add(Point3D p2){
		this.x += p2.x;
		this.y += p2.y;
		this.z += p2.z;
	}
	
	public void sub(Point3D p2){
		this.x -= p2.x;
		this.y -= p2.y;
		this.z -= p2.z;
	}
	
	public void addVector(Vec vec){
		this.x += vec.x;
		this.y += vec.y;
		this.z += vec.z;
	}
	public void subVector(Vec vec){
		this.x -= vec.x;
		this.y -= vec.y;
		this.z -= vec.z;
	}
	
	public static Vec sub(Point3D p, Point3D p2){
		return new Vec(p2.x - p.x, p2.y - p.y, p2.z - p.z);
	}
	
	public static double length(Point3D p, Point3D p2){
		double dist1 = Math.pow(p2.x - p.x, 2);
		double dist2 = Math.pow(p2.y - p.y, 2);
		double dist3 = Math.pow(p2.z - p.z, 2);
		return Math.sqrt(dist1 + dist2 + dist3);
	}
	
	
}

