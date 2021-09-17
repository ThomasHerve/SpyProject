node {
    stage ('Build') {
        withMaven {
          bat "mvn clean verify"
        } // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe reports and FindBugs reports
      }
}
