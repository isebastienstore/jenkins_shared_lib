def call(){
    sh """
        ./mvnw -ntp clean -P-webapp
    """  
}
