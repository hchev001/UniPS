/**
 * Provides a Business Entity object
 */

import { Comment } from './comment.model';
import { Address } from './address.model';
import { Rating } from './rating.model'

export class BusinessEntity {
    constructor (
      address: Address,
      category: string,
      comments: Comment[],
      createdDate: string,
      description: string,
      email: string,
      hours: string,
      id: number,
      name: string,
      private password: string,
      phone: number,
      phoneBusiness: number,
      pictureFeatured: string,
      pictures: string[],
      question1: string,
      question2: string,
      rateAverage: number,
      ratings: Rating[],
      role: string,
      status: string,
      token: string,
      username: string,
    ) {}
}
