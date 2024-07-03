

def call(credentialsId){
    timeout(time: 1, unit: 'HOURS'){
        waitForQualityGate abortPipeline: false, credentialsId: credentialsId
    }
}


