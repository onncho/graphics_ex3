package ex3.render.raytrace;
import java.util.LinkedList;
import java.util.Map;

import math.Point3D;
import math.Ray;


public class ConvexPolygon extends Surface {

	LinkedList<Point3D> pointsLinkedList;

	public ConvexPolygon() {
		super();
		pointsLinkedList = new LinkedList<Point3D>();
	}

	//init all variables from the xml
	public void init(Map<String, String> attributes) {
		super.init(attributes);
		for (int i = 0; i < attributes.size(); i++) {
			String tempPoint = "p" + i;
			if (attributes.containsKey(tempPoint)) {
				pointsLinkedList.add(new Point3D(attributes.get(tempPoint)));
			}
		}
	}
	
	@Override
	public Intersection intersectRay(Ray ray){
		return null;
	}

	public LinkedList<Point3D> getPointsLinkedList() {
		return pointsLinkedList;
	}


}
