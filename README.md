# Agile-Board
The idea is a pet project to practice different techniques and technologies in a non-trivial but yet not too complicated software.
The project will have a single repository with all different stacks.

## Technologies
- Java 8 
- SpringBoot
- Postgres
- AngularJS
- Angular Material 

## Features and High-level Stories

### Authentication
Allow users to login/logout and keep track of login audits.

* As a User I want to login using my credentials so that I can use the application.
* As an Admin I want to view login audit so that I can identify possible threats or issues
* As a User I want to use a one-time password for first login so that I can set my own password
* As a User I want to logout from the application so that no one can use my session after I'm gone
* As a User I want to keep my login status open for 30 days so that I can easily access the application

### Users
Manage users to be able to use the application.

* As an Admin I want to view the list of users in order to be able to manage them
* As an Admin I want to create new user in order for the user to use the application
* As an Admin I want to block a user in order to prevent them from accessing the application
* As an Admin I want to change user role in order to correct their access privileges
* As an Admin I want to reset user password in order to force the user to change it
* As a User I want to change my password in order to be more secure
* As a User I want to update my profile in order for other users to view my profile
* As a User I want to upload my profile photo in order for mark my assignments, comments in the application
* As a User I want to change my presence status in order for others to know if I'm working from home etc
* As a User I want to view user profiles in order to get more details about other people

### Projects
Manage projects to be available for working in the application.

* As a Project Owner I want to list all my projects in order to be able to manage them
* As a Project Owner/ Team Member I want to view project details in order to be able to manage it
* As a Project Owner/ Team Member I want to view project members in order to be able to administer the project
* As a Project Owner I want to create a project in order to make it available for working
* As a Project Owner I want to get notification when my projects change in order to administer the project
* As a Project Owner I want to assign project members in order to allow them to work on the project
* As a Project Owner I want to unassign project members in order to prevent them from working on the project
* As a Project Owner I want to export project details in order to use in other systems
* As a Team Member I want to view project details in order to be able to be informed
* As a Team Member I want to view project members in order to be able to view their profiles
* As a Team Member I want to get notification when my projects change in order to be informed

### Kanban Board
The core management of the project and its work items.

* As a Team Member I want to view project board in order to work on project work items
* As a Team Member I want to create a work item in order to allow working on it
* As a Team Member I want to view work item details in order to work or handle it
* As a Team Member I want to update project details in order to provide details for members to work on it
* As a Team Member I want to assign member(s) to a work item in order view work on items
* As a Team Member I want to unassign member(s) from a work item in order to reflect on the item state
* As a Team Member I want to add comment to work item in order to provide details for members to work on it
* As a Team Member I want to view work item comments in order to be informed about the item details
* As a Team Member I want to delete comment from a work item in order to correct misplaced details
* As a Team Member I want to update comment on a work item in order to correct details
* As a Team Member I want to update work item state in order to reflect its state in the workflow
* As a Team Member I want to follow a work item in order to get notifications on its changes
* As a Team Member I want to get a notification when followed work item got changed in order to act accordingly
* As a Team Member I want to unfollow a work item in order not to get change notifications
* As a Team Member I want to add estimates to work item in order to track progress
* As a Team Member I want to link work item to other work items in order to indicate relation among them
* As a Team Member I want to view work item links in order to act accordingly
* As a Team Member I want to view work item history in order to understand the current state

### Global Search
Search all relevant information in the application in one place.

* As a User I want to search projects in order to easily navigate to the desired project
* As a User I want to search people in order to view their profiles
* As a User I want to search work items in order to navigate to the desired work item

### Dashboard
Greet the user with the important information for their use.

* As an Admin I want to view the top 10 failed login attempts in my dashboard in order to investigate possible threat
* As a Project Owner I view to see the top 10 projects with recent changes in my dashboard in order to get prompt information
* As a Team Member I want to view the list of assigned work items in order to be more focused
* As a Team Member I want to view the list of assigned projects in order to easily navigate their boards
* As a Team Member I want to view the list of followed work items in order to act accordingly

