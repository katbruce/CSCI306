//Class: Setting
//Controls the enum for which setting each burner is on
//Katie Bruce and Rachel Castro
//9/7/23
public enum Setting {
	
	//initialize enum temperatures
    OFF("---"), LOW("--+"), MEDIUM("-++"), HIGH("+++");
	
    private String setting;

    //setter
    Setting(String setting){
        this.setting = setting;
    }

    //toString method
    @Override
    public String toString() {
        return setting;
    }

}

	