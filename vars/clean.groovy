def call(){
    bat """
        docker --version
        ./mvnw -ntp clean -P-webapp
    """  
}
