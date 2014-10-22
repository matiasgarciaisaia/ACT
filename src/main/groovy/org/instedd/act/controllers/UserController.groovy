package org.instedd.act.controllers

import org.instedd.act.models.User
import org.instedd.act.misc.UserExport

class UserController {
    
    def users = []
    
    def index() {
        return users
    }
    
    def create(params) {
        def user = new User(params.organization, params.location)
        UserExport.write(user)
        users.add(user)
    }

}
