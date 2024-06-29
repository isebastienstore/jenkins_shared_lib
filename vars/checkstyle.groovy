def call(){
    sh 'mvn -ntp checkstyle:check'
}