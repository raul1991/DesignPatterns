public class CurrentConditionsDisplay implements DisplayElement, Observer {
	
	private static final String CURRENT_CONDITIONS = "\n[CurrentConditionsDisplay]\nTemperature : %s\nHumidity : %s\nPressure : %s\n";
	private float temp;
	private float humidity;
	private float pressure;
	private Subject weatherData;

	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	public void display() {
		System.out.println(String.format(CURRENT_CONDITIONS, this.temp, this.humidity, this.pressure));
	}

	public void update(float temp, float humidity, float pressure) {
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
	}

}