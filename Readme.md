# This application was developed by Juan Manuel Francisco Antúnez Armella

It was generated using spring initializr, the Java used is java 11 (as it's the one I have installed in my local machine).

How to run the code, you need to open the command line, go to the root directory of the application where you download it, then excecute the following commands in order to run the code.

**mvn clean:clean**

**mvn compile**

**mvn exec:java -Dexec.mainClass=com.CoxExercise.Cox.CoxApplication**


For the frontend you will need to have installed node js as well as angular. If that's not the case I'll set the insntructions to do it.

First confirm you if have node js installed with the following command:

**node -v**

You should get the version you are using. If instead you get an answer that the command node is not recognized you will need to install node, go to this web site: https://nodejs.org/en/ download the LTS version and install it in you computer.

The next step is to verify that the package manage was installed correctly, to do this use the following command:

**npm -v**

If that returns the value of the version that you are using, everything is ready to run the frontend in your machine.

Please go to the folder called: frontend, there you will need to use the following command to start the frontend:

**npm install**

**ng serve -o**

