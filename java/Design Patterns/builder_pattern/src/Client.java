public class Client {
    public static void main(String[] args) {
        User user1 = new User.UserBuilder()
        .setUserId("01")
        .setFirstName("akshat")
        .setLastName("singh")
        .setAge(38)
        .build();
        System.out.println(user1);
        
        // Testing with Optional Parameters and incorrect order
        User user2 = new User.UserBuilder()
        .setLastName("B")
        .setUserId("02")
        .setFirstName("Mahendra")
        .build();
        
        System.out.println(user2);
    }
}
