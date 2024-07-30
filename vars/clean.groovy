def call(){
    sh """
        chmod +x ./mvnw
        ./mvnw -ntp clean -P-webapp
    """  
}
