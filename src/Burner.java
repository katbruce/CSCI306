//Burner: class to control individual burner temps and settings
//rachel castro and katie bruce
//9/7/23

public class Burner {
	//members
	public enum Temperature {
		BLAZING, HOT, WARM, COLD
	}
	
	private Temperature myTemperature; 
	
	private Setting mySetting;
	
	private int timer; 
	
	public static final int TIME_DURATION = 2; 
	
	
	
	//getters/setters
	public Temperature getTemperature() {
		return myTemperature; 
	}
	
	//constructors
	public Burner(){
		super();
		this.mySetting = Setting.OFF;
		this.myTemperature = Temperature.COLD; 
	}
	
	//methods
	
	//raises the setting one notch
	public void plusButton() {
		//reset timer
		timer = TIME_DURATION;
		
		switch(mySetting) {
		case OFF:
			mySetting = Setting.LOW;
			break;
		case LOW:
			mySetting = Setting.MEDIUM; 
			break;
		case MEDIUM:
			mySetting = Setting.HIGH;
			break;
		case HIGH:
			mySetting = Setting.HIGH;
			break; 
		}
		
	}
	
	//lowers the setting one notch
	public void minusButton() {
		timer = TIME_DURATION;
		
		switch(mySetting) {
		case OFF:
			break;
		case LOW:
			mySetting = Setting.OFF; 
			break;
		case MEDIUM:
			mySetting = Setting.LOW;
			break;
		case HIGH:
			mySetting = Setting.MEDIUM;
			break; 
		}
	}
	
	//called to update the burner every minute
	public void updateTemperature() {
		//timer update
		timer--;
		//temperature update
		if (timer == 0) {
			
			//increase temperature by 1
			switch(myTemperature) {
				case COLD:
					myTemperature = Temperature.WARM;
				case WARM:
					myTemperature = Temperature.HOT;
				case HOT:
					myTemperature = Temperature.BLAZING;
				case BLAZING:
					myTemperature = Temperature.BLAZING;
			}
		}
		return; 
	}
	
	
	//Show the status of the burner
	public void display() {
		String stoveOut;
		if (myTemperature == Temperature.COLD) {
			stoveOut = "coooool";
		} else if (myTemperature == Temperature.WARM) {
			stoveOut = "warm";
		} else if (myTemperature == Temperature.HOT) {
			stoveOut = "CAREFUL";
		} else if (myTemperature == Temperature.BLAZING) {
			stoveOut = "VERY HOT! DON'T TOUCH";
		}
		
		String finalOut = "[" + mySetting.toString() + "] ..... " + stoveOut; 
		System.out.println(finalOut);
		
		if (myTemperature == Temperature.BLAZING) {
			System.out.println("RED LIGHT - HOT BURNER ALERT"); 
		}
		
	}
	
	//returns blazing status
	public boolean isBlazing() {
		if (myTemperature == Temperature.BLAZING) {
			return true;
		}
		return false; 
	}

}
