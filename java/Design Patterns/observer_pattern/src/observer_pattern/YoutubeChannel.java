package observer_pattern;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements Subject {
	public static List<Observer> subscriberList = new ArrayList<>();

	@Override
	public void subscribe(Observer ob) {
		subscriberList.add(ob);
	}

	@Override
	public void unsubscribe(Observer ob) {
		if (ob instanceof Subscriber) {
	        subscriberList.removeIf(observer -> 
	        ((Subscriber) ob).getName().equals(((Subscriber) observer).getName()));
	    }
	}

	@Override
	public void notifyObserver(String title) {
		for (Observer observer: subscriberList) {
			observer.getNotified(title);
		}
	}

	// Method to print all elements in the subscriberList
    public static List<String> subscriberNames() {
        List<String> subscribers = new ArrayList<>();
        for (Observer observer : subscriberList) {
        	subscribers.add(((Subscriber) observer).getName());
        }
        return subscribers;
    }
}
