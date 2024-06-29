def call(){
    sh 'mvn -ntp verify -P-webapp'
}