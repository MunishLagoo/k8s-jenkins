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


pipelineJob('Helm-Deploy') {
 configure { flowdefinition ->
   flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
     'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
       'userRemoteConfigs' {
         'hudson.plugins.git.UserRemoteConfig' {
           'url'("https://github.com/MunishLagoo/jenkins.git")
           //'url'('https://DevOps-Batches@dev.azure.com/DevOps-Batches/DevOps60/_git/frontend')
         }
       }
       'branches' {
         'hudson.plugins.git.BranchSpec' {
           'name'('*/main')
         }
       }
     }
     'scriptPath'('Jenkinsfile-helm-deploy')
     'lightweight'(true)
   }
 }
}


pipelineJob('k8s-DB-Deploy') {
 configure { flowdefinition ->
   flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
     'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
       'userRemoteConfigs' {
         'hudson.plugins.git.UserRemoteConfig' {
           'url'("https://github.com/MunishLagoo/jenkins.git")
           //'url'('https://DevOps-Batches@dev.azure.com/DevOps-Batches/DevOps60/_git/frontend')
         }
       }
       'branches' {
         'hudson.plugins.git.BranchSpec' {
           'name'('*/main')
         }
       }
     }
     'scriptPath'('Jenkinsfile-all-components')
     'lightweight'(true)
   }
 }
}

