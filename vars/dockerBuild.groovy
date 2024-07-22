// def call(String project, String ImageTag, String hubUser){
    
//     sh """
//      docker image build -t ${hubUser}/${project} . 
//      docker image tag ${hubUser}/${project} ${hubUser}/${project}:${ImageTag}
//      docker image tag ${hubUser}/${project} ${hubUser}/${project}:latest
//     """
// }

//def call(String aws_account_id, String region, String ecr_repoName){
    
//    bat """
//     docker build -t ${ecr_repoName} .
//     docker tag ${ecr_repoName}:latest ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
//    """
//}

def call(String project, String ImageTag, String hubUser, boolean isArm64 = false) {
    def buildCommand = isArm64 ? "npm run java:docker:arm64" : "npm run java:docker"

    bat """
      ${buildCommand}

      docker image tag ${hubUser}/${project} ${hubUser}/${project}:${ImageTag}
      docker image tag ${hubUser}/${project} ${hubUser}/${project}:latest

      # Démarrage des services Docker
      #docker compose -f src/main/docker/app.yml up -d
    """
}
