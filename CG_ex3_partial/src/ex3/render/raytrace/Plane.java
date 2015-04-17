package ex3.render.raytrace;

import math.Point3D;
import math.Ray;
import math.Vec;

public class Plane extends Surface {
	
	private Vec normal;
	private Point3D v0;
	
	public Plane(Vec normal, Point3D v0){
		this.normal = new Vec(normal);
		this.v0 = new Point3D(v0);
	}
	
	@Override
	public Intersection intersectRay(Ray ray) {
		//if the plane and the ray are parallel or the ray shoots at the back
		if(Vec.dotProd(normal, ray.v) >= 0){
			return null;
		}
		double si = Vec.dotProd(normal, Point3D.sub(ray.p, v0));
		si /= Vec.dotProd(normal, ray.v);
		Point3D intersectionPoint = new Point3D(ray.p);
		intersectionPoint.addVector(Vec.scale(si, ray.v));
		return new Intersection(intersectionPoint, si, this);
		
		
		//double t = Vec.dotProd(Vec.scale(1/Vec.dotProd(normal, V),Point3D.vecBetween(center , P0)), normal);
	}

}
