def call(){
    bat 'dir src/main/webapp/app/**/*.spec.ts || echo "No test files found"'
    bat 'npm test'
}