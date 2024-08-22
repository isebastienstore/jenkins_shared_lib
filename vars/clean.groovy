def call(){
    bat """
        ./mvnw -ntp clean -P-webapp
    """  
}
