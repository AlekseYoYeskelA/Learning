package patterns.behavioral.iterator;

import patterns.behavioral.iterator.profile.Profile;
import patterns.behavioral.iterator.social_networks.Facebook;
import patterns.behavioral.iterator.social_networks.LinkedIn;
import patterns.behavioral.iterator.social_networks.SocialNetwork;
import patterns.behavioral.iterator.spammer.SocialSpammer;

import java.util.List;
import java.util.Scanner;

public class Demo {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please specify social network to target spam tool (default:Facebook):");
        System.out.println("1. Facebook");
        System.out.println("2. LinkedIn");
        String choice = scanner.nextLine();

        SocialNetwork network;
        if (choice.equals("2")) {
            network = new LinkedIn(createTestProfiles());
        } else {
            network = new Facebook(createTestProfiles());
        }

        SocialSpammer spammer = new SocialSpammer(network);
        spammer.sendSpamToFriends("anna.smith@bing.com", "Hey! This is Anna's friend Josh. Can you do me a favor and like this post [link]?");
        spammer.sendSpamToCoworkers("anna.smith@bing.com", "Hey! This is Anna's boss Jason. Anna told me you wold be interested in [link].");
    }

    public static List<Profile> createTestProfiles() {
        List<Profile> data = List.of(
                new Profile("anna.smith@bing.com", "Anna Smith", "friends:mad_max@ya.com", "friends:catwoman@yahoo.com",
                        "coworkers:sam@amazon.com"),
                new Profile("mad_max@ya.com", "Maximilian", "friends:anna.smith@bing.com", "coworkers:sam@amazon.com"),
                new Profile("bill@microsoft.eu", "Billie", "coworkers:avanger@ukr.net"),
                new Profile("avanger@ukr.net", "John Day", "coworkers:bill@microsoft.eu"),
                new Profile("sam@amazon.com", "Sam Kitting", "coworkers:anna.smith@bing.com", "coworkers:mad_max@ya.com",
                        "friends:catwoman@yahoo.com"),
                new Profile("catwoman@yahoo.com", "Liza", "friends:anna.smith@bing.com", "friends:sam@amazon.com")
        );
        return data;
    }
}
