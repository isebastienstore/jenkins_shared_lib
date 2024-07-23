// def call(String project, String ImageTag, String hubUser){
    
//     bat """
//      docker rmi ${hubUser}/${project}:${ImageTag}
//      docker rmi ${hubUser}/${project} ${hubUser}/${project}:latest
//     """
// }

 def call(String project, String ImageTag, String hubUser){
    bat """
        powershell -Command "
            if (docker images -q ${hubUser}/${project}:${ImageTag}) {
                docker rmi ${hubUser}/${project}:${ImageTag}
            }
            if (docker images -q ${hubUser}/${project}:latest) {
                docker rmi ${hubUser}/${project}:latest
            }
        "
    """
}



//def call(String aws_account_id, String region, String ecr_repoName){
    
//    bat """
//     docker rmi ${ecr_repoName}:latest ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
//    """
//}
