package ex3.render.raytrace;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import math.Point3D;
import math.Ray;
import math.Vec;
/**
 * A Scene class containing all the scene objects including camera, lights and
 * surfaces. Some suggestions for code are in comment
 * If you uncomment these lines you'll need to implement some new types like Surface
 * 
 * You can change all methods here this is only a suggestion! This is your world, 
 * add members methods as you wish
 */
public class Scene implements IInitable {

	protected List<Surface> surfaces;
	protected List<Light> lights;
	protected Camera camera;
	protected Vec backgroundCol;
	protected int maxRecursionLevel;
	protected Vec ambientLight;

	public Scene() {
		surfaces = new LinkedList<Surface>();
		lights = new LinkedList<Light>();
		camera = new Camera();
	}

	public void init(Map<String, String> attributes) {
		if (attributes.containsKey("background-col")){			
			backgroundCol = new Vec(attributes.get("background-col"));
		}
		if (attributes.containsKey("max-recursion-level")){			
			maxRecursionLevel = Integer.parseInt("max-recursion-level");
		}
		if (attributes.containsKey("ambient-light")){
			ambientLight = new Vec(attributes.get("ambientLight"));
		}
	}

	/**
	 * Send ray return the nearest intersection. Return null if no intersection
	 * 
	 * @param ray
	 * @return
	 */
	public Intersection findIntersection(Ray ray) {
		double shortestLength = Double.MAX_VALUE;
		Intersection minIntersection = null;
		for(Surface surface: surfaces){
			Intersection intersection = surface.intersectRay(ray);
			double currentLength = intersection.getLength();
			if (currentLength < shortestLength){
				minIntersection = intersection; 
				shortestLength = currentLength; 
			} 
		}
		return minIntersection;
	}

	public Vec calcColor(Ray ray, int level) {
		//TODO implement ray tracing recursion here, add whatever you need
		return null;
	}

	/**
	 * Add objects to the scene by name
	 * 
	 * @param name Object's name
	 * @param attributes Object's attributes
	 */
	public void addObjectByName(String name, Map<String, String> attributes) {
		//this adds all objects to scene except the camera
		
		Surface surface = null;
		Light light = null;
	
		//Check for surfaces
		if ("sphere".equals(name))
			surface = new Sphere();
		
		if ("triangle".equals(name))
			surface = new Triangle();
		
		if ("convexpolygon".equals(name))
			surface = new ConvexPolygon();
		
		if ("disc".equals(name))
			surface = new Disc();
		
		//Check for lights
		if ("dir-light".equals(name))
			light = new DirectionalLight();
		
		if ("omni-light".equals(name))
			light = new OmniLight();
		
		if ("spot-light".equals(name))
			light = new SpotLight();

		//adds a surface to the list of surfaces
		if (surface != null) {
		surface.init(attributes);
			surfaces.add(surface);
		}
		
		//adds a light to the list of lights
		if (light != null) {
			light.init(attributes);
			lights.add(light);
		}
	}

	public void setCameraAttributes(Map<String, String> attributes) {
		this.camera.init(attributes);
	}
}