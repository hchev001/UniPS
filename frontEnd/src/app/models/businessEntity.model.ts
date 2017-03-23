/**
 * Provides a Business Entity object
 */

export class BusinessEntity {
    constructor (
        private id: String,
        private date: String,
        private username: String,
        private password: String,
        private name: String,
        private phone: number,
        private phoneBusiness: number,
        private email: String,
        private question1: String,
        private question2: String,
        private pictureFeatured: String,
        private pictures: String[],
        private description: String,
        private hours: String,
        private rateAverage: number,
        private comments: String[],
        private ratings: String[],
        private address: String[],
        private status: String,
        private role: String,
        private token: String
    ) {}
}
