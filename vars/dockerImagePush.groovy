def call(String aws_account_id, String region, String ecr_repoName) {
    withCredentials([
        string(credentialsId: 'AWS_ACCESS_KEY', variable: 'AWS_ACCESS_KEY_ID'),
        string(credentialsId: 'AWS_SECRET_KEY', variable: 'AWS_SECRET_ACCESS_KEY')
    ]) {
        // Exécution sécurisée : pas d'interpolation Groovy, suppression du token Docker après usage
        sh '''
            set +x
            export AWS_ACCESS_KEY_ID=$AWS_ACCESS_KEY_ID
            export AWS_SECRET_ACCESS_KEY=$AWS_SECRET_ACCESS_KEY
            export AWS_DEFAULT_REGION='''' + region + ''''

            export DOCKER_CONFIG=$(mktemp -d)
            aws ecr get-login-password --region ''' + region + ''' | docker login --username AWS --password-stdin ''' + aws_account_id + '''.dkr.ecr.''' + region + '''.amazonaws.com
            set -x

            docker push ''' + aws_account_id + '''.dkr.ecr.''' + region + '''.amazonaws.com/''' + ecr_repoName + ''':latest

            docker logout ''' + aws_account_id + '''.dkr.ecr.''' + region + '''.amazonaws.com
            rm -rf $DOCKER_CONFIG
        '''
    }
}
