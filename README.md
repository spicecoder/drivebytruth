# drivebytruth
"A Design time truth " driven way to trigger modules -Giving first class recognition to Design time truth progression


The project  is a maven project and can be run with ModuleSubscrberScheduler as the main class. 
ModuleSubscrberScheduler initiates the process by invoking the module whose truth state is START .
And the flow of the App is determined by the truth state achieved by the module. 
Again this sample does not have all the flows like the user id / password being invalid .
The valid userid / password are in the static data in AppData class.

More practical underpinnings of this approach is not this particular implementation 
-which uses the publisher /scheduler model , but the recognition that the truth statements and their progression conceived at design time
should not be trashed and reinvented at coding time, but we can give them the first class citizenship in our code and recognise that they 
define the important flows in the App.

The above code has been the initial experimentation before I arrived into the concept of truthiness of software . This concept is summarised below:
Truth Server presents a new way to test software code that has been designed with a purpose in mind, expressed as ‘software service’. 
Although it is always taken for granted that a software code has a purpose, very often this purpose remain un-stated at the right granular level 
that  would allow it to describe the design of particular software code piece within a software service. Truth Server maintains a software testing philosophy 
that says a truthiness of a software it self can be tested by matching the initial design criteria with the execution time result of a software service.
Truth Server approach to software code testing relies on some ‘resolution patterns’ that are brought in place before the coding takes place. 
This allows to create a framework of software testing that is based on the design thoughts that went into producing the code that matches the 
resolution patterns identified during the design phase  of software code and allows one to test whether the behaviour of code matches with those 
initial design thoughts. The testing criteria remains valid irrespective of particular implementation detail or syntax of the programming language used . 
The Truth Server approach can be adopted by any programming language for carrying out truthiness testing
