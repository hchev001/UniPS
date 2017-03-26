/**
 * Provides a Business Entity object
 */

import { Comment } from './comment.model';
import { Address } from './address.model';

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
        private comments: Comment[],
        private ratings: String[],
        private address: Address,
        private status: String,
        private role: String,
        private token: String
    ) {}
}
