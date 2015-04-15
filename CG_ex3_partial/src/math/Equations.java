package math;


public class Equations {
	public static double solveQuadratic(double a, double b, double c){
		double t1, t2;
		double delta = b*b - 4*a*c;
		if (delta < 0) {
			return Double.MAX_VALUE;
		}
		
		System.out.println("Found Intersection!");
		t1 = (-b + Math.sqrt(delta))/(2*a);
		t2 = (-b - Math.sqrt(delta))/(2*a);
		
		
		if(t1 < 0){
			return t2;
		}
		if(t2 < 0){
			return t1;
		}
		return Math.min(t1, t2);
	}
}
