package tdd.samples;

interface WindowController {
	public void close();

	public void wclose();
}

interface DoorsController {
	public void close();
}

class DomoticSystem {

	private WindowController windows;
	private DoorsController doors;

	public DomoticSystem(WindowController windows, DoorsController doors) {
		this.windows = windows;
		this.doors = doors;
	}

	public void activateSecurity() {
		windows.close();
		doors.close();

	}
}