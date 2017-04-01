/**
 * Provides a Business Entity object
 */

import { Comment } from './comment.model';
import { Address } from './address.model';
import { Rating } from './rating.model'

export class BusinessEntity {
    constructor (
        id: String,
        date: String,
        username: String,
        private password: String,
        name: String,
        phone: number,
        phoneBusiness: number,
        email: String,
        question1: String,
        question2: String,
        pictureFeatured: String,
        pictures: String[],
        description: String,
        hours: String,
        rateAverage: number,
        comments: Comment[],
        ratings: String[],
        address: Address,
        status: String,
        role: String,
        token: String
    ) {}
}
