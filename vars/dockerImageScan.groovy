// def call(String project, String ImageTag, String hubUser){
//    
//     bat """   
//         trivy image ${hubUser}/${project}:latest > scan.txt
//         type scan.txt
//     """
// }

def call(String aws_account_id, String region, String ecr_repoName){
    
    bat """
        trivy image ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest > scan.txt
        type scan.txt
    """
}