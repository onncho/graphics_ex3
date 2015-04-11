package math;

public class Equations {
	public static double solveQuadratic(double a, double b, double c){
		double t1, t2;
		try{
			t1 = (-b + Math.sqrt(b*b - 4*a*c))/(2*a);
			t2 = (-b - Math.sqrt(b*b - 4*a*c))/(2*a);
		}
		catch(Exception E){
			return Double.MAX_VALUE;
		}
		
		if(t1 < 0){
			return t2;
		}
		if(t2 < 0){
			return t1;
		}
		return Math.min(t1, t2);
	}
}
