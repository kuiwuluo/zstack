package org.zstack.test.integration.image

import org.springframework.http.HttpEntity
import org.springframework.web.util.UriComponentsBuilder
import org.zstack.core.progress.ProgressCommands
import org.zstack.header.core.progress.ProgressConstants
import org.zstack.header.rest.RESTConstant
import org.zstack.header.rest.RESTFacade
import org.zstack.sdk.BackupStorageInventory
import org.zstack.storage.ceph.backup.CephBackupStorageBase
import org.zstack.testlib.EnvSpec
import org.zstack.testlib.SubCase
import org.zstack.utils.gson.JSONObjectUtil

/**
 * Created by xing5 on 2017/3/21.
 */
class ImageProgressCase extends SubCase {
    EnvSpec env

    @Override
    void clean() {
        env.delete()
    }

    @Override
    void setup() {
        spring {
            ceph()
            kvm()
            include("Progress.xml")
        }
    }

    @Override
    void environment() {
        env = Env.oneCephBackupStorageEnv()
    }

    void testAddImageProgress() {
        RESTFacade restf = bean(RESTFacade.class)
        BackupStorageInventory bs = env.inventoryByName("ceph-bk")

        env.afterSimulator(CephBackupStorageBase.DOWNLOAD_IMAGE_PATH) { rsp, HttpEntity<String> e ->
            Map cmd = JSONObjectUtil.toObject(e.getBody(), LinkedHashMap.class)

            UriComponentsBuilder ub = UriComponentsBuilder.fromHttpUrl(restf.getBaseUrl())
            ub.path(RESTConstant.COMMAND_CHANNEL_PATH)
            String url = ub.build().toUriString()

            int i = 0
            retryInSecs(5, 1) {
                i += 20
                def header = [(RESTConstant.COMMAND_PATH): ProgressConstants.PROGRESS_REPORT_PATH]
                def rcmd = new ProgressCommands.ProgressReportCmd()
                rcmd.progress = String.valueOf(i)
                rcmd.setThreadContextMap(cmd.threadContext)
                rcmd.setThreadContextStack(cmd.threadContextStack)
                restf.syncJsonPost(url, JSONObjectUtil.toJsonString(rcmd), header, ProgressCommands.ProgressReportResponse.class)
            }

            return rsp
        }

        addImage {
            backupStorageUuids = [bs.uuid]
            name = "image"
            url = "http://zstack.org/download/image.qcow2"
            format = "qcow2"
        }
    }

    @Override
    void test() {
        env.create {
            testAddImageProgress()
        }
    }
}
