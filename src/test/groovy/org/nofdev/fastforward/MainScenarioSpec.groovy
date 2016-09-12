package org.nofdev.fastforward

import groovy.util.logging.Slf4j
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration

import javax.annotation.Resource


/**
 * main scenario of devops
 */
@ActiveProfiles(value = "test")
@ContextConfiguration(loader = SpringApplicationContextLoader, classes = [fastforwardspecApplication])
@Slf4j
class MainScenarioSpec {

    @Resource
    ProjectFastforward projectFastforward

    @Resource
    SCMFastforward scmFastforward

    def "walk through a typical DevOps process"() {
        log.debug "as service owner, I want to setup a project"
        def projectId = projectFastforward.create(new ProjectDTO(
                name: 'publish',
                group: 'h5app',
                type: 'springboot',

        ))

        log.debug "and it will create a SCM repos for the project"

        def scmInfo = scmFastforward.getInfo()
        log.debug "the chosen SCM: $scmInfo"

        ReposDTO reposDTO = scmFastforward.getReposByProjectId(projectId)
        if (isSCMExists) {
            log.debug "it should show the SCM info if exists"
            log.debug "project info: $reposDTO"
        }
        else {
            log.debug "it should create SCM repos if does not exists"
            reposDTO = scmFastforward.createRepos(projectId)
        }

        log.debug "as service owner, I should be able to clone the repos, and project README.md of specific project type" +
                " should appear at the root"
        log.debug "README.md should tell me how to generate the scaffold and how to get stated"

        log.debug "maybe it tells me to use nodejs yoeman generator to generate my project init code"
        log.debug "there should be 'answering file' in the repos root, so I need not to input project info by hand"

        log.debug "suppose I do not care about features, branching, issues, and versioning and sth. like that"

        log.debug "and I do not need any backing service"

        log.debug "when I finished my code, I want to deploy this to dev-self-testing environment"
        log.debug "as my own build can not be trusted, so it should have a CI/CD to build the project for me"
        buildFastforward.setBuildMode(projectId, BUILDMODE.BUILD_ON_SCM_SOURCE_CHANGE)
        BuildDTO build = buildFastforward.forceBuild(projectId)

        log.debug "the project-build must be identical for all environments, and it should be stored in a artifact repos"


        log.debug "deployment-build = project-build + deployment-configuration"
        log.debug "deployment-build should stored in a deployment artifact repos"

        log.debug "after all, we need an execution environment to run this deployment-build"
        log.debug "somehow, all env are ready, and the deploy was done."

        log.debug "now, finally, we should register and expose this service"

        log.debug "but, here comes a question: WHAT to register? Be it Project? Be it Service? Be it method?"
        log.debug "after a long discuss, we discover that nothing need to be registered but system state should be reported."

        log.debug ""

    }
}
