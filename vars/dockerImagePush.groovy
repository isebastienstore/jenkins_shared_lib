def call(String aws_account_id, String region, String ecr_repoName){
    
    bat """
        set AWS_ACCESS_KEY_ID=${ACCESS_KEY}
        set AWS_SECRET_ACCESS_KEY=${SECRET_KEY}
        aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
        docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
    """
}





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