
def call(String aws_account_id, String region, String ecr_repoName){
    withCredentials(
        [aws(
            credentialsId: 'aws-credentials-id',
            accessKeyVariable: 'AWS_ACCESS_KEY_ID', 
            secretKeyVariable: 'AWS_SECRET_ACCESS_KEY'
            )
        ]
    ) {
        sh """
            export AWS_ACCESS_KEY_ID=${AWS_ACCESS_KEY_ID}
            export AWS_SECRET_ACCESS_KEY=${AWS_SECRET_ACCESS_KEY}
            echo 'Obtaining ECR login password...'
            ecrLoginPassword=$(aws ecr get-login-password --region ${region})
            echo 'Login password obtained'
            echo 'Attempting Docker login...'
            echo ${ecrLoginPassword} | docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
            docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
        """
    }
}





//Version valide pour docker hub

//def call(String project, String ImageTag, String hubUser){
//    withCredentials([string(credentialsId: 'docker-hub-password', variable: 'PASS')]) {
//        bat """
//            powershell -Command "\$pass = \$env:PASS; Set-Content -Path password.txt -Value \$pass; Get-Content -Path password.txt | docker login -u ${hubUser} --password-stdin"
//            docker image push ${hubUser}/${project}:${ImageTag}
//            docker image push ${hubUser}/${project}:latest
//            del password.txt
//        """
//    }
//}





//peut etre utile

// def call(String project, String ImageTag, String hubUser){
//     withCredentials([usernamePassword(
//             credentialsId: "docker",
//             usernameVariable: "USER",
//             passwordVariable: "PASS"
//     )]) {
//         bat "docker login -u '$USER' -p '$PASS'"
//     }
//     bat "docker image push ${hubUser}/${project}:${ImageTag}"
//     bat "docker image push ${hubUser}/${project}:latest"   
// }