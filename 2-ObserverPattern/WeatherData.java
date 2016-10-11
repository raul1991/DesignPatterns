import java.util.List;
import java.util.ArrayList;

public class WeatherData implements Subject {
	private List<Observer> observers = new ArrayList<>();
	private float temp;
	private float humidity;
	private float pressure;

	public float getTemperature() {
		return this.temp;
	}

	public float getHumidity() {
		return this.humidity;
	}

	public float getPressure() {
		return this.pressure;
	}

	public void measurementChanged() {
		notifyObservers();
	}

	public void setMeasurements(float temp, float humidity, float pressure) {
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementChanged();
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void unregisterObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for(Observer o : observers) {
			o.update(getTemperature(), getHumidity(), getPressure());
		}
	}

}