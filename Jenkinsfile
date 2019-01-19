pipeline
{
    agent any
    stages
    {
        stage('Build')
        {
            steps
            {
                echo "building"
            }
        }
        stage('Test')
        {
            steps
            {
                sh "mvn test"
            }
        }
        stage('Deploy')
        {
            steps
            {
                echo "deploy"
            }
        }
    }
}
