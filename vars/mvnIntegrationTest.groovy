def call(){
    try {
        sh './mvnw -ntp verify -P-webapp'
    } catch (err) {
        throw err
    } finally {
        junit '**/target/surefire-reports/TEST-*.xml,**/target/failsafe-reports/TEST-*.xml'
    }
}