def call(String aws_account_id, String region, String ecr_repoName) {
    withCredentials([
        string(credentialsId: 'AWS_ACCESS_KEY', variable: 'AWS_ACCESS_KEY_ID'),
        string(credentialsId: 'AWS_SECRET_KEY', variable: 'AWS_SECRET_ACCESS_KEY')
    ]) {
        // Configure AWS CLI avec les clés d'accès
        sh """
            aws configure set aws_access_key_id ${AWS_ACCESS_KEY_ID}
            aws configure set aws_secret_access_key ${AWS_SECRET_ACCESS_KEY}
            aws configure set region ${region}

            aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
            docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
        """
    }
}
