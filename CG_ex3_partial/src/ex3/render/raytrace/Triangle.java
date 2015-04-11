package ex3.render.raytrace;
import java.util.Map;

import math.Point3D;
import math.Ray;


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
		return null;
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



	