/**
* Class : MallardDuck.java
* A Duck that looks like a Mallard and does not fly at all. 
* So MallardDuck will extend class Duck.
* 
*/
public class MallardDuck extends Duck {
	
	public MallardDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyNoWay();
	}

	@Override
	public void swim() {
		//Swim like the base normal duck does.
	}

	@Override
	public void display() {
		//Look something like a mallard here.
	}

	public void quack() {
		//I'll just quack.
		System.out.println("Quack by MallardDuck");
	}

}