public class User {
    
    private final String userId;
    private final String firstName;
    private final String lastName;
    private final int age;

    private User(UserBuilder userBuilder) {
        this.userId = userBuilder.userId;
        this.firstName = userBuilder.firstName;
        this.lastName = userBuilder.lastName;
        this.age = userBuilder.age;
    }

    // Only Getter methods for creating Immutable objects
    public String getUserId() {
        return userId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public double getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User [userId=" + this.userId + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", age=" + this.age + "]";
    }

    /**
    * InnerUser
    */
    public static class UserBuilder {
        
        private String userId;
        private String firstName;
        private String lastName;
        private int age;

        public UserBuilder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public User build() {
            User user = new User(this);
            return user;
        }
    }
    
}