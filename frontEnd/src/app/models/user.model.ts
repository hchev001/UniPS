/**
 * Provides a user object
 */


export class User {
        private id: number;
        private createdDate: String;
        private username: String;
        private password: String;

        private email: String;
        private question1: String;
        private question2: String;
        private pictureFeatured: String;
        private pictures: String[];
        private description: String;
        private status: String;
        private role: String;
        private token: String;
    constructor (
        username: String,
        email: String,
        pictureFeatured: String,
        description: String
        ) {
            this.username = username;
            this.email = email;
            this.pictureFeatured = pictureFeatured;
            this.description = description;
        }

	public get $id(): number {
		return this.id;
	}

	public set $id(value: number) {
		this.id = value;
	}
	public get $createdDate(): String {
		return this.createdDate;
	}

	public set $createdDate(value: String) {
		this.createdDate = value;
	}

	public get $username(): String {
		return this.username;
	}
    
}
