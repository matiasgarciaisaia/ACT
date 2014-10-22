package org.instedd.act.misc

import org.instedd.act.controllers.UserController

class RsyncDaemon {
    UserController userController
    static final DESTINATION = "utnso@192.168.0.151"
    
    def sync() {
        def cmd1="rsync -avz --remove-source-files ${UserExport.RSYNC_DIR} ${DESTINATION}:dest/ination/.groovy/"
        println(cmd1)
        println(cmd1.execute().text)
        println(cmd1.execute().err.text)
    }

    static main(args) {
        def controller = new UserController()
        def daemon = new RsyncDaemon()
        println("pwd".execute().text)
        daemon.userController = controller
        
        daemon.sync()
        
        controller.create([organization: 'msf-spain', location: 'Sierra Leone/Northern Province/Kambia District/Kambia']);
        
        daemon.sync()
        
        controller.create([organization: 'msf-spain', location: 'Sierra Leone/Northern Province/Kambia District/Kambia']);
        controller.create([organization: 'msf-spain', location: 'Sierra Leone/Northern Province/Kambia District/Kambia']);
        
        daemon.sync()
    }

}
