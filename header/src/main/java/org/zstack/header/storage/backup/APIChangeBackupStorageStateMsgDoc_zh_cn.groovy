package org.zstack.header.storage.backup

org.zstack.header.storage.backup.APIChangeBackupStorageStateEvent

doc {
    title "ChangeBackupStorageState"

    category "storage.backup"

    desc "在这里填写API描述"

    rest {
        request {
			url "PUT /v1/backup-storage/{uuid}/actions"


            header (OAuth: 'the-session-uuid')

            clz APIChangeBackupStorageStateMsg.class

            desc ""
            
			params {

				column {
					name "uuid"
					enclosedIn "changeBackupStorageState"
					desc "资源的UUID，唯一标示该资源"
					location "url"
					type "String"
					optional false
					since "0.6"
					
				}
				column {
					name "stateEvent"
					enclosedIn "changeBackupStorageState"
					desc ""
					location "body"
					type "String"
					optional false
					since "0.6"
					values ("enable","disable")
				}
				column {
					name "systemTags"
					enclosedIn ""
					desc ""
					location "body"
					type "List"
					optional true
					since "0.6"
					
				}
				column {
					name "userTags"
					enclosedIn ""
					desc ""
					location "body"
					type "List"
					optional true
					since "0.6"
					
				}
			}
        }

        response {
            clz APIChangeBackupStorageStateEvent.class
        }
    }
}