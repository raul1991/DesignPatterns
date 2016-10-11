public class StatisticsDisplay implements DisplayElement, Observer {
	
	private static final String CURRENT_CONDITIONS = "\n[StatisticsDisplay]\nAvg Temperature : %s\nMin Temperature : %s\nMax Temperature : %s\n";
	private float avgTemp;
	private float minTemp;
	private float maxTemp;
	private Subject weatherData;

	public StatisticsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	public void display() {
		System.out.println(String.format(CURRENT_CONDITIONS, this.avgTemp, this.minTemp, this.maxTemp));
	}

	public void update(float avgTemp, float minTemp, float maxTemp) {
		this.avgTemp = avgTemp;
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
		display();
	}

}