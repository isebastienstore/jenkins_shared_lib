// def call(String project, String ImageTag, String hubUser){
//    
//     bat """
//      docker image build -t ${hubUser}/${project} . 
//      docker image tag ${hubUser}/${project} ${hubUser}/${project}:${ImageTag}
//      docker image tag ${hubUser}/${project} ${hubUser}/${project}:latest
//     """
// }

def call(String aws_account_id, String region, String ecr_repoName){
    
    bat """
     xcopy /E /I src\main\docker target\docker
     copy target\*.jar target\docker\
     copy Dockerfile target\docker\
     docker build -t ${ecr_repoName} target/docker/
     docker tag ${ecr_repoName}:latest ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
    """
}

