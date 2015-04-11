package ex3.render.raytrace;
import java.util.Map;

import math.Point3D;
import math.Ray;
import math.Vec;

public class Disc extends Surface {
	
	private Point3D center;
	private double radius;
	private Vec normal;
	
	public Disc() {
		super();
	}
	
	//init all variables from the xml
	public void init(Map<String, String> attributes) {
		if (attributes.containsKey("center")) {
			center = new Point3D(attributes.get("center"));
		}
		if (attributes.containsKey("radius")) {
			radius = (Double.parseDouble(attributes.get("radius")));
		}
		if (attributes.containsKey("normal")) {
			normal = new Vec(attributes.get("normal"));
		}
	}
	
	@Override
	public Intersection intersectRay(Ray ray){
		return null;
	}

	public Point3D getCenter() {
		return center;
	}

	public double getRadius() {
		return radius;
	}

	public Vec getNormal() {
		return normal;
	}
	
	

}
