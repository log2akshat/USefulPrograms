package observer_pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

public class Demo {

	public static void main(String[] args) {
		Subject portal = new YoutubeChannel();

		Observer observer1 = new Subscriber("Akshat");
		portal.subscribe(observer1);

		Observer observer2 = new Subscriber("Diwakar");
		portal.subscribe(observer2);

		portal.notifyObserver("Introduction to Spring Boot");

		System.out.println(YoutubeChannel.subscriberNames());

		// For Menu Driven Programming
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("Press 1 to upload a Video");
			System.out.println("Press 2 create a new Subscriber");
			System.out.println("Press 3 unsubscribe a existing Subscriber");
			System.out.println("Press 4 to exit");

			int keyStroke = 0;
			try {
				keyStroke = Integer.parseInt(br.readLine());
			} catch (IOException | NumberFormatException e) {
				e.printStackTrace();
			}

			if(keyStroke == 1) {
				System.out.println("Enter the name of the video to upload:");
				Optional<String> videoName = readLine(br);
				videoName.ifPresent(portal::notifyObserver);
			} else if (keyStroke == 2) {
				System.out.println("Enter the name of the Subscriber:");
				Optional<String> subscriberName = readLine(br);
				subscriberName.ifPresent(name -> {
					Observer newSubscriber = new Subscriber(name);
					portal.subscribe(newSubscriber);
				});
			} else if (keyStroke == 3) {
				System.out.println("Enter the name of the Subscriber to Unsubscribe:");
				Optional<String> subscriberName = readLine(br);
				subscriberName.ifPresent(name -> {
					if(YoutubeChannel.subscriberNames().contains(name)) {
						Observer subscriberToRemove = new Subscriber(name);
						portal.unsubscribe(subscriberToRemove);
						System.out.println("Updated Subscribers:");
						System.out.println(YoutubeChannel.subscriberNames());
					} else {
						System.out.println("Subscriber not found: " + name);
					}
				});
			} else if (keyStroke == 4) {
				break;
			} else {
				System.out.println("You have not selected the correct option.");
			}
		}
	}

	// Helper method to read a line from BufferedReader and return it as Optional
	private static Optional<String> readLine(BufferedReader br) {
		try {
			return Optional.ofNullable(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}
}
