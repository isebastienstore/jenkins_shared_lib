def call(credentialsId){

    withSonarQubeEnv(credentialsId: credentialsId) {
         bat 'mvn clean package sonar:sonar'
    }
}