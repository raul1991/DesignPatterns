# Exercise 1 - Strategy Pattern
## Problem : SimUDuck App
### Description : Creating a DuckSimulation App

## Changing Requirements :

0. Premise
   
    We started off by creating a base class "Duck" and making two other ducks inheriting from it.

	#Modifications

	None (Since this was the first change)

	#Mistake Identified :

	Due to this design we had all the behaviors in the base classes as well irrespective of their explicit need in those classes.

1. Add ducks those can fly.

	# Modifications : 

	Now we added a fly behaviour in our base class (Duck) so we could have fly behaviour.

	# Mistake Identified : 

	Since every bird will now be flying as every bird inherits from Duck class. So a rubber duck which 
	will also extend the Duck class will now be able to fly which is a flaw.
	You can do nothing inside the fly method but still the class representation would still say
	that you can fly which is bad.
	So in other words, changes in the base class will affect the child classes as well.
	
	# Rectification :

	Let's make an interface for the two changing behaviors Fly - Flyable interface and Quack - Quackable interface.
	Every duck that wants specific feature will implement the required interface.
	Now we have made two new types FlyingBehavior classes - FlyWithRockets and FlyNoWay
	those implement Flyable interface. Now any change to flying behaviour will only change the 
	ducks actually having flying capabilities and not other ducks like DummyDuck, StatuedDuck
	, WoodenDuck or RubberDuck.
