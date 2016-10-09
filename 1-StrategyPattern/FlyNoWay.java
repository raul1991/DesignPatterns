/**
* Class : FlyNoWay.java
* rockets. We can just implement this FlyBehavior interface
* here and override the fly method according to this class.
* Say this bird shouldn't fly that is what the requirement said
* so be it. Do nothing inside the override fly method.
*/
public class FlyNoWay implements FlyBehavior {
	public void fly() {
		//do nothing here, as this bird can't fly.
		System.out.println("I can't fly");
	}
}