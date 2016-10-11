# Exercise 2 - Observer Pattern
## Problem : Weather O Rama
### Description : Creating a Weather O Rama App

## Changing Requirements :

0. First Design

	Application should provide three display elements - Current Conditions, weather statistics and a simple forecast, all updated in real time as WeatherData object requires the most recent measurements.
	We would be changing in the already present source file WeatherData.java and override the measurementChanged() and update all the displays.

	# Modifications :

	We Created a class WeatherData and inside it's measurementChanged method we update the displays.

	# Mistake Identified : 

	Every display will have a different way to updating the display element. We have placed the update logic inside the WeatherData class now which will make the change difficult. Every time a new display will be added, we will have to change in the Subject (WeatherData) which is bad. Here the Subject (which had to nofify) and the Observer (Those which will be notified when a change in Subject happens.) are tightly coupled. In other words new Observer when added will initiate a change in the Subject as well.
	
	# Rectification :

	Implementing an Observer pattern