package seedu.address.model.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.group.Group;
import seedu.address.model.group.GroupName;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.PersonGroup;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    private static final ArrayList<PersonGroup> ALEX_YEOH_GROUPS = new ArrayList<>();
    private static final ArrayList<PersonGroup> BERNICE_YU_GROUPS = new ArrayList<>();
    private static final ArrayList<PersonGroup> CHARLOTTE_GROUPS = new ArrayList<>();
    private static final ArrayList<PersonGroup> DAVID_LI_GROUPS = new ArrayList<>();
    private static final ArrayList<PersonGroup> IRFAN_IBRAHIM_GROUPS = new ArrayList<>();
    private static final ArrayList<PersonGroup> ROY_GROUPS = new ArrayList<>();
    private static Person alex;
    private static Person bernice;
    private static Person charlotte;
    private static Person david;
    private static Person irfan;
    private static Person roy;

    public static Person[] getSamplePersons() {
        PersonGroup hackathonExco = new PersonGroup("Hackathon exco");
        PersonGroup focPubsTeam = new PersonGroup("FOC publicity team");
        PersonGroup eventComm = new PersonGroup("NUSS Events Committee");
        PersonGroup hall = new PersonGroup("Eusoff Hall");
        ALEX_YEOH_GROUPS.add(hackathonExco);
        ALEX_YEOH_GROUPS.add(focPubsTeam);
        ALEX_YEOH_GROUPS.add(eventComm);
        ALEX_YEOH_GROUPS.add(hall);
        BERNICE_YU_GROUPS.add(eventComm);
        BERNICE_YU_GROUPS.add(hall);
        CHARLOTTE_GROUPS.add(hall);
        CHARLOTTE_GROUPS.add(hackathonExco);
        CHARLOTTE_GROUPS.add(focPubsTeam);
        DAVID_LI_GROUPS.add(focPubsTeam);
        DAVID_LI_GROUPS.add(eventComm);
        DAVID_LI_GROUPS.add(hall);
        IRFAN_IBRAHIM_GROUPS.add(hall);
        IRFAN_IBRAHIM_GROUPS.add(hackathonExco);
        ROY_GROUPS.add(hall);
        ROY_GROUPS.add(eventComm);

        alex = new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new Address("Blk 30 Geylang Street 29, #06-40"),
                getTagSet("friends"), new HashMap<>(), ALEX_YEOH_GROUPS);
        bernice = new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                        new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                        getTagSet("colleagues", "friends"), new HashMap<>(), BERNICE_YU_GROUPS);
        charlotte = new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"),
                new Email("charlotte@example.com"), new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                        getTagSet("neighbours"), new HashMap<>(), CHARLOTTE_GROUPS);
        david = new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                        new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                        getTagSet("family"), new HashMap<>(), DAVID_LI_GROUPS);
        irfan = new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                new Address("Blk 47 Tampines Street 20, #17-35"),
                getTagSet("classmates"), new HashMap<>(), IRFAN_IBRAHIM_GROUPS);
        roy = new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                        new Address("Blk 45 Aljunied Street 85, #11-31"),
                        getTagSet("colleagues"), new HashMap<>(), ROY_GROUPS);

        return new Person[] {alex, bernice, charlotte, david, irfan, roy};
    }

    public static Group[] getSampleGroups() {
        Set<Person> hall = new HashSet<>();
        Set<Person> hackathon = new HashSet<>();
        Set<Person> publicityFoc = new HashSet<>();
        Set<Person> eventsCommittee = new HashSet<>();
        hackathon.add(alex);
        hall.add(bernice);
        hall.add(charlotte);
        hall.add(david);
        hall.add(irfan);
        hall.add(roy);
        hackathon.add(alex);
        hackathon.add(charlotte);
        hackathon.add(irfan);
        publicityFoc.add(alex);
        publicityFoc.add(charlotte);
        publicityFoc.add(david);
        eventsCommittee.add(alex);
        eventsCommittee.add(bernice);
        eventsCommittee.add(david);
        eventsCommittee.add(roy);
        return new Group[]{new Group(new GroupName("Eusoff Hall"), hall),
            new Group(new GroupName("Hackathon exco"), hackathon),
            new Group(new GroupName("FOC publicity team"), publicityFoc),
            new Group(new GroupName("NUSS Events Committee"), eventsCommittee)
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        for (Group g: getSampleGroups()) {
            sampleAb.addGroup(g);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
