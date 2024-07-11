# Using a Java base image
FROM openjdk:17-slim

# Set the working directory inside the container
WORKDIR /robot

# Copy the source files
COPY src/main/java/com/robot/ /robot/com/robot/

# Compiles the Java code into class files
RUN javac /robot/com/robot/*.java

# Command to run the program
CMD ["java", "com.robot.RobotMain", "$@"]

# This line allows you to pass arguments to the program when running the container
ENTRYPOINT ["java", "com.robot.RobotMain"]