// Creates the model for the ratings
//

export class Rating {

  rate: string;
  userId: number;

  constructor (
    rate: string,
    userId: number
  ) {
    this.rate = rate;
    this.userId = userId;
  }
}
