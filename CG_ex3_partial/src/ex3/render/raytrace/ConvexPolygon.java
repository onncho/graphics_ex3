package ex3.render.raytrace;
import java.util.LinkedList;
import java.util.Map;

import math.Point3D;
import math.Ray;
import math.Vec;


public class ConvexPolygon extends Surface {

	private LinkedList<Point3D> points;
	private Vec normal;

	public ConvexPolygon() {
		super();
		points = new LinkedList<Point3D>();
		normal = new Vec("0 0 0");
	}

	//init all variables from the xml
	public void init(Map<String, String> attributes) {
		super.init(attributes);
		for (int i = 0; i < attributes.size(); i++) {
			String tempPoint = "p" + i;
			if (attributes.containsKey(tempPoint)) {
				points.add(new Point3D(attributes.get(tempPoint)));
			}
		}
		Vec v1 = Point3D.sub(points.get(0), points.get(1));
		Vec v2 = Point3D.sub(points.get(0), points.get(2));
		normal = Vec.crossProd(v1, v2);
	}
	
	@Override
	public Intersection intersectRay(Ray ray){
		int length = points.size();
		Vec normal = Vec.crossProd(Point3D.sub(points.get(1), points.get(0)), 
				Point3D.sub(points.get(2), points.get(1)));
		Intersection intersection = new Plane(normal, points.get(0)).intersectRay(ray);
		if(intersection == null){
			return null;
		}
		Point3D intersectionPoint = intersection.getP();

		for(int i = 0; i < points.size(); i++){
			if(!checkTwoDots(points.get((i + 1) % length), points.get(i),ray, intersectionPoint)){
				return null;
			}
		}
		
		return intersection;
	}

	public LinkedList<Point3D> getPointsLinkedList() {
		return points;
	}
	
	private boolean checkTwoDots(Point3D p0, Point3D p1, Ray ray, Point3D intersectionPoint){
		Vec v1 = Point3D.sub(ray.p, p0);
		Vec v2 = Point3D.sub(ray.p, p1);
		Vec normal1 = Vec.crossProd(v2, v1);
		normal1.scale(1 / normal1.length());
		
		return Vec.dotProd(Point3D.sub(ray.p, intersectionPoint), normal1) < 0;
	}
}
