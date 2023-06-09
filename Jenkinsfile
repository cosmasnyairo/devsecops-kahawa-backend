try {
    node {
        def app
        stage('Clone Repository') {
            final scmVars = checkout(scm)
            env.BRANCH_NAME = scmVars.GIT_BRANCH
            env.SHORT_COMMIT = "${scmVars.GIT_COMMIT[0..7]}"
            env.GIT_REPO_NAME = scmVars.GIT_URL.replaceFirst(/^.*\/([^\/]+?).git$/, '$1')
        }
        stage('Run Java Unit Tests') {
            sh 'mvn -DskipTests clean install'
        }
        stage('SonarQube code analysis') {
          withCredentials([string(credentialsId: 'SONAR_TOKEN', variable: 'SONAR_TOKEN')]) {
              try {
                  sh 'mvn sonar:sonar -Dsonar.projectKey=devsecops-kahawa-backend -Dsonar.organization=kahawa'
              }
              catch (Error | Exception e) {
                  echo 'Sonarqube failed'
              }
          }
            
        }

        stage('Build Docker Image') {
            app = docker.build("${env.GIT_REPO_NAME}")
        }

        stage('Push Image to Registry') {
                retry(3) {
                    docker.withRegistry('https://937762161455.dkr.ecr.eu-west-1.amazonaws.com/', 'ecr:eu-west-1:awsecr-uat') {
                        app.push("uat-${env.SHORT_COMMIT}")
                        app.push('latest')
                    }
                }
        }
  }
} catch (Error | Exception e) {
    //Finish failing the build after telling someone about it
    throw e
} finally {
  // Post build steps here
  /* Success or failure, always run post build steps */
// send email
// publish test results etc etc
}
def version() {
    pom = readMavenPom file: 'pom.xml'
    return pom.version
}
