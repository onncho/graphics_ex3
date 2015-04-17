package ex3.render.raytrace;
import math.Vec;
import math.Point3D;

public class Intersection {
	private Point3D p;
	private double length;
	private Surface surface;
	
	public Intersection(Point3D p, double length, Surface surface){
		this.p = new Point3D(p);
		this.length = length;
		this.surface = surface;
	}

	public Point3D getP() {
		return p;
	}

	public double getLength() {
		return length;
	}

	public Surface getSurface() {
		return surface;
	}
	
}
