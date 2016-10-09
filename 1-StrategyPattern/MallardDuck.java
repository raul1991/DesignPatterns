/**
* Class : MallardDuck.java
* A Duck that looks like a Mallard and flies with rocket. 
* So MallardDuck will extend class Duck.
* 
*/
public class MallardDuck extends Duck {
	
	public MallardDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithRockets();
	}

	@Override
	public void swim() {
		//Swim like the base normal duck does.
	}

	@Override
	public void display() {
		//Look something like a mallard here.
	}

}