node {
    stage ('Build') {
        withMaven {
        if(isUnix()){
            sh "mvn clean verify"
        } else {
            bat "mvn clean verify"
            }
        } // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe reports and FindBugs reports
      }
}
