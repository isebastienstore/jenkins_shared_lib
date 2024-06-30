def call(){
    bat 'ls -al src/main/webapp/app/**/*.spec.ts || echo "No test files found"'
    bat 'npm test'
}