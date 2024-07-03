def call(credentialsId){

    withSonarQubeEnv(credentialsId: credentialsId) {
        bat 'mvn -Pprod clean verify org.sonarsource.scanner.maven:sonar-maven-plugin:3.11.0.3922:sonar'
    }
}