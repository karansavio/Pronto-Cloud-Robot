# Pronto-Cloud-Robot
Pronto Cloud Coding Test

<!-- AUTHOR: KARAN CHOUDHARY -->

### TO RUN THE APPLICATION NORMALLY ###

1. Navigate to `src/main/java/`

2. Enter `javac com/robot/*.java`

3. Run `java com.robot.RobotMain F1,R1,B2,L1,B3`

### TO RUN THE APPLICATION USING DOCKER IMAGE ###

(Note: the image name can be any name, I have used `robot-image` in this example).

1. Inside the root robot directory where the `Dockerfile` exists, run:

docker build -t robot-image . 

docker run robot-image F1,R1,B2,L1,B3

### RUNNING CI/CD PIPELINE ON GITHUB ACTIONS ###

The pipeline consists of three stages:

1. build-test

2. publish-to-staging

3. publish-to-production


The usual flow in a production like environment would be to run unit tests on a `dev` before proceeding to deploy to a `staging` environment and then to `production`

The way docker has been encorporated is we build the docker image as `robot-app` and then save and upload that image as a `tar` file. This is just for demonstration purposes a way to show how we can upload a docker image as an artifact into a build directory path without requiring any access keys or credentials.

Once we pass the build stage and all the tests have passed, we can then proceed to staging and once staging has passed we can then push to production.

