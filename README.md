SpringMVCParameters
===================

Build with 
mvn clean compile


Searching the net for examples I've found quite a few really good tutorials for
Spring MVC including forms and validating the results.

However all examples I've found passing only one object to the form and
retrieving one object in return.

Maybe it's bad design but I want to pass multiple business objects to a form
and validating those on submit (using jQuery and Ajax).

After reading a lot of questions and answers regarding this topic, skimming
through http secifications and a lot of trial and error, I came up with this
project.

I deliberately left in the submits and controller functions which are not 
working (adding comments to it).

The main intention for this project was to backup a stackoverflow question net
yet asked since I'm still struggeling with the wording of the question.
Maybe a code review is more what was needed.
The main mistery for me still are the concept of passing parameters to the
server as well as the Spring magic restoring the business objects.

The project was kept intentionally as simple as possible to focus on the concept
of passing multiple parameters.
The project raising the issues is more complicated, the business objects of it
especially.

May it be helpful to others for experimenting. Do not hesitate to fork and play
with it.

