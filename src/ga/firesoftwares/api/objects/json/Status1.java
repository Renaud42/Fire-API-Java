package ga.firesoftwares.api.objects.json;

public class Status1 {

	// Fields
	private boolean online;
	private String status;
	private String hostname;
	
	// Getters and setters
	public boolean isOnline() {
		return online;
	}
	public void setOnline(boolean online) {
		this.online = online;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	
}

class cpu {
	
	// Fields
	private String _0;
	private String _1;
	private String _2;
	
	// Getters and setters
	public String get0() {
		return _0;
	}
	public void set0(String _0) {
		this._0 = _0;
	}
	public String get1() {
		return _1;
	}
	public void set1(String _1) {
		this._1 = _1;
	}
	public String get2() {
		return _2;
	}
	public void set2(String _2) {
		this._2 = _2;
	}
	
}

class ram {
	
	// Fields
	private double used;
	private double total;
	private double percent;
	
	// Getters and setters
	public double getUsed() {
		return used;
	}
	public void setUsed(double used) {
		this.used = used;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}
	
}

class disk {
	
	// Fields
	private double used;
	private double total;
	private double percent;
	public double getUsed() {
		return used;
	}
	
	// Getters and setters
	public void setUsed(double used) {
		this.used = used;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}
	
}

class units {

	// Fields
	private String disk;
	private String ram;
	
	// Getters and setters
	public String getDisk() {
		return disk;
	}
	public void setDisk(String disk) {
		this.disk = disk;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	
}
