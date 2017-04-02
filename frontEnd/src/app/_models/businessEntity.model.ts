/**
 * Provides a Business Entity object
 */

import { Comment } from './comment.model';
import { Address } from './address.model';
import { Rating } from './rating.model'

export class BusinessEntity {
    constructor (
      id: number,
      createdDate: string,
      username: string,
      password: string,
      email: string,
      question1: string,
      question2: string,
      pictureFeatured: string,
      pictures: string[],
      description: string,
      status: string,
      role: string,
      token: string,
      name: string,
      phone: number,
      phoneBusiness: number,
      hours: string,
      rateAverage: number,
      comments: Comment[],
      ratings: Rating[],
      address: Address,
      category: string,
    ) {}


}
