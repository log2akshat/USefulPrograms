package observer_pattern;

public interface Portal {
	void subscribe(Observer ob);
	void unsubscribe(Observer ob);
	void notifyObserver(String title);

}
