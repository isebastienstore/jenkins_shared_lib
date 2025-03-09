def call(String aws_account_id, String region, String ecr_repoName) {
    withCredentials([aws(credentialsId: 'AWS_ACCESS_KEY', accessKeyVariable: 'AWS_ACCESS_KEY_ID', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY')]) {
        sh """
            aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
            docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
        """
    }
}