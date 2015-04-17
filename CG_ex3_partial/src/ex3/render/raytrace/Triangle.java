package ex3.render.raytrace;
import java.util.Map;

import math.Point3D;
import math.Ray;
import math.Vec;


public class Triangle extends Surface {
	private Point3D p0;
	private Point3D p1;
	private Point3D p2;
	
	
	public Triangle() { 
		super();
	}

	//init all variables from the xml
	public void init(Map<String, String> attributes) {
		super.init(attributes);
		if (attributes.containsKey("p0")) {
			p0 = new Point3D(attributes.get("p0"));
		}
		if (attributes.containsKey("p1")) {
			p1 = new Point3D(attributes.get("p1"));
		}
		if (attributes.containsKey("p2")) {
			p2 = new Point3D(attributes.get("p2"));
		}
	}
	
	@Override
	public Intersection intersectRay(Ray ray){		
		//finding all vectors
		Vec v1 = Point3D.sub(ray.p, p0);
		Vec v2 = Point3D.sub(ray.p, p1);
		Vec v3 = Point3D.sub(ray.p, p2);
		
		//finding all normals
		Vec normal1 = Vec.crossProd(v2, v1);
		normal1.scale(1 / normal1.length());
		
		Vec normal2 = Vec.crossProd(v3, v2);
		normal2.scale(1 / normal2.length());
		
		Vec normal3 = Vec.crossProd(v1, v3);
		normal3.scale(1 / normal3.length());
		
		//finding intersection with plane
		Vec normal = Vec.crossProd(Point3D.sub(p1, p0), Point3D.sub(p2, p1));
		Intersection intersection = new Plane(normal, p0).intersectRay(ray);
		if(intersection == null){
			return null;
		}
		Point3D intersectionPoint = intersection.getP();
		
		
		//doing all three tests
		if((Vec.dotProd(Point3D.sub(ray.p, intersectionPoint), normal1) < 0) ||
				(Vec.dotProd(Point3D.sub(ray.p, intersectionPoint), normal2) < 0) ||
				(Vec.dotProd(Point3D.sub(ray.p, intersectionPoint), normal3) < 0)){
			return null;
		}
		return intersection;
	}

	public Point3D getP0() {
		return p0;
	}

	public Point3D getP1() {
		return p1;
	}

	public Point3D getP2() {
		return p2;
	}
	
	
	
}



	