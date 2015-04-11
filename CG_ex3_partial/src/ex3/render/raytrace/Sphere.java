package ex3.render.raytrace;
import java.util.Map;

import math.Point3D;
import math.Ray;
import math.Vec;
import math.Equations;

public class Sphere extends Surface {
	private Point3D center;
	private double radius;

	public Sphere() {
		super();
	}


	//init all variables from the xml
	public void init(Map<String, String> attributes) {
		super.init(attributes);
		if (attributes.containsKey("center")) {
			center = new Point3D(attributes.get("center"));
		}
		if (attributes.containsKey("radius")) {
			radius = (Double.parseDouble(attributes.get("radius")));
		}	
	}
	
	@Override
	public Intersection intersectRay(Ray ray){
		double a = 1;
		Vec v1 = Vec.scale(2, ray.v);
		Vec v2 = Point3D.sub(center, ray.p);
		double b = Vec.dotProd(v1, v2);
		double c = Math.pow(Point3D.sub(center, ray.p).length(), 2) - Math.pow(radius ,2);
		double t = Equations.solveQuadratic(a,b,c);
		Point3D p = new Point3D(ray.p);
		p.addVector(Vec.scale(t, ray.v));
		return new Intersection(p, t, this);
	}

	public Point3D getCenter() {
		return center;
	}

	public double getRadius() {
		return radius;
	}
}
