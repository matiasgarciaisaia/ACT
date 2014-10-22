package org.instedd.act.misc

import groovy.json.JsonBuilder

class UserExport {
    static final RSYNC_DIR = "json/export"
    
    static { new File(RSYNC_DIR).mkdirs() }

    static write(user) {
        new File([RSYNC_DIR, user.hashCode() + ".json"].join(File.separator)).withWriter { out ->
            out.writeLine(toJSON(user))
        }
        
    }
    
    static toJSON(user) {
        def json = new JsonBuilder()
        json organization: user.organization, location: user.location
        json.toString()
    }
}
