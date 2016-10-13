public class HeatIndexDisplay implements DisplayElement, Observer {
	//Formula for calculating heat index = 0.5 * {T + 61.0 + [(T-68.0)*1.2] + (RH*0.094)}

	private static final String CURRENT_CONDITIONS = "\n[HeatIndexDisplay]\nHeat Index : %s\n";
	private float temp;
	private float humidity;
	private float pressure;
	private Subject weatherData;

	public HeatIndexDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	public void display() {
		System.out.println(String.format(CURRENT_CONDITIONS, ""+getHeatIndex()));
	}

	public void update(float temp, float humidity, float pressure) {
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
	}

	private double getHeatIndex() {
		return (0.5 * (temp + 61.0 + ((temp-68.0)*1.2) + (humidity*0.094)));
	}

}