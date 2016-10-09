public class Main {
	
	public static void main(String[] args) {
		Duck someDuck = new MallardDuck();
		someDuck.performQuack();
		someDuck.performFly();
		someDuck.setFlyBehavior(new FlyWithRockets());
		someDuck.performFly();
		someDuck.performQuack();
	}
}