def call(){
    sh """
        ./mvnw -Pprod clean verify -DskipTests
        """
}