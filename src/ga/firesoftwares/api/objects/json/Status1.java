package ga.firesoftwares.api.objects.json;

import java.util.ArrayList;

public class Status1 {

	// Fields
	private boolean online;
	private String status;
	private ArrayList<String> cpu;
	private Storage ram;
	private Storage disk;
	private Units units;
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
	public ArrayList<String> getCpu() {
		return cpu;
	}
	public void setCpu(ArrayList<String> cpu) {
		this.cpu = cpu;
	}
	public Storage getRam() {
		return ram;
	}
	public void setRam(Storage ram) {
		this.ram = ram;
	}
	public Storage getDisk() {
		return disk;
	}
	public void setDisk(Storage disk) {
		this.disk = disk;
	}
	public Units getUnits() {
		return units;
	}
	public void setUnits(Units units) {
		this.units = units;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	
}
