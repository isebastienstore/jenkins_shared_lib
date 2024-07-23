 def call(String project, String ImageTag, String hubUser){
     withCredentials([usernamePassword(
             credentialsId: "docker",
             usernameVariable: "USER",
             passwordVariable: "PASS"
     )]) {
         bat "docker login -u '$USER' -p '$PASS'"
     }
     bat "docker image push ${hubUser}/${project}:${ImageTag}"
     bat "docker image push ${hubUser}/${project}:latest"   
 }

//def call(String aws_account_id, String region, String ecr_repoName){
//    
//    bat """
//     aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
//     docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
//    """
//}