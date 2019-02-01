#!/usr/bin/env groovy
@Library('peon-pipeline') _

node {
    def appToken
    def commitHash
    try {
        cleanWs()

        def version
        stage("checkout") {
            appToken = github.generateAppToken()

            sh "git init"
            sh "git pull https://x-access-token:$appToken@github.com/navikt/tortuga-skatt-client.git"

            sh "make bump-version"

            version = sh(script: 'cat VERSION', returnStdout: true).trim()

            commitHash = sh(script: 'git rev-parse HEAD', returnStdout: true).trim()
            github.commitStatus("pending", "navikt/tortuga-skatt-client", appToken, commitHash)
        }

        stage("build") {
            sh "make"
        }

        stage("release") {
            sh "make release"

            sh "git push --tags https://x-access-token:$appToken@github.com/navikt/tortuga-skatt-client HEAD:master"
        }

        github.commitStatus("success", "navikt/tortuga-skatt-client", appToken, commitHash)
    } catch (err) {
        github.commitStatus("failure", "navikt/tortuga-skatt-client", appToken, commitHash)

        throw err
    }
}
