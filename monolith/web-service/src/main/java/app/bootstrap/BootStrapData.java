package app.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.model.Contact;
import app.model.User;
import app.model.Group;
import app.repositories.ContactRepository;
import app.repositories.GroupRepository;
import app.repositories.UserRepository;

@Component // tells spring to detect as a spring managed component
public class BootStrapData implements CommandLineRunner {

    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final ContactRepository contactRepository;

    public BootStrapData(UserRepository userRepository, GroupRepository groupRepository,
            ContactRepository contactRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.contactRepository = contactRepository;
    }

    @Override
    public void run(String... args) throws Exception {
                
        System.out.println("Started bootstrap");
        Contact ericContact = new Contact();

        ericContact.setAddressLine1("adrress 1");
        ericContact.setAddressLine2("adrress 2");
        ericContact.setCity("City");
        ericContact.setCountry("country");
        ericContact.setZip("zip");

        Contact ericSecondContact = new Contact();

        ericSecondContact.setAddressLine1("adrress 1 2");
        ericSecondContact.setAddressLine2("adrress 2 2");
        ericSecondContact.setCity("City2");
        ericSecondContact.setCountry("country2");
        ericSecondContact.setZip("zip2");

        contactRepository.save(ericContact);
        System.out.println("Number of contacts: " + contactRepository.count());
        
        User eric = new User("Eric", "Evans");
        Group funGroup = new Group("titles", "body");
        eric.getUserGroups().add(funGroup);
        funGroup.getUsers().add(eric);

        eric.getContacts().add(ericContact);
        eric.getContacts().add(ericSecondContact);


        userRepository.save(eric);
        groupRepository.save(funGroup);
        contactRepository.save(ericSecondContact);
        
        User rod = new User("rod", "johnson");
        Group springGroup = new Group("spring", "group");

        rod.getUserGroups().add(springGroup);
        springGroup.getUsers().add(rod);

        userRepository.save(rod);
        groupRepository.save(springGroup);

        System.out.println("Number of groups: " + groupRepository.count());
        System.out.println("Number of contacts: " + contactRepository.count());
        System.out.println("user contacts: " + eric.getContacts().toString());
    }
        
}
