# Model-View-Controller design pattern
This is a company system to manage employees build with the use of MVC design pattern. 

## UML diagram
![uml](https://github.com/zoyakatashinskaya/model-view-controller-student-project/blob/main/uml_mvc.png)

## Output
```
########### VIEW ###########
This is the Best Company Management System.

########### CONTROLLER ###########
There are no employees in the system. 
Please, create new entry.

Please, select an action:
1) Create New Employee
2) Print information
3) Update information
```

1) Create employee
```
Your choice: 
1
CREATING NEW EMPLOYEE: 
Please enter a name :
Ivan
Please enter a surname :
Ivanov
########### VIEW ###########

New employee has been successfully created.
Name :'Ivan', Surname :'Ivanov', Id :'Qj50WmGY'
```

2) Update employee
```
########### CONTROLLER ###########
There are/is 1 employee(s) in the system. 

Please, select an action:
1) Create New Employee
2) Print information
3) Update information
Your choice: 3
```

3) Print information
```
Your choice: 
2
PRINT EMPLOYEE INFO
Please enter employee's ID: 
Qj50WmGY
Select what would you like to print out:
1) Name & Surname
2) Address
3) Phone number
1
########### VIEW ###########
Name :'Ivan', Surname :'Ivanov', Id :'Qj50WmGY'
```
