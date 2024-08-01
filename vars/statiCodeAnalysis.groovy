def call(credentialsId){

    withSonarQubeEnv(credentialsId: credentialsId) {
        bat './mvnw -Pprod org.sonarsource.scanner.maven:sonar-maven-plugin:3.11.0.3922:sonar'
    }
}