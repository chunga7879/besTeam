## besTeam

##### 2023/02/9 ~ ing

### Description
This is a back-end to create best teams for school projects. 
It is very important to form a group based on the ability and interest of people. 
It will create a survey based on project information. Using answers of participants, it will create teams.  

#### Future goal
It can be extended to be used in the company to form a team for new projects.

### UX

##### Human need
The professor wants to create teams based on students interest and ability. 

##### Human tasks


### Functions


### Objects 
1. User 

2. Project 
- name
- category (ex. software)
- number of members per team
- List of roles for this project with how many people will be assigned for this role

2. Survey
- created by project

3. Role
- Name (ex. Java Back-end developer)
- List of ability 

4. Ability
- Name (ex. Java, Spring boot)

5. Category (To provide some examples when user create project & create/select roles)
- Name
- List of roles included in the category 

6. Participants (participants of survey)
- Name
- email
- StudentId / EmployeeId

7. SurveyResponse
