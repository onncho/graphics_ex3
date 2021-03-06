package ex3.render.raytrace;

import java.util.Map;

import math.Point3D;
import math.Vec;

/**
 * Represent a point light
 * 
 * Add methods as you wish, this can be a super class for other lights (think which)
 */
public abstract class Light implements IInitable {
//TODO add methods. If you don't like this class you can write your own.
	protected Vec color;

	public Light() {
		color = new Vec(1,1,1);
	}

	@Override
	public void init(Map<String, String> attributes) {
		if (attributes.containsKey("color")){			
			color = new Vec(attributes.get("color"));
		}
	}
	
	public Vec getColor(){
		return color;
	}
}
