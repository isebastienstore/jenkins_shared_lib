def call(){
    bat """
        ./mvnw -Pprod clean verify -DskipTests
        """
}