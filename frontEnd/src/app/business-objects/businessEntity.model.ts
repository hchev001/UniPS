/**
 * Provides a Business Entity object
 */

export class BusinessEntity {
    
    userName:String;
    name: String;
    phone: number;
    businessPhone: number;
    email: String;
    picture: String;
    description: String;
    hours: String;
    rating: number;

    constructor(
        userName: String, 
        name: String, 
        phone: number, 
        businessPhone: number, 
        email: String, 
        picture: String, 
        description: String, 
        hours: String,
        rating: number
        ) {

            this.userName = userName;
            this.name = name;
            this.phone = phone;
            this.businessPhone = businessPhone;
            this.email = email;
            this.picture = picture;
            this.description = description;
            this.hours = hours;
            this.rating = rating;

    }
}