package ex3.render.raytrace;

import java.util.Map;

import math.Point3D;
import math.Vec;

public class SpotLight extends OmniLight{
	
	protected Vec direction;
	
	public SpotLight(){
		super();
	}
	
	public void init(Map<String, String> attributes){
		super.init(attributes);
		if (attributes.containsKey("direction")){			
			direction = new Vec(attributes.get("direction"));
		}		
	}
}
