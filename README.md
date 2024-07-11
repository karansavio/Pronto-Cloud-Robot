# Pronto-Cloud-Robot
Pronto Cloud Coding Test

<!-- AUTHOR: KARAN CHOUDHARY -->

### TO RUN THE APPLICATION NORMALLY ###

1. Navigate to `src/main/java/`

2. Enter `javac com/robot/*.java`

3. Run `java com.robot.RobotMain F1,R1,B2,L1,B3`

### TO RUN THE APPLICATION USING DOCKER IMAGE ###

(Note: the image name can be any name, I have used `robot-image` in this example).

1. Inside the root robot directory where the Dockerfile exists, run:

docker build -t robot-image . 

docker run robot-image F1,R1,B2,L1,B3
