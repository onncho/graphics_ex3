package ex3.render.raytrace;
import java.util.Map;
import math.Point3D;
import math.Vec;

public class DirectionalLight extends Light {

	protected Vec direction;

	public DirectionalLight() {
		super();
	}

	@Override
	public void init(Map<String, String> attributes) {
		if (attributes.containsKey("color")){			
			color = new Vec(attributes.get("color"));
		}
		if (attributes.containsKey("direction")){			
			direction = new Vec(attributes.get("direction"));
		}
	}
	
	public Vec getDirection(){
		return direction;
	}
}
