public class Chapter implements Comparable<Chapter> {
	String location;
	float highestTextFrequency;
	String word;

	public Chapter() {
	}

	public Chapter(String location, float highestTextFrequency, String word) {
		super();
		this.location = location;
		this.highestTextFrequency = highestTextFrequency;
		this.word = word;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public float getHighestTextFrequency() {
		return highestTextFrequency;
	}

	public void setHighestTextFrequency(float highestTextFrequency) {
		this.highestTextFrequency = highestTextFrequency;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	@Override
	public int compareTo(Chapter o) {
		if (this.getHighestTextFrequency() > o.getHighestTextFrequency())
			return 1;
		else
			return -1;
	}

}
