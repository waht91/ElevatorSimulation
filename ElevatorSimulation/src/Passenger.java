
public class Passenger {
	
	private int id;
	private int dfloor;
	private int cfloor;
	private String Way;
	private double arrivaltime = 0.00;
	private double timewaited = 0.00;
	public Passenger(int id, int a, int b, double ab){
		this.id = id;
		this.cfloor = a;
		this.dfloor = b;
		int abc= a-b;
		if(abc>0) {
			Way ="UP";
		}else {
			Way ="DOWN";
		}
		this.arrivaltime = ab;
	}
	public String getWay() {
		return this.Way;
	}
	public int getcfloor(){
		return this.cfloor;
	}
	public int getdfloor(){
		return this.dfloor;
	}
	public void SetWait(double a){
		this.timewaited = a;
	}
	public double getWait (){
		return timewaited;
	}
	public double getArrival(){
		return arrivaltime;
	}
	public int getid(){
		return id;
	}
	public double getLeavingTime() {
		return arrivaltime + timewaited;
	}
}
