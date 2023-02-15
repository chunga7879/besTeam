## besTeam

##### 2023/02/9 ~ ing

### Description
This is a back-end to create best teams for school projects. 
It is very important to form a group based on the ability and interest of people. 
It will create a survey based on project information. Using answers of participants, it will create teams.  

#### Future goal
It can be extended to be used in the company to form a team for new projects
with new fields such as how many teams it wants to form, possible time slots or previous experience.

#### Future goal 2
- I want to develop the project to provide some space that the students use the web to progress their group work.
- Providing some functionality to decide schedule, divide works, track progress and communicate/messages.
(provide space for all about group working materials.)

##### Human need
Now: The professor wants to create teams based on students interest and ability. 

Future goal 1: company form teams for their project to maximize employee's abilities and promote their interests. 
Future goal 2: school provides students the best group work experience. 

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
- mapped with project  =>  will create question with project and survey options
- PreOption

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
