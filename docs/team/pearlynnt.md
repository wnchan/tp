---
layout: page
title: Pearlynn Toh's Project Portfolio Page
---

### Project: StudentConnect

StudentConnect is a desktop application that stores and organises students’ contact details, and project group. Students can easily search for the profiles of other students and connect with potential teammates. This streamlines the process of forming project teams. It also offers tools for tracking project progress/deadlines, ensuring that the group stays on task.

# Summary of Contributions
Given below are my contributions to the project.

* **Find Students Feature**: Added the ability to find student(s) by name
  * What it does: This feature allows the user to find student(s) by name with any combination of partial keyword(s).
  * Justification: This feature helps users to find other students more quickly and easily. Without this feature, users would need to know the exact spelling of a student's name in order to find them. With this feature, users can enter any combination of partial keywords, such as the first few letters of the student's name, their middle name, or their last name. This can be especially helpful for users who are not sure of the exact spelling of a student's name, or for users who are trying to find a student who has a common name.
  * Highlights: Modified the code to check of each word in the students' name contains the keyword(s) instead of having to match the keyword(s).
* **Filter Students Feature**: Added the ability to filter students by tutorial
  * What it does: This feature allows the user to filter students by tutorial with any combination of tutorial slot(s).
  * Justification: This feature helps users to search for other students who are also interested in attending or are assigned to the same tutorial slot. Without this feature, users would need to manually scroll through the list of students to search for students who have indicated the same tutorial. With this feature, users can enter any combination of valid tutorial slot(s) to retrieve the list of students in the tutorial slot(s) provided. This is important because it allows users to search for other students who are available during the same preferred tutorial slot.
  * Highlights: A new Predicate class had to be written to support this feature. Invalid tutorial slot(s) provided by the user had to be handled gracefully so that the user can understand how to proceed to use the command correctly.
* **Find Group Feature**: Added the ability to find a group by group number
  * What it does: This feature allows the user to find a project group by a group number.
  * Justification: This feature helps users to find a specific group more quickly and easily. Without this feature, users would need to manually scroll through the list of groups to find the group that they are searching for. With this feature, users can simply enter a group number and the system will return a list of all the group members.
  * Highlights: A new Predicate class had to be written to support this feature. Invalid group number provided by the user had to be handled gracefully so that the user can understand how to proceed to use the command correctly.
* **Filter Groups Feature**: Added the ability to filter groups by tutorial
  * What it does: This feature allows the user to filter groups by a tutorial slot.
  * Justification: This feature helps users to search for groups that belong to a particular tutorial that they may prefer. Without this feature, users would need to manually scroll through the list of groups to search for groups that belong to a particular tutorial. With this feature, users can enter a tutorial slot to retrieve the list of groups that belong to the tutorial slot provided.
  * Highlights: A new Predicate class had to be written to support this feature. Invalid tutorial slot provided by the user had to be handled gracefully so that the user can understand how to proceed to use the command correctly.
* **Check Group Feature**: Added the ability to check if a group fulfils the diversity requirements of the course
  * What it does: This feature allows the user to check the composition of a group's members.
  * Justification: This feature helps users to check if a group fulfils the diversity group formation requirements of the course with a single command. Without this feature, users would need to manually find the details of each member in the group to check if the group meets the diversity requirements. With this feature, users can enter a group number to easily check the composition of the group members. This helps to ensure that users have the opportunity to work with and learn from others from different backgrounds.
  * Highlights: Different warning messages were written to inform users of what the group may fall short of in terms of group formation so that the user can ensure that the members are from diverse backgrounds. Extensive test cases and test data were written to rigorously test the different possible composition of the group members.

* **Code Contributed**: [RepoSense link](https://nus-cs2103-ay2324s1.github.io/tp-dashboard/?search=pearlynnt&breakdown=false&sort=groupTitle%20dsc&sortWithin=title&since=2023-09-22&timeframe=commit&mergegroup=&groupSelect=groupByRepos)

* **Project management**:
  * Set up the team's Github Repository, and project documentation.
  * Reviewed the team's Github pull requests.
  * Managed the milestones on Github.

* **Documentation**:
  * User Guide:
    * Added the 'Find Command', 'Filter Command', 'Find Group Command', 'Filter Group Command', and 'Check Command' sections
  * Developer Guide:
