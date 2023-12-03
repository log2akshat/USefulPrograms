package observer_pattern;

public interface Subject {
	void subscribe(Observer ob);
	void unsubscribe(Observer ob);
	void notifyObserver(String title);

}
