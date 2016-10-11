import java.util.Random;

public class ForecastDisplay implements DisplayElement, Observer {
	
	private static final String[] FORECAST_INFORMATION = new String[] {
		"Go ahead and enjoy the rain showers", "Stay put, storm is coming", "I don't care, do whatever you like :@" };
	private float temp;
	private float humidity;
	private float pressure;
	private Subject weatherData;

	public ForecastDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	public void display() {
		System.out.println("\n[ForecastDisplay]\n"+FORECAST_INFORMATION[new Random().nextInt(3)]);
	}

	public void update(float temp, float humidity, float pressure) {
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
	}

}