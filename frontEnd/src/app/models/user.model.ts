/**
 * Provides a user object
 */

export class User {
    constructor (
        private id: number,
        private createdDate: String,
        private username: String,
        private password: String,
        private email: String,
        private question1: String,
        private question2: String,
        private pictureFeatured: String,
        private pictures: String[],
        private description: String,
        private status: String,
        private role: String,
        private token: String
    ) {}
}
