/**
 * Provides model for Address object
 */

export class Address {
    constructor (
        private city: String,
        private line1: String,
        private line2: String,
        private state: String,
        private zip: number
    ) {}
}
