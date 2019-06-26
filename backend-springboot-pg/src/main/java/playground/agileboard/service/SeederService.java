package playground.agileboard.service;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import playground.agileboard.model.LoginUser;
import playground.agileboard.model.Project;
import playground.agileboard.model.ProjectMember;
import playground.agileboard.model.User;
import playground.agileboard.model.UserProfile;
import playground.agileboard.model.WorkItem;
import playground.agileboard.repository.AuthRepository;
import playground.agileboard.repository.ProjectMemberRepository;
import playground.agileboard.repository.ProjectRepository;
import playground.agileboard.repository.UserProfileRepository;
import playground.agileboard.repository.UserRepository;
import playground.agileboard.repository.WorkItemRepository;

@Service
public class SeederService {
  private HashService hashService;

  private UserRepository userRepository;
  private AuthRepository authRepository;
  private UserProfileRepository profileRepository;
  private ProjectRepository projectRepository;
  private ProjectMemberRepository memberRepository;
  private WorkItemRepository workItemRepository;
  
  @Autowired
  public SeederService(HashService hashService, UserRepository userRepository,
      AuthRepository authRepository, UserProfileRepository profileRepository,
      ProjectRepository projectRepository, ProjectMemberRepository memberRepository,
      WorkItemRepository workItemRepository) {

    this.hashService = hashService;

    this.userRepository = userRepository;
    this.authRepository = authRepository;
    this.profileRepository = profileRepository;
    this.projectRepository = projectRepository;
    this.memberRepository = memberRepository;
    this.workItemRepository = workItemRepository;
  }

  public void seed() {
    seedUsers();
    seedProjects();
    seedWorkItems();
  }

  private void seedUsers() {
    final String passwordHash = hashService.hash(DEFAULT_PASSWORD);
    for (final User user : USERS) {
      userRepository.save(user);
      authRepository.save(new LoginUser(user.getEmail(), passwordHash, user.getId()));
      profileRepository.save(new UserProfile(user.getId(), user.getEmail(), user.getFirstName(),
          user.getLastName(), PHOTO_URL, DEFAULT_BIO));
    }
  }

  private void seedProjects() {
    for (final Project project : PROJECTS) {
      projectRepository.save(project);

      for (final User user : USERS) {
        memberRepository.save(new ProjectMember(
            Integer.parseInt(String.format("%d%d", project.getId(), user.getId())), project.getId(),
            project.getCode(), user.getId(), user.getFirstName(), user.getLastName(),
            user.getEmail(), project.getStartDate()));
      }
    }
  }

  private void seedWorkItems() {
    for (final WorkItem item : WORK_ITEMS) {
      workItemRepository.save(item);
    }
  }
  
  private static final List<User> USERS =
      Arrays.asList(new User(1, "admin@corp.com", "John", "Doe", "ACTIVE", Instant.now()),
          new User(2, "elit.pretium@sit.ca", "Jack", "Kibo", "ACTIVE",
              Instant.parse("2018-08-23T10:42:33.00Z")),
          new User(3, "pharetra@dignissimpharetraNam.org", "Zoe", "Wylie", "ACTIVE",
              Instant.parse("2019-04-21T10:20:48.00Z")),
          new User(4, "orci@augueeu.net", "Yardley", "Micah", "ACTIVE",
              Instant.parse("2019-08-08T02:18:32.00Z")),
          new User(5, "id@interdumlibero.co.uk", "Hedwig", "Tate", "ACTIVE",
              Instant.parse("2019-11-12T11:49:25.00Z")),
          new User(6, "vitae.sodales@liberonecligula.ca", "Samuel", "Kuame", "ACTIVE",
              Instant.parse("2020-02-05T08:30:41.00Z")));
  private static final String DEFAULT_PASSWORD = "Password1234";
  private static final List<Project> PROJECTS = Arrays.asList(
      new Project(1, "XYZ", "Project XYZ", "Lorem Ipsum XYZ",
          Instant.parse("2018-01-01T00:00:00.00Z"), Instant.parse("2022-01-01T00:00:00.00Z"), 1),
      new Project(2, "ABC", "Project ABC", "Lorem Ipsum ABC",
          Instant.parse("2018-01-01T00:00:00.00Z"), Instant.parse("2022-01-01T00:00:00.00Z"), 1));

  private static final String PHOTO_URL = "https://placeimg.com/200/200/people";
  private static final String DEFAULT_BIO =
      "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";

  private static final List<WorkItem> WORK_ITEMS = Arrays.asList(
      new WorkItem(1, 1, "XYZ", "Task 1", "Lorem ipsum dolor sit amet", "TASK", "DONE"),
      new WorkItem(2, 1, "XYZ", "Task 2",
          "sunt in culpa qui officia deserunt mollit anim id est laborum", "TASK", "DONE"),
      new WorkItem(3, 1, "XYZ", "Task 3", "Excepteur sint occaecat cupidatat non proident", "TASK",
          "IN_PROGRESS"),
      new WorkItem(4, 1, "XYZ", "Task 4",
          "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur",
          "TASK", "IN_PROGRESS"),
      new WorkItem(5, 1, "XYZ", "Task 5",
          "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat",
          "TASK", "IN_PROGRESS"),
      new WorkItem(6, 1, "XYZ", "Task 6",
          "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", "TASK", "BLOCKED"),
      new WorkItem(7, 1, "XYZ", "Task 7", "consectetur adipisicing elit", "TASK", "NOT_STARTED"),
      new WorkItem(8, 2, "ABC", "Task 1", "Lorem ipsum dolor sit amet", "TASK", "DONE"),
      new WorkItem(9, 2, "ABC", "Task 2",
          "sunt in culpa qui officia deserunt mollit anim id est laborum", "TASK", "DONE"),
      new WorkItem(10, 2, "ABC", "Task 3", "Excepteur sint occaecat cupidatat non proident", "TASK",
          "BLOCKED"),
      new WorkItem(11, 2, "ABC", "Task 4",
          "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur",
          "TASK", "IN_PROGRESS"),
      new WorkItem(12, 2, "ABC", "Task 5",
          "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat",
          "TASK", "NOT_STARTED"),
      new WorkItem(13, 2, "ABC", "Task 6",
          "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", "TASK", "BLOCKED"),
      new WorkItem(14, 2, "ABC", "Task 7", "consectetur adipisicing elit", "TASK", "NOT_STARTED"));
}
