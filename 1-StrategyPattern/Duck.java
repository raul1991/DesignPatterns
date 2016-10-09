/**
* Class : Duck.java
* Since every duck can be different , making a duck class.
* All the other Specific Duck classes will inherit from this class.
*/
public class Duck {
	//will be set by the base classes.
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;

	public void setFlyBehavior(FlyBehavior fb) {
		flyBehavior = fb;
	}

	public void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}

	public void performQuack() {
		quackBehavior.quack();
	}

	public void performFly() {
		flyBehavior.fly();
	}

	public void swim() {
		//I am swimming people.
	}

	public void display() {
		//I am a duck being displayed
	}
	//other duck specific methods.
}