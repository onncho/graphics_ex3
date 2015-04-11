package ex3.render.raytrace;
import java.util.Map;

import math.Ray;
import math.Vec;

/**
 * Represent a point light
 * 
 * Add methods as you wish, this can be a super class for other lights (think
 * which)
 */
public abstract class Surface implements IInitable {

	protected Vec mtl_diffuse;
	protected Vec mtl_specular;
	protected Vec mtl_ambient;
	protected Vec mtl_emission;
	protected double mtl_shininess;
	protected double reflectance;

	public Surface() {
		mtl_diffuse = new Vec(0.7, 0.7, 0.7);
		mtl_specular = new Vec(1, 1, 1);
		mtl_ambient = new Vec(0.1, 0.1, 0.1);
		mtl_emission = new Vec(0, 0, 0);
		mtl_shininess = 100;
		reflectance = 0;
	}

	@Override
	public void init(Map<String, String> attributes) {
		if (attributes.containsKey("mtl-diffuse")) {
			mtl_diffuse = new Vec(attributes.get("mtl-diffuse"));
		}
		if (attributes.containsKey("mtl-specular")) {
			mtl_specular = new Vec(attributes.get("mtl-specular"));
		}
		if (attributes.containsKey("mtl-ambient")) {
			mtl_ambient = new Vec(attributes.get("mtl-ambient"));
		}
		if (attributes.containsKey("mtl-emission")) {
			mtl_emission = new Vec(attributes.get("mtl-emission"));
		}
		if (attributes.containsKey("mtl-shininess")) {
			mtl_shininess = Double.parseDouble((attributes.get("mtl-shininess")));
		}
		if (attributes.containsKey("mtl-reflectance")) {
			reflectance = Double.parseDouble((attributes.get("mtl-reflectance")));
		}
	}
	
	public abstract Intersection intersectRay(Ray ray);

	public Vec getMtl_diffuse() {
		return mtl_diffuse;
	}

	public Vec getMtl_specular() {
		return mtl_specular;
	}

	public Vec getMtl_ambient() {
		return mtl_ambient;
	}

	public Vec getMtl_emission() {
		return mtl_emission;
	}

	public double getMtl_shininess() {
		return mtl_shininess;
	}

	public double getReflectance() {
		return reflectance;
	}

}
