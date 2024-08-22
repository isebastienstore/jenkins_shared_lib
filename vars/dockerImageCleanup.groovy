// def call(String project, String ImageTag, String hubUser){
    
//     bat """
//      docker rmi ${hubUser}/${project} 
//      docker rmi ${hubUser}/${project}:${ImageTag}
//     """
// }


def call(String aws_account_id, String region, String ecr_repoName){
    
    bat """
     docker rmi ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
    """
}
