def call(){
    sh 'chmod +x ./mvnw'
    sh './mvnw -ntp clean -P-webapp'
}