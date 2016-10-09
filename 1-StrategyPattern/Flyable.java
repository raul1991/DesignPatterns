/**
* Class : Flyable.java
* Pulling out what changes into the separate interfaces
* So if Now we have a requirement of birds those fly with
* rockets. We can just implement this interface in say
* FlyWithRockets class and override the fly method.
* 
*/
public interface Flyable {
	public void fly();
}