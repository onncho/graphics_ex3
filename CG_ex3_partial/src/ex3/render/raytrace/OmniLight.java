package ex3.render.raytrace;
import math.Point3D;

import java.util.Map;

import math.Vec;

public class OmniLight extends Light {
	
	protected Point3D pos;
	double kc, kl, kq;
	
	public OmniLight(){
		super();
		kc = 1;
		kl = kq = 0;
		
	}
	
	@Override
	public void init(Map<String, String> attributes){
		super.init(attributes);
		if (attributes.containsKey("pos")){			
			pos = new Point3D(attributes.get("pos"));
		}
		if (attributes.containsKey("kc")){
			kc = Double.parseDouble(attributes.get("kc"));
			kl = Double.parseDouble(attributes.get("kl"));
			kq = Double.parseDouble(attributes.get("kq"));
		}
	}
	
	public Vec getColor() {
		return color;
	}

	public Point3D getPos() {
		return pos;
	}

	public double getKc() {
		return kc;
	}
	
	public double getKl() {
		return kl;
	}
	
	public double getKq() {
		return kq;
	}
	
}
