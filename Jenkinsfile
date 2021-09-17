node {
    env.JAVA_HOME="${tool 'jdk1.8.0_251'}"
    env.PATH="${env.JAVA_HOME}/bin:${env.PATH}"

    stage ('Build') {
        withMaven {
          bat "mvn clean verify"
        } // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe reports and FindBugs reports
      }
}
