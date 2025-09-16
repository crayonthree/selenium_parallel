pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out code....'
                checkout scm
            }
        }

        stage('Compile and Run Java File') {
            steps {
                echo 'Compiling and running Parallel Browser Testing'
                bat '''
                    cd src
                    javac test\\java\\com\\cineplex\\ThreadedBrowserLauncher.java
                    java com.cineplex.ThreadedBrowserLauncher
                '''
            }
        }

        stage('Complete') {
            steps {
                echo 'Build complete.'
            }
        }
    }
}