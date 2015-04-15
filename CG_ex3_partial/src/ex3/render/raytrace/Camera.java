package ex3.render.raytrace;

import java.util.Map;
import java.util.Scanner;

import math.Point3D;
import math.Ray;
import math.Vec;


/**
 * Represents the scene's camera.
 * 
 */
public class Camera implements IInitable{

	public Point3D eye, Pc;
	public Vec direction, upDirection, rightDirection;
	public double screenWidth, screenDist;
	

	public void init(Map<String, String> attributes) {
		if (attributes.containsKey("eye")) { 
			eye = new Point3D(attributes.get("eye"));   
		}
		if (attributes.containsKey("direction")) { 
			direction = new Vec(attributes.get("direction"));
			direction.normalize();
		}
		if (attributes.containsKey("up-direction")) { 
			upDirection = new Vec(attributes.get("up-direction")); 
			upDirection.normalize();
			rightDirection = Vec.crossProd(direction, upDirection);
			rightDirection.normalize();
			upDirection = Vec.crossProd(rightDirection, direction);
			System.out.println("Direction " +direction);
			System.out.println("Up Direction " +upDirection);
			System.out.println("Left Direction " +rightDirection);
			
		}
		if (attributes.containsKey("screen-width")) { 
			String screenWidthStr = attributes.get("screen-width");
			Scanner s = new Scanner(screenWidthStr);
			screenWidth = s.nextDouble();
			s.close();
		}
		
		if (attributes.containsKey("screen-dist")) { 
			String screenWidthStr = attributes.get("screen-dist");
			Scanner s = new Scanner(screenWidthStr);
			screenDist = s.nextDouble();
			s.close();
		}
		Pc = new Point3D(eye);
		Pc.addVector(Vec.scale(screenDist, direction));
	}
	
	/**
	 * Transforms image xy coordinates to view pane xyz coordinates. Returns the
	 * ray that goes through it.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	
	public Ray constructRayThroughPixel(double x, double y, double height, double width) {
		double pixelSize = screenWidth / width;
		Point3D P = new Point3D(Pc);
		double rightScalar = (x - Math.floor(width/2))*pixelSize;
		double upScalar = (y - Math.floor(height/2))*pixelSize;
		P.addVector(Vec.scale(rightScalar, rightDirection));
		P.subVector(Vec.scale(upScalar, upDirection));
		Vec vec = new Vec(P, eye);
		return new Ray(eye, vec);
	}
}
