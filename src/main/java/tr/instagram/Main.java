package tr.instagram;

import java.util.Scanner;

public class Main{

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Please enter your username : ");
        String username = scanner.nextLine();
        System.out.println("Please enter your password : ");
        String password = scanner.nextLine();
        System.out.println("Please enter target profile name : ");
        String targetProfileName = scanner.nextLine();

        App app = new App();
        app.loginWith(username , password);
        app.navigateToTargetProfile(targetProfileName);
        app.clickFirstPost();
        app.likePosts(app.getPostCount());
    }
}
