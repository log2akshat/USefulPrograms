package observer_pattern;

public class Subscriber implements Observer {

	String subscriberName;

	public Subscriber(String subscriberName) {
		super();
		this.subscriberName = subscriberName;
	}

	@Override
	public void getNotified(String title) {
		System.out.println("Hello, " + subscriberName + 
				" a new video " + title + " is uploaded.");
	}

	public String getName() {
		return subscriberName;
	}

}
