package org.zstack.header.host

org.zstack.header.host.APIGetHypervisorTypesReply

doc {
    title "GetHypervisorTypes"

    category "host"

    desc "在这里填写API描述"

    rest {
        request {
			url "GET /v1/hosts/hypervisor-types"


            header (OAuth: 'the-session-uuid')

            clz APIGetHypervisorTypesMsg.class

            desc ""
            
			params {

				column {
					name "systemTags"
					enclosedIn ""
					desc ""
					location "query"
					type "List"
					optional true
					since "0.6"
					
				}
				column {
					name "userTags"
					enclosedIn ""
					desc ""
					location "query"
					type "List"
					optional true
					since "0.6"
					
				}
			}
        }

        response {
            clz APIGetHypervisorTypesReply.class
        }
    }
}