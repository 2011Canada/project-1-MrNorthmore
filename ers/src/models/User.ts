export class User {
    userId: number
    creds: Credentials
    firstName: string
    lastName: string
    userEmail: string
    userRoleId: number
}

class Credentials {
    username: string
    password: string
}