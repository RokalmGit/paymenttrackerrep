# paymenttrackerrep

Installation instructions:

1) Extract maven.zip to the desktop.

2) Download the latest version of JDK and install it. It can be found here: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

3) Set the PATH for maven and JAVA_HOME. To do so, right click on My PC (or This PC on Win10) and go to Properties, Advanced System Settings, Advanced, Environment Variables. Add a user variable called “Path” if it doesn't exist and set variable value to the path of the “bin” folder in maven directory. For example, mine is at C:\Users\Rokalm\Desktop\apache-maven-3.3.9\bin. 

If the variable exists, edit it and add the path to the very end. Path strings are seperated by “;”.

4) Add a “JAVA_HOME” variable to your system variables and set its value to where the JDK is installed, for example: C:\Program Files\Java\jdk1.8.0_73.

5) Open the command line and type mvn -v. If you get an output like this:

Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-10T17:41:47+01:00)
Maven home: C:\Users\Rokalm\Desktop\apache-maven-3.3.9\bin\..
Java version: 1.8.0_73, vendor: Oracle Corporation
Java home: C:\Program Files\Java\jdk1.8.0_73\jre
Default locale: en_GB, platform encoding: Cp1254
OS name: "windows 10", version: "10.0", arch: "amd64", family: "dos"

then maven is installed correctly.

6) Using the command line, type “cd desktop\maven\paymenttracker” to navigate to the project folder. Type mvn compile to compile the program and mvn package to create the executable jar file. It will be in the target folder under paymenttracker.
7) Run the jar file.

Assumptions that are made:

1) If a user enters an invalid input, for example USD sds then he/she receives an error message saying that is an invalid entry. Everything before the invalid entry is added.

2) If a user enters a currency code that contains more or less than 3 characters, he/she receives an error message.

3) If a user tries to withdraw more money than what is available, he/she receives an error message. I assumed that currencies cannot go below 0.

If you receive errors about maven version, go to the project's folder and edit pom.xml. Scroll down and change “version” in this block:


    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.3</version>
    <configuration>
        <source>1.8</source>
        <target>1.8</target>
    </configuration>

