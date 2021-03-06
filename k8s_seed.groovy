//pipelineJob('CI-Pipelines/frontend') {
//  configure { flowdefinition ->
//    flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
//      'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
//        'userRemoteConfigs' {
//          'hudson.plugins.git.UserRemoteConfig' {
//            'url'('https://DevOps-Batches@dev.azure.com/DevOps-Batches/DevOps60/_git/frontend')
//          }
//        }
//        'branches' {
//          'hudson.plugins.git.BranchSpec' {
//            'name'('*/main')
//          }
//        }
//      }
//      'scriptPath'('Jenkinsfile')
//      'lightweight'(true)
//    }
//  }
//}


pipelineJob('k8s-all-app-deploy') {
 configure { flowdefinition ->
   flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
     'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
       'userRemoteConfigs' {
         'hudson.plugins.git.UserRemoteConfig' {
           'url'("https://github.com/MunishLagoo/k8s-jenkins.git")
           //'url'('https://DevOps-Batches@dev.azure.com/DevOps-Batches/DevOps60/_git/frontend')
         }
       }
       'branches' {
         'hudson.plugins.git.BranchSpec' {
           'name'('*/main')
         }
       }
     }
     'scriptPath'('k8s-helm-deploy-jenkinsfile')
     'lightweight'(true)
   }
 }
}


pipelineJob('k8s-all-backend-Deploy') {
 configure { flowdefinition ->
   flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
     'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
       'userRemoteConfigs' {
         'hudson.plugins.git.UserRemoteConfig' {
           'url'("https://github.com/MunishLagoo/k8s-jenkins.git")
           //'url'('https://DevOps-Batches@dev.azure.com/DevOps-Batches/DevOps60/_git/frontend')
         }
       }
       'branches' {
         'hudson.plugins.git.BranchSpec' {
           'name'('*/main')
         }
       }
     }
     'scriptPath'('k8s-backend-components-jenkinsfile')
     'lightweight'(true)
   }
 }
}

